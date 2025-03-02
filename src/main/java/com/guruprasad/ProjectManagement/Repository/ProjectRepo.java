package com.guruprasad.ProjectManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guruprasad.ProjectManagement.Model.Project;

public interface ProjectRepo extends JpaRepository<Project,Integer> {

}
