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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class RankingController implements Initializable, CenaControlada {

    ControladorDeCenas meuControlador;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @Override
    public void defineCenaPai(ControladorDeCenas screenParent) {
        meuControlador = screenParent;
    }

    @FXML
    private AnchorPane anchorPane;

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
    private Label lblPosicao1;

    @FXML
    private Label lblNomeJogador1;

    @FXML
    private Label lblNomeJogador2;

    @FXML
    private Label lblNomeJogador3;

    @FXML
    private Label lblNomeJogador10;

    @FXML
    private Label lblNomeJogador9;

    @FXML
    private Label lblNomeJogador8;

    @FXML
    private Label lblNomeJogador4;

    @FXML
    private Label lblNomeJogador5;

    @FXML
    private Label lblNomeJogador6;

    @FXML
    private Label lblNomeJogador7;

    @FXML
    private Label lblNivelJogador1;

    @FXML
    private Label lblNivelJogador2;

    @FXML
    private Label lblNivelJogador3;

    @FXML
    private Label lblNivelJogador4;

    @FXML
    private Label lblNivelJogador5;

    @FXML
    private Label lblNivelJogador6;

    @FXML
    private Label lblNivelJogador7;

    @FXML
    private Label lblNivelJogador8;

    @FXML
    private Label lblNivelJogador9;

    @FXML
    private Label lblNivelJogador10;

    @FXML
    void actionBtnConfigs(ActionEvent event) {
        meuControlador.setScreen(Main.cenaConfiguracoes);
    }

    @FXML
    void actionBtnConquistas(ActionEvent event) {
        meuControlador.setScreen(Main.cenaConquistas);
    }

    @FXML
    void actionBtnConteudo(ActionEvent event) {
        meuControlador.setScreen(Main.cenaConteudo);
    }

    @FXML
    void actionBtnJogar(ActionEvent event) {
        meuControlador.setScreen(Main.cenaJogada);
    }

    @FXML
    void actionBtnMenu(ActionEvent event) {
        meuControlador.setScreen(Main.cenaMenu);
    }

    @FXML
    void actionBtnPerfil(ActionEvent event) {

    }

    @FXML
    void actionBtnSobre(ActionEvent event) {
        meuControlador.setScreen(Main.cenaSobre);
    }

    @FXML
    void actionBtnGitHub(ActionEvent event) {
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
