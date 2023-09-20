package com.lucas.rastreio.domain.dto.response;

import java.time.LocalDate;

public class SituationResponseDTO {
    
    private String details;

    private LocalDate dateAction;
    
    public SituationResponseDTO(String details, LocalDate dateAction) {
        this.details = details;
        this.dateAction = dateAction;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public LocalDate getDateAction() {
        return dateAction;
    }

    public void setDateAction(LocalDate dateAction) {
        this.dateAction = dateAction;
    }

    
}
