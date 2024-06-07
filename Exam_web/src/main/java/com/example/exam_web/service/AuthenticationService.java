package com.example.exam_web.service;



import com.example.exam_web.jwt.model.AuthenticationResponse;
import com.example.exam_web.jwt.model.UserPrincipal;
import com.example.exam_web.jwt.util.JwtUtil;
import com.example.exam_web.model.Role;
import com.example.exam_web.model.Employee;
import com.example.exam_web.repository.RoleRepository;
import com.example.exam_web.repository.EmployeeRepository;
import com.example.exam_web.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

@Service
@AllArgsConstructor
public class AuthenticationService implements UserDetailsService {

    public final EmployeeService userService;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final EmployeeRepository userRepository;
    private final ModelMapper mapper;
    private final JwtUtil jwtUtil;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        var userEntity = userService.findByEmail(email);
        return new UserPrincipal(userEntity);
    }


    public ResponseEntity<?> authenticate(String email, String password)
            throws NoSuchAlgorithmException {

        if (email.isEmpty() || password.isEmpty()) {
            throw new BadCredentialsException("Unauthorized");
        }

        var userEntity = userService.findByEmail(email);

        if (userEntity == null) {
            System.out.println("There are no account with these credentials");
            return ResponseEntity.badRequest().body("{\"message\":\"There are no account with these credentials\"}");
        }

        if (!passwordEncoder.matches(password, userEntity.getPassword())) {
            System.out.println("Password Incorrect !");
            return ResponseEntity.badRequest().body("{\"message\":\"Password Incorrect !\"}");
        }

        Role role = getRole(userEntity.getId());
        UserPrincipal userDetails = new UserPrincipal(userEntity);
        var jwt = jwtUtil.generateToken(userDetails);
        System.out.println(jwt);
        return ResponseEntity.ok().body( new AuthenticationResponse(jwt));
    }


    public Role getRole(Long id){
        return this.roleRepository.findRoleByUsersIn(Arrays.asList(mapper.map(userService.findById(id),Employee.class)));
    }

}