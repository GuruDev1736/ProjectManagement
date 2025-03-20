package com.guruprasad.ProjectManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guruprasad.ProjectManagement.Model.Task;

public interface TaskRepo extends JpaRepository<Task,Integer> {
    
}
