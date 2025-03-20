package com.guruprasad.ProjectManagement.Repository;

import com.guruprasad.ProjectManagement.Model.Project;
import com.guruprasad.ProjectManagement.Model.ProjectManager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectManagerRepo extends JpaRepository<ProjectManager, Integer> {
}
