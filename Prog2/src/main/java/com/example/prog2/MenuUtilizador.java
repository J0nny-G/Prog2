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

import java.io.IOException;
import java.io.Serializable;
import java.util.Optional;

public class MenuUtilizador implements Serializable {
    @FXML
    private Button idCriarCliente;

    @FXML
    private Button idCriarSkill;

    @FXML
    private Button idCriarTalento;

    @FXML
    private Button idEditarSkill;

    @FXML
    void btnCriarCliente(ActionEvent event) {
        try{
            Parent root = FXMLLoader.load(getClass().getResource("MenuCliente.fxml"));
            Scene regCena = new Scene(root);
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(regCena);
            stage.setTitle("Criar Cliente");
            stage.show();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnCriarSkill(ActionEvent event) {
        try{
            Parent root = FXMLLoader.load(getClass().getResource("CriarSkill.fxml"));
            Scene regCena = new Scene(root);
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(regCena);
            stage.setTitle("Criar Skill");
            stage.show();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnCriarTalento(ActionEvent event) {
        try{
            Parent root = FXMLLoader.load(getClass().getResource("MenuPerfilTalento.fxml"));
            Scene regCena = new Scene(root);
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(regCena);
            stage.setTitle("Criar Perfil Talento");
            stage.show();
        }catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void btnEditarSkill(ActionEvent event) {
        try{
            Parent root = FXMLLoader.load(getClass().getResource("EditarSkill.fxml"));
            Scene regCena = new Scene(root);
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(regCena);
            stage.setTitle("Editar Skill");
            stage.show();
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
    @FXML
    void btnSkillTalento(ActionEvent event) {
        try{
            Parent root = FXMLLoader.load(getClass().getResource("MenuSkillTalento.fxml"));
            Scene regCena = new Scene(root);
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(regCena);
            stage.setTitle("Associar Perfil de Talento");
            stage.show();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void btnSair(ActionEvent actionEvent) {
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
                        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
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

    public void btnCriarD(ActionEvent event) {
        try{
            Parent root = FXMLLoader.load(getClass().getResource("MenuDescricao.fxml"));
            Scene regCena = new Scene(root);
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(regCena);
            stage.setTitle("Associar Perfil de Talento");
            stage.show();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void btnPTalento(ActionEvent event) {
        try{
            Parent root = FXMLLoader.load(getClass().getResource("PesquisarTalentos.fxml"));
            Scene regCena = new Scene(root);
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(regCena);
            stage.setTitle("Pesquisar Talentos");
            stage.show();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void btnRPropostas(ActionEvent event) {
        try{
            Parent root = FXMLLoader.load(getClass().getResource("RegistarProposta.fxml"));
            Scene regCena = new Scene(root);
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(regCena);
            stage.setTitle("Registar Proposta");
            stage.show();
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}
