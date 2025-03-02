package com.guruprasad.ProjectManagement.Repository;

import com.guruprasad.ProjectManagement.Model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepo extends JpaRepository<Client,Integer> {
}
