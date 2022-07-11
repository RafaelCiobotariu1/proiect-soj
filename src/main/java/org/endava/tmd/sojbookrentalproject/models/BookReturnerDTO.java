package org.endava.tmd.sojbookrentalproject.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class BookReturnerDTO {
    private String title;
    private User userWhoBorrowed;
    private Date endDate;
}
