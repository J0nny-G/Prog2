package com.example.prog2;

import java.io.IOException;
import java.io.Serializable;

public class Criar_Admin implements Serializable {
    public Criar_Admin() {
    }
    public static void criarAdmin(Admin admin) {
        Repositorio.getRepo().getAdmin().put(admin.getUsername(), admin);
        System.out.println("Admin criado com sucesso!!!");
        System.out.println(Repositorio.getRepo());
        Repositorio.getRepo().serialize("src\\main\\resources\\uti.repo");
    }
}
