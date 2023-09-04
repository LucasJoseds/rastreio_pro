package com.lucas.rastreio.domain.dto;

import java.time.LocalDate;

public record PackageDTO(Long id , String code , Long user , LocalDate initDate , LocalDate finalDate) {
    
}
