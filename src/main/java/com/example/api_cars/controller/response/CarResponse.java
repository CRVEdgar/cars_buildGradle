package com.example.api_cars.controller.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CarResponse {

    private Long id;
    private String make;
    private String model;
    private int year;
}
