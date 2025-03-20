package com.guruprasad.ProjectManagement.Service;

import com.guruprasad.ProjectManagement.PayLoad.ProjectManagerDTO;

import java.util.List;

public interface ProjectManagerService {

    ProjectManagerDTO createProjectManager(ProjectManagerDTO projectManagerDTO);
    ProjectManagerDTO updateProjectManager(ProjectManagerDTO projectManagerDTO , int id);
    ProjectManagerDTO getProjectManagerById(int id);
    List<ProjectManagerDTO> getProjectManagers();
    void deleteProjectManagerById(int id);
}
