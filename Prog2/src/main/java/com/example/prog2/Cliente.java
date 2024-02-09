package com.example.prog2;

import java.io.Serializable;

public class Cliente implements Serializable {
    private String nomeCliente;
    private String paisCliente;
    private String emailCliente;
    private String talentoCliente;

    public Cliente() {
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getPaisCliente() {
        return paisCliente;
    }

    public void setPaisCliente(String paisCliente) {
        this.paisCliente = paisCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public String getTalentoCliente() {
        return talentoCliente;
    }

    public void setTalentoCliente(String talentoCliente) {
        this.talentoCliente = talentoCliente;
    }
}
