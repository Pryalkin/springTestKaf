package com.kaftanchikova.entrant.service.impl;

import com.kaftanchikova.entrant.exceptions.UserNotFoundException;
import com.kaftanchikova.entrant.model.Entrant;
import com.kaftanchikova.entrant.repository.EntrantRepo;
import com.kaftanchikova.entrant.service.EntrantService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EntrantServiceImpl implements EntrantService {

    private final EntrantRepo entrantRepo;

    @Override
    public Entrant addEntrant(Entrant entrant) {
        return entrantRepo.save(entrant);
    }

    @Override
    public List<Entrant> getEntrants() {
        return entrantRepo.findAll();
    }

    @Override
    public List<Entrant> enrollEntrant(Long id, Boolean isStatus) throws UserNotFoundException {
        Entrant entrant = entrantRepo.findById(id).orElseThrow(() -> new UserNotFoundException("User not found exception"));
        entrant.setStatus(isStatus);
        entrantRepo.save(entrant);
        return entrantRepo.findAll();
    }

    @Override
    public List<Entrant> deleteEntrant(Long id) throws UserNotFoundException {
        Entrant entrant = entrantRepo.findById(id).orElseThrow(() -> new UserNotFoundException("User not found exception"));
        entrantRepo.deleteById(entrant.getId());
        return entrantRepo.findAll();
    }
}
