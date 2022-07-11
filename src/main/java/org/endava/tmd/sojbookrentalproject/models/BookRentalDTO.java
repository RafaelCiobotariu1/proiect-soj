package org.endava.tmd.sojbookrentalproject.models;

import lombok.Data;

import java.util.Date;

@Data
public class BookRentalDTO {
    private Long listaCartiId;
    private Date startPeriodDate;
    private Date endPeriodDate;
    private Long userId;
}
