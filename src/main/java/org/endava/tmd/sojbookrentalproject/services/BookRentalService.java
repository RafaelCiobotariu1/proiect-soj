package org.endava.tmd.sojbookrentalproject.services;

import lombok.AllArgsConstructor;
import org.endava.tmd.sojbookrentalproject.models.BookRental;
import org.endava.tmd.sojbookrentalproject.models.BookReturnerDTO;
import org.endava.tmd.sojbookrentalproject.repositories.BookRentalRepository;
import org.endava.tmd.sojbookrentalproject.repositories.ListaCartiRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BookRentalService {
    private BookRentalRepository bookRentalRepository;
    private ListaCartiRepository listaCartiRepository;


    public List<BookReturnerDTO> getBooksForUser(Long id){
        return bookRentalRepository.findAll().stream()
                .filter(rental -> rental.getListaCarti().getOwner().getId() == id)
                .filter(rental -> rental.getEndPeriodDate().after(new Date()) && rental.getStartPeriodDate().before(new Date()))
                .map(rental -> new BookReturnerDTO(rental.getListaCarti().getBook().getTitle(), rental.getUser(), rental.getEndPeriodDate()))
                .collect(Collectors.toList());
    }


    public void extendWith(Long id, Integer weeks){
        BookRental bookRental = bookRentalRepository.findById(id).get();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(bookRental.getEndPeriodDate());
        if(weeks == null){
            weeks = 1;
        }
        int numberOfDays = 7 * weeks;
        calendar.add(Calendar.DAY_OF_YEAR, numberOfDays);
        Date newEndDate = calendar.getTime();
        bookRental.setEndPeriodDate(newEndDate);
        bookRentalRepository.saveAndFlush(bookRental);
    }
}
