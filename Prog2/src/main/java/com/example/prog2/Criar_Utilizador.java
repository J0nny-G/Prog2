package com.example.prog2;

public class Criar_Utilizador {
    public Criar_Utilizador() {
    }
    public static void criarUtilizador(Utilizador utilizador){
        Repositorio.getRepo().getUtilizador().put(utilizador.getUsername(), utilizador);
        System.out.println("Cliente criado com sucesso!!!");
        System.out.println(utilizador.getUsername());
        System.out.println(Repositorio.getRepo());
        Repositorio.getRepo().serialize("src\\main\\resources\\uti.repo");

    }
}
