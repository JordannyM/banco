package com.aula04.banco.banco.model;

import java.util.ArrayList;
import java.util.List;

public class BancoCliente {
    private static List<Cliente> clientes = new ArrayList<>();

        public static void adiciona(Cliente cliente){
            BancoCliente.clientes.add(cliente);
        }

        public static List<Cliente> buscar(){
            return clientes;
        }
}
