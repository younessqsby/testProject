package com.bforbank.testProject.repository;

import com.bforbank.testProject.model.Pot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PotRepository extends JpaRepository<Pot,Integer> {
    Pot findByClientId(int clientId);
}
