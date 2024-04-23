package com.maximodev.restwithspringboot.Services;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.maximodev.restwithspringboot.model.Person;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public Person findById(String id){
        logger.info("Finding one person!");

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Felpola");
        person.setLastName("OFelps");
        person.setAddress("Diadema - São Paulo - Brasil");
        person.setGender("Male");
        return person;
    }
    
}
