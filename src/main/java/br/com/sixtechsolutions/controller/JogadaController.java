package br.com.sixtechsolutions.controller;

import br.com.sixtechsolutions.CenaControlada;
import br.com.sixtechsolutions.ControladorDeCenas;
import br.com.sixtechsolutions.Main;
import br.com.sixtechsolutions.controller.logica.Regras;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class JogadaController extends Regras implements Initializable, CenaControlada {

    ControladorDeCenas meuControlador;

    Button[] listabtn = new Button[12];

    @Override
    public void defineCenaPai(ControladorDeCenas screenParent) {
        meuControlador = screenParent;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listabtn[0] = btnA1;
        listabtn[1] = btnA2;
        listabtn[2] = btnA3;
        listabtn[3] = btnA4;
        listabtn[4] = btnA5;
        listabtn[5] = btnA6;
        listabtn[6] = btnA7;
        listabtn[7] = btnA8;
        listabtn[8] = btnA9;
        listabtn[9] = btnA10;
        listabtn[10] = btnA11;
        listabtn[11] = btnA12;
    }

    @FXML
    public Button btnA1;
    @FXML
    public Button btnA2;
    @FXML
    public Button btnA3;
    @FXML
    public Button btnA4;
    @FXML
    public Button btnA5;
    @FXML
    public Button btnA6;
    @FXML
    public Button btnA7;
    @FXML
    public Button btnA8;
    @FXML
    public Button btnA9;
    @FXML
    public Button btnA10;
    @FXML
    public Button btnA11;
    @FXML
    public Button btnA12;
    @FXML
    public Button btnIniciar;
    @FXML
    public ProgressBar barraVida;
    @FXML
    public ProgressBar barraEstamina;
    @FXML
    public Label lblPontuacao;
    @FXML
    public Label exibePontuacao;
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
    void actionBtnPerfil(ActionEvent event) {

    }

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
    void actionBtnMenu(ActionEvent event) {
        meuControlador.setScreen(Main.cenaMenu);
    }

    @FXML
    void actionBtnMelhoresScores(ActionEvent event) {
        meuControlador.setScreen(Main.cenaRanking);
    }

    @FXML
    void actionBtnSobre(ActionEvent event) {
        meuControlador.setScreen(Main.cenaSobre);
    }

    public void btnA1Action(ActionEvent event) {
        cliclouBotao(listabtn, btnA1, exibePontuacao, 0);
        verificaJogada(listabtn);
    }

    @FXML
    public void btnA2Action(ActionEvent event) {
        cliclouBotao(listabtn, btnA2, exibePontuacao, 1);
        verificaJogada(listabtn);

    }

    @FXML
    public void btnA3Action(ActionEvent event) {
        cliclouBotao(listabtn, btnA3, exibePontuacao, 2);
        verificaJogada(listabtn);
    }

    @FXML
    public void btnA4Action(ActionEvent event) {
        cliclouBotao(listabtn, btnA4, exibePontuacao, 3);
        verificaJogada(listabtn);
    }

    @FXML
    public void btnA5Action(ActionEvent event) {
        cliclouBotao(listabtn, btnA5, exibePontuacao, 4);
        verificaJogada(listabtn);
    }

    @FXML
    public void btnA6Action(ActionEvent event) {
        cliclouBotao(listabtn, btnA6, exibePontuacao, 5);
        verificaJogada(listabtn);
    }

    @FXML
    public void btnA7Action(ActionEvent event) {
        cliclouBotao(listabtn, btnA7, exibePontuacao, 6);
        verificaJogada(listabtn);
    }

    @FXML
    public void btnA8Action(ActionEvent event) {
        cliclouBotao(listabtn, btnA8, exibePontuacao, 7);
        verificaJogada(listabtn);
    }

    @FXML
    public void btnA9Action(ActionEvent event) {
        cliclouBotao(listabtn, btnA9, exibePontuacao, 8);
        verificaJogada(listabtn);
    }

    @FXML
    public void btnA10Action(ActionEvent event) {
        cliclouBotao(listabtn, btnA10, exibePontuacao, 9);
        verificaJogada(listabtn);
    }

    @FXML
    public void btnA11Action(ActionEvent event) {
        cliclouBotao(listabtn, btnA11, exibePontuacao, 10);
        verificaJogada(listabtn);
    }

    @FXML
    public void btnA12Action(ActionEvent event) {
        cliclouBotao(listabtn, btnA12, exibePontuacao, 11);
        verificaJogada(listabtn);
    }

    @FXML
    public void btnAction(ActionEvent event) {
        iniciaJogo(listabtn);
    }

}
