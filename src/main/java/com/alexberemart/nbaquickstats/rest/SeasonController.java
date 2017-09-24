package com.alexberemart.nbaquickstats.rest;

import com.alexberemart.nbaquickstats.model.Season;
import com.alexberemart.nbaquickstats.repository.SeasonRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by aberenguer on 22/09/2017.
 */


@RestController
@AllArgsConstructor
public class SeasonController {

    private SeasonRepository seasonRepository;

    @CrossOrigin(origins = {"http://localhost:4200",
            "https://nba-quick-stats.herokuapp.com"})
    @RequestMapping(path = "/season", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Season>> list() {
        return ResponseEntity.ok().body(seasonRepository.findAll());
    }

    @RequestMapping(path = "/season", method = RequestMethod.POST)
    public ResponseEntity<Season> create(@RequestBody Season season) {
        return ResponseEntity.ok().body(seasonRepository.save(season));
    }

    @RequestMapping(path = "/season/{id}",
            method = RequestMethod.DELETE)
    public ResponseEntity<Season> delete(@PathVariable String id) {
        seasonRepository.delete(id);
        return ResponseEntity.noContent().build();
    }
}