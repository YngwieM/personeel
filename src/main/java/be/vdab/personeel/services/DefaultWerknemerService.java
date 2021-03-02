package be.vdab.personeel.services;

import be.vdab.personeel.domain.Werknemer;
import be.vdab.personeel.repositories.WerknemerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
@Service
@Transactional
 class DefaultWerknemerService implements WerknemerService {

    private final WerknemerRepository werknemerRepository;

    public DefaultWerknemerService(WerknemerRepository werknemerRepository) {
        this.werknemerRepository = werknemerRepository;
    }

    @Override
    public List<Werknemer> findByJobtitelIdOrderByJobTitelId(int JobTitelId) {
        return werknemerRepository.findByJobtitelIdOrderByJobTitelId(JobTitelId);
    }

    @Override
    public BigDecimal updateSalaris(BigDecimal nieuwSalaris, int id) {
        return werknemerRepository.updateSalaris(nieuwSalaris,id);
    }

    @Override
    public List<Werknemer> findAllByEmailAdresOrderByJobTitelId() {
        return werknemerRepository.findAllByEmailAdresOrderByJobTitelId();
    }

    @Override
    public List<Werknemer> findOndergeschikten(int chefid) {
        return werknemerRepository.findOndergeschikten(chefid);
    }

    @Override
    public List<Werknemer> findChef(int chefid) {
        return werknemerRepository.findChef(chefid);
    }
}
