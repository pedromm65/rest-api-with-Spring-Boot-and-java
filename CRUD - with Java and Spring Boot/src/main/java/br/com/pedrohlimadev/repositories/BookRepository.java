package br.com.pedrohlimadev.repositories;

import br.com.pedrohlimadev.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
