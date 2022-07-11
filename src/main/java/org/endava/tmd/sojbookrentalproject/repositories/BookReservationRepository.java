package org.endava.tmd.sojbookrentalproject.repositories;

import org.endava.tmd.sojbookrentalproject.models.BookRental;
import org.endava.tmd.sojbookrentalproject.models.BookReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookReservationRepository extends JpaRepository<BookReservation,Long> {
}
