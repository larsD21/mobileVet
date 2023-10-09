package de.vet.entity;

import jakarta.persistence.*;

//author Lars Diekmann
@Entity
@Table(name = "Drug")
public class Drug {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "drugID")
    private long drugID;
    private String name;
    private double price;
}
