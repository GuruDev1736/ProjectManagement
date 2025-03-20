package com.guruprasad.ProjectManagement.Service;

import java.util.List;

import com.guruprasad.ProjectManagement.PayLoad.TeamMemberDTO;

public interface TeamMemberService {

    TeamMemberDTO createTeamMember(TeamMemberDTO teamMemberDTO);

    List<TeamMemberDTO> getAllTeamMembers();

    TeamMemberDTO getTeamMemberById(int id);

    TeamMemberDTO updateTeamMember(TeamMemberDTO teamMemberDTO, int id);

    void deleteTeamMemberById(int id);
    
}
