package com.bforbank.testProject.service;

import com.bforbank.testProject.model.Trader;
import com.bforbank.testProject.repository.TraderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class TraderService implements ITraderService {

    @Autowired
    private TraderRepository traderRepository;

    @Override
    public Trader findById(int id) {
        return traderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trader with id " + id + " not found."));
    }

    @Override
    public List<Trader> findAll() {
        return traderRepository.findAll();
    }

    @Override
    public Trader save(Trader trader) {
        return traderRepository.save(trader);
    }

    @Override
    public void deleteById(int id) {
        traderRepository.deleteById(id);
    }
}
