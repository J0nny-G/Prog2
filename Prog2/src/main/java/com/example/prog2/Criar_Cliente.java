package com.example.prog2;

public class Criar_Cliente {
    public Criar_Cliente() {
    }

    public  static  void criarCliente(Cliente cliente){
        Repositorio.getRepo().getCliente().put(cliente.getNomeCliente(), cliente);
        System.out.println("Cliente criado com sucesso!!!");
        System.out.println(Repositorio.getRepo());
        Repositorio.getRepo().serialize("src\\main\\resources\\uti.repo");

    }
}
