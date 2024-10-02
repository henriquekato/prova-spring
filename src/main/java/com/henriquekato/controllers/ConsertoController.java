package com.henriquekato.controllers;

import com.henriquekato.model.Conserto;
import com.henriquekato.model.ConsertoDTO;
import com.henriquekato.persistence.ConsertoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/conserto")
public class ConsertoController {
    @Autowired
    private ConsertoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody ConsertoDTO conserto){
        repository.save(new Conserto(conserto));
    }
}
