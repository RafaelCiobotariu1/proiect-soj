package org.endava.tmd.sojbookrentalproject.controlers;


import lombok.AllArgsConstructor;
import org.endava.tmd.sojbookrentalproject.models.Book;
import org.endava.tmd.sojbookrentalproject.repositories.BookRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/books")
public class BookController {

    private BookRepository bookRepository;

    @GetMapping
    public List<Book> list(){

        return bookRepository.findAll();
    }

    @GetMapping({"/{id}"})
    public Book get(@PathVariable Long id){

        return bookRepository.findById(id).get();
    }

    @PostMapping
    public Book create(@RequestBody final Book book){
        return bookRepository.saveAndFlush(book);
    }

    @PutMapping
    public Book update(@RequestBody final Book book){
        return bookRepository.saveAndFlush(book);
    }

    @DeleteMapping({"/{id}"})
    public void delete(@PathVariable Long id){
        Book book =  bookRepository.findById(id).get();
        bookRepository.delete(book);
    }
}
