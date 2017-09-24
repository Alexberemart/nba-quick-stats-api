package com.alexberemart.nbaquickstats.repository;

/**
 * Created by aberenguer on 22/09/2017.
 */

import com.alexberemart.nbaquickstats.model.Season;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeasonRepository extends JpaRepository<Season, String> {
}
