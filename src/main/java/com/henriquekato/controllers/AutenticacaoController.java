package com.henriquekato.controllers;

import com.henriquekato.model.usuario.DadosAutenticacaoDTO;
import com.henriquekato.model.usuario.Usuario;
import com.henriquekato.services.TokenService;
import com.henriquekato.util.security.DadosToken;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {
    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<DadosToken> efetuarLogin(@RequestBody @Valid DadosAutenticacaoDTO dados){
        var token = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        var authentication = manager.authenticate(token);
        DadosToken dadosToken = new DadosToken(tokenService.gerarToken((Usuario) authentication.getPrincipal()));
        return ResponseEntity
                .ok(dadosToken);
    }
}
