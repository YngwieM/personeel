package be.vdab.personeel.services;

import be.vdab.personeel.domain.Jobtitel;
import be.vdab.personeel.domain.Werknemer;
import be.vdab.personeel.repositories.WerknemerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


@Service
@Transactional
 class DefaultWerknemerService implements WerknemerService {

    private final WerknemerRepository werknemerRepository;

    public DefaultWerknemerService(WerknemerRepository werknemerRepository) {
        this.werknemerRepository = werknemerRepository;
    }


    @Override
    public Werknemer findById(long id) {
        return werknemerRepository.findById(id).get();
    }

    @Override
    public List<Werknemer> findByChefId(Long chefId) {
        return werknemerRepository.findByChefId(chefId);
    }

    @Override
    public List<Werknemer> findByJobtitel(Jobtitel jobtitel) {
        return werknemerRepository.findByJobtitel(jobtitel);
    }

    @Override
    public void updateWerknemer(Werknemer werknemer) { werknemerRepository.save(werknemer); }

}
