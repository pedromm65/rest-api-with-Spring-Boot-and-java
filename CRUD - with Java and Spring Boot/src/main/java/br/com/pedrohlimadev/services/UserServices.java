package br.com.pedrohlimadev.services;

import br.com.pedrohlimadev.controllers.PersonController;
import br.com.pedrohlimadev.data.vo.v1.PersonVO;
import br.com.pedrohlimadev.exceptions.RequiredObjectIsNullException;
import br.com.pedrohlimadev.exceptions.ResourceNotFoundException;
import br.com.pedrohlimadev.mapper.DozerMapper;
import br.com.pedrohlimadev.model.Person;
import br.com.pedrohlimadev.repositories.PersonRepository;
import br.com.pedrohlimadev.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@Service
public class UserServices implements UserDetailsService {

    private final Logger logger = Logger.getLogger(UserServices.class.getName());


    @Autowired
    UserRepository repository;

    public UserServices(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("Finding one user by username " + username + "!");
        var user = repository.findByUsername(username);

        if (user != null) {
            return user;
        } else {
            throw new UsernameNotFoundException("Username " + username + " not found!");
        }

    }
}
