package com.guruprasad.ProjectManagement.Repository;

import com.guruprasad.ProjectManagement.Model.TeamMembers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamMemberRepo extends JpaRepository<TeamMembers,Integer> {
}
