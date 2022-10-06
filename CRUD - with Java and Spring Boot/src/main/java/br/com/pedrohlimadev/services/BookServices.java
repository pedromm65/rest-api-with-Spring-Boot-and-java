package br.com.pedrohlimadev.services;


import br.com.pedrohlimadev.controllers.BookControllers;
import br.com.pedrohlimadev.data.vo.v1.BookVO;
import br.com.pedrohlimadev.exceptions.ResourceNotFoundException;
import br.com.pedrohlimadev.mapper.DozerMapper;
import br.com.pedrohlimadev.model.Book;
import br.com.pedrohlimadev.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

@Service
public class BookServices {

    @Autowired
    private BookRepository repository;

    public List<BookVO> findAll() {
        var books = DozerMapper.parseListObjects(repository.findAll(), BookVO.class);
        books.forEach(b -> b.add(linkTo(methodOn(BookControllers.class).findById(b.getKey())).withSelfRel()));
        return books;
    }

    public BookVO findById(Long id) {
        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        var vo = DozerMapper.parseObject(entity, BookVO.class);
        vo.add(linkTo(methodOn(BookControllers.class).findById(vo.getKey())).withSelfRel());

        return vo;
    }

    public BookVO create(BookVO book) {
        var entity = DozerMapper.parseObject(book, Book.class);
        var vo = DozerMapper.parseObject(repository.save(entity), BookVO.class);

        vo.add(linkTo(methodOn(BookControllers.class).findById(vo.getKey())).withSelfRel());

        return vo;
    }

    public BookVO update(BookVO book) {
        var entity = repository.findById(book.getKey())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        entity.setAuthor(book.getAuthor());
        entity.setTitle(book.getTitle());
        entity.setLaunchDate(book.getLaunchDate());
        entity.setPrice(book.getPrice());

        var vo = DozerMapper.parseObject(repository.save(entity), BookVO.class);

        vo.add(linkTo(methodOn(BookControllers.class).findById(vo.getKey())).withSelfRel());

        return vo;
    }

    public void delete(Long id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        repository.delete(entity);
    }
}
