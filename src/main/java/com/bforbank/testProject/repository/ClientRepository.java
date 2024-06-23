package com.bforbank.testProject.repository;

import com.bforbank.testProject.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Integer> {
}
