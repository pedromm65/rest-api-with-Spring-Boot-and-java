package br.com.pedrohlimadev.unittests.mockito.services;

import br.com.pedrohlimadev.data.vo.v1.BookVO;
import br.com.pedrohlimadev.data.vo.v1.PersonVO;
import br.com.pedrohlimadev.exceptions.RequiredObjectIsNullException;
import br.com.pedrohlimadev.model.Book;
import br.com.pedrohlimadev.model.Person;
import br.com.pedrohlimadev.repositories.BookRepository;
import br.com.pedrohlimadev.services.BookServices;
import br.com.pedrohlimadev.unittests.mapper.mocks.MockBook;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;


@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
class BookServicesTest {

    MockBook input;

    @InjectMocks
    private BookServices service;

    @Mock
    BookRepository repository;

    @BeforeEach
    void SetUpMocks() throws Exception {
        input = new MockBook();
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findAll() {
        List<Book> list = input.mockEntityList();

        when(repository.findAll()).thenReturn(list);

        var books = service.findAll();

        assertNotNull(books);
        assertEquals(14, books.size());

        var bookOne = books.get(1);

        assertNotNull(bookOne);
        assertNotNull(bookOne.getKey());
        assertNotNull(bookOne.getLinks());

        assertTrue(bookOne.toString().contains("links: [</api/book/v1/1>;rel=\"self\"]"));
        assertEquals(Long.valueOf(1L), bookOne.getKey());
        assertEquals("Author Test1", bookOne.getAuthor());
        assertEquals("Title Test1", bookOne.getTitle());
        assertEquals(1D, bookOne.getPrice());
        assertNotNull(bookOne.getLaunchDate());

        var bookFour = books.get(4);
        assertNotNull(bookFour);
        assertNotNull(bookFour.getKey());
        assertNotNull(bookFour.getLinks());

        assertTrue(bookFour.toString().contains("links: [</api/book/v1/4>;rel=\"self\"]"));
        assertEquals(Long.valueOf(4), bookFour.getKey());
        assertEquals("Author Test4", bookFour.getAuthor());
        assertEquals("Title Test4", bookFour.getTitle());
        assertEquals(1D, bookFour.getPrice());
        assertNotNull(bookFour.getLaunchDate());


        var bookSeven = books.get(7);
        assertNotNull(bookSeven);
        assertNotNull(bookSeven.getKey());
        assertNotNull(bookSeven.getLinks());

        assertTrue(bookSeven.toString().contains("links: [</api/book/v1/7>;rel=\"self\"]"));
        assertEquals(Long.valueOf(7), bookSeven.getKey());
        assertEquals("Author Test7", bookSeven.getAuthor());
        assertEquals("Title Test7", bookSeven.getTitle());
        assertEquals(1D, bookSeven.getPrice());
        assertNotNull(bookSeven.getLaunchDate());


    }

    @Test
    void findById() {
        Book entity = input.mockEntity(1);
        entity.setId(1L);

        when(repository.findById(1L)).thenReturn(Optional.of(entity));

        var result = service.findById(1L);

        assertNotNull(result);
        assertNotNull(result.getKey());
        assertNotNull(result.getLinks());

        assertTrue(result.toString().contains("links: [</api/book/v1/1>;rel=\"self\"]"));
        assertEquals(Long.valueOf(1L), result.getKey());
        assertEquals("Author Test1", result.getAuthor());
        assertEquals("Title Test1", result.getTitle());
        assertEquals(1D, result.getPrice());
        assertNotNull(result.getLaunchDate());


    }

    @Test
    void create() {

        Book entity = input.mockEntity(1);
        entity.setId(1L);

        Book persisted = entity;
        persisted.setId(1L);

        BookVO vo = input.mockVO(1);
        vo.setKey(1L);

        when(repository.save(entity)).thenReturn(persisted);

        var result = service.create(vo);

        assertNotNull(result);
        assertNotNull(result.getKey());
        assertNotNull(result.getLinks());

        assertTrue(result.toString().contains("links: [</api/book/v1/1>;rel=\"self\"]"));
        assertEquals("Author Test1", result.getAuthor());
        assertEquals("Title Test1", result.getTitle());
        assertEquals(1D, result.getPrice());
        assertNotNull(result.getLaunchDate());

    }
    @Test
    void createWithNullBook() {
        Exception exception = assertThrows(RequiredObjectIsNullException.class, () -> {
            service.create(null);
        });

        String expectedMessage = "Is is not allowed to persist a null object!";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
    @Test
    void updateWithNullBook() {
        Exception exception = assertThrows(RequiredObjectIsNullException.class, () -> {
            service.update(null);
        });

        String expectedMessage = "Is is not allowed to persist a null object!";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void update() {
        Book entity = input.mockEntity(1);
        entity.setId(1L);

        Book persisted = entity;
        persisted.setId(1L);

        BookVO vo = input.mockVO(1);
        vo.setKey(1L);

        when(repository.findById(1L)).thenReturn(Optional.of(entity));
        when(repository.save(entity)).thenReturn(persisted);

        var result = service.update(vo);

        assertNotNull(result);
        assertNotNull(result.getKey());
        assertNotNull(result.getLinks());

        assertTrue(result.toString().contains("links: [</api/book/v1/1>;rel=\"self\"]"));
        assertEquals(Long.valueOf(1L), result.getKey());
        assertEquals("Author Test1", result.getAuthor());
        assertEquals("Title Test1", result.getTitle());
        assertEquals(1D, result.getPrice());
        assertNotNull(result.getLaunchDate());

    }

    @Test
    void delete() {
        Book entity = input.mockEntity();
        entity.setId(1L);

        when(repository.findById(1L)).thenReturn(Optional.of(entity));

        service.findById(1L);
    }
}