package com.cdc.api1.repository;

import com.cdc.api1.entity.Candidate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidateRepository extends CrudRepository<Candidate, Long> {

    List<Candidate> findByFirstName(String firstName);

}
