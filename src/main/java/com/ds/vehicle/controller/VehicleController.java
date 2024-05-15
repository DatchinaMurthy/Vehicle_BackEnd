package com.ds.vehicle.controller;

import com.ds.vehicle.model.Vehicle;
import com.ds.vehicle.service.impl.VehicleServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/Vehicle")
public class VehicleController {

    @Autowired
    private VehicleServiceImpl vehicleService;

    @GetMapping
    public List<Vehicle> getAllVehicle(){
        return vehicleService.getAllVehicle();
    }


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Vehicle> createPost(@Valid @RequestBody Vehicle vehicle){
        return new ResponseEntity<>(vehicleService.saveOrUpdate(vehicle), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vehicle> updatePost(@PathVariable(name = "id") long id, @Valid @RequestBody Vehicle vehicle){
        Vehicle vehicleRes=vehicleService.Update(vehicle,id);
        return new ResponseEntity<>(vehicleRes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> getPostById(@PathVariable(name = "id") long id){
        return ResponseEntity.ok(vehicleService.getVehicle(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVehicle(@PathVariable(name = "id") long id){
        vehicleService.deleteVehicleById(id);
        return new ResponseEntity<>("Vehicle Entity is Deleted", HttpStatus.OK);
    }
}
