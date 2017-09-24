package com.alexberemart.nbaquickstats.rest;

import com.alexberemart.nbaquickstats.model.Player;
import com.alexberemart.nbaquickstats.model.Team;
import com.alexberemart.nbaquickstats.repository.PlayerRepository;
import com.alexberemart.nbaquickstats.repository.TeamRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by aberenguer on 22/09/2017.
 */


@RestController
@AllArgsConstructor
public class PlayerController {

    private PlayerRepository playerRepository;

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(path = "/player", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Player>> list() {
        return ResponseEntity.ok().body(playerRepository.findAll());
    }

    @RequestMapping(path = "/player", method = RequestMethod.POST)
    public ResponseEntity<Player> create(@RequestBody Player customerByTownFields) {
        return ResponseEntity.ok().body(playerRepository.save(customerByTownFields));
    }
}