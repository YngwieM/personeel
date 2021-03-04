package be.vdab.personeel.services;

import be.vdab.personeel.domain.Werknemer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface WerknemerService {

    List<Werknemer> findAll();
    @Query("update Werknemer w set w.salaris = ?1 where w.id = ?2")
    BigDecimal updateSalaris(BigDecimal nieuwSalaris, int id);
    List <Werknemer> findById(long id);
    List<Werknemer> findByChefIsNull();
}
