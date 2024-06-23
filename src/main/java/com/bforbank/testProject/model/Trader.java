package com.bforbank.testProject.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "Trader")
@Getter
@Setter
@NoArgsConstructor
public class Trader {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trader_id")
    private int id;

    @Column(name = "name")
    private String name;


    // Getters and Setters

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Trader(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
