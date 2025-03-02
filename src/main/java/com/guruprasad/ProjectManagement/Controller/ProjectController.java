package com.guruprasad.ProjectManagement.Controller;

import com.guruprasad.ProjectManagement.Model.Project;
import com.guruprasad.ProjectManagement.PayLoad.ApiResponse;
import com.guruprasad.ProjectManagement.PayLoad.ProjectDTO;
import com.guruprasad.ProjectManagement.Service.ProjectService;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {

    private final ProjectService projectService;


    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<ProjectDTO>> createProject (@RequestBody ProjectDTO projectDTO)
    {
        ProjectDTO projectDTO1 = projectService.createProject(projectDTO);
        return ResponseEntity.ok(new ApiResponse<>("200","Project Created Successfully",projectDTO1));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse<ProjectDTO>> updateProject (@PathVariable("id") int id , @RequestBody ProjectDTO projectDTO)
    {
        ProjectDTO projectDTO1 = projectService.updateProject(id,projectDTO);
        return ResponseEntity.ok(new ApiResponse<>("200","Project Updated Successfully",projectDTO1));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ProjectDTO>> getProjectById(@PathVariable("id") int id)
    {
        ProjectDTO projectDTO = projectService.getProjectById(id);
        return ResponseEntity.ok(new ApiResponse<>("200","Project Get Successfully",projectDTO));
    }

    @GetMapping("/")
    public ResponseEntity<ApiResponse<List<ProjectDTO>>> getAllProject()
    {
        List<ProjectDTO> projectDTOS = projectService.getAllProject();
        return ResponseEntity.ok(new ApiResponse<>("200","Project Fetched Successfully",projectDTOS));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteProject(@PathVariable("id") int id)
    {
        projectService.deleteProject(id);
        return ResponseEntity.ok(new ApiResponse<>("200","Project Deleted Successfully",""));
    }

}
