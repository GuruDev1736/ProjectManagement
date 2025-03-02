package com.guruprasad.ProjectManagement.ServiceImpl;

import java.util.List;

import com.guruprasad.ProjectManagement.Exception.ResourceNotFoundException;
import com.guruprasad.ProjectManagement.Model.Project;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.guruprasad.ProjectManagement.PayLoad.ProjectDTO;
import com.guruprasad.ProjectManagement.Repository.ProjectRepo;
import com.guruprasad.ProjectManagement.Service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepo projectRepo;
    private final ModelMapper modelMapper;

    public ProjectServiceImpl(ProjectRepo projectRepo, ModelMapper modelMapper) {
        this.projectRepo = projectRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public ProjectDTO createProject(ProjectDTO projectDTO) {
        Project project = modelMapper.map(projectDTO,Project.class);
        Project saved = projectRepo.save(project);
        return modelMapper.map(saved, ProjectDTO.class);
    }

    @Override
    public ProjectDTO updateProject(int projectId, ProjectDTO projectDTO) {
        Project project = projectRepo.findById(projectId).orElseThrow(() -> new ResourceNotFoundException("Project","Id",projectId));
        project.setProjectCost(projectDTO.getProjectCost());
        project.setProjectDeadline(projectDTO.getProjectDeadline());
        project.setProjectName(projectDTO.getProjectName());
        project.setStatus(projectDTO.getStatus());

        Project updated = projectRepo.save(project);
        return modelMapper.map(updated, ProjectDTO.class);
    }

    @Override
    public ProjectDTO getProjectById(int id) {
        Project project = projectRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Project","Id", id));
        return modelMapper.map(project, ProjectDTO.class);

    }

    @Override
    public void deleteProject(int id) {
        Project project = projectRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Project","Id", id));
        projectRepo.delete(project);
    }

    @Override
    public List<ProjectDTO> getAllProject() {
        List<ProjectDTO> projects = projectRepo.findAll().stream().map(project -> modelMapper.map(project, ProjectDTO.class)).toList();
        return projects;
    }

}
