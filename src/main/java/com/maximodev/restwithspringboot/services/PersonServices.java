package com.maximodev.restwithspringboot.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maximodev.restwithspringboot.data.vo.v1.PersonVO;
import com.maximodev.restwithspringboot.data.vo.v2.PersonVOV2;
import com.maximodev.restwithspringboot.exceptions.ResourceNotFoundException;
import com.maximodev.restwithspringboot.mapper.DozerMapper;
import com.maximodev.restwithspringboot.mapper.custom.PersonMapper;
import com.maximodev.restwithspringboot.model.Person;
import com.maximodev.restwithspringboot.repositories.PersonRepository;

@Service
public class PersonServices {
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonMapper personMapper;

    public List<PersonVO> findAll(){
        logger.info("Finding all people!");

        return DozerMapper.parseListObjects(personRepository.findAll(), PersonVO.class);
    }
    public PersonVO findById(Long id){
        logger.info("Finding one person!");

        var entity = personRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        return DozerMapper.parseObject(entity, PersonVO.class);
    }

    public PersonVO create(PersonVO person) {
        logger.info("Creating one person!");
        var entity = DozerMapper.parseObject(person, Person.class);
        return DozerMapper.parseObject(personRepository.save(entity), PersonVO.class);
    }


    public PersonVOV2 createV2(PersonVOV2 person) {
        logger.info("Creating one person!");
        var entity = personMapper.convertVoToEntity(person);
        return personMapper.convertEntityToVo(personRepository.save(entity));
    }

    public PersonVO update(PersonVO person) {
        logger.info("Updating one person!");

        Person entity = personRepository.findById(person.getId())
        .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return DozerMapper.parseObject(personRepository.save(entity), PersonVO.class);
    }

    public void delete(Long id) {
        logger.info("Deleting one person!");

        Person entity = personRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        personRepository.delete(entity);

    }
    
}
