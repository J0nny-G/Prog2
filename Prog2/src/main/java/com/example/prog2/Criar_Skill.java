package com.example.prog2;

public class Criar_Skill {
    public Criar_Skill() {
    }
    public static void criarSkill(Skill skill){
        Repositorio.getRepo().getSkill().put(skill.getNomeSkill(), skill);
        System.out.println("Skill criada com sucesso!!!");
        System.out.println(Repositorio.getRepo());
        Repositorio.getRepo().serialize("src\\main\\resources\\uti.repo");


    }
}
