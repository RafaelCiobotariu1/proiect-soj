package org.endava.tmd.sojbookrentalproject.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "book_reservations")
public class BookReservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookReservationId;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    private User user;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    private Book book;

}
