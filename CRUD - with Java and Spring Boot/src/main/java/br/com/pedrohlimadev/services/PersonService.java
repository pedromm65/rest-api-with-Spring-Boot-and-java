package br.com.pedrohlimadev.services;

import br.com.pedrohlimadev.exceptions.ResourceNotFoundException;
import br.com.pedrohlimadev.model.Person;
import br.com.pedrohlimadev.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;


@Service
public class PersonService {

    private final Logger logger = Logger.getLogger(PersonService.class.getName());


    @Autowired
    PersonRepository repository;
    public List<Person> findAll() {
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            Person person = mockPerson(i);
            persons.add(person);
        }

        return repository.findAll();
    }


    public Person findById(Long id) {
        logger.info("Finding one person!");

        Person person = new Person();



        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
    }

    public Person create(Person person) {
        logger.info("Creating one person!");

        return  repository.save(person);
    }

    public Person update(Person person) {
        logger.info("Updating one person!");

        var entity = repository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return repository.save(entity);
    }

    public void delete(Long id) {
        logger.info("Deleting one person!");

        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        repository.delete(entity);
    }

    private Person mockPerson(int i) {
        logger.info("Finding all people!");

        Person person = new Person();

        person.setFirstName("Person name: " + i);
        person.setLastName("Last name: " + i);
        person.setAddress("Some addres in Brasil: " + i);
        person.setGender("Male");

        return person;
    }

}
