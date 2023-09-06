package com.lucas.rastreio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lucas.rastreio.domain.model.Situation;

@Repository
public interface SituationRepository extends JpaRepository<Situation,Long> {
    
}
