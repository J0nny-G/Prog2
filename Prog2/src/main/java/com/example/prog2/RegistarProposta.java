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

public class RegistarProposta {
    @FXML
    private TextField idCategoriaT;

    @FXML
    private TextField idMinExperiencia;

    @FXML
    private TextField idNHorasT;

    @FXML
    private TextField idNomePropostas;

    @FXML
    private Button idRegistarP;

    @FXML
    private TextField idSkillNe;

    @FXML
    private Button idVoltar;

    @FXML
    void btnRegistarP(ActionEvent event) {
        if(idNomePropostas.getText().isEmpty() || idCategoriaT.getText().isEmpty() || idSkillNe.getText().isEmpty() ||idMinExperiencia.getText().isEmpty() || idNHorasT.getText().isEmpty() ) {
            Alert alertDatInv = new Alert(Alert.AlertType.ERROR);
            alertDatInv.setTitle("Erro");
            alertDatInv.setHeaderText("Verifique os dados inseridos");
            alertDatInv.show();
        }else {
            Proposta p = new Proposta();
            p.setNomeProposta(idNomePropostas.getText());
            p.setCategoriaProposta(idCategoriaT.getText());
            p.setMinAnosExperiencia(idMinExperiencia.getText());
            p.setSkillsNecessarias(idSkillNe.getText());
            p.setNumeroHorasTrabalho(idNHorasT.getText());

            Criar_Proposta.criarProposta(p);
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
