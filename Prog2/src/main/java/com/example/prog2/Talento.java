package com.example.prog2;

import java.io.Serializable;
import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.List;

public class Talento implements Serializable {
    private String nomeTalento;
    private String emailTalento;
    private String paisTalento;
    private String precoH;
    private String perfil;


    public Talento() {
    }


    public String getNomeTalento() {
        return nomeTalento;
    }

    public void setNomeTalento(String nomeTalento) {
        this.nomeTalento = nomeTalento;
    }

    public String getPaisTalento() {
        return paisTalento;
    }

    public void setPaisTalento(String paisTalento) {
        this.paisTalento = paisTalento;
    }

    public String getPrecoH() {
        return precoH;
    }

    public void setPrecoH(String precoH) {
        this.precoH = precoH;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getEmailTalento() {
        return emailTalento;
    }

    public void setEmailTalento(String emailTalento) {
        this.emailTalento = emailTalento;
    }
}
