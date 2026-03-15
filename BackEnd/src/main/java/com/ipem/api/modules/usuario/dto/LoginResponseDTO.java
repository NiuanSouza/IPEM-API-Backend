package com.ipem.api.modules.usuario.dto;

import com.ipem.api.modules.usuario.model.enums.Permissao;

public record LoginResponseDTO(
        String token,
        UsuarioResponseDTO user
) {}