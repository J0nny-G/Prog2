package com.example.prog2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class EditarSkill implements Initializable {

    @FXML
    private ListView<String> ListSkills;

    @FXML
    private RadioButton idrddevolopers;

    @FXML
    private TextField idNomeSkill;

    @FXML
    private RadioButton idux;

    @FXML
    private Button idVoltar;

    @FXML
    private RadioButton idpm;

    @FXML
    void BtnVoltar(ActionEvent event) {
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
    @FXML
    void btnEditar(ActionEvent event) {
        Repositorio repo = Repositorio.getRepo();
        String nomeSkill = ListSkills.getSelectionModel().getSelectedItem();
        Skill skill = repo.getSkill().get(nomeSkill);
        if (skill == null) {
            Alert alertDatInv = new Alert(Alert.AlertType.ERROR);
            alertDatInv.setTitle("Erro");
            alertDatInv.setHeaderText("Não existem skills selecionadas");
            alertDatInv.show();
        } else {
            skill.setNomeSkill(idNomeSkill.getText());
            skill.setDeveloper(idrddevolopers.isSelected());
            skill.setUx(idux.isSelected());
            skill.setPm(idpm.isSelected());

            repo.getSkill().put(nomeSkill, skill);
        }
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
   public void initialize(URL url, ResourceBundle resourceBundle) {
       Repositorio repo = Repositorio.getRepo();
       for (Skill s : repo.getSkill().values()) {
           ListSkills.getItems().add(s.getNomeSkill());
       }

       ListSkills.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
           Skill skill = repo.getSkill().get(newValue);
               idNomeSkill.setText(skill.getNomeSkill());
               idrddevolopers.setSelected(skill.isDeveloper());
               idux.setSelected(skill.isUx());
               idpm.setSelected(skill.isPm());
       });
   }

    public void rddevolepes(ActionEvent event) {
    }

    public void rdux(ActionEvent event) {
    }

    public void rdpm(ActionEvent event) {
    }
}
