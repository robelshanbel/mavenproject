package com.example.craftapi.controller;

import com.example.craftapi.model.Candidates;
import com.example.craftapi.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.Console;

@Controller

public class CandidateController {

    @Autowired
    private CandidateService candidateService;


    @GetMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("listCandidates",candidateService.getAllCandidatess());
        return "index";
    }

    @GetMapping("/showNewCandidateForm")
    public String showNewCandidateForm( Model model){

        Candidates candidates=new Candidates();
        model.addAttribute("candidates",candidates);
        return "new_candidates";
    }

    @PostMapping("/saveCandidates")

    public String saveCandidates(@ModelAttribute("candidates") Candidates candidates){

        candidateService.saveCandidates(candidates);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")

    public String showFormForUpdate(@PathVariable (value="id")Long id, Model model)
    {
        Candidates candidates=candidateService.getCandidateById(id);
        model.addAttribute("candidates",candidates);

        return "update_candidates";
    }

    @GetMapping("/deletecandidatesdata/{id}")

    public String deletecandidatesdata(@PathVariable (value = "id") long id  ){

        this.candidateService.deleteCandidatesById(id);

        return "redirect:/";
    }
}
