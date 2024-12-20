package com.mvn_project.SustEnergy.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "energy_device")
public class EnergyDevice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String type;
    private Double capacity;
    private String status;

    @ManyToOne
    private User user; // Associação com User

    // Construtor padrão
    public EnergyDevice() {}

    // Construtor com parâmetros
    public EnergyDevice(String name, String type, Double capacity, User user) {
        this.name = name;
        this.type = type;
        this.capacity = capacity;
        this.user = user;
    }

    public EnergyDevice(String string, String string2, double d, String string3, Object object) {
        //TODO Auto-generated constructor stub
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getCapacity() {
        return capacity;
    }

    public void setCapacity(Double capacity) {
        this.capacity = capacity;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

