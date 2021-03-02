package be.vdab.personeel.services;

import be.vdab.personeel.domain.Werknemer;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface WerknemerService {

    List<Werknemer> findByJobtitelIdOrderByJobTitelId(int JobTitelId);
    BigDecimal updateSalaris(BigDecimal nieuwSalaris, int id);
    List<Werknemer> findAllByEmailAdresOrderByJobTitelId();
    List<Werknemer> findOndergeschikten(int chefid);
    List<Werknemer> findChef(int chefid);
}
