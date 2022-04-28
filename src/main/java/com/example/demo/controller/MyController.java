package com.example.demo.controller;

import com.example.demo.model.Car;
import com.example.demo.repository.MyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

    private final MyRepository repository;

    @Autowired
    public MyController(MyRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public String toDo() {
        return "index";
    }

    @GetMapping("/add")
    public @ResponseBody String add(@RequestParam String name,
               @RequestParam Integer power) {
        Car car = new Car(name,power);
        repository.save(car);
        return "Saved!";
    }

    @GetMapping("/list")
    public @ResponseBody Iterable<Car> getAll() {
        return repository.findAll();
    }
}
