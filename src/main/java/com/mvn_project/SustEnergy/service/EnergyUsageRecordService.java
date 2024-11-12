package com.mvn_project.SustEnergy.service;

import com.mvn_project.SustEnergy.model.EnergyUsageRecord;
import com.mvn_project.SustEnergy.repository.EnergyUsageRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnergyUsageRecordService {

    private final EnergyUsageRecordRepository energyUsageRecordRepository;

    @Autowired
    public EnergyUsageRecordService(EnergyUsageRecordRepository energyUsageRecordRepository) {
        this.energyUsageRecordRepository = energyUsageRecordRepository;
    }

    public List<EnergyUsageRecord> findAllRecords() {
        return energyUsageRecordRepository.findAll();
    }

    public Optional<EnergyUsageRecord> findRecordById(Long id) {
        return energyUsageRecordRepository.findById(id);
    }

    public EnergyUsageRecord saveRecord(EnergyUsageRecord energyUsageRecord) {
        return energyUsageRecordRepository.save(energyUsageRecord);
    }

    public void deleteRecordById(Long id) {
        energyUsageRecordRepository.deleteById(id);
    }
}
