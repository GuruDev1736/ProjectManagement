package com.guruprasad.ProjectManagement.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    private String projectName;
    private String projectDescription;
    private String startDate;
    private String projectDeadline;
    private String status;
    private int projectCost;
    private String priority;
    private String projectCategory;
    private String projectManager;
    private String projectNote;
    private Date creationDate;

    @OneToMany(mappedBy = "project",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Client> client = new ArrayList<>();

    @OneToMany(mappedBy = "project",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<ProjectManager> managers = new ArrayList<>();

    @OneToMany(mappedBy = "project",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<TeamMembers> members = new ArrayList<>();

}
