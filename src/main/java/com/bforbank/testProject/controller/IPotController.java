package com.bforbank.testProject.controller;

import com.bforbank.testProject.model.Pot;

public interface IPotController extends IController<Pot>{
    Pot addToPot(int clientId, double amount);
    Pot getPotForClient(int clientId);
    boolean isPotAvailable(int clientId);
}
