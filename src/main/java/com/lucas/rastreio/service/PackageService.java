package com.lucas.rastreio.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.lucas.rastreio.domain.dto.PackageDTO;

import com.lucas.rastreio.domain.model.Client;
import com.lucas.rastreio.domain.model.Package;
import com.lucas.rastreio.domain.model.Situation;
import com.lucas.rastreio.repository.ClientRepository;
import com.lucas.rastreio.repository.PackageRepository;
import com.lucas.rastreio.repository.SituationRepository;

@Service
public class PackageService {

    @Autowired
    private PackageRepository packageRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private SituationRepository situationRepository;

    public Package create(PackageDTO dto) {

        Client nClient = new Client(dto);
        clientRepository.save(nClient);

        Package nPackage = new Package(dto, nClient);
        packageRepository.save(nPackage);

        Situation situation = new Situation(dto, nPackage);
        situationRepository.save(situation);

        return nPackage;

    }

    @Scheduled(cron = "0 * * * * *")
    public void updateSituation() {

        List<Package> pacotes = packageRepository.findAll();

        for (Package pacote : pacotes) {
            // Sua lógica para atualizar a situação do pacote aqui
            Situation novaSituacao = new Situation();
            novaSituacao.setDetails("Objeto postado");
            novaSituacao.setDateAction(LocalDate.now());

            // Associe a nova situação ao pacote
            novaSituacao.setPack(pacote);

            // Salve a nova situação no repositório de situação
            situationRepository.save(novaSituacao);
        }
    }

}
