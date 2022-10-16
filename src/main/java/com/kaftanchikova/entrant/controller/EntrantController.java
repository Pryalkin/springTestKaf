package com.kaftanchikova.entrant.controller;

import com.kaftanchikova.entrant.exceptions.ExceptionHandling;
import com.kaftanchikova.entrant.exceptions.UserNotFoundException;
import com.kaftanchikova.entrant.model.Entrant;
import com.kaftanchikova.entrant.service.EntrantService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@AllArgsConstructor
public class EntrantController extends ExceptionHandling {

    private final EntrantService entrantService;

    @PostMapping("/entrant")
    public void addUser(@RequestBody Entrant entrant){
        entrantService.addEntrant(entrant);
    }

    @GetMapping("/entrants")
    public ResponseEntity<List<Entrant>> getUsers(){
        return new ResponseEntity<>(entrantService.getEntrants(), HttpStatus.OK);
    }

    @GetMapping("/entrant/enroll/status/{id}")
    public ResponseEntity<List<Entrant>> enrollEntrant(@PathVariable Long id) throws UserNotFoundException {
        return new ResponseEntity<>(entrantService.enrollEntrant(id, true), HttpStatus.OK);
    }

    @GetMapping("/entrant/delete/{id}")
    public ResponseEntity<List<Entrant>> deleteEntrant(@PathVariable Long id) throws UserNotFoundException {
        return new ResponseEntity<>(entrantService.deleteEntrant(id), HttpStatus.OK);
    }

}
