package com.lipinski.petshop_api.service;

import com.lipinski.petshop_api.clients.Clients;
import com.lipinski.petshop_api.clients.ClientsRepository;
import com.lipinski.petshop_api.clients.ClientsRequestDTO;
import com.lipinski.petshop_api.clients.ClientsResponseDTO;
import com.lipinski.petshop_api.error.ResourceNotFoundExeception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientsService {
    @Autowired
    private ClientsRepository repository;

    public ClientsResponseDTO findById(Long id) {

        Clients clients = repository.findById(id).get();
        if (clients == null) {
            throw new ResourceNotFoundExeception("Client not found for id: " + id);
        }
        ClientsResponseDTO dto = new ClientsResponseDTO(clients);
        return dto;
    }

    public List<ClientsResponseDTO> findAll() {
        List<Clients> clients = repository.findAll();
        List<ClientsResponseDTO> dto = null;
        if (clients != null) {
            dto = new ArrayList<ClientsResponseDTO>();
            for (Clients c : clients) {
                dto.add(new ClientsResponseDTO(c));
            }
        }
        return dto;
    }

    public ResponseEntity<Clients> addClients(ClientsRequestDTO clients) {
        Clients newClient = new Clients(clients);
        Clients saveClient = repository.save(newClient);

//        if(saveClient.equals(null)) {
//            return null;
//
//        } else {
//            if (saveClient.getName().equals(null)) {
//
//            }
//            if (saveClient.getName().length() > 63) {
//
//            }
            return new ResponseEntity<Clients>(saveClient, HttpStatus.CREATED);
//        }

    }

    public ResponseEntity<String> deleteClients(Long id) {
        repository.deleteById(id);
        return new ResponseEntity<String>("Cliente deletado com sucesso", HttpStatus.OK);
    }

    public Clients editClients(Long id, ClientsRequestDTO clients) {
        Clients newClient = new Clients(clients);
        newClient.setId(id);
        Clients save = repository.save(newClient);
        return save;
    }

}
