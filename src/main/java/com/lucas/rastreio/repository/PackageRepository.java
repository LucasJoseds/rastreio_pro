package com.lucas.rastreio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lucas.rastreio.domain.dto.DetailsResponseDTO;
import com.lucas.rastreio.domain.model.Package;

@Repository
public interface PackageRepository extends JpaRepository<Package,Long> {



    @Query(nativeQuery = true, value = "select p.datails , c.name from packages p join clients c on p.client_id=c.id and p.code =:code")
    List<Package> listDetails(@Param("code") String code);
}
