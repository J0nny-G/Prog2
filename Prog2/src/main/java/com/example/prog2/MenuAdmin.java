package com.example.prog2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.util.Optional;

public class MenuAdmin {
    @FXML
    private Button idListarClientes;

    @FXML
    private Button idListarPro;

    @FXML
    private Button idListarSkills;

    @FXML
    private Button idListarTalen;

    @FXML
    private Button idListarUti;

    @FXML
    private Button idObterRela;

    @FXML
    private Button idVoltar;

    @FXML
    void btnListarClientes(ActionEvent event) {
        try{
            Parent root = FXMLLoader.load(getClass().getResource("ListarCliente.fxml"));
            Scene regCena = new Scene(root);
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(regCena);
            stage.setTitle("Listar Clientes");
            stage.show();
        }catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void btnListarProp(ActionEvent event) {
        try{
            Parent root = FXMLLoader.load(getClass().getResource("ListarProposta.fxml"));
            Scene regCena = new Scene(root);
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(regCena);
            stage.setTitle("Registar");
            stage.show();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnListarSkills(ActionEvent event) {
        try{
            Parent root = FXMLLoader.load(getClass().getResource("ListarSkill.fxml"));
            Scene regCena = new Scene(root);
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(regCena);
            stage.setTitle("Listar Skills");
            stage.show();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnListarTalen(ActionEvent event) {
        try{
            Parent root = FXMLLoader.load(getClass().getResource("ListarTalentos.fxml"));
            Scene regCena = new Scene(root);
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(regCena);
            stage.setTitle("Listar Talentos");
            stage.show();
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
    @FXML
    void btnListarUti(ActionEvent event) {
        try{
            Parent root = FXMLLoader.load(getClass().getResource("ListarUtilizador.fxml"));
            Scene regCena = new Scene(root);
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(regCena);
            stage.setTitle("Listar Utilizadores");
            stage.show();
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
    @FXML
    void btnObterRela(ActionEvent event) {
        try{
            Parent root = FXMLLoader.load(getClass().getResource("ObterRelatorios.fxml"));
            Scene regCena = new Scene(root);
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(regCena);
            stage.setTitle("Registar");
            stage.show();
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
    @FXML
    void btnSair(ActionEvent event) {
        try {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmação de término de sessão");
            alert.setHeaderText("Confirma sair?");
            alert.setContentText("Deseja terminar sessão?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                try {
                    Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("PaginaPrincipal.fxml"));
                    Scene regCena = new Scene(root);
                    Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    stage.setScene(regCena);
                    stage.setTitle("Iniciar Sessão");
                    stage.show();
                } catch (Exception var7) {
                    var7.printStackTrace();
                }
            }
        } catch (Exception var8) {
            var8.printStackTrace();
        }
    }
    public void btnCriarUtilizador(ActionEvent event) {
        try{
            Parent root = FXMLLoader.load(getClass().getResource("RegistarUtiAd.fxml"));
            Scene regCena = new Scene(root);
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(regCena);
            stage.setTitle("Registar");
            stage.show();
        }catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void btnEditarUti(ActionEvent event) {
        try{
            Parent root = FXMLLoader.load(getClass().getResource("EditarUtilizador.fxml"));
            Scene regCena = new Scene(root);
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(regCena);
            stage.setTitle("Registar");
            stage.show();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
