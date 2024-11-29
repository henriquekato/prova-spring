package com.henriquekato.controllers;

import com.henriquekato.model.conserto.*;
import com.henriquekato.persistence.ConsertoRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/conserto")
public class ConsertoController {
    @Autowired
    private ConsertoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<ConsertoDadosDTO> cadastrar(@RequestBody @Valid ConsertoCadastroDTO consertoCadastroDTO, UriComponentsBuilder uriBuilder) {
        Conserto conserto = new Conserto(consertoCadastroDTO);
        repository.save(conserto);
        var uri = uriBuilder.path("/conserto/{id}").buildAndExpand(conserto.getId()).toUri();
        return ResponseEntity.created(uri).body(new ConsertoDadosDTO(conserto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsertoDadosDTO> getConsertoByid(@PathVariable long id) {
        Optional<Conserto> consertoOptional = repository.findById(id);
        return consertoOptional.map((conserto) -> ResponseEntity.ok(new ConsertoDadosDTO(conserto))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<Page<ConsertoDadosDTO>> listarTodosDados(Pageable paginacao) {
        Page<ConsertoDadosDTO> all = repository
                .findAll(paginacao)
                .map(ConsertoDadosDTO::new);
        return ResponseEntity.ok(all);
    }

    @GetMapping("/principais")
    public ResponseEntity<List<ConsertoListagemDTO>> listarPrincipaisDados() {
        List<ConsertoListagemDTO> list = repository
                .findAllByAtivoTrue()
                .stream()
                .map(ConsertoListagemDTO::new)
                .toList();
        return ResponseEntity.ok(list);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<ConsertoDadosDTO> atualizar(@RequestBody @Valid ConsertoDadosAtualizacaoDTO dados) {
        try {
            Conserto conserto = repository.getReferenceById(dados.id());
            conserto.atualizarDados(dados);
            return ResponseEntity.ok(new ConsertoDadosDTO(conserto));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluir(@PathVariable long id) {
        try {
            Conserto conserto = repository.getReferenceById(id);
            conserto.excluir();
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
