package com.aula04.banco.banco.controller;

import com.aula04.banco.banco.dto.RequestCliente;
import com.aula04.banco.banco.model.BancoCliente;
import com.aula04.banco.banco.model.Cliente;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ClienteController {
    BancoCliente bancoCliente = new BancoCliente();
    @GetMapping("/clientes")
    public String clientes(Model model){

        Cliente cliente = new Cliente("Nath", "nath@letscode.com", 123, 0);
        Cliente cliente2 = new Cliente("Rapha", "tapha@letscode.com",1234, 1);

        BancoCliente.adiciona(cliente);
        BancoCliente.adiciona(cliente2);

        model.addAttribute("clientes", BancoCliente.buscar());

        return "clientes";
    }

    @GetMapping("/cadastra/cliente")
    public String formClientes(){ return "formCliente";}

    @PostMapping("/cliente")
    public String cadastraCliente(RequestCliente requestCliente){
              Cliente cliente = new Cliente(
                      requestCliente.getNome(),
                      requestCliente.getEmail(),
                      requestCliente.getConta(),
                      requestCliente.getAgencia());
              bancoCliente.adiciona(cliente);
              return "clienteCadastrado";
    }
}
