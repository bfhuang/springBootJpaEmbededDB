package com.jpaexample.controller;


import com.jpaexample.model.Person;
import com.jpaexample.model.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    PersonRepository repository;
    /**
     * GET /create  --> Create a new booking and save it in the database.
     */
    @RequestMapping("/create")
    public Map<String, Object> create(Person person) {

        Person save = repository.save(person);
        Map<String, Object> dataMap = new HashMap<String, Object>();
        dataMap.put("message", "Person created successfully");
        dataMap.put("status", "1");
        dataMap.put("person", save);
        return dataMap;
    }

    /**
     * GET /read  --> Read a booking by booking id from the database.
     */
    @RequestMapping("/read")
    public Map<String, Object> read(@RequestParam Long personId) {
        Person person = (Person) repository.findOne(personId);
        Map<String, Object> dataMap = new HashMap<String, Object>();
        dataMap.put("message", "Person found successfully");
        dataMap.put("status", "1");
        dataMap.put("person", person);
        return dataMap;
    }

    /**
     * GET /update  --> Update a booking record and save it in the database.
     */
    @RequestMapping("/update")
    public Map<String, Object> update(@RequestParam Long personId, @RequestParam String firstName) {
        Person person = (Person) repository.findOne(personId);
        person.setFirstName(firstName);
        person = repository.save(person);
        Map<String, Object> dataMap = new HashMap<String, Object>();
        dataMap.put("message", "Person updated successfully");
        dataMap.put("status", "1");
        dataMap.put("person", person);
        return dataMap;
    }

    /**
     * GET /delete  --> Delete a booking from the database.
     */
    @RequestMapping("/delete")
    public Map<String, Object> delete(@RequestParam Long personId) {
        repository.delete(personId);
        Map<String, Object> dataMap = new HashMap<String, Object>();
        dataMap.put("message", "Person deleted successfully");
        dataMap.put("status", "1");
        return dataMap;
    }

    /**
     * GET /read  --> Read all booking from the database.
     */
    @RequestMapping("/read-all")
    public Map<String, Object> readAll() {
        List<Person> persons = (List<Person>) repository.findAll();
        Map<String, Object> dataMap = new HashMap<String, Object>();
        dataMap.put("message", "Person found successfully");
        dataMap.put("totalBooking", persons.size());
        dataMap.put("status", "1");
        dataMap.put("persons", persons);
        return dataMap;
    }
}
