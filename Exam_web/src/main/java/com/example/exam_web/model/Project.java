package com.example.exam_web.model;





import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double budget;

    @OneToMany(mappedBy = "project")
    private List<Employee> employees;
}
