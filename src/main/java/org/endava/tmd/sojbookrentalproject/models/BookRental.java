package org.endava.tmd.sojbookrentalproject.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "book_rentals")
public class BookRental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookRentalId;


    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    private User user;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    private ListaCarti listaCarti;


    @Column(name = "start_period_date", nullable = false)
    private Date startPeriodDate;


    @Column(name = "end_period_date", nullable = false)
    private Date endPeriodDate;
}
