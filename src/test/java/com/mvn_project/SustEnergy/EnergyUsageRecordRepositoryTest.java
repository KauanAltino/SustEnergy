package com.mvn_project.SustEnergy;

import com.mvn_project.SustEnergy.model.EnergyDevice;
import com.mvn_project.SustEnergy.model.EnergyUsageRecord;
import com.mvn_project.SustEnergy.repository.EnergyDeviceRepository;
import com.mvn_project.SustEnergy.repository.EnergyUsageRecordRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class EnergyUsageRecordRepositoryTest {

    @Autowired
    private EnergyDeviceRepository energyDeviceRepository;

    @Autowired
    private EnergyUsageRecordRepository energyUsageRecordRepository;

    @Test
    public void testCreateAndFindEnergyUsageRecord() {
        // Criando e salvando a instância de EnergyDevice primeiro
        EnergyDevice device = new EnergyDevice();
        device.setName("Solar Panel");
        device.setType("Solar");
        device.setCapacity(5000.0);
        device.setStatus("Active");
        energyDeviceRepository.save(device);  // Persistindo a instância de EnergyDevice
    
        // Criando o EnergyUsageRecord e associando ao dispositivo salvo
        EnergyUsageRecord record = new EnergyUsageRecord();
        record.setDevice(device);  // Associando o dispositivo salvo
        record.setTimestamp(LocalDate.now());  // Ajuste conforme sua necessidade
        record.setEnergyConsumed(150.0);
        record.setEnergyGenerated(200.0);
    
        // Salvando o EnergyUsageRecord
        energyUsageRecordRepository.save(record);
    
        // Recuperando e verificando o registro
        Optional<EnergyUsageRecord> foundRecord = energyUsageRecordRepository.findById(record.getId());
        assertTrue(foundRecord.isPresent());
        assertEquals(150.0, foundRecord.get().getEnergyConsumed());
        assertEquals(200.0, foundRecord.get().getEnergyGenerated());
        assertEquals(device.getId(), foundRecord.get().getDevice().getId());
    }
}
