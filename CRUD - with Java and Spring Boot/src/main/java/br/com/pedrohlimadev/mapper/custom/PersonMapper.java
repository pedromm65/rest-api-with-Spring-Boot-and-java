package br.com.pedrohlimadev.mapper.custom;

import br.com.pedrohlimadev.data.vo.v1.PersonVO;
import br.com.pedrohlimadev.data.vo.v2.PersonVOV2;
import br.com.pedrohlimadev.model.Person;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PersonMapper {

    public PersonVOV2 convertEntitytoVO(Person person) {
        PersonVOV2 vo = new PersonVOV2();
        vo.setId(person.getId());
        vo.setAddress(person.getAddress());
        vo.setFirstName(person.getFirstName());
        vo.setBirthDay(new Date());
        vo.setGender(person.getGender());
        vo.setLastName(person.getLastName());

        return vo;
    }

    public Person convertVoToEntity(PersonVOV2 person) {
        Person entity = new Person();
        entity.setId(person.getId());
        entity.setAddress(person.getAddress());
        entity.setFirstName(person.getFirstName());
        //vo.setBirthDay(new Date());
        entity.setGender(person.getGender());
        entity.setLastName(person.getLastName());

        return entity;
    }
}
