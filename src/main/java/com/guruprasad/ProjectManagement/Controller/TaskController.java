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
import com.guruprasad.ProjectManagement.PayLoad.TaskDTO;
import com.guruprasad.ProjectManagement.Service.TaskService;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/create/{projectId}/{teamMemberId}")
    public ResponseEntity<ApiResponse<TaskDTO>> createTask(@RequestBody TaskDTO taskDTO,
            @PathVariable Integer projectId, @PathVariable Integer teamMemberId) {
        TaskDTO createdTask = taskService.createTask(taskDTO, projectId, teamMemberId);
        return ResponseEntity.ok(new ApiResponse<>("200", "Task created successfully", createdTask));
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<TaskDTO>>> getAllTasks() {
        List<TaskDTO> tasks = taskService.getAllTasks();
        return ResponseEntity.ok(new ApiResponse<>("200", "Tasks fetched successfully", tasks));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<TaskDTO>> getTaskById(@PathVariable Integer id) {
        TaskDTO task = taskService.getTaskById(id);
        return ResponseEntity.ok(new ApiResponse<>("200", "Task fetched successfully", task));
    }

    @PutMapping("/update/{id}/{projectId}/{teamMemberId}")
    public ResponseEntity<ApiResponse<TaskDTO>> updateTask(@RequestBody TaskDTO taskDTO, @PathVariable Integer id,
            @PathVariable Integer projectId, @PathVariable Integer teamMemberId) {
        TaskDTO updatedTask = taskService.updateTask(taskDTO, id, projectId, teamMemberId);
        return ResponseEntity.ok(new ApiResponse<>("200", "Task updated successfully", updatedTask));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse<String>> deleteTask(@PathVariable Integer id) {
        taskService.deleteTask(id);
        return ResponseEntity.ok(new ApiResponse<>("200", "Task deleted successfully", "Task deleted successfully"));
    }

}
