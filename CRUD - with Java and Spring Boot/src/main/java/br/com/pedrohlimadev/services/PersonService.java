package br.com.pedrohlimadev.services;

import br.com.pedrohlimadev.data.vo.v1.PersonVO;
import br.com.pedrohlimadev.data.vo.v2.PersonVOV2;
import br.com.pedrohlimadev.exceptions.ResourceNotFoundException;
import br.com.pedrohlimadev.mapper.DozerMapper;
import br.com.pedrohlimadev.mapper.custom.PersonMapper;
import br.com.pedrohlimadev.model.Person;
import br.com.pedrohlimadev.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import java.util.logging.Logger;


@Service
public class PersonService {

    private final Logger logger = Logger.getLogger(PersonService.class.getName());


    @Autowired
    PersonRepository repository;

    @Autowired
    PersonMapper mapper;
    public List<PersonVO> findAll() {
        List<PersonVO> persons = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            PersonVO person = mockPerson(i);
            persons.add(person);
        }

        return DozerMapper.parseListObjects(repository.findAll(), PersonVO.class);
    }


    public PersonVO findById(Long id) {
        logger.info("Finding one person!");

        PersonVO person = new PersonVO();

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        return DozerMapper.parseObject(entity, PersonVO.class);
    }

    public PersonVO create(PersonVO person) {
        logger.info("Creating one person!");

        var entity = DozerMapper.parseObject(person, Person.class);

        var vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);

        return vo;
    }

    public PersonVOV2 createV2(PersonVOV2 person) {
        logger.info("Creating one person with V2!");

        var entity = mapper.convertVoToEntity(person);

        var vo = mapper.convertEntitytoVO(repository.save(entity));

        return vo;
    }

    public PersonVO update(PersonVO person) {
        logger.info("Updating one person!");

        var entity = repository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        var vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);

        return vo;
    }

    public void delete(Long id) {
        logger.info("Deleting one person!");

        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        repository.delete(entity);
    }

    private PersonVO mockPerson(int i) {
        logger.info("Finding all people!");

        PersonVO person = new PersonVO();

        person.setFirstName("PersonVO name: " + i);
        person.setLastName("Last name: " + i);
        person.setAddress("Some address in Brasil: " + i);
        person.setGender("Male");

        return person;
    }

}
