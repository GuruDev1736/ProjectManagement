package com.guruprasad.ProjectManagement.Model;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "projectManager")
public class ProjectManager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String projectManagerName;
    private String projectManagerPhoneNo;
    private String projectManagerEmail;
    private String projectManagerAddress;
    private Date creationDate;

    @OneToMany(mappedBy = "projectManager", cascade = CascadeType.ALL)
    private Set<Project> projects = new HashSet<>();

}
