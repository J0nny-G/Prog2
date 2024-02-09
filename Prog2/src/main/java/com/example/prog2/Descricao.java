package com.example.prog2;

import java.io.Serializable;

public class Descricao implements Serializable {
    private String TituloDescricao;

    private String NomeD;

    private String DataC;

    private String DataT;
    private String talento;

    public Descricao() {
    }

    public String getTituloDescricao() {
        return TituloDescricao;
    }

    public void setTituloDescricao(String tituloDescricao) {
        TituloDescricao = tituloDescricao;
    }

    public String getNomeD() {
        return NomeD;
    }

    public void setNomeD(String nomeD) {
        NomeD = nomeD;
    }

    public String getDataC() {
        return DataC;
    }

    public void setDataC(String dataC) {
        DataC = dataC;
    }

    public String getDataT() {
        return DataT;
    }

    public void setDataT(String dataT) {
        DataT = dataT;
    }

    public String getTalento() {
        return talento;
    }

    public void setTalento(String talento) {
        this.talento = talento;
    }
}
