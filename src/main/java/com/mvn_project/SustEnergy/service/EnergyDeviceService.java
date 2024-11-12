package com.mvn_project.SustEnergy.service;

import com.mvn_project.SustEnergy.model.EnergyDevice;
import com.mvn_project.SustEnergy.repository.EnergyDeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnergyDeviceService {

    private final EnergyDeviceRepository energyDeviceRepository;

    @Autowired
    public EnergyDeviceService(EnergyDeviceRepository energyDeviceRepository) {
        this.energyDeviceRepository = energyDeviceRepository;
    }

    public List<EnergyDevice> findAllDevices() {
        return energyDeviceRepository.findAll();
    }

    public Optional<EnergyDevice> findDeviceById(Long id) {
        return energyDeviceRepository.findById(id);
    }

    public EnergyDevice saveDevice(EnergyDevice energyDevice) {
        return energyDeviceRepository.save(energyDevice);
    }

    public void deleteDeviceById(Long id) {
        energyDeviceRepository.deleteById(id);
    }
}
