package com.bforbank.testProject.service;

import com.bforbank.testProject.model.Client;

public interface IClientService extends IService<Client>{
    void addTransaction(int clientId, double amount);
}
