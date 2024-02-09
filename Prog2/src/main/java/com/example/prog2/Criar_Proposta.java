package com.example.prog2;

public class Criar_Proposta {
    public Criar_Proposta() {
    }
    public static void criarProposta(Proposta proposta) {
        Repositorio.getRepo().getProposta().put(proposta.getNomeProposta(),proposta);
        System.out.println("Proposta criada com sucesso!!!");
        System.out.println(Repositorio.getRepo());
        Repositorio.getRepo().serialize("src\\main\\resources\\uti.repo");
    }
}
