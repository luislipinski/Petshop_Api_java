package com.lipinski.petshop_api.controller;

import com.lipinski.petshop_api.service.ClientsService;
import com.lipinski.petshop_api.clients.Clients;
import com.lipinski.petshop_api.clients.ClientsRequestDTO;
import com.lipinski.petshop_api.clients.ClientsResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clients")
public class ClientsController {
    @Autowired
    private ClientsService service;


    @GetMapping(value = "/search/{id}")
    public ClientsResponseDTO findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping(value = "/search")
    public List<ClientsResponseDTO> findAll() {
        return service.findAll();
    }

    @PostMapping(value = "/create")
    public Clients registerClient(@RequestBody ClientsRequestDTO clients) {
        return service.addClients(clients).getBody();
    }

    @DeleteMapping(value = "/delete/{id}")
    @ResponseBody
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        return service.deleteClients(id);
    }
    @PutMapping(value = "/edit/{id}")
    public Clients editaProdutoById(@PathVariable Long id, @RequestBody ClientsRequestDTO clients) {
        service.editClients(id, clients);
       return service.editClients(id, clients);

    }
}
