package com.example.prog2;

public class Criar_SkillTalento {
    public Criar_SkillTalento() {
    }

    public static void criarSkillTalento(SkillTalento skillTalento){
        Repositorio.getRepo().getSkillTalento().put(skillTalento.getSkill(), skillTalento);
        System.out.println("Perfil Talento Associado a Skill com Sucesso");
        System.out.println(Repositorio.getRepo());
        Repositorio.getRepo().serialize("src\\main\\resources\\uti.repo");
    }
}
