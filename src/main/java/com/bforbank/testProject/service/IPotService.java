package com.bforbank.testProject.service;

import com.bforbank.testProject.model.Pot;

public interface IPotService extends IService<Pot>{
    Pot addToPot(int clientId, double amount);
    Pot getPotForClient(int clientId);
    boolean isPotAvailable(int clientId);
    void updateTransactionCount(int clientId);
    void updatePot(Pot pot);
}
