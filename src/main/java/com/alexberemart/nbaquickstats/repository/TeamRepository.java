package com.alexberemart.nbaquickstats.repository;

/**
 * Created by aberenguer on 22/09/2017.
 */

import com.alexberemart.nbaquickstats.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepository extends JpaRepository<Team, String> {
    List<Team> findByName(@Param("name") String name);
}
