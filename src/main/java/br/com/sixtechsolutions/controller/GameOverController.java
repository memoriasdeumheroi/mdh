package br.com.sixtechsolutions.controller;

import br.com.sixtechsolutions.CenaControlada;
import br.com.sixtechsolutions.ControladorDeCenas;
import br.com.sixtechsolutions.Main;
import br.com.sixtechsolutions.controller.logica.Resultado;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class GameOverController implements Initializable, CenaControlada {

    private ControladorDeCenas meuControlador;
    private final Resultado resultado = new Resultado();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lblPontos.setText(String.valueOf(resultado.getPontos()));
    }

    @Override
    public void defineCenaPai(ControladorDeCenas screenParent) {
        meuControlador = screenParent;
    }

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Label lblGameOver;

    @FXML
    private Label lblPontosLabel;

    @FXML
    private Label lblPontos;

    @FXML
    private Label lblImagemMarioSonic;

    @FXML
    private Button btnJogarNovamente;

    @FXML
    private Button btnVoltarMenu;

    @FXML
    void actionBtnJogarNovamente(ActionEvent event) {
        meuControlador.unloadScreen(Main.cenaGameOver);
        meuControlador.loadScreen(Main.cenaMenu, Main.cenaMenuLocal);
        meuControlador.setScreen(Main.cenaDificuldade);
        resultado.zeraResultados();
    }

    @FXML
    void actionBtnVoltarMenu(ActionEvent event) {
        meuControlador.unloadScreen(Main.cenaGameOver);
        meuControlador.loadScreen(Main.cenaMenu, Main.cenaMenuLocal);
        meuControlador.setScreen(Main.cenaMenu);
        resultado.zeraResultados();
    }

}
