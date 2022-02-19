package com.aula04.banco.banco.model;

import lombok.*;

@Getter @Setter
@AllArgsConstructor

public class Cliente {
    private String nome;
    private String email;
    private Integer conta;
    private Integer agencia;
}
