package org.endava.tmd.sojbookrentalproject.controlers;


import lombok.AllArgsConstructor;

import org.endava.tmd.sojbookrentalproject.models.BookRental;
import org.endava.tmd.sojbookrentalproject.models.BookRentalDTO;
import org.endava.tmd.sojbookrentalproject.models.BookReturnerDTO;
import org.endava.tmd.sojbookrentalproject.repositories.BookRentalRepository;
import org.endava.tmd.sojbookrentalproject.repositories.ListaCartiRepository;
import org.endava.tmd.sojbookrentalproject.repositories.UserRepository;
import org.endava.tmd.sojbookrentalproject.services.BookRentalService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/book-rental")
public class BookRentalController {

    private BookRentalRepository bookRentalRepository;
    private ListaCartiRepository listaCartiRepository;
    private UserRepository userRepository;

    private BookRentalService bookRentalService;

    @GetMapping
    public List<BookRental> list(){

        return bookRentalRepository.findAll();
    }

    @GetMapping({"/{id}"})
    public BookRental get(@PathVariable Long id){

        return bookRentalRepository.findById(id).get();
    }

    @PostMapping
    public BookRental create(@RequestBody final BookRentalDTO bookRentalDTO){
        BookRental bookRental = new BookRental();
        bookRental.setListaCarti(listaCartiRepository.findById(bookRentalDTO.getListaCartiId()).get());
        bookRental.setUser(userRepository.findById(bookRentalDTO.getUserId()).get());
        bookRental.setStartPeriodDate(bookRentalDTO.getStartPeriodDate());
        bookRental.setEndPeriodDate(bookRentalDTO.getEndPeriodDate());
        return bookRentalRepository.saveAndFlush(bookRental);
    }

    @PutMapping
    public BookRental update(@RequestBody final BookRental book){
        return bookRentalRepository.saveAndFlush(book);
    }

    @DeleteMapping({"/{id}"})
    public void delete(@PathVariable Long id){
        BookRental bookRental =  bookRentalRepository.findById(id).get();
        bookRentalRepository.delete(bookRental);
    }

    @GetMapping("/my-rentals/{id}")
    public List<BookReturnerDTO> getMyRental(@PathVariable Long id){
        return bookRentalService.getBooksForUser(id);
    }

    @PutMapping(value = {"/extend/{rentingId}/with/{weeks}","/extend/{rentingId}/with"})
    public void updateRent(@PathVariable Long rentingId, @PathVariable(required = false) Integer weeks){
        bookRentalService.extendWith(rentingId,weeks);
    }
}
