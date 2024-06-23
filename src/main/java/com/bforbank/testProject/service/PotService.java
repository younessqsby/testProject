package com.bforbank.testProject.service;

import com.bforbank.testProject.expection.ClientNotFoundException;
import com.bforbank.testProject.expection.PotNotFoundException;
import com.bforbank.testProject.model.Client;
import com.bforbank.testProject.model.Pot;
import com.bforbank.testProject.repository.ClientRepository;
import com.bforbank.testProject.repository.PotRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class PotService implements IPotService {

    @Autowired
    private PotRepository potRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Pot findById(int id) {
        return potRepository.findById(id)
                .orElseThrow(() -> new PotNotFoundException("Pot with id " + id + " not found."));
    }

    @Override
    public List<Pot> findAll() {
        return potRepository.findAll();
    }

    @Override
    public Pot save(Pot pot) {
        return potRepository.save(pot);
    }

    @Override
    public void deleteById(int id) {
        potRepository.deleteById(id);
    }

    @Override
    public Pot addToPot(int clientId, double amount) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new ClientNotFoundException("Client with id " + clientId + " not found."));
        Pot pot = client.getPot();
        if (pot == null) {
            pot = new Pot();
            pot.setClient(client);
            client.setPot(pot);
        }

        pot.setAmount(pot.getAmount() + amount);
        pot.setTransactionCount(pot.getTransactionCount() + 1);
        updatePotAvailability(pot);

        return potRepository.save(pot);
    }

    @Override
    public Pot getPotForClient(int clientId) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new ClientNotFoundException("Client with id " + clientId + " not found."));
        return client.getPot();
    }

    @Override
    public boolean isPotAvailable(int clientId) {
        Pot pot = getPotForClient(clientId);
        return pot != null && pot.isAvailable();
    }

    private void updatePotAvailability(Pot pot) {
        if (pot.getTransactionCount() >= 3 && pot.getAmount() >= 10) {
            pot.setAvailable(true);
        } else {
            pot.setAvailable(false);
        }
    }
    @Override
    public void updatePot(Pot pot) {
        potRepository.save(pot);
    }

    @Override
    public void updateTransactionCount(int clientId) {
        Pot pot = findById(clientId);
        pot.setTransactionCount(pot.getTransactionCount() + 1);
        updatePot(pot); // Save the updated Pot entity
    }
}