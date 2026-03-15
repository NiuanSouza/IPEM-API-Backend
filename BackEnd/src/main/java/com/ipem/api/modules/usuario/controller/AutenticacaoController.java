package com.ipem.api.modules.usuario.controller;

import com.ipem.api.infrastructure.security.TokenService;
import com.ipem.api.modules.usuario.dto.AutenticacaoDTO;
import com.ipem.api.modules.usuario.dto.LoginResponseDTO;
import com.ipem.api.modules.usuario.dto.UsuarioResponseDTO;
import com.ipem.api.modules.usuario.model.Usuario;
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
@RequestMapping("/auth")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AutenticacaoDTO data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.senha());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        Usuario usuario = (Usuario) auth.getPrincipal();

        var token = tokenService.gerarToken(usuario);

        UsuarioResponseDTO userDto = new UsuarioResponseDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getPermissao()
        );

        return ResponseEntity.ok(new LoginResponseDTO(token, userDto));
    }
}