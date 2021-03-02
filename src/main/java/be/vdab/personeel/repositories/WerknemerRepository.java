package be.vdab.personeel.repositories;


import be.vdab.personeel.domain.Werknemer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface WerknemerRepository extends JpaRepository<Werknemer, Long> {
    List<Werknemer> findByJobtitelIdOrderByJobTitelId(int JobTitelId);
    @Query("update Werknemer w set w.salaris = ?1 where w.id = ?2")
    BigDecimal updateSalaris(BigDecimal nieuwSalaris, int id);
    List<Werknemer> findAllByEmailAdresOrderByJobTitelId();
    @Query("select w.werknemer from Werknemer w where w.chefId < ?1")
    List<Werknemer> findOndergeschikten(int chefid);
    @Query("select w.werknemer from Werknemer w where w.chefId > ?1")
    List<Werknemer> findChef(int chefid);
    void findById(long id);
}
