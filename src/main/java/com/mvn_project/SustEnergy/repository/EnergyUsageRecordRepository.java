package com.mvn_project.SustEnergy.repository;

import com.mvn_project.SustEnergy.model.EnergyUsageRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnergyUsageRecordRepository extends JpaRepository<EnergyUsageRecord, Long> {
}
