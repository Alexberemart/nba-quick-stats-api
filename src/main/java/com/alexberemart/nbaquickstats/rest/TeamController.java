package com.alexberemart.nbaquickstats.rest;

import com.alexberemart.nbaquickstats.model.Team;
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
public class TeamController {

    private TeamRepository teamRepository;

    @CrossOrigin(origins = {"http://localhost:4200",
            "https://nba-quick-stats.herokuapp.com"})
    @RequestMapping(path = "/team", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Team>> list() {
        return ResponseEntity.ok().body(teamRepository.findAll());
    }

    @RequestMapping(path = "/team", method = RequestMethod.POST)
    public ResponseEntity<Team> create(@RequestBody Team customerByTownFields) {
        return ResponseEntity.ok().body(teamRepository.save(customerByTownFields));
    }
}