package com.guruprasad.ProjectManagement.Service;

import java.util.List;

import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Producer;

import com.guruprasad.ProjectManagement.PayLoad.ProjectDTO;

public interface ProjectService {

    ProjectDTO createProject(ProjectDTO projectDTO);

    ProjectDTO updateProject(int projectId, ProjectDTO projectDTO);

    ProjectDTO getProjectById(int id);

    void deleteProject(int id);

    List<ProjectDTO> getAllProject();

}
