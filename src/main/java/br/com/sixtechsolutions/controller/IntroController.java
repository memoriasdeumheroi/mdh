package br.com.sixtechsolutions.controller;

import br.com.sixtechsolutions.CenaControlada;
import br.com.sixtechsolutions.ControladorDeCenas;
import br.com.sixtechsolutions.Main;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class IntroController implements Initializable, CenaControlada {

    private ControladorDeCenas meuControlador;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @Override
    public void defineCenaPai(ControladorDeCenas screenParent) {
        meuControlador = screenParent;
    }

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Button btnIniciar;

    @FXML
    private Label lblLogo;

    @FXML
    public void actionBtnIniciar(ActionEvent event) {
        meuControlador.loadScreen(Main.cenaLogin, Main.cenaLoginLocal);
        meuControlador.setScreen(Main.cenaLogin);
    }

}
