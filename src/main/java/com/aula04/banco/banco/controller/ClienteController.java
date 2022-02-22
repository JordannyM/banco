package com.aula04.banco.banco.controller;

import com.aula04.banco.banco.dto.RequestCliente;
import com.aula04.banco.banco.dto.ResponseCliente;
import com.aula04.banco.banco.model.BancoCliente;
import com.aula04.banco.banco.model.Cliente;
import com.aula04.banco.banco.model.Conta;
import com.aula04.banco.banco.model.TipoConta;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    Random random = new Random();

    BancoCliente bancoCliente = new BancoCliente();
    @GetMapping
    public List<ResponseCliente> clientes(){
        return ResponseCliente.toResponse(bancoCliente.buscar());
    }

    @PostMapping
    public ResponseCliente cadastraCliente(@RequestBody RequestCliente requestCliente){
        List<Conta> contas= new ArrayList<>();
        Conta conta = new Conta(UUID.randomUUID(),random.nextInt(), 23, TipoConta.CONTA_CORRENTE);
        contas.add(conta);

        Cliente cliente = new Cliente(
                UUID.randomUUID(),
                requestCliente.getNome(),
                requestCliente.getEmail(),
                requestCliente.getSenha(),
                contas
        );
        bancoCliente.adiciona(cliente);
        return new ResponseCliente(cliente);
    }
}
