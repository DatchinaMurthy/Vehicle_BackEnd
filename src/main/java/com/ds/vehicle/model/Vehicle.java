package com.ds.vehicle.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;

@Data
@Table
@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;
    @Column(name = "yr")
    @NotEmpty
    @Size(min=4, message = "Please enter the valid year")
    private String year;
    @Column
    private String make;
    @Column
    private String model;
    @Column
    private int vin;
}
