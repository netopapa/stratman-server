package com.virtualmenu.repository;

import com.virtualmenu.model.Cenario;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface CenarioRepository extends BaseRepository<Cenario, Long> {
    Optional<Cenario> findByDateReferenceBetween(LocalDate start, LocalDate end);
}
