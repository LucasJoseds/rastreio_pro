package com.lucas.rastreio.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.lucas.rastreio.domain.dto.ClientDTO;
import com.lucas.rastreio.domain.dto.PackageDTO;

@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    private String cpf;


    public Client(){
        
    }
    
    public Client(PackageDTO dto) {
        this.id = dto.getId();
        this.name = dto.getClientName();
        this.cpf = dto.getClientCpf();

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
