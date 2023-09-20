package com.lucas.rastreio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lucas.rastreio.domain.dto.SituationResponseDTO;
import com.lucas.rastreio.domain.model.Package;
import com.lucas.rastreio.domain.model.Situation;

@Repository
public interface PackageRepository extends JpaRepository<Package,Long> {



    @Query("select new com.lucas.rastreio.domain.dto.SituationResponseDTO(s.details,s.dateAction) from Situation s where s.pack.code =:code")
    List<SituationResponseDTO> listPackages(@Param("code") String code);
}
