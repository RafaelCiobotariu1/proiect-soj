package org.endava.tmd.sojbookrentalproject.services;

import lombok.AllArgsConstructor;
import org.endava.tmd.sojbookrentalproject.models.Book;
import org.endava.tmd.sojbookrentalproject.models.BookRental;
import org.endava.tmd.sojbookrentalproject.models.ListaCarti;
import org.endava.tmd.sojbookrentalproject.models.User;
import org.endava.tmd.sojbookrentalproject.repositories.BookRentalRepository;
import org.endava.tmd.sojbookrentalproject.repositories.BookRepository;
import org.endava.tmd.sojbookrentalproject.repositories.ListaCartiRepository;
import org.endava.tmd.sojbookrentalproject.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ListaCartiService {

    BookRepository bookRepository;
    UserRepository userRepository;
    ListaCartiRepository listaCartiRepository;

    BookRentalRepository bookRentalRepository;


    public ListaCarti create(Long userId, Long bookId){
        User user = userRepository.findById(userId).get();
        Book book = bookRepository.findById(bookId).get();
        ListaCarti listaCarti = new ListaCarti(book, user);
        return listaCartiRepository.saveAndFlush(listaCarti);
    }


    public List<ListaCarti> available(){
        return listaCartiRepository.findAll().stream().filter(listaCarti -> isBookAvailable(listaCarti.getId())).collect(Collectors.toList());
    }

    public boolean isBookAvailable(Long id){
        List<BookRental> activeRentals = bookRentalRepository.findAll().stream()
                .filter(rental -> rental.getListaCarti().getId() == id)
                .filter(rental -> rental.getEndPeriodDate().after(new Date()) && rental.getStartPeriodDate().before(new Date()))
                .collect(Collectors.toList());

        if(activeRentals != null && activeRentals.size() > 0)
            return false;

        return true;
    }




}
