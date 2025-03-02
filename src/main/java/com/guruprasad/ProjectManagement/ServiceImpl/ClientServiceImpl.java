package com.guruprasad.ProjectManagement.ServiceImpl;

import com.guruprasad.ProjectManagement.Exception.ResourceNotFoundException;
import com.guruprasad.ProjectManagement.Model.Client;
import com.guruprasad.ProjectManagement.PayLoad.ClientDTO;
import com.guruprasad.ProjectManagement.Repository.ClientRepo;
import com.guruprasad.ProjectManagement.Service.ClientService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private final ModelMapper modelMapper;
    private final ClientRepo clientRepo;

    public ClientServiceImpl(ModelMapper modelMapper, ClientRepo clientRepo) {
        this.modelMapper = modelMapper;
        this.clientRepo = clientRepo;
    }

    @Override
    public ClientDTO createClient(ClientDTO clientDTO) {
        Client client = modelMapper.map(clientDTO,Client.class);
        Client saved = clientRepo.save(client);
        return modelMapper.map(saved,ClientDTO.class);
    }

    @Override
    public ClientDTO updateClient(int id, ClientDTO clientDTO) {
        Client client = clientRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Client","Id",id));
        client.setClientName(clientDTO.getClientName());
        client.setClientCollege(clientDTO.getClientCollege());
        client.setClientAddress(clientDTO.getClientAddress());
        client.setClientEmail(clientDTO.getClientEmail());
        client.setClientPhoneNo(clientDTO.getClientPhoneNo());

        Client updated = clientRepo.save(client);
        return modelMapper.map(updated,ClientDTO.class);
    }

    @Override
    public ClientDTO getClientById(int id) {
        Client client = clientRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Client","Id",id));
        return modelMapper.map(client,ClientDTO.class);
    }

    @Override
    public void deleteClient(int id) {
        Client client = clientRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Client","Id",id));
        clientRepo.delete(client);
    }

    @Override
    public List<ClientDTO> getAllClients() {
        List<ClientDTO> clientDTOS = clientRepo.findAll().stream().map(client -> modelMapper.map(client,ClientDTO.class)).toList();
        return clientDTOS;
    }
}
