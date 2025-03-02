package com.guruprasad.ProjectManagement.PayLoad;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private String clientCollege;
}
