package org.endava.tmd.sojbookrentalproject.repositories;

import org.endava.tmd.sojbookrentalproject.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
}
