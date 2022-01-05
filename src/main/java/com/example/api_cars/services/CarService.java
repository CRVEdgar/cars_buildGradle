package com.example.api_cars.services;

import com.example.api_cars.controller.request.CarRequest;
import com.example.api_cars.controller.request.PartsResquest;
import com.example.api_cars.controller.response.CarResponse;
import com.example.api_cars.controller.response.PartsResponse;
import com.example.api_cars.core.Converter;
import com.example.api_cars.entities.Car;
import com.example.api_cars.entities.PartsCar;
import com.example.api_cars.repository.CarRepository;
import com.example.api_cars.repository.PartsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private PartsRepository partsRepository;

    @Autowired
    private Converter converterService;

    public List<CarResponse> findAllCar(){
        List<Car> cars = carRepository.findAll();
        return converterService.fromListModelToResponse(cars);
    }

    public List<PartsResponse> findAllCarParts(Long cardId){
        List<PartsCar> parts = partsRepository.findByCarId(cardId);
        return converterService.fromListModelToPartsResponse(parts);
    }

    @Transactional
    public CarResponse addCAr(CarRequest request){
        Car carSave = carRepository.save(
                converterService.fromCarRequest(request)
        );

        return converterService.fromModelToCarResponse(carSave);
    }

    @Transactional
    public PartsResponse addParts(PartsResquest request){
        PartsCar parts = partsRepository.save(
                converterService.fromPartsRequest(request)
        );

        return converterService.fromModelToPartsResponse(parts);
    }
}
