package com.bforbank.testProject.controller;

import com.bforbank.testProject.model.Client;
import com.bforbank.testProject.service.IClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientController implements IClientController {

    @Autowired
    private IClientService clientService;

    @Override
    @GetMapping("/{id}")
    public Client getById(@PathVariable int id) {
        return clientService.findById(id);
    }

    @Override
    @GetMapping
    public List<Client> getAll() {
        return clientService.findAll();
    }

    @Override
    @PostMapping
    public Client create(@RequestBody Client client) {
        return clientService.save(client);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        clientService.deleteById(id);
    }
}