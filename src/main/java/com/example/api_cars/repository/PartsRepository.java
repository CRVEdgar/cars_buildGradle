package com.example.api_cars.repository;

import com.example.api_cars.entities.PartsCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PartsRepository extends JpaRepository<PartsCar, Long> {

    List<PartsCar> findByCarId(Long cardId);
}
