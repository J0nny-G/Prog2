package com.example.prog2;

import java.io.Serializable;

public class SkillTalento implements Serializable {
    private String skill;
    private String talento;
    private String anosExp;

    public SkillTalento() {
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getTalento() {
        return talento;
    }

    public void setTalento(String talento) {
        this.talento = talento;
    }

    public String getAnosExp() {
        return anosExp;
    }

    public void setAnosExp(String anosExp) {
        this.anosExp = anosExp;
    }
}
