package com.example.demo.repository;

import com.example.demo.model.Car;
import org.springframework.data.repository.CrudRepository;

// CRUD - Create Read Update Delete

public interface MyRepository extends CrudRepository<Car,Integer> {

}
