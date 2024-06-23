package com.bforbank.testProject.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pot")
@Getter
@Setter
@NoArgsConstructor
public class Pot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pot_id")
    private int id;

    @OneToOne
    @JoinColumn(name = "client_id", referencedColumnName = "client_id")
    private Client client;
    @Column
    private double amount;
    @Column
    private boolean available;
    @Column
    private int transactionCount;

    // Getters and Setters

    public int getId() {
        return id;
    }

    public Client getClient() {
        return client;
    }

    public double getAmount() {
        return amount;
    }

    public boolean isAvailable() {
        return available;
    }

    public int getTransactionCount() {
        return transactionCount;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void setTransactionCount(int transactionCount) {
        this.transactionCount = transactionCount;
    }

    public Pot(int id, Client client, double amount, boolean available, int transactionCount) {
        this.id = id;
        this.client = client;
        this.amount = amount;
        this.available = available;
        this.transactionCount = transactionCount;
    }
}
