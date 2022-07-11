package org.endava.tmd.sojbookrentalproject.controlers;


import lombok.AllArgsConstructor;
import org.endava.tmd.sojbookrentalproject.models.BookReservation;
import org.endava.tmd.sojbookrentalproject.models.BookReservationDTO;
import org.endava.tmd.sojbookrentalproject.repositories.BookRepository;
import org.endava.tmd.sojbookrentalproject.repositories.BookReservationRepository;
import org.endava.tmd.sojbookrentalproject.repositories.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/book-reservation")
public class BookReservationController {

    private BookReservationRepository bookReservationRepository;
    private UserRepository userRepository;
    private BookRepository bookRepository;

    @GetMapping
    public List<BookReservation> list(){

        return bookReservationRepository.findAll();
    }

    @GetMapping({"/{id}"})
    public BookReservation get(@PathVariable Long id){

        return bookReservationRepository.findById(id).get();
    }

    @PostMapping
    public BookReservation create(@RequestBody final BookReservationDTO bookReservationDTO){
        BookReservation bookReservation = new BookReservation();
        bookReservation.setUser(userRepository.findById(bookReservationDTO.getUserId()).get());
        bookReservation.setBook(bookRepository.findById(bookReservationDTO.getBookId()).get());
        return bookReservationRepository.saveAndFlush(bookReservation);
    }

    @PutMapping
    public BookReservation update(@RequestBody final BookReservation book){
        return bookReservationRepository.saveAndFlush(book);
    }

    @DeleteMapping({"/{id}"})
    public void delete(@PathVariable Long id){
        BookReservation BookReservation =  bookReservationRepository.findById(id).get();
        bookReservationRepository.delete(BookReservation);
    }
}
