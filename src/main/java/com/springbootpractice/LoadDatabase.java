package com.springbootpractice;

import com.springbootpractice.entities.Match;
import com.springbootpractice.entities.MatchOdd;
import com.springbootpractice.entities.Sport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.springbootpractice.repositories.MatchRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(MatchRepository matchRepository) {

        Match match = new Match();
        match.setTeamA("OSFP");
        match.setTeamA("PAO");
        match.setMatchDate(LocalDate.of(2021, 03,31 ));
        match.setMatchTime(LocalTime.now());
        match.setDescription("OSFP-PAO");
        match.setSport(Sport.BASKETBALL);

        MatchOdd matchOdd = new MatchOdd();        
        matchOdd.setOdd(new BigDecimal("1.5"));
        matchOdd.setSpecifier("X");
        
        match.addMatchOdd(matchOdd);


        return args -> {
            log.info("Preloading " + matchRepository.save(new Match()));
//            log.info("Preloading " + matchRepository.save(new Employee("Peter", "tester", "employed")));
//            log.info("Preloading " + matchRepository.save(new Employee("George", "developer", "unemployed")));
//            log.info("Preloading " + matchRepository.save(new Employee("Michael", "tester", "unemployed")));
        };
    }
}
