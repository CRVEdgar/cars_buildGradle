package com.example.api_cars.controller;

import com.example.api_cars.controller.request.CarRequest;
import com.example.api_cars.controller.request.PartsResquest;
import com.example.api_cars.controller.response.CarResponse;
import com.example.api_cars.controller.response.PartsResponse;
import com.example.api_cars.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {
    @Autowired
    private CarService service;

    @GetMapping("/{carId}")
    public List<PartsResponse> findParts(@PathVariable Long carId){
        return service.findAllCarParts(carId);
    }

    @GetMapping
    public List<CarResponse> findAllCar(){
        return service.findAllCar();
    }

    @PostMapping("/car")
    @ResponseStatus(HttpStatus.CREATED)
    public CarResponse AddCar(CarRequest request){
        return service.addCAr(request);
    }

    @PostMapping("/parts")
    @ResponseStatus(HttpStatus.CREATED)
    public PartsResponse AddParts(PartsResquest request){
        return service.addParts(request);
    }
}
