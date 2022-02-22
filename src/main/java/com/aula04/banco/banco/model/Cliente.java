package com.aula04.banco.banco.model;

import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter @Setter
@AllArgsConstructor

public class Cliente {
    private UUID id;
    private String nome;
    private String email;
    private String senha;
    private List<Conta> contas;
}
