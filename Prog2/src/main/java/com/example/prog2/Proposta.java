package com.example.prog2;

import java.io.Serializable;

public class Proposta implements Serializable {
    private String NomeProposta;

    private String CategoriaProposta;

    private String SkillsNecessarias;

    private String MinAnosExperiencia;

    private String NumeroHorasTrabalho;

    public Proposta() {

    }

    public String getNomeProposta() {
        return NomeProposta;
    }

    public void setNomeProposta(String nomeProposta) {
        NomeProposta = nomeProposta;
    }

    public String getCategoriaProposta() {
        return CategoriaProposta;
    }

    public void setCategoriaProposta(String categoriaProposta) {
        CategoriaProposta = categoriaProposta;
    }

    public String getSkillsNecessarias() {
        return SkillsNecessarias;
    }

    public void setSkillsNecessarias(String skillsNecessarias) {
        SkillsNecessarias = skillsNecessarias;
    }

    public String getMinAnosExperiencia() {
        return MinAnosExperiencia;
    }

    public void setMinAnosExperiencia(String minAnosExperiencia) {
        MinAnosExperiencia = minAnosExperiencia;
    }

    public String getNumeroHorasTrabalho() {
        return NumeroHorasTrabalho;
    }

    public void setNumeroHorasTrabalho(String numeroHorasTrabalho) {
        NumeroHorasTrabalho = numeroHorasTrabalho;
    }
}
