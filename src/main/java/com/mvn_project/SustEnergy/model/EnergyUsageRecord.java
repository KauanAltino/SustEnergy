package com.mvn_project.SustEnergy.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;
import jakarta.persistence.Table;


@Entity
@Table(name = "energy_usage_record")
public class EnergyUsageRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "device_id")
    private EnergyDevice device; 

    private LocalDate timestamp;
    private Double energyConsumed;
    private Double energyGenerated;

    // Construtor padrão
    public EnergyUsageRecord() {}

    // Construtor com parâmetros
    public EnergyUsageRecord(EnergyDevice device, LocalDate timestamp, Double energyConsumed, Double energyGenerated) {
        this.device = device;
        this.timestamp = timestamp;
        this.energyConsumed = energyConsumed;
        this.energyGenerated = energyGenerated;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EnergyDevice getDevice() {
        return device;
    }

    public void setDevice(EnergyDevice device) {
        this.device = device;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDate timestamp) {
        this.timestamp = timestamp;
    }

    public Double getEnergyConsumed() {
        return energyConsumed;
    }

    public void setEnergyConsumed(Double energyConsumed) {
        this.energyConsumed = energyConsumed;
    }

    public Double getEnergyGenerated() {
        return energyGenerated;
    }

    public void setEnergyGenerated(Double energyGenerated) {
        this.energyGenerated = energyGenerated;
    }
}

