package com.example.api_cars.core;


import com.example.api_cars.controller.request.CarRequest;
import com.example.api_cars.controller.request.PartsResquest;
import com.example.api_cars.controller.response.CarResponse;
import com.example.api_cars.controller.response.PartsResponse;
import com.example.api_cars.entities.Car;
import com.example.api_cars.entities.PartsCar;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Converter {

    public CarResponse fromModelToCarResponse(Car car){
        return new CarResponse(
                car.getId(),
                car.getMake(),
                car.getModel(),
                car.getYearCar()
        );
    }

    public Car fromCarRequest(CarRequest request){
        Car carSave = new Car(
                request.getMake(),
                request.getModel(),
                request.getYear()
        );
        return  carSave;
    }

    public PartsResponse fromModelToPartsResponse(PartsCar parts){
        return new PartsResponse(
                parts.getId(),
                parts.getPartNumber(),
                parts.getName(),
                parts.getCost()
        );
    }

    public PartsCar fromPartsRequest(PartsResquest request){
        PartsCar partsSave = new PartsCar(
                request.getCarId(),
                request.getPartNumber(),
                request.getName(),
                request.getCost()
        );
        return  partsSave;
    }

    public List<CarResponse> fromListModelToResponse(List<Car> cars){
        List<CarResponse> carResponseList = new ArrayList<>();

        for(Car carConverter : cars){
            carResponseList.add(
                    new CarResponse(
                            carConverter.getId(),
                            carConverter.getMake(),
                            carConverter.getModel(),
                            carConverter.getYearCar()
                    )
            );
        }

        return carResponseList;
    }

    public List<PartsResponse> fromListModelToPartsResponse(List<PartsCar> partsCar){
        List<PartsResponse> partsResponseList = new ArrayList<>();

        for(PartsCar partsConverter : partsCar){
            partsResponseList.add(
                    new PartsResponse(
                            partsConverter.getCarId(),
                            partsConverter.getPartNumber(),
                            partsConverter.getName(),
                            partsConverter.getCost()
                    )
            );
        }
        return partsResponseList;
    }

}
