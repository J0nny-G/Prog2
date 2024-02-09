package com.example.prog2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

import static com.example.prog2.Repositorio.getRepo;

public class MenuSkill {

    @FXML
    private ToggleGroup Area;

    @FXML
    private TextField idNomeSkill;

    @FXML
    private Button idcriar;

    @FXML
    private RadioButton idpm;

    @FXML
    private RadioButton idrddevolopers;

    @FXML
    private RadioButton idux;

    @FXML
    private Button idvoltar;

    @FXML
    void btnCriar(ActionEvent event) {
        boolean found = false;
        Repositorio repo = getRepo();
        if(idNomeSkill.getText().isEmpty() || Area.getSelectedToggle()==null) {
            Alert alertDatInv = new Alert(Alert.AlertType.ERROR);
            alertDatInv.setTitle("Erro");
            alertDatInv.setHeaderText("Verifique os dados inseridos");
            alertDatInv.show();
        }
        for (Skill skill : repo.getSkill().values()) {
            if (idNomeSkill.getText().equals(skill.getNomeSkill())) {
                found = true;
                Alert alertDatInv = new Alert(Alert.AlertType.ERROR);
                alertDatInv.setTitle("Erro");
                alertDatInv.setHeaderText("Skill já existe");
                alertDatInv.show();
            }
        }
            if(!found){
                Skill s1 = new Skill();
                s1.setNomeSkill(idNomeSkill.getText());
                s1.setDeveloper(idrddevolopers.isSelected());
                s1.setUx(idux.isSelected());
                s1.setPm(idpm.isSelected());
                Criar_Skill.criarSkill(s1);
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("MenuUtilizador.fxml"));
                    Scene regCena = new Scene(root);
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    stage.setScene(regCena);
                    stage.setTitle("Menu Utilizador");
                    stage.show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    @FXML
    void btnvoltar(ActionEvent event) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("MenuUtilizador.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene regCena = new Scene (root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(regCena);
        stage.setTitle("Login");
        stage.show();

    }

    @FXML
    void rddevolepes(ActionEvent event) {

    }

    @FXML
    void rdpm(ActionEvent event) {

    }

    @FXML
    void rdux(ActionEvent event) {

    }


}
