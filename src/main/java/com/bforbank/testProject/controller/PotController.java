package com.bforbank.testProject.controller;

import com.bforbank.testProject.model.Pot;
import com.bforbank.testProject.service.IPotService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pot")
@RequiredArgsConstructor
public class PotController implements IPotController {

    @Autowired
    private IPotService potService;

    @Override
    @GetMapping("/{id}")
    public Pot getById(@PathVariable int id) {
        return potService.findById(id);
    }

    @Override
    @GetMapping("/getAll")
    public List<Pot> getAll() {
        return potService.findAll();
    }

    @Override
    @PostMapping("/create")
    public Pot create(@RequestBody Pot pot) {
        return potService.save(pot);
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        potService.deleteById(id);
    }

    @PostMapping("/add")
    public Pot addToPot(@RequestParam int clientId, @RequestParam double amount) {
        return potService.addToPot(clientId, amount);
    }

    @GetMapping("/client/{clientId}")
    public Pot getPotForClient(@PathVariable int clientId) {
        return potService.getPotForClient(clientId);
    }

    @GetMapping("/client/{clientId}/available")
    public boolean isPotAvailable(@PathVariable int clientId) {
        return potService.isPotAvailable(clientId);
    }
}
