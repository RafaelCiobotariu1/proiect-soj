package org.endava.tmd.sojbookrentalproject.repositories;

import org.endava.tmd.sojbookrentalproject.models.Book;
import org.endava.tmd.sojbookrentalproject.models.BookRental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRentalRepository extends JpaRepository<BookRental,Long> {
}
