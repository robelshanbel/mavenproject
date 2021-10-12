package com.example.craftapi.service;


import com.example.craftapi.model.Candidates;

import java.util.List;

public interface CandidateService {
    List<Candidates>getAllCandidatess();
    void saveCandidates(Candidates candidates );

    Candidates getCandidateById( long id);
    void deleteCandidatesById(long id);
}

