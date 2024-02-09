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

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.example.prog2.Repositorio.getRepo;

public class MenuDescricao implements Initializable {
    @FXML
    private Button idCDescricao;

    @FXML
    private DatePicker idDcomeco;

    @FXML
    private DatePicker idDtermino;

    @FXML
    private TextField idNomeEmpresa;

    @FXML
    private TextField idTitulo;
    @FXML
    private ComboBox<String> idCbTalento;

    @FXML
    private Button idVoltar;

    @FXML
    void btnCDescricao(ActionEvent event) {
        Boolean found = false;
        if(idCDescricao.getText().isEmpty() || idDcomeco.getValue() == null || idTitulo.getText().isEmpty() ||idNomeEmpresa.getText().isEmpty()){
            Alert alertDatInv = new Alert(Alert.AlertType.ERROR);
            alertDatInv.setTitle("Erro");
            alertDatInv.setHeaderText("Verifique os dados inseridos");
            alertDatInv.show();
        }
        Repositorio repo = getRepo();
        for (Descricao dd : repo.getDescricao().values()) {
            if (dd.getTalento() == idCbTalento.getValue()) {
                found = true;
                Alert alertDatInv = new Alert(Alert.AlertType.ERROR);
                alertDatInv.setTitle("Erro");
                alertDatInv.setHeaderText("O perfil talento já contém uma descrição");
                alertDatInv.show();
            }

        }  
        if(!found){
            Descricao d = new Descricao();
            d.setTituloDescricao(idTitulo.getText());
            d.setNomeD(idNomeEmpresa.getText());
            d.setDataC(String.valueOf(idDcomeco.getValue()));
            d.setDataT(String.valueOf(idDtermino.getValue()));
            d.setTalento(idCbTalento.getValue());

            Criar_Descricao.criarDescricao(d);
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Repositorio repo = getRepo();
        for(Talento t : repo.getTalento().values()){
            String[] items = {t.getNomeTalento()};
            idCbTalento.getItems().addAll(items);
        }
    }
}
