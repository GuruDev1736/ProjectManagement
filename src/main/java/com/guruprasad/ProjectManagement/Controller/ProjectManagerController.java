package com.guruprasad.ProjectManagement.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guruprasad.ProjectManagement.PayLoad.ApiResponse;
import com.guruprasad.ProjectManagement.PayLoad.ProjectManagerDTO;
import com.guruprasad.ProjectManagement.Service.ProjectManagerService;

@RestController
@RequestMapping("/manager")
public class ProjectManagerController {

    private final ProjectManagerService projectManagerService;

    public ProjectManagerController(ProjectManagerService projectManagerService) {
        this.projectManagerService = projectManagerService;
    }

    @PostMapping("/create/{id}")
    public ResponseEntity<ApiResponse<ProjectManagerDTO>> createProjectManager(@RequestBody ProjectManagerDTO projectManagerDTO , @PathVariable("id") int id){
        ProjectManagerDTO createdProjectManager = projectManagerService.createProjectManager(projectManagerDTO,id);
        return ResponseEntity.ok(new ApiResponse<>("200","Project Manager created successfully", createdProjectManager));
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<ProjectManagerDTO>>> getAllProjectManagers(){
        List<ProjectManagerDTO> projectManagers = projectManagerService.getProjectManagers();
        return ResponseEntity.ok(new ApiResponse<>("200","Project Managers fetched successfully", projectManagers));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ProjectManagerDTO>> getProjectManagerById(@PathVariable int id){
        ProjectManagerDTO projectManager = projectManagerService.getProjectManagerById(id);
        return ResponseEntity.ok(new ApiResponse<>("200","Project Manager fetched successfully", projectManager));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<ProjectManagerDTO>> updateProjectManager(@PathVariable int id, @RequestBody ProjectManagerDTO projectManagerDTO){
        ProjectManagerDTO updatedProjectManager = projectManagerService.updateProjectManager(projectManagerDTO, id);
        return ResponseEntity.ok(new ApiResponse<>("200","Project Manager updated successfully", updatedProjectManager));
    }   

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteProjectManager(@PathVariable int id){
        projectManagerService.deleteProjectManagerById(id);
        return ResponseEntity.ok(new ApiResponse<>("200","Project Manager deleted successfully", null));
    }
    
}
