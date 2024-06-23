package com.bforbank.testProject.service;

import com.bforbank.testProject.model.Client;
import com.bforbank.testProject.model.Pot;
import com.bforbank.testProject.repository.ClientRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Transactional
public class ClientService implements IClientService {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private PotService potService;

    @Override
    public Client findById(int id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client with id " + id + " not found."));
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client save(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public void deleteById(int id) {
        clientRepository.deleteById(id);
    }

    @Override
    public void addTransaction(int clientId, double amount) {
        Client client = findById(clientId); // Implement this method to find client by ID
        Pot pot = client.getPot();
        pot.setAmount(pot.getAmount() + amount);
        pot.setTransactionCount(pot.getTransactionCount() + 1);
        potService.updatePot(pot); // Implement updatePot method in PotService
    }
}