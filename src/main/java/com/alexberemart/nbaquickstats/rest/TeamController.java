package com.alexberemart.nbaquickstats.rest;

import com.alexberemart.nbaquickstats.model.Team;
import com.alexberemart.nbaquickstats.repository.TeamRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by aberenguer on 22/09/2017.
 */


@RestController
@AllArgsConstructor
public class TeamController {

    private TeamRepository teamRepository;

    @RequestMapping(path = "/people", method = RequestMethod.GET)
    public ResponseEntity<List<Team>> list() {
        return ResponseEntity.ok().body(teamRepository.findAll());
    }
}