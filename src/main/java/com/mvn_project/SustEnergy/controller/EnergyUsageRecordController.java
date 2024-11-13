package com.mvn_project.SustEnergy.controller;

import com.mvn_project.SustEnergy.model.EnergyUsageRecord;
import com.mvn_project.SustEnergy.repository.EnergyUsageRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/energy-usage")
public class EnergyUsageRecordController {

    @Autowired
    private EnergyUsageRecordRepository energyUsageRecordRepository;

    @GetMapping
    public List<EnergyUsageRecord> getAllRecords() {
        return energyUsageRecordRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnergyUsageRecord> getRecordById(@PathVariable Long id) {
        Optional<EnergyUsageRecord> record = energyUsageRecordRepository.findById(id);
        return record.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public EnergyUsageRecord createRecord(@RequestBody EnergyUsageRecord record) {
        return energyUsageRecordRepository.save(record);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnergyUsageRecord> updateRecord(@PathVariable Long id, @RequestBody EnergyUsageRecord updatedRecord) {
        return energyUsageRecordRepository.findById(id).map(record -> {
            record.setEnergyConsumed(updatedRecord.getEnergyConsumed());
            record.setTimestamp(updatedRecord.getTimestamp());
            return ResponseEntity.ok(energyUsageRecordRepository.save(record));
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecord(@PathVariable Long id) {
        if (energyUsageRecordRepository.existsById(id)) {
            energyUsageRecordRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
