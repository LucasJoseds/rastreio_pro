package com.lucas.rastreio.domain.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import com.lucas.rastreio.domain.dto.PackageDTO;

@Entity
@Table(name="situations")
public class Situation {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String details;

    private LocalDate dateAction;

    @ManyToOne
    @JoinColumn(name = "pack_id")
    private Package pack;

    public Situation(){

    }

    public Situation(PackageDTO dto , Package pack){
        this.details="Objeto postado";
        this.dateAction=LocalDate.now();
        this.pack=pack;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
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

    public Package getPack() {
        return pack;
    }

    public void setPack(Package pack) {
        this.pack = pack;
    }

 

       
}

