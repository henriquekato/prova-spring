package com.henriquekato.controllers;

import com.henriquekato.model.Conserto;
import com.henriquekato.model.ConsertoDTO;
import com.henriquekato.model.ConsertoListagemDTO;
import com.henriquekato.persistence.ConsertoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conserto")
public class ConsertoController {
    @Autowired
    private ConsertoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid ConsertoDTO conserto){
        repository.save(new Conserto(conserto));
    }

    @GetMapping
    public Page<Conserto> listarTodosDados(Pageable paginacao){
        return repository.findAll(paginacao);
    }

    @GetMapping("/principais")
    public List<ConsertoListagemDTO> listarPrincipaisDados(){
        return repository.findAll().stream().map(ConsertoListagemDTO::new).toList();
    }
}
