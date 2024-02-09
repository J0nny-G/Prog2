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

public class MenuPerfilTalento implements Initializable {
    @FXML
    private TextField idEmail;

    @FXML
    private TextField idNome;

    @FXML
    private TextField idPais;

    @FXML
    private TextField idPrecoH;

    @FXML
    private Button idcriartalento;

    @FXML
    private ComboBox<String> idperfil;

    @FXML
    private Button idvoltar;

    @FXML
    void btncriartalento(ActionEvent event) {
        if(idNome.getText().isEmpty() || idEmail.getText().isEmpty() || idPais.getText().isEmpty() || idPrecoH.getText().isEmpty() || idperfil.getValue() == null) {
            Alert alertDatInv = new Alert(Alert.AlertType.ERROR);
            alertDatInv.setTitle("Erro");
            alertDatInv.setHeaderText("Verifique os dados inseridos");
            alertDatInv.show();
        }else{
            Talento t1 = new Talento();
            t1.setNomeTalento(idNome.getText());
            t1.setEmailTalento(idEmail.getText());
            t1.setPaisTalento(idPais.getText());
            t1.setPrecoH(idPrecoH.getText());
            t1.setPerfil(idperfil.getValue());

            Criar_Talento.criarTalento(t1);
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
        stage.setTitle("Menu Utilizador");
        stage.show();
    }

    @FXML
    void cmbperfil(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String[] items = {"Publico","Privado"};
        idperfil.getItems().addAll(items);
    }

}
