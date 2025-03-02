package com.guruprasad.ProjectManagement.Service;

import com.guruprasad.ProjectManagement.Model.Client;
import com.guruprasad.ProjectManagement.PayLoad.ClientDTO;

import java.util.List;

public interface ClientService {

    ClientDTO createClient(ClientDTO clientDTO);
    ClientDTO updateClient(int id , ClientDTO clientDTO);
    ClientDTO getClientById(int id);
    void deleteClient(int id);
    List<ClientDTO> getAllClients();

}
