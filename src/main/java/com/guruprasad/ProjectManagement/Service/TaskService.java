package com.guruprasad.ProjectManagement.Service;

import java.util.List;

import com.guruprasad.ProjectManagement.PayLoad.TaskDTO;

public interface TaskService {
    
    TaskDTO createTask(TaskDTO taskDTO , Integer projectId, Integer teamMemberId);
    List<TaskDTO> getAllTasks();
    TaskDTO getTaskById(Integer id);
    TaskDTO updateTask(TaskDTO taskDTO,Integer id , Integer projectId, Integer teamMemberId);
    void deleteTask(Integer id);

}
