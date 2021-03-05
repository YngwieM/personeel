package be.vdab.personeel.services;

import be.vdab.personeel.domain.Werknemer;
import be.vdab.personeel.repositories.WerknemerRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
 class DefaultWerknemerService implements WerknemerService {

    private final WerknemerRepository werknemerRepository;

    public DefaultWerknemerService(WerknemerRepository werknemerRepository) {
        this.werknemerRepository = werknemerRepository;
    }

    @Override
    public List<Werknemer> findAll() {
        return werknemerRepository.findAll();
    }

    @Override
    public BigDecimal updateSalaris(BigDecimal nieuwSalaris, long id) {
        return werknemerRepository.updateSalaris(nieuwSalaris,id);
    }

    @Override
    public List<Werknemer> findById(long id) {
        return werknemerRepository.findById(id);
    }

    @Override
    public List<Werknemer> findByChefIsNull() {
        return werknemerRepository.findByChefIsNull();
    }
}
