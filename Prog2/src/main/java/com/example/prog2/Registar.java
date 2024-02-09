package com.example.prog2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.example.prog2.Repositorio.getRepo;

public class Registar implements Initializable {
    @FXML
    private ComboBox<String> cmbtipo;

    @FXML
    private TextField email;

    @FXML
    private TextField nif;

    @FXML
    private TextField nome;

    @FXML
    private PasswordField password;

    @FXML
    private TextField telemovel;

    @FXML
    private TextField username;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String[] items = {"Utilizador"};
        cmbtipo.getItems().addAll(items);
    }

    public Registar() {
    }

    public void criar(ActionEvent actionEvent) {
        boolean found = false;
        if (nome.getText().isEmpty() || email.getText().isEmpty() || nif.getText().isEmpty() || password.getText().isEmpty() || username.getText().isEmpty() || cmbtipo.getValue() == null) {
            Alert alertDatInv = new Alert(Alert.AlertType.ERROR);
            alertDatInv.setTitle("Erro");
            alertDatInv.setHeaderText("Verifique os dados inseridos");
            alertDatInv.show();
        }
        Repositorio repo = getRepo();
        for (Utilizador u : repo.getUtilizador().values()) {
            if (u.getUsername().equals(username.getText())) {
                found = true;
                Alert alertDatInv = new Alert(Alert.AlertType.ERROR);
                alertDatInv.setTitle("Erro");
                alertDatInv.setHeaderText("Utilizador já existe");
                alertDatInv.show();
            }
        }
        if (!found) {
            Utilizador u1 = new Utilizador();
            u1.setNome(nome.getText());
            u1.setEmail(email.getText());
            u1.setTelemovel(telemovel.getText());
            u1.setNif(nif.getText());
            u1.setTipo(cmbtipo.getValue().toString());
            u1.setUsername(username.getText());
            u1.setPassword(password.getText());

            Criar_Utilizador.criarUtilizador(u1);

            try {
                Parent root = FXMLLoader.load(getClass().getResource("PaginaPrincipal.fxml"));
                Scene regCena = new Scene(root);
                Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                stage.setScene(regCena);
                stage.setTitle("Login");
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void voltar(ActionEvent event) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("PaginaPrincipal.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene regCena = new Scene (root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(regCena);
        stage.setTitle("Login");
        stage.show();

    }
}
