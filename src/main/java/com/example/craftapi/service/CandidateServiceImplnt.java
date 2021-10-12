package com.example.craftapi.service;

import com.example.craftapi.model.Candidates;
import com.example.craftapi.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CandidateServiceImplnt implements CandidateService{
    @Autowired

    CandidateRepository candidateRepository;

    @Override


    public List<Candidates> getAllCandidatess() {
        return candidateRepository.findAll();
    }

    @Override
    public void saveCandidates(Candidates candidates) {
        this.candidateRepository.save(candidates);
    }

    @Override
    public Candidates getCandidateById( long id) {
        Optional<Candidates> optional=candidateRepository.findById(id);

        Candidates candidates=null;
        if (optional.isPresent()){
            candidates=optional.get();
        }
        else{

            throw new RuntimeException("Candidates not found->"+ id);
        }

        return candidates;
    }

    @Override
    public void deleteCandidatesById( long id) {
        this.candidateRepository.deleteById(id);


    }
}

