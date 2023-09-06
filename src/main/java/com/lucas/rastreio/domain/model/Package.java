package com.lucas.rastreio.domain.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import com.lucas.rastreio.domain.dto.PackageDTO;

@Entity
@Table(name = "packages")
public class Package {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String code;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    private LocalDate initDate;

    private LocalDate finalDate;

  
    public Package(){
        
    }

    public Package(PackageDTO dto , Client client ){
        this.id=dto.getId();
        this.code=dto.getCode();
        this.initDate=dto.getInitDate();
        this.finalDate=dto.getFinalDate();
        this.client = client;
   
        
    }

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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

 


}
