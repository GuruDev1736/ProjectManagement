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
public class ProjectManagerDTO {

    private int id;

    private String projectManagerName;
    private String projectManagerPhoneNo;
    private String projectManagerEmail;
    private String projectManagerAddress;
    private Date creationDate = new Date();
}
