package com.lucas.rastreio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucas.rastreio.domain.dto.PackageDTO;
import com.lucas.rastreio.domain.model.Client;
import com.lucas.rastreio.domain.model.Package;
import com.lucas.rastreio.repository.ClientRepository;
import com.lucas.rastreio.repository.PackageRepository;

@Service
public class PackageService {

    @Autowired
    private PackageRepository packageRepository;

    @Autowired
    private ClientRepository clientRepository;

    public Package create(PackageDTO dto) {

        Client nClient = new Client(dto);
        clientRepository.save(nClient);

        Package nPackage = new Package(dto, nClient);
        
        return packageRepository.save(nPackage);


    }
}
