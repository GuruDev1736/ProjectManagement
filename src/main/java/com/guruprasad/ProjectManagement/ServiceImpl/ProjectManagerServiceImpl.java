package com.guruprasad.ProjectManagement.ServiceImpl;

import com.guruprasad.ProjectManagement.Exception.ResourceNotFoundException;
import com.guruprasad.ProjectManagement.Model.Project;
import com.guruprasad.ProjectManagement.Model.ProjectManager;
import com.guruprasad.ProjectManagement.PayLoad.ProjectManagerDTO;
import com.guruprasad.ProjectManagement.Repository.ProjectManagerRepo;
import com.guruprasad.ProjectManagement.Repository.ProjectRepo;
import com.guruprasad.ProjectManagement.Service.ProjectManagerService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectManagerServiceImpl implements ProjectManagerService {

    private final ModelMapper modelMapper;

    private final ProjectManagerRepo projectManagerRepo;
    private final ProjectRepo projectRepo;

    public ProjectManagerServiceImpl(ModelMapper modelMapper, ProjectManagerRepo projectManagerRepo, ProjectRepo projectRepo) {
        this.modelMapper = modelMapper;
        this.projectManagerRepo = projectManagerRepo;
        this.projectRepo = projectRepo;
    }

    @Override
    public ProjectManagerDTO createProjectManager(ProjectManagerDTO projectManagerDTO, int projectId) {
        Project project = projectRepo.findById(projectId).orElseThrow(() -> new ResourceNotFoundException("Project", "Id", projectId));
        ProjectManager newProjectManager = modelMapper.map(projectManagerDTO, ProjectManager.class);
        newProjectManager.getProjects().add(project);
        project.setProjectManager(newProjectManager);
        ProjectManager saved = projectManagerRepo.save(newProjectManager);
        projectRepo.save(project);
        return modelMapper.map(saved, ProjectManagerDTO.class);
    }

    @Override
    public ProjectManagerDTO updateProjectManager(ProjectManagerDTO projectManagerDTO, int id) {

        ProjectManager manager = projectManagerRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("manager","Id",id));
        manager.setProjectManagerName(projectManagerDTO.getProjectManagerName());
        manager.setProjectManagerEmail(projectManagerDTO.getProjectManagerEmail());
        manager.setProjectManagerAddress(projectManagerDTO.getProjectManagerAddress());
        manager.setProjectManagerPhoneNo(projectManagerDTO.getProjectManagerPhoneNo());
        ProjectManager save = projectManagerRepo.save(manager);
        return modelMapper.map(save, ProjectManagerDTO.class);
    }

    @Override
    public ProjectManagerDTO getProjectManagerById(int id) {
        ProjectManager manager = projectManagerRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("manager","Id",id));
        return modelMapper.map(manager, ProjectManagerDTO.class);
    }

    @Override
    public List<ProjectManagerDTO> getProjectManagers() {
        List<ProjectManagerDTO> managers = projectManagerRepo.findAll().stream().map(x -> modelMapper.map(x, ProjectManagerDTO.class)).toList();
        return managers;
    }

    @Override
    public void deleteProjectManagerById(int id) {
        ProjectManager manager = projectManagerRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("manager","Id",id));
        projectManagerRepo.delete(manager);
    }
}
