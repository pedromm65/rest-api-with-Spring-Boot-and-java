package br.com.pedrohlimadev.unittests.mapper.mocks;

import br.com.pedrohlimadev.data.vo.v1.BookVO;
import br.com.pedrohlimadev.model.Book;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MockBook {


    public Book mockEntity() {
        return mockEntity(0);
    }
    
    public BookVO mockVO() {
        return mockVO(0);
    }
    
    public List<Book> mockEntityList() {
        List<Book> books = new ArrayList<Book>();
        for (int i = 0; i < 14; i++) {
            books.add(mockEntity(i));
        }
        return books;
    }

    public List<BookVO> mockVOList() {
        List<BookVO> books = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            books.add(mockVO(i));
        }
        return books;
    }
    
    public Book mockEntity(Integer number) {
        Book book = new Book();
        book.setTitle("Title Test" + number);
        book.setAuthor("Author Test" + number);
        book.setLaunchDate(new Date());
        book.setPrice(1D);
        book.setId(number.longValue());
        return book;
    }

    public BookVO mockVO(Integer number) {
        BookVO book = new BookVO();
        book.setTitle("Title Test" + number);
        book.setAuthor("Author Test" + number);
        book.setLaunchDate(new Date());
        book.setPrice(1D);
        book.setKey(number.longValue());
        return book;
    }

}
