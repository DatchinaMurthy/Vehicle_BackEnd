package com.ds.vehicle.service;

import com.ds.vehicle.model.Vehicle;

import java.util.List;

public interface VehicleService {

    List<Vehicle> getAllVehicle();

    Vehicle saveOrUpdate(Vehicle vehicle);

    Vehicle getVehicle(long id);

    Vehicle Update(Vehicle vehicle, long id);

    void deleteVehicleById(long id);
}
