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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

import static com.example.prog2.Repositorio.getRepo;

public class EditarUtilizador implements Initializable {
    @FXML
    private ListView<String> ListUtilizador;

    @FXML
    private Button idEditarDados;

    @FXML
    private TextField idEmail;

    @FXML
    private TextField idNIF;

    @FXML
    private TextField idNome;

    @FXML
    private PasswordField idPassword;

    @FXML
    private TextField idTelemovel;

    @FXML
    private TextField idUsername;

    @FXML
    private Button idVoltar;

    @FXML
    void btnEditarDados(ActionEvent event) {
        Repositorio repo = getRepo();
        String username = ListUtilizador.getSelectionModel().getSelectedItem();
        Utilizador user = repo.getUtilizador().get(username);
        user.setEmail(idEmail.getText());
        user.setNif(idNIF.getText());
        user.setNome(idNome.getText());
        user.setPassword(idPassword.getText());
        user.setTelemovel(idTelemovel.getText());
        user.setUsername(idUsername.getText());

        repo.getUtilizador().put(username, user);
    }

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

        Repositorio repo = getRepo();
        for (Utilizador u : repo.getUtilizador().values()) {
            ListUtilizador.getItems().addAll(u.getUsername());
        }
        ListUtilizador.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            Utilizador utilizador = repo.getUtilizador().get(newValue);
            idNome.setText(utilizador.getNome());
            idEmail.setText(utilizador.getEmail());
            idNIF.setText(utilizador.getNif());
            idTelemovel.setText(utilizador.getTelemovel());
            idUsername.setText(utilizador.getUsername());
            idPassword.setText(utilizador.getPassword());
        });

    }
}
