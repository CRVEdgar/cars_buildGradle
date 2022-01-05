package com.example.api_cars.controller.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PartsResponse {

    private Long carId;
    private String partNumber;
    private String name;
    private Double cost;
}
