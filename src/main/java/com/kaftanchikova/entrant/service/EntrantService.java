package com.kaftanchikova.entrant.service;

import com.kaftanchikova.entrant.exceptions.UserNotFoundException;
import com.kaftanchikova.entrant.model.Entrant;

import java.util.List;

public interface EntrantService {

    Entrant addEntrant(Entrant entrant);
    List<Entrant> getEntrants();
    List<Entrant> enrollEntrant(Long id, Boolean isStatus) throws UserNotFoundException;
    List<Entrant> deleteEntrant(Long id) throws UserNotFoundException;
}
