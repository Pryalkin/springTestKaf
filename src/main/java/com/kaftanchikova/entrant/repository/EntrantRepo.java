package com.kaftanchikova.entrant.repository;

import com.kaftanchikova.entrant.model.Entrant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntrantRepo extends JpaRepository<Entrant, Long> {
}
