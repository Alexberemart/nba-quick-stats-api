package com.alexberemart.nbaquickstats.rest;

import com.alexberemart.nbaquickstats.model.PlayerByTeam;
import com.alexberemart.nbaquickstats.repository.PlayerByTeamRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class PlayerByTeamController {

    private PlayerByTeamRepository playerByTeamRepository;

    @CrossOrigin(origins = {"http://localhost:4200",
            "https://nba-quick-stats.herokuapp.com"})
    @RequestMapping(path = "/playerByTeam",
            method = RequestMethod.GET)
    public ResponseEntity<Iterable<PlayerByTeam>> list() {
        return ResponseEntity.ok().body(playerByTeamRepository.findAll());
    }

    @CrossOrigin(origins = {"http://localhost:4200",
            "https://nba-quick-stats.herokuapp.com"})
    @RequestMapping(path = "/playerByTeamByTeam",
            method = RequestMethod.GET)
    public ResponseEntity<List<PlayerByTeam>> listByTeam(@RequestParam("teamID") String teamId) {
        return ResponseEntity.ok().body(playerByTeamRepository.findByTeamCode(teamId));
    }

    @RequestMapping(path = "/playerByTeam",
            method = RequestMethod.POST)
    public ResponseEntity<PlayerByTeam> create(@RequestBody PlayerByTeam customerByTownFields) {
        return ResponseEntity.ok().body(playerByTeamRepository.save(customerByTownFields));
    }

    @RequestMapping(path = "/playerByTeam",
            method = RequestMethod.DELETE)
    public ResponseEntity<PlayerByTeam> delete(@PathVariable String id) {
        playerByTeamRepository.delete(id);
        return ResponseEntity.noContent().build();
    }
}