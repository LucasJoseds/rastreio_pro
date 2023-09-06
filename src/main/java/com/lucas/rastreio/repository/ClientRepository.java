package com.lucas.rastreio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lucas.rastreio.domain.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long>{
    
}
