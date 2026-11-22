package com.skillpilots.bookapi.repository;
import com.skillpilots.bookapi.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
public interface BookRepository extends JpaRepository<Book,Long> {}