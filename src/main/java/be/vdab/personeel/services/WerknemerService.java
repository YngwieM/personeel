package be.vdab.personeel.services;

import be.vdab.personeel.domain.Jobtitel;
import be.vdab.personeel.domain.Werknemer;
import java.util.List;


public interface WerknemerService {

Werknemer findById(long id);
    List<Werknemer> findByChefId(Long chefId);
    List <Werknemer> findByJobtitel(Jobtitel jobtitel);
    void updateWerknemer(Werknemer werknemer);
}
