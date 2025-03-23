package com.guruprasad.ProjectManagement.Controller;

import com.guruprasad.ProjectManagement.PayLoad.ApiResponse;
import com.guruprasad.ProjectManagement.PayLoad.ClientDTO;
import com.guruprasad.ProjectManagement.Service.ClientService;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }


    @PostMapping("/create/{id}")
    public ResponseEntity<ApiResponse<ClientDTO>> createClient(@RequestBody ClientDTO clientDTO , @PathVariable("id") int id)
    {
        ClientDTO clientDTO1 = clientService.createClient(clientDTO,id);
        return ResponseEntity.ok(new ApiResponse<>("200","Client Created Successfully",clientDTO1));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ClientDTO>> getClientById(@PathVariable("id") int id)
    {
        ClientDTO clientDTO = clientService.getClientById(id);
        return ResponseEntity.ok(new ApiResponse<>("200","Client Fetched Successfully",clientDTO));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse<ClientDTO>> updateClient(@PathVariable("id") int id , ClientDTO clientDTO)
    {
        ClientDTO clientDTO1 = clientService.updateClient(id,clientDTO);
        return ResponseEntity.ok(new ApiResponse<>("200","Client Updated Successfully",clientDTO1));
    }

    @GetMapping("/")
    public ResponseEntity<ApiResponse<List<ClientDTO>>> GetAllClients()
    {
        List<ClientDTO> clientDTOS = clientService.getAllClients();
        return ResponseEntity.ok(new ApiResponse<>("200","All Client Fetched Successfully",clientDTOS));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteClient(@PathVariable int id)
    {
        clientService.deleteClient(id);
        return ResponseEntity.ok(new ApiResponse<>("200","Client Deleted Successfully",""));
    }
}
