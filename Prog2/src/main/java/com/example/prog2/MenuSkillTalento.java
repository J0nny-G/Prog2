package com.example.prog2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.example.prog2.Repositorio.getRepo;


public class MenuSkillTalento implements Initializable {
    @FXML
    private Button idConfirmar;

    @FXML
    private ComboBox<String> idSkill;

    @FXML
    private ComboBox<String> idTalento;

    @FXML
    private Button idvoltar;
    @FXML
    private TextField idAnos;

    @FXML
    void btnConfirmar(ActionEvent event) {
        if(idSkill.getValue() == null || idTalento.getValue() == null || idAnos.getText().isEmpty()){
            Alert alertDatInv = new Alert(Alert.AlertType.ERROR);
            alertDatInv.setTitle("Erro");
            alertDatInv.setHeaderText("Verifique os dados inseridos");
            alertDatInv.show();
        }else{
            SkillTalento sk = new SkillTalento();
            sk.setSkill(idSkill.getValue());
            sk.setTalento(idTalento.getValue());
            sk.setAnosExp(idAnos.getText());

            Criar_SkillTalento.criarSkillTalento(sk);
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


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Repositorio repo = getRepo();
        for(Talento t : repo.getTalento().values()){
            String[] items = {t.getNomeTalento()};
            this.idTalento.getItems().addAll(items);
        }
        for(Skill s : repo.getSkill().values()){
            String[] items = {s.getNomeSkill()};
            this.idSkill.getItems().addAll(items);
        }


    }
}
