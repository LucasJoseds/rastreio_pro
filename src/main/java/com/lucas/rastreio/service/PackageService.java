package com.lucas.rastreio.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.lucas.rastreio.domain.dto.PackageDTO;
import com.lucas.rastreio.domain.dto.SituationResponseDTO;
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

    private final String OBJ_POSTADO = "Objeto postado";

    private final String TRANSITO = "Em trânsito para o destino";

    private final String A_CAMINHO = "A caminho do destinatário";

    private boolean continua = true;

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

        Situation t = new Situation();
        List<Situation> situations = new ArrayList<>();
        Situation novaSituacao = new Situation();

        if (continua) {
            situations = situationRepository.findAll();
            List<Package> pacotes = packageRepository.findAll();
            System.out.println(situations.toString());
            t = situations.get(situations.size() - 1);
            for (Package pacote : pacotes) {
                if (t.getDetails().equals(OBJ_POSTADO)) {
                    situations = situationRepository.listDetails(OBJ_POSTADO);
                    for (Situation situation : situations) {
                        if (situation.getDetails().equals(OBJ_POSTADO)) {
                            novaSituacao.setDetails(TRANSITO);
                            novaSituacao.setDateAction(LocalDate.now());
                        }
                    }
                }
                if (t.getDetails().equals(TRANSITO)) {
                    situations = situationRepository.listDetails(TRANSITO);
                    for (Situation situation : situations) {
                        if (situation.getDetails().equals(TRANSITO)) {
                            novaSituacao.setDetails(A_CAMINHO);
                            novaSituacao.setDateAction(LocalDate.now());
                            continua = false;
                        }
                    }
                }
                novaSituacao.setPack(pacote);
                situationRepository.save(novaSituacao);
            }
        }
    }

    public List<SituationResponseDTO> returnDetails(String code){

        return packageRepository.listPackages(code);
    }
}