package com.ds.vehicle.service.impl;

import com.ds.vehicle.model.Vehicle;
import com.ds.vehicle.repository.VehicleRepository;
import com.ds.vehicle.service.VehicleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Slf4j
@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;
    @Override
    public List<Vehicle> getAllVehicle() {
        return vehicleRepository.findAll().stream().collect(Collectors.toList());
    }

    @Override
    public Vehicle saveOrUpdate(Vehicle vehicle) {
        vehicleRepository.save(vehicle);
        return vehicle;
    }

    @Override
    public Vehicle getVehicle(long id) {
        return vehicleRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public Vehicle Update(Vehicle vehicle, long id) {
        Vehicle updateVehicle=new Vehicle();
        Optional<Vehicle> checkVehicle=vehicleRepository.findById(id);
        if(checkVehicle.isPresent()){
            updateVehicle.setMake(vehicle.getMake());
            updateVehicle.setModel(vehicle.getModel());
            updateVehicle.setVin(vehicle.getVin());
            updateVehicle.setYear(vehicle.getYear());
            vehicleRepository.saveAndFlush(updateVehicle);
        }
        return updateVehicle;
    }

    @Override
    public void deleteVehicleById(long id) {
        Vehicle vehicle=vehicleRepository.findById(id).orElseThrow(()-> new RuntimeException("No Data"));
        vehicleRepository.delete(vehicle);
    }
}
