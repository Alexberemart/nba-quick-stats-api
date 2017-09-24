package com.alexberemart.nbaquickstats.repository;

/**
 * Created by aberenguer on 22/09/2017.
 */

import com.alexberemart.nbaquickstats.model.PlayerByTeam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerByTeamRepository extends JpaRepository<PlayerByTeam, String> {
    List<PlayerByTeam> findByTeamCode(String code);
}
