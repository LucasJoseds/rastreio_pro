package com.lucas.rastreio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lucas.rastreio.domain.model.Situation;

@Repository
public interface SituationRepository extends JpaRepository<Situation,Long> {
    
    @Query(nativeQuery = true , value = "select * from situations s where s.details =:details")
    List<Situation> listDetails(@Param("details")String details);
}
