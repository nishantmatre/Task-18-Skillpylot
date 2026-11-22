package com.skillpilots.bookapi.controller;
import com.skillpilots.bookapi.model.Book;
import com.skillpilots.bookapi.repository.BookRepository;
import jakarta.validation.Valid;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.*;
@RestController @RequestMapping("/api/books")
public class BookController {
 private final BookRepository repo;
 public BookController(BookRepository repo){this.repo=repo;}
 @GetMapping public ResponseEntity<List<Book>> all(){return ResponseEntity.ok(repo.findAll());}
 @GetMapping("/{id}") public ResponseEntity<?> one(@PathVariable Long id){
  return repo.findById(id).<ResponseEntity<?>>map(ResponseEntity::ok)
   .orElseGet(()->ResponseEntity.status(404).body(Map.of("message","Book not found with id "+id)));
 }
 @PostMapping public ResponseEntity<Book> create(@Valid @RequestBody Book book){
  book.setId(null); return ResponseEntity.status(HttpStatus.CREATED).body(repo.save(book));
 }
 @PutMapping("/{id}") public ResponseEntity<?> update(@PathVariable Long id,@Valid @RequestBody Book input){
  return repo.findById(id).<ResponseEntity<?>>map(book->{book.setTitle(input.getTitle());book.setAuthor(input.getAuthor());book.setPrice(input.getPrice());return ResponseEntity.ok(repo.save(book));})
   .orElseGet(()->ResponseEntity.status(404).body(Map.of("message","Book not found with id "+id)));
 }
 @DeleteMapping("/{id}") public ResponseEntity<?> delete(@PathVariable Long id){
  if(!repo.existsById(id)) return ResponseEntity.status(404).body(Map.of("message","Book not found with id "+id));
  repo.deleteById(id); return ResponseEntity.noContent().build();
 }
}