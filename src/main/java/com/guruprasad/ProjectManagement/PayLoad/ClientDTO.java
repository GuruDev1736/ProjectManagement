package com.guruprasad.ProjectManagement.PayLoad;


import com.guruprasad.ProjectManagement.Model.Project;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {

    private int id;
    private String clientName;
    private String clientPhoneNo;
    private String clientEmail;
    private String clientAddress;
    private Date creationDate = new Date();
}
