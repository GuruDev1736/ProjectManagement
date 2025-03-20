package com.guruprasad.ProjectManagement.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @ManyToMany
    @JoinTable(
        name = "project_managers",
        joinColumns = @JoinColumn(name = "project_id"),
        inverseJoinColumns = @JoinColumn(name = "manager_id")
    )
    private Set<ProjectManager> managers = new HashSet<>();

    @ManyToMany
    @JoinTable(
        name = "project_team_members",
        joinColumns = @JoinColumn(name = "project_id"),
        inverseJoinColumns = @JoinColumn(name = "team_member_id")
    )
    private Set<TeamMembers> members = new HashSet<>();

}
