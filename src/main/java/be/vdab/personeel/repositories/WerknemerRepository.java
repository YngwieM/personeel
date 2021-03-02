package be.vdab.personeel.repositories;


import be.vdab.personeel.domain.Werknemer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface WerknemerRepository extends JpaRepository<Werknemer, Long> {
    List<Werknemer> findByJobtitelIdOrderByJobTitelId(int JobTitelId);
    @Query("update Werknemer w set w.salaris = ?1 where w.id = ?2")
    BigDecimal updateSalaris(BigDecimal nieuwSalaris, int id);
    List<Werknemer> findAllByEmailAdresOrderByJobTitelId();
}
