package com.example.prog2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ListarSkill implements Initializable {

    @FXML
    private ListView<String> ListSkills;

    @FXML
    private Button idVoltar;

    @FXML
    void btnVoltar(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("MenuAdmin.fxml"));
            Scene regCena = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(regCena);
            stage.setTitle("MenuAdmin");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Repositorio repo = Repositorio.getRepo();
        for(Skill s : repo.getSkill().values()){
            ListSkills.getItems().addAll(s.getNomeSkill());
        }
    }
}
