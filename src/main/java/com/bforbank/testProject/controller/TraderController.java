package com.bforbank.testProject.controller;

import com.bforbank.testProject.model.Trader;
import com.bforbank.testProject.service.ITraderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trader")
public class TraderController implements ITraderController {

    @Autowired
    private ITraderService traderService;

    @Override
    @GetMapping("/{id}")
    public Trader getById(@PathVariable int id) {
        return traderService.findById(id);
    }

    @Override
    @GetMapping("/getAll")
    public List<Trader> getAll() {
        return traderService.findAll();
    }

    @Override
    @PostMapping("/create")
    public Trader create(@RequestBody Trader trader) {
        return traderService.save(trader);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        traderService.deleteById(id);
    }
}