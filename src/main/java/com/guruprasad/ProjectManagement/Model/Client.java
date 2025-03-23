package com.guruprasad.ProjectManagement.Model;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String clientName;
    private String clientPhoneNo;
    private String clientEmail;
    private String clientAddress;
    private Date creationDate;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "projectId", nullable = false)
    private Project project;
}
