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
import com.guruprasad.ProjectManagement.PayLoad.TeamMemberDTO;
import com.guruprasad.ProjectManagement.Service.TeamMemberService;

@RestController
@RequestMapping("/api/team-members")
public class TeamMemberController {

    private final TeamMemberService teamMemberService;

    public TeamMemberController(TeamMemberService teamMemberService) {
        this.teamMemberService = teamMemberService;
    }

    @PostMapping("/create/{projectId}")
    public ResponseEntity<ApiResponse<TeamMemberDTO>> createTeamMember(@RequestBody TeamMemberDTO teamMemberDTO , @PathVariable int projectId) {
        TeamMemberDTO createdTeamMember = teamMemberService.createTeamMember(teamMemberDTO, projectId);
        return ResponseEntity.ok(new ApiResponse<>("200", "Team Member created successfully", createdTeamMember));
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<TeamMemberDTO>>> getAllTeamMembers() {
        List<TeamMemberDTO> teamMembers = teamMemberService.getAllTeamMembers();
        return ResponseEntity.ok(new ApiResponse<>("200", "Team Members fetched successfully", teamMembers));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<TeamMemberDTO>> getTeamMemberById(@PathVariable int id) {
        TeamMemberDTO teamMember = teamMemberService.getTeamMemberById(id);
        return ResponseEntity.ok(new ApiResponse<>("200", "Team Member fetched successfully", teamMember));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<TeamMemberDTO>> updateTeamMember(@PathVariable int id,
            @RequestBody TeamMemberDTO teamMemberDTO) {
        TeamMemberDTO updatedTeamMember = teamMemberService.updateTeamMember(teamMemberDTO, id);
        return ResponseEntity.ok(new ApiResponse<>("200", "Team Member updated successfully", updatedTeamMember));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteTeamMember(@PathVariable int id) {
        teamMemberService.deleteTeamMemberById(id);
        return ResponseEntity.ok(new ApiResponse<>("200", "Team Member deleted successfully", null));
    }

}
