package com.guruprasad.ProjectManagement.PayLoad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDTO {
    private int Id;
    private String projectName;
    private String projectDescription;
    private String startDate;
    private String projectDeadline;
    private String status;
    private int projectCost;
    private String priority;
    private String projectCategory;
    private ProjectManagerDTO projectManager;
    private String projectNote;
    private Date creationDate = new Date();
    private ClientDTO client;
}
