package com.example.craftapi;

import com.example.craftapi.model.Candidates;
import com.example.craftapi.repository.CandidateRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.*;
@SpringBootTest
class CraftapiApplicationTests {

@Autowired
    CandidateRepository candidateRepository;
    @Test
    void contextLoads() {
    }


    @Test
    void readAllCandidateTest(){
        List<Candidates>  list=candidateRepository.findAll();
Assertions.assertThat(list).size().isGreaterThan(0);
    }
}
