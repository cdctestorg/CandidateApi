package com.cdc.candidate.mgmt;

import com.cdc.candidate.mgmt.entity.Candidate;
import com.cdc.candidate.mgmt.repository.CandidateRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CandidateApi {

    public static void main(String[] args) {
        SpringApplication.run(CandidateApi.class, args);
    }


    @Bean
    public CommandLineRunner sampleData(CandidateRepository candidateRepository) {
        return args -> {
            candidateRepository.save(new Candidate(1L, "chris", "decastro", "chris@decastro.com", 5));
            candidateRepository.save(new Candidate(2L, "clark", "kent", "clark@kent.com", 4));
            candidateRepository.save(new Candidate(3L, "michael", "jordan", "michael@jordan.com", 3));
        };
    }
}
