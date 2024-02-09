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
import java.util.List;
import java.util.ResourceBundle;

import static com.example.prog2.Repositorio.getRepo;

public class MenuCliente implements Initializable{
    @FXML
    private TextField idEmail;

    @FXML
    private TextField idNome;

    @FXML
    private TextField idPais;

    @FXML
    private Button idcriarcliente;

    @FXML
    private ComboBox<String> cmbtalento;

    @FXML
    private Button idvoltar;

    @FXML
    void btncriarcliente(ActionEvent event) {

        if(idEmail.getText().isEmpty() || idEmail.getText().isEmpty() || idNome.getText().isEmpty() || idPais.getText().isEmpty() || cmbtalento.getValue()==null){
            Alert alertDatInv = new Alert(Alert.AlertType.ERROR);
            alertDatInv.setTitle("Erro");
            alertDatInv.setHeaderText("Verifique os dados inseridos");
            alertDatInv.show();
        }else{
                Cliente c1 = new Cliente();
                c1.setEmailCliente(idEmail.getText());
                c1.setNomeCliente(idNome.getText());
                c1.setPaisCliente(idPais.getText());
                c1.setTalentoCliente(cmbtalento.getValue());

                Criar_Cliente.criarCliente(c1);
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Repositorio repo = getRepo();
        for(Talento t : repo.getTalento().values()){
            String[] items = {t.getNomeTalento()};
            cmbtalento.getItems().addAll(items);
        }
    }
}
