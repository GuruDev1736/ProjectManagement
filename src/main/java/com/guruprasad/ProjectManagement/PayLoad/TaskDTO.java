package com.guruprasad.ProjectManagement.PayLoad;



import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskDTO {
    private Integer id;
    private String title;
    private String description;
    private String status;
    private String priority;
    private String dueDate;
    private Date creationDate = new Date();
}
