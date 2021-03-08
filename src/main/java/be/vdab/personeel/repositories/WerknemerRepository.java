package be.vdab.personeel.repositories;


import be.vdab.personeel.domain.Jobtitel;
import be.vdab.personeel.domain.Werknemer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface WerknemerRepository extends JpaRepository<Werknemer, Long> {
    List<Werknemer> findByChefId(Long chefId);
    Optional <Werknemer> findByChefIsNull();
    List <Werknemer> findByJobtitel(Jobtitel jobtitel);
}
