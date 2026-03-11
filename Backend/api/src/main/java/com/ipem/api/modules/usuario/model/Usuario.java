package com.ipem.api.modules.usuario.model;

import com.ipem.api.core.models.BaseEntity;
import com.ipem.api.modules.usuario.model.enums.Permissao;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario extends BaseEntity {

    @Id
    @Column(name = "num_registro", length = 5)
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String senha;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Permissao permissao;
}