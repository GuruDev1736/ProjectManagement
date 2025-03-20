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
public class TeamMemberDTO {

    private int id;
    private String memberName;
    private String memberEmail;
    private String memberPhone;
    private String memberAddress;
    private Date creationDate;
}
