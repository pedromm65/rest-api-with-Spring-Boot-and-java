package br.com.pedrohlimadev.unittests.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import br.com.pedrohlimadev.data.vo.v1.BookVO;
import br.com.pedrohlimadev.data.vo.v1.PersonVO;
import br.com.pedrohlimadev.mapper.DozerMapper;
import br.com.pedrohlimadev.model.Book;
import br.com.pedrohlimadev.model.Person;
import br.com.pedrohlimadev.unittests.mapper.mocks.MockBook;
import br.com.pedrohlimadev.unittests.mapper.mocks.MockPerson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DozerConverterTest {
    
    MockPerson inputPerson;
    MockBook inputBook;

    @BeforeEach
    public void setUp() {
        inputPerson = new MockPerson();
        inputBook = new MockBook();
    }

    @Test
    public void parseEntityToVOTest() {
        PersonVO outputPerson = DozerMapper.parseObject(inputPerson.mockEntity(), PersonVO.class);
        BookVO outputBook = DozerMapper.parseObject(inputBook.mockEntity(), BookVO.class);

        assertEquals(Long.valueOf(0L), outputPerson.getKey());
        assertEquals("First Name Test0", outputPerson.getFirstName());
        assertEquals("Last Name Test0", outputPerson.getLastName());
        assertEquals("Address Test0", outputPerson.getAddress());
        assertEquals("Male", outputPerson.getGender());

        assertEquals(Long.valueOf(0L), outputBook.getKey());
        assertEquals("Author Test0", outputBook.getAuthor());
        assertEquals("Title Test0", outputBook.getTitle());
        assertEquals(1D, outputBook.getPrice());
        //assertEquals(new Date(), outputBook.getLaunchDate());
    }

    @Test
    public void parseEntityListToVOListTest() {
        List<PersonVO> outputPersonList = DozerMapper.parseListObjects(inputPerson.mockEntityList(), PersonVO.class);
        List<BookVO> outputBookList = DozerMapper.parseListObjects(inputBook.mockEntityList(), BookVO.class);

        PersonVO outputPersonZero = outputPersonList.get(0);

        assertEquals(Long.valueOf(0L), outputPersonZero.getKey());
        assertEquals("First Name Test0", outputPersonZero.getFirstName());
        assertEquals("Last Name Test0", outputPersonZero.getLastName());
        assertEquals("Address Test0", outputPersonZero.getAddress());
        assertEquals("Male", outputPersonZero.getGender());
        
        PersonVO outputPersonSeven = outputPersonList.get(7);
        
        assertEquals(Long.valueOf(7L), outputPersonSeven.getKey());
        assertEquals("First Name Test7", outputPersonSeven.getFirstName());
        assertEquals("Last Name Test7", outputPersonSeven.getLastName());
        assertEquals("Address Test7", outputPersonSeven.getAddress());
        assertEquals("Female", outputPersonSeven.getGender());
        
        PersonVO outputPersonTwelve = outputPersonList.get(12);
        
        assertEquals(Long.valueOf(12L), outputPersonTwelve.getKey());
        assertEquals("First Name Test12", outputPersonTwelve.getFirstName());
        assertEquals("Last Name Test12", outputPersonTwelve.getLastName());
        assertEquals("Address Test12", outputPersonTwelve.getAddress());
        assertEquals("Male", outputPersonTwelve.getGender());

        BookVO outputBookZero = outputBookList.get(0);

        assertEquals(Long.valueOf(0L), outputBookZero.getKey());
        assertEquals("Author Test0", outputBookZero.getAuthor());
        assertEquals("Title Test0", outputBookZero.getTitle());
        assertEquals(1D, outputBookZero.getPrice());
        //assertEquals(new Date(), outputBookZero.getLaunchDate());

        BookVO outputBookSeven = outputBookList.get(7);

        assertEquals(Long.valueOf(7L), outputBookSeven.getKey());
        assertEquals("Author Test7", outputBookSeven.getAuthor());
        assertEquals("Title Test7", outputBookSeven.getTitle());
        assertEquals(1D, outputBookSeven.getPrice());
        //assertEquals(new Date(), outputBookSeven.getLaunchDate());

        BookVO outputBookTwelve = outputBookList.get(12);

        assertEquals(Long.valueOf(12L), outputBookTwelve.getKey());
        assertEquals("Author Test12", outputBookTwelve.getAuthor());
        assertEquals("Title Test12", outputBookTwelve.getTitle());
        assertEquals(1D, outputBookTwelve.getPrice());
        //assertEquals(new Date(), outputBookTwelve.getLaunchDate());


    }

    @Test
    public void parseVOToEntityTest() {
        Person outputPerson = DozerMapper.parseObject(inputPerson.mockVO(), Person.class);
        Book outputBook = DozerMapper.parseObject(inputBook.mockVO(), Book.class);
        
        assertEquals(Long.valueOf(0L), outputPerson.getId());
        assertEquals("First Name Test0", outputPerson.getFirstName());
        assertEquals("Last Name Test0", outputPerson.getLastName());
        assertEquals("Address Test0", outputPerson.getAddress());
        assertEquals("Male", outputPerson.getGender());        
        
        assertEquals(Long.valueOf(0L), outputBook.getId());
        assertEquals("Author Test0", outputBook.getAuthor());
        assertEquals("Title Test0", outputBook.getTitle());
        assertEquals(1D, outputBook.getPrice());
        //assertEquals(new Date(), outputBook.getLaunchDate());
    }

    @Test
    public void parserVOListToEntityListTest() {
        List<Person> outputPersonList = DozerMapper.parseListObjects(inputPerson.mockVOList(), Person.class);
        List<Book> outputBookList = DozerMapper.parseListObjects(inputBook.mockVOList(), Book.class);
        
        Person outputPersonZero = outputPersonList.get(0);
        
        assertEquals(Long.valueOf(0L), outputPersonZero.getId());
        assertEquals("First Name Test0", outputPersonZero.getFirstName());
        assertEquals("Last Name Test0", outputPersonZero.getLastName());
        assertEquals("Address Test0", outputPersonZero.getAddress());
        assertEquals("Male", outputPersonZero.getGender());
        
        Person outputPersonSeven = outputPersonList.get(7);
        
        assertEquals(Long.valueOf(7L), outputPersonSeven.getId());
        assertEquals("First Name Test7", outputPersonSeven.getFirstName());
        assertEquals("Last Name Test7", outputPersonSeven.getLastName());
        assertEquals("Address Test7", outputPersonSeven.getAddress());
        assertEquals("Female", outputPersonSeven.getGender());
        
        Person outputPersonTwelve = outputPersonList.get(12);
        
        assertEquals(Long.valueOf(12L), outputPersonTwelve.getId());
        assertEquals("First Name Test12", outputPersonTwelve.getFirstName());
        assertEquals("Last Name Test12", outputPersonTwelve.getLastName());
        assertEquals("Address Test12", outputPersonTwelve.getAddress());
        assertEquals("Male", outputPersonTwelve.getGender());

        Book outputBookZero = outputBookList.get(0);

        assertEquals(Long.valueOf(0L), outputBookZero.getId());
        assertEquals("Author Test0", outputBookZero.getAuthor());
        assertEquals("Title Test0", outputBookZero.getTitle());
        assertEquals(1D, outputBookZero.getPrice());
        //assertEquals(new Date(), outputBookZero.getLaunchDate());

        Book outputBookSeven = outputBookList.get(7);

        assertEquals(Long.valueOf(7L), outputBookSeven.getId());
        assertEquals("Author Test7", outputBookSeven.getAuthor());
        assertEquals("Title Test7", outputBookSeven.getTitle());
        assertEquals(1D, outputBookSeven.getPrice());
        //assertEquals(new Date(), outputBookSeven.getLaunchDate());

        Book outputBookTwelve = outputBookList.get(12);

        assertEquals(Long.valueOf(12L), outputBookTwelve.getId());
        assertEquals("Author Test12", outputBookTwelve.getAuthor());
        assertEquals("Title Test12", outputBookTwelve.getTitle());
        assertEquals(1D, outputBookTwelve.getPrice());
        //assertEquals(new Date(), outputBookTwelve.getLaunchDate());
    }
}
