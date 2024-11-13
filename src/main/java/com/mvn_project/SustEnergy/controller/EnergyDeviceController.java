package com.mvn_project.SustEnergy.controller;

import com.mvn_project.SustEnergy.model.EnergyDevice;
import com.mvn_project.SustEnergy.repository.EnergyDeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/energy-devices")
public class EnergyDeviceController {

    @Autowired
    private EnergyDeviceRepository energyDeviceRepository;

    @GetMapping
    public List<EnergyDevice> getAllDevices() {
        return energyDeviceRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnergyDevice> getDeviceById(@PathVariable Long id) {
        Optional<EnergyDevice> device = energyDeviceRepository.findById(id);
        return device.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public EnergyDevice createDevice(@RequestBody EnergyDevice device) {
        return energyDeviceRepository.save(device);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnergyDevice> updateDevice(@PathVariable Long id, @RequestBody EnergyDevice updatedDevice) {
        return energyDeviceRepository.findById(id).map(device -> {
            device.setName(updatedDevice.getName());
            device.setStatus(updatedDevice.getStatus());
            return ResponseEntity.ok(energyDeviceRepository.save(device));
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDevice(@PathVariable Long id) {
        if (energyDeviceRepository.existsById(id)) {
            energyDeviceRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
