package com.cdc.api1.controller;

import com.cdc.api1.entity.Candidate;
import com.cdc.api1.repository.CandidateRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
public class CandidateController {

    private final CandidateRepository candidateRepository;

    public CandidateController(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    @GetMapping(value = "/candidate", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Candidate> getCandidates() {
        return candidateRepository.findAll();
    }

    @GetMapping(value = "/candidate/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Candidate getCandidate(@PathVariable long id) {
        return candidateRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Invalid candidate id %s", id)));
    }

    @PostMapping(value = "/candidate", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Candidate createCandidate(@Valid @RequestBody Candidate candidate) {
        return candidateRepository.save(candidate);

    }
}
