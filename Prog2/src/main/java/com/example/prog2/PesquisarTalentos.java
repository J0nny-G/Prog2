package com.example.prog2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import static com.example.prog2.Repositorio.getRepo;

public class PesquisarTalentos {
    @FXML
    private TextField idNomeS;

    @FXML
    private Button idPesquisar;

    @FXML
    private Button idVoltar;

    @FXML
    void btnPesquisar(ActionEvent event) {
        boolean found=false;
        Repositorio repo = getRepo();
        for(Skill s : repo.getSkill().values()){
            if(s.getNomeSkill().contains(idNomeS.getText())){
                found = true;
                try{
                    Parent root = FXMLLoader.load(getClass().getResource("ListaTalentos.fxml"));
                    Scene regCena = new Scene(root);
                    Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    stage.setScene(regCena);
                    stage.setTitle("Lista Talentos");
                    stage.show();
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        if(!found) {
            Alert alertDatInv = new Alert(Alert.AlertType.ERROR);
            alertDatInv.setTitle("Erro");
            alertDatInv.setHeaderText("Skill não existe");
            alertDatInv.show();
        }

    }

    @FXML
    void btnVoltar(ActionEvent event) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("MenuUtilizador.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene regCena = new Scene (root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(regCena);
        stage.setTitle("Menu Utilizador");
        stage.show();

    }
}
