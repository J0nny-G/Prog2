package com.example.prog2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

import static com.example.prog2.Repositorio.*;

public class PaginaPrincipal {

    @FXML
    private PasswordField password;

    @FXML
    private TextField username;


        @FXML
        void btnCriarConta(ActionEvent event) {
                try{
                        Parent root = FXMLLoader.load(getClass().getResource("Registar.fxml"));
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
        void btnLogin(ActionEvent event) {
                boolean found = false;
                try{
                    Repositorio repo = getRepo();
                        for(Utilizador u : repo.getUtilizador().values()) {
                            if (username.getText().equalsIgnoreCase(u.getUsername()) && password.getText().equals(u.getPassword())) {
                                found = true;
                                System.out.println("Login com Sucesso!");
                                Parent root = FXMLLoader.load(getClass().getResource("MenuUtilizador.fxml"));
                                Scene regCena = new Scene(root);
                                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                                stage.setScene(regCena);
                                stage.setTitle("Menu Utilizador");
                                stage.show();

                            }
                        }
                        for (Admin a : repo.getAdmin().values()) {
                            if (username.getText().equalsIgnoreCase(a.getUsername()) && password.getText().equals(a.getPassword())) {
                                found = true;
                                System.out.println("Login com Sucesso!");
                                Parent root = FXMLLoader.load(getClass().getResource("MenuAdmin.fxml"));
                                Scene regCena = new Scene(root);
                                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                                stage.setScene(regCena);
                                stage.setTitle("Menu Admin");
                                stage.show();
                            }
                        }
                        if (!found) {
                                Alert alertDatInv = new Alert(Alert.AlertType.ERROR);
                                alertDatInv.setTitle("Erro");
                                alertDatInv.setHeaderText("Utilizador/Password Errada!");
                                alertDatInv.show();
                        }

                }catch (Exception e) {
                        e.printStackTrace();
                }

        }


    }
