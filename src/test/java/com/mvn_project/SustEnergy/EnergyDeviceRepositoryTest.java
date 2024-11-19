package com.mvn_project.SustEnergy;

import com.mvn_project.SustEnergy.model.EnergyDevice;
import com.mvn_project.SustEnergy.repository.EnergyDeviceRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class EnergyDeviceRepositoryTest {

    @Autowired
    private EnergyDeviceRepository energyDeviceRepository;

    @Test
    public void testCreateAndFindEnergyDevice() {
        EnergyDevice device = new EnergyDevice();
        device.setName("Solar Panel");
        device.setType("Solar");
        device.setCapacity(5000.0);
        device.setStatus("Active");
    
        // Salve o objeto
        energyDeviceRepository.save(device);

        // Tente recuperar o objeto salvo
        Optional<EnergyDevice> foundDevice = energyDeviceRepository.findById(device.getId());
        assertTrue(foundDevice.isPresent());
        assertEquals("Solar Panel", foundDevice.get().getName());
    }


    @Test
    public void testUpdateEnergyDevice() {
        EnergyDevice device = new EnergyDevice("Wind Turbine", "Wind", 6000.0, "Active", null);
        energyDeviceRepository.save(device);

        device.setStatus("Inactive");
        EnergyDevice updatedDevice = energyDeviceRepository.save(device);

        assertEquals("Inactive", updatedDevice.getStatus());
    }

    @Test
    public void testDeleteEnergyDevice() {
        EnergyDevice device = new EnergyDevice("Hydro Generator", "Hydro", 10000.0, "Active", null);
        energyDeviceRepository.save(device);

        energyDeviceRepository.deleteById(device.getId());

        Optional<EnergyDevice> foundDevice = energyDeviceRepository.findById(device.getId());
        assertFalse(foundDevice.isPresent());
    }
}
