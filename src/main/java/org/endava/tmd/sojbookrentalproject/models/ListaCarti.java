package org.endava.tmd.sojbookrentalproject.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "lista_carti")
public class ListaCarti {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    private Book book;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    private User owner;

    @JsonIgnore
    @OneToMany(mappedBy = "listaCarti")
    private List<BookRental> rentals;

    @JsonIgnore
    @OneToMany(mappedBy = "book")
    private List<BookReservation> reservations;

    public ListaCarti(Book book, User user) {
        this.book = book;
        this.owner = user;
    }
}
