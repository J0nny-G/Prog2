package com.example.prog2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("PaginaPrincipal.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),400,400);
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Repositorio repositorio = Repositorio.getRepo();
        Repositorio.deserialize("src\\main\\resources\\uti.repo");
        if(repositorio.getAdmin().size()==0){
            Admin a1 = new Admin();
            a1.setUsername("admin");
            a1.setPassword("admin");
            Criar_Admin.criarAdmin(a1);
        }
        if(repositorio.getUtilizador().size()==0){
            Utilizador a1 = new Utilizador();
            a1.setUsername("teste");
            a1.setPassword("teste");
            Criar_Utilizador.criarUtilizador(a1);
        }
        launch();
    }
}