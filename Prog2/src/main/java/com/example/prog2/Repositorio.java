package com.example.prog2;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Repositorio implements Serializable {
    private static Repositorio repo;

    static {
        try {
            repo = new Repositorio();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Map<String, Admin> admin;
    private Map<String, Utilizador> utilizador;
    private Map<String, Skill> skill;
    private Map<String, Talento> talento;
    private Map<String, Cliente> cliente;
    private Map<String, SkillTalento> skillTalento;
    private Map<String, Descricao> descricao;
    private Map<String, Proposta> proposta;


    public Repositorio() throws IOException {
        admin = new HashMap<>();
        utilizador = new HashMap<>();
        skill = new HashMap<>();
        talento = new HashMap<>();
        cliente = new HashMap<>();
        skillTalento = new HashMap<>();
        descricao = new HashMap<>();
        proposta = new HashMap<>();

    }

    public Map<String, Utilizador> getUtilizador() {
        return utilizador;
    }

    public Map<String, Admin> getAdmin() {
        return admin;
    }

    public Map<String, Skill> getSkill() {
        return skill;
    }

    public static Repositorio getRepo() {
        return repo;
    }

    public Map<String, Talento> getTalento() {
        return talento;
    }

    public Map<String, Cliente> getCliente() {
        return cliente;
    }

    public Map<String, SkillTalento> getSkillTalento() {
        return skillTalento;
    }

    public Map<String, Descricao> getDescricao() {
        return descricao;
    }

    public Map<String, Proposta> getProposta() {
        return proposta;
    }

    @Override
    public String toString() {
        return "Repositorio{" +
                "admin=" + admin +
                ", utilizador=" + utilizador +
                ", skill=" + skill +
                ", talento=" + talento +
                ", cliente=" + cliente +
                ", skillTalento=" + skillTalento +
                ", descricao=" + descricao +
                ", proposta=" + proposta +
                '}';
    }

    public void serialize(String filename){

        try{
            FileOutputStream fileOut = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this);
            out.close();
            fileOut.close();
            System.out.printf("Serialização guardada " + filename + "\n");
        } catch(IOException ex){
            System.out.println("Erro na serialização: " + ex.getMessage());
        }
    }

    public static void deserialize(String filename){

        try{
            FileInputStream fileIn = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            repo = (Repositorio) in.readObject();
            in.close();
            fileIn.close();
        } catch(IOException ex){
            System.out.println("Erro na deserialização: " + ex.getMessage());
        } catch(ClassNotFoundException ex){
            System.out.println("Classe repositorio nao encontrada " + ex.getMessage());
        }
    }

}

