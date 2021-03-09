package be.vdab.personeel.services;

import be.vdab.personeel.domain.Jobtitel;
import be.vdab.personeel.domain.Werknemer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface WerknemerService {
    Werknemer findByChefIsNull();
Werknemer findById(long id);
    List<Werknemer> findByChefId(Long chefId);
    List <Werknemer> findByJobtitel(Jobtitel jobtitel);
    void updateWerknemer(Werknemer werknemer);
}
