package com.lucas.rastreio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucas.rastreio.domain.dto.PackageDTO;
import com.lucas.rastreio.domain.dto.SituationResponseDTO;
import com.lucas.rastreio.domain.model.Package;
import com.lucas.rastreio.domain.model.Situation;
import com.lucas.rastreio.service.PackageService;

@RestController
@RequestMapping(value = "/package")
public class PackageController {

    @Autowired
    private PackageService packageService;
    

    @PostMapping(value="/create")
    public ResponseEntity<Package> createPackage(@RequestBody PackageDTO dto){

        Package nPackage = packageService.create(dto);
        return new ResponseEntity<Package>(nPackage, HttpStatus.CREATED);
    }


    @GetMapping(value = "/{code}")
    public ResponseEntity <List<SituationResponseDTO>> returnDetails(@PathVariable String code){

        List<SituationResponseDTO>result = packageService.returnDetails(code);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
