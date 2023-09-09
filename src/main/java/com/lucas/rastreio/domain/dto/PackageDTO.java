package com.lucas.rastreio.domain.dto;

import java.time.LocalDate;


public class PackageDTO {
    
    private Long id; 
    private String code; 
    private String clientName;
    private String clientCpf;
    private LocalDate initDate; 
    private LocalDate finalDate;


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    
    public LocalDate getInitDate() {
        return initDate;
    }
    public void setInitDate(LocalDate initDate) {
        this.initDate = initDate;
    }
    public LocalDate getFinalDate() {
        return finalDate;
    }
    public void setFinalDate(LocalDate finalDate) {
        this.finalDate = finalDate;
    }
    public String getClientName() {
        return clientName;
    }
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }
    public String getClientCpf() {
        return clientCpf;
    }
    public void setClientCpf(String clientCpf) {
        this.clientCpf = clientCpf;
    }
  
    
    
}
