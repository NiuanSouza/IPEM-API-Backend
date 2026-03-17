package com.ipem.api.modules.usuario.service;

import com.ipem.api.modules.usuario.model.Usuario;
import com.ipem.api.modules.usuario.model.enums.Permissao;
import com.ipem.api.modules.usuario.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository repository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public Map<String, Object> cadastrar(Map<String, Object> dados) {
        Usuario novoUsuario = Usuario.builder()
                .id((Integer) dados.get("id"))
                .nome((String) dados.get("nome"))
                .email((String) dados.get("email"))
                .permissao(Permissao.valueOf((String) dados.get("permissao")))
                .senha(passwordEncoder.encode((String) dados.get("senha")))
                .build();

        repository.save(novoUsuario);

        return Map.of(
                "id", novoUsuario.getId(),
                "nome", novoUsuario.getNome(),
                "email", novoUsuario.getEmail(),
                "permissao", novoUsuario.getPermissao()
        );
    }
}