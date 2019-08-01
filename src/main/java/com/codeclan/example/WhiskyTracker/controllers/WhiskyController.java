package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/whiskies")
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;

    @GetMapping
    public List<Whisky> getAllWhiskys(){
        return whiskyRepository.findAll();
    }

    @GetMapping(value = "/years/{year}")
    public List<Whisky> findWhiskyOfParticularYear(@PathVariable int year){
        return whiskyRepository.findWhiskyOfParticularYear(year);
    }

    @GetMapping(value = "/{id}")
    public List<Whisky> findWhiskyBasedOnId(@PathVariable int id){
        return whiskyRepository.findWhiskyOfParticularYear(id);
    }

    @GetMapping(value = "/distillery/age/{age}")
    public List<Whisky> findWhiskyBasedOnDistilleryAndAge(@PathVariable int age){
        return whiskyRepository.findWhiskyBasedOnDistilleryAndAge(age);
    }




}
