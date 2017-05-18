package br.com.sixtechsolutions.controller;

import br.com.sixtechsolutions.CenaControlada;
import br.com.sixtechsolutions.ControladorDeCenas;
import br.com.sixtechsolutions.controller.logica.Personagem;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class DificuldadeController implements Initializable, CenaControlada {

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @Override
    public void defineCenaPai(ControladorDeCenas screenParent) {
        meuControlador = screenParent;
    }

    private ControladorDeCenas meuControlador;
    private final Personagem personagem = new Personagem();
    private boolean personagemSelecionado;

    @FXML
    private ProgressBar progressBarAtaque1;

    @FXML
    private ProgressBar progressBarDefesa1;

    @FXML
    private ProgressBar progressBarAgilidade1;

    @FXML
    private ProgressBar progressBarAtaque2;

    @FXML
    private ProgressBar progressBarDefesa2;

    @FXML
    private ProgressBar progressBarAgilidade2;

    @FXML
    private Label lblAtaquePersonagem1;

    @FXML
    private Label lblDefesaPersonagem1;

    @FXML
    private Label lblDificuldade;

    @FXML
    private Label lblPersonagem1;

    @FXML
    private Label lblAgilidadePersonagem1;

    @FXML
    private Label lblPersonagem2;

    @FXML
    private Label lblAtaquePersonagem2;

    @FXML
    private Label lblDefesaPersonagem2;

    @FXML
    private Label lblAgilidadePersonagem2;

    @FXML
    private Button btnFacil;

    @FXML
    private Button btnNormal;

    @FXML
    private Button btnDificil;

    @FXML
    private Button btnHeroi;

    @FXML
    private Button btnCrash;

    @FXML
    private Button btnDonkeyKong;

    @FXML
    private Button btnDukeNukem;

    @FXML
    private Button btnMegaman;

    @FXML
    private Button btnKratos;

    @FXML
    private Button btnMario;

    @FXML
    private Button btnLaraCroft;

    @FXML
    private Button btnPacman;

    @FXML
    private Button btnRyu;

    @FXML
    private Button btnSonic;

    @FXML
    private Button btnZelda;

    @FXML
    private Button btnBomberman;

    @FXML
    private Button btnAleatorio;

    @FXML
    private Button btnJogar;

    @FXML
    void actionBtnFacil(ActionEvent event) {

    }

    @FXML
    void actionBtnNormal(ActionEvent event) {

    }

    @FXML
    void actionBtnDificil(ActionEvent event) {

    }

    @FXML
    void actionBtnHeroi(ActionEvent event) {

    }

    @FXML
    void actionBtnJogar(ActionEvent event) {

    }

    @FXML
    void actionBtnAleatorio(ActionEvent event) {

    }

    @FXML
    void actionBtnBomberman(ActionEvent event) {
        personagem.setPersonagem("bomberman");
        personagemSelecionado = true;
    }

    @FXML
    void actionBtnCrash(ActionEvent event) {
        personagem.setPersonagem("crash");
        personagemSelecionado = true;
    }

    @FXML
    void actionBtnDonkeyKong(ActionEvent event) {
        personagem.setPersonagem("donkeykong");
        personagemSelecionado = true;
    }

    @FXML
    void actionBtnDukeNukem(ActionEvent event) {
        personagem.setPersonagem("dukenukem");
        personagemSelecionado = true;
    }

    @FXML
    void actionBtnKratos(ActionEvent event) {
        personagem.setPersonagem("kratos");
        personagemSelecionado = true;
    }

    @FXML
    void actionBtnLaraCroft(ActionEvent event) {
        personagem.setPersonagem("laracroft");
        personagemSelecionado = true;
    }

    @FXML
    void actionBtnMario(ActionEvent event) {
        personagem.setPersonagem("mario");
        personagemSelecionado = true;
    }

    @FXML
    void actionBtnMegaman(ActionEvent event) {
        personagem.setPersonagem("megaman");
        personagemSelecionado = true;
    }

    @FXML
    void actionBtnPacman(ActionEvent event) {
        personagem.setPersonagem("pacman");
        personagemSelecionado = true;
    }

    @FXML
    void actionBtnRyu(ActionEvent event) {
        personagem.setPersonagem("ryu");
        personagemSelecionado = true;
    }

    @FXML
    void actionBtnSonic(ActionEvent event) {
        personagem.setPersonagem("sonic");
        personagemSelecionado = true;
    }

    @FXML
    void actionBtnZelda(ActionEvent event) {
        personagem.setPersonagem("zelda");
        personagemSelecionado = true;
    }

}
