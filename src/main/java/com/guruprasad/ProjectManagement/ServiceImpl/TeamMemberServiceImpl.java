package com.guruprasad.ProjectManagement.ServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.guruprasad.ProjectManagement.Exception.ResourceNotFoundException;
import com.guruprasad.ProjectManagement.Model.Project;
import com.guruprasad.ProjectManagement.Model.TeamMembers;
import com.guruprasad.ProjectManagement.PayLoad.TeamMemberDTO;
import com.guruprasad.ProjectManagement.Repository.TeamMemberRepo;
import com.guruprasad.ProjectManagement.Repository.ProjectRepo;
import com.guruprasad.ProjectManagement.Service.TeamMemberService;

@Service
public class TeamMemberServiceImpl implements TeamMemberService {

    private final ModelMapper modelMapper;

    private final TeamMemberRepo teamMemberRepo;
    private final ProjectRepo projectRepo;

    public TeamMemberServiceImpl(ModelMapper modelMapper, TeamMemberRepo teamMemberRepo, ProjectRepo projectRepo) {
        this.modelMapper = modelMapper;
        this.teamMemberRepo = teamMemberRepo;
        this.projectRepo = projectRepo;
    }

    @Override
    public TeamMemberDTO createTeamMember(TeamMemberDTO teamMemberDTO , int projectId) {

        Project project = projectRepo.findById(projectId).orElseThrow(()-> new ResourceNotFoundException("Project", "Id", projectId));

        TeamMembers teamMember = modelMapper.map(teamMemberDTO, TeamMembers.class);
        teamMember.setProject(project);
        TeamMembers saved = teamMemberRepo.save(teamMember);
        return modelMapper.map(saved, TeamMemberDTO.class);
    }

    @Override
    public List<TeamMemberDTO> getAllTeamMembers() {
        List<TeamMembers> teamMembers = teamMemberRepo.findAll();
        return teamMembers.stream().map(teamMember -> modelMapper.map(teamMember, TeamMemberDTO.class)).toList();
    }

    @Override
    public TeamMemberDTO getTeamMemberById(int id) {
        TeamMembers teamMember = teamMemberRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Team Member", "Id", id));
        return modelMapper.map(teamMember, TeamMemberDTO.class);
    }

    @Override
    public TeamMemberDTO updateTeamMember(TeamMemberDTO teamMemberDTO, int id) {
        TeamMembers teamMember = teamMemberRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Team Member", "Id", id));
        teamMember.setMemberName(teamMemberDTO.getMemberName());
        teamMember.setMemberEmail(teamMemberDTO.getMemberEmail());
        teamMember.setMemberPhone(teamMemberDTO.getMemberPhone());
        teamMember.setMemberAddress(teamMemberDTO.getMemberAddress());
        TeamMembers saved = teamMemberRepo.save(teamMember);
        return modelMapper.map(saved, TeamMemberDTO.class);
    }

    @Override
    public void deleteTeamMemberById(int id) {
        TeamMembers teamMember = teamMemberRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Team Member", "Id", id));
        teamMemberRepo.delete(teamMember);
    }

}
