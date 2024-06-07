package com.example.exam_web.model;


import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;

    @ElementCollection
    private List<String> skills;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;
}
