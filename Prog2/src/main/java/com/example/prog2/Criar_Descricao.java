package com.example.prog2;

public class Criar_Descricao {
    public Criar_Descricao() {
    }

    public  static  void criarDescricao(Descricao descricao){
        Repositorio.getRepo().getDescricao().put(descricao.getTituloDescricao(), descricao);
        System.out.println("Descricao criada com sucesso!!!");
        System.out.println(Repositorio.getRepo());
        Repositorio.getRepo().serialize("src\\main\\resources\\uti.repo");

    }
}
