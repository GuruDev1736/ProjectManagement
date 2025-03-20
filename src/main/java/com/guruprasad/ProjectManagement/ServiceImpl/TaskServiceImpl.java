package com.guruprasad.ProjectManagement.ServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.guruprasad.ProjectManagement.Exception.ResourceNotFoundException;
import com.guruprasad.ProjectManagement.Model.Project;
import com.guruprasad.ProjectManagement.Model.Task;
import com.guruprasad.ProjectManagement.Model.TeamMembers;
import com.guruprasad.ProjectManagement.PayLoad.TaskDTO;
import com.guruprasad.ProjectManagement.Repository.ProjectRepo;
import com.guruprasad.ProjectManagement.Repository.TaskRepo;
import com.guruprasad.ProjectManagement.Repository.TeamMemberRepo;
import com.guruprasad.ProjectManagement.Service.TaskService;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepo taskRepo;
    private final ModelMapper modelMapper;
    private final ProjectRepo projectRepo;
    private final TeamMemberRepo teamMemberRepo;

    public TaskServiceImpl(TaskRepo taskRepo, ModelMapper modelMapper, ProjectRepo projectRepo, TeamMemberRepo teamMemberRepo) {
        this.taskRepo = taskRepo;
        this.modelMapper = modelMapper;
        this.projectRepo = projectRepo;
        this.teamMemberRepo = teamMemberRepo;
    }

    @Override
    public TaskDTO createTask(TaskDTO taskDTO, Integer projectId, Integer teamMemberId) {

        Project project = projectRepo.findById(projectId).orElseThrow(() -> new ResourceNotFoundException("Project","Id",projectId));
        TeamMembers teamMember = teamMemberRepo.findById(teamMemberId).orElseThrow(() -> new ResourceNotFoundException("TeamMember","Id",teamMemberId));

        Task task = modelMapper.map(taskDTO, Task.class);
        task.setProject(project);
        task.setTeamMember(teamMember);
        task = taskRepo.save(task);
        return modelMapper.map(task, TaskDTO.class);
    }

    @Override
    public List<TaskDTO> getAllTasks() {
        List<Task> tasks = taskRepo.findAll();
        return tasks.stream().map(task -> modelMapper.map(task, TaskDTO.class)).toList();
    }

    @Override
    public TaskDTO getTaskById(Integer id) {
        Task task = taskRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Task","Id",id));
        return modelMapper.map(task, TaskDTO.class);
    }

    @Override
    public TaskDTO updateTask(TaskDTO taskDTO, Integer id, Integer projectId, Integer teamMemberId) {
        Task task = taskRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Task","Id",id));
        Project project = projectRepo.findById(projectId).orElseThrow(() -> new ResourceNotFoundException("Project","Id",projectId));
        TeamMembers teamMember = teamMemberRepo.findById(teamMemberId).orElseThrow(() -> new ResourceNotFoundException("TeamMember","Id",teamMemberId));

        task.setProject(project);
        task.setTeamMember(teamMember);
        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setStatus(taskDTO.getStatus());
        task.setPriority(taskDTO.getPriority());
        task.setDueDate(taskDTO.getDueDate());

        task = taskRepo.save(task);
        return modelMapper.map(task, TaskDTO.class);
    }

    @Override
    public void deleteTask(Integer id) {
        Task task = taskRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Task","Id",id));
        taskRepo.delete(task);
    }
}
