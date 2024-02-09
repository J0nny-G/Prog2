package com.example.prog2;

public class Criar_Talento {
    public Criar_Talento() {
    }
    public static void criarTalento(Talento talento) {
        Repositorio.getRepo().getTalento().put(talento.getNomeTalento(), talento);
        System.out.println("Talento criado com sucesso!!!");
        System.out.println(Repositorio.getRepo());
        Repositorio.getRepo().serialize("src\\main\\resources\\uti.repo");
    }

}
