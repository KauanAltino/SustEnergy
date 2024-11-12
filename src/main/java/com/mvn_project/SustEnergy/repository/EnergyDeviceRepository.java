package com.mvn_project.SustEnergy.repository;

import com.mvn_project.SustEnergy.model.EnergyDevice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnergyDeviceRepository extends JpaRepository<EnergyDevice, Long> {
}
