package com.amsidh.mvc.springbootsonardemo.controller;

import com.amsidh.mvc.springbootsonardemo.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/demo")
public class DemoController {

    @GetMapping
    public String hello() {
        return "Hello World Springboot Demo App";
    }

    @GetMapping("/person/{personId}")
    public Person getPerson(@PathVariable String personId) {
        return Person.builder().personId(personId).personName("Amsidh").age(38).build();
    }
}
