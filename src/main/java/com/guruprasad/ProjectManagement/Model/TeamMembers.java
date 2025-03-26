package com.guruprasad.ProjectManagement.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "teamMembers")
public class TeamMembers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String memberName;
    private String memberEmail;
    private String memberPhone;
    private String memberAddress;
    private Date creationDate;

   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "project_id")
   private Project project;
}
