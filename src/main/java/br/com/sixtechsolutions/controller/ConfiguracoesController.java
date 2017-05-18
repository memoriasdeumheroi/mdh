package br.com.sixtechsolutions.controller;

import br.com.sixtechsolutions.CenaControlada;
import br.com.sixtechsolutions.ControladorDeCenas;
import br.com.sixtechsolutions.Main;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class ConfiguracoesController implements Initializable, CenaControlada {

    ControladorDeCenas meuControlador;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @Override
    public void defineCenaPai(ControladorDeCenas screenParent) {
        meuControlador = screenParent;
    }

    @FXML
    private Pane pane;

    @FXML
    private Button btnPerfil;

    @FXML
    private Button btnMenu;

    @FXML
    private Button btnJogar;

    @FXML
    private Button btnConquistas;

    @FXML
    private Button btnConteudo;

    @FXML
    private Button btnMelhoresScores;

    @FXML
    private Button btnConfigs;

    @FXML
    private Button btnSobre;

    @FXML
    private Button btnGitHub;

    @FXML
    private Label lblNomedoPlayer;

    @FXML
    private Label lblNvDoPlayer;

    @FXML
    private Label lblExperiencia;

    @FXML
    private void actionBtnMenu(ActionEvent event) {
        meuControlador.setScreen(Main.cenaMenu);
    }

    @FXML
    private void actionBtnConquistas(ActionEvent event) {
        meuControlador.setScreen(Main.cenaConquistas);
    }

    @FXML
    private void actionBtnConteudo(ActionEvent event) {
        meuControlador.setScreen(Main.cenaConteudo);
    }

    @FXML
    private void actionBtnJogar(ActionEvent event) {
        meuControlador.setScreen(Main.cenaJogada);
    }

    @FXML
    private void actionBtnMelhoresScores(ActionEvent event) {
        meuControlador.setScreen(Main.cenaRanking);
    }

    @FXML
    private void actionBtnPerfil(ActionEvent event) {

    }

    @FXML
    private void actionBtnSobre(ActionEvent event) {
        meuControlador.setScreen(Main.cenaSobre);
    }

    @FXML
    private void actionBtnGitHub(ActionEvent event) {
        if (Desktop.isDesktopSupported()) {
            new Thread(() -> {
                try {
                    Desktop.getDesktop().browse(new URI("https://github.com/memoriasdeumheroi/mdh"));
                } catch (IOException | URISyntaxException e1) {
                    e1.printStackTrace();
                }
            }).start();
        }
    }
}
