package com.example.prog2;

import java.io.Serializable;

public class Skill extends Utilizador implements Serializable {
    private String nomeSkill;
    private boolean developer;
    private boolean ux;
    private boolean pm;

    public Skill() {
    }

    public String getNomeSkill() {
        return nomeSkill;
    }

    public void setNomeSkill(String nomeSkill) {
        this.nomeSkill = nomeSkill;
    }

    public boolean isDeveloper() {
        return developer;
    }

    public void setDeveloper(boolean developer) {
        this.developer = developer;
    }

    public boolean isUx() {
        return ux;
    }

    public void setUx(boolean ux) {
        this.ux = ux;
    }

    public boolean isPm() {
        return pm;
    }

    public void setPm(boolean pm) {
        this.pm = pm;
    }
}
