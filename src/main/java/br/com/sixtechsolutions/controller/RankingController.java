package br.com.sixtechsolutions.controller;

import br.com.sixtechsolutions.CenaControlada;
import br.com.sixtechsolutions.ControladorDeCenas;
import br.com.sixtechsolutions.Main;
import br.com.sixtechsolutions.controller.logica.DadosJogador;
import br.com.sixtechsolutions.controller.logica.Personagem;
import br.com.sixtechsolutions.model.dao.JogadorDAO;
import br.com.sixtechsolutions.model.database.Database;
import br.com.sixtechsolutions.model.database.DatabaseFactory;
import br.com.sixtechsolutions.model.dominio.Jogador;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Connection;
import java.util.List;
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
    private final Database database = DatabaseFactory.getDatabase("mysql");
    private final Connection connection = database.conectar();
    private final JogadorDAO jogadorDAO = new JogadorDAO();
    private final Label[] listanome = new Label[10];
    private final Label[] listapontos = new Label[10];
    private DadosJogador dados = new DadosJogador();
    private Personagem personagem = new Personagem();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        jogadorDAO.setConnection(connection);
        listanome[0] = lblNomeJogador1;
        listanome[1] = lblNomeJogador2;
        listanome[2] = lblNomeJogador3;
        listanome[3] = lblNomeJogador4;
        listanome[4] = lblNomeJogador5;
        listanome[5] = lblNomeJogador6;
        listanome[6] = lblNomeJogador7;
        listanome[7] = lblNomeJogador8;
        listanome[8] = lblNomeJogador9;
        listanome[9] = lblNomeJogador10;
        listapontos[0] = lblPontosJogador1;
        listapontos[1] = lblPontosJogador2;
        listapontos[2] = lblPontosJogador3;
        listapontos[3] = lblPontosJogador4;
        listapontos[4] = lblPontosJogador5;
        listapontos[5] = lblPontosJogador6;
        listapontos[6] = lblPontosJogador7;
        listapontos[7] = lblPontosJogador8;
        listapontos[8] = lblPontosJogador9;
        listapontos[9] = lblPontosJogador10;
        atualizaRanking(jogadorDAO.listar());
        database.desconectar(connection);
        atualizarAvatarPerfil(dados.getIdPersonagem());
        lblNomedoPlayer.setText(dados.getNome());
        lblNvDoPlayer.setText(String.valueOf(dados.getNivel()));
        lblExperiencia.setText(String.valueOf(dados.getExperiencia()));
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
    private Button btnSair;

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
    private Label lblPosicao4;

    @FXML
    private Label lblPosicao5;

    @FXML
    private Label lblPosicao6;

    @FXML
    private Label lblPosicao7;

    @FXML
    private Label lblPosicao8;

    @FXML
    private Label lblPosicao9;

    @FXML
    private Label lblPosicao10;

    @FXML
    private Label lblPosicao3;

    @FXML
    private Label lblPosicao2;

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
    private Label lblPosicao;

    @FXML
    private Label lblJogador;

    @FXML
    private Label lblPontos;

    @FXML
    private Label lblPontosJogador1;

    @FXML
    private Label lblPontosJogador2;

    @FXML
    private Label lblPontosJogador3;

    @FXML
    private Label lblPontosJogador4;

    @FXML
    private Label lblPontosJogador5;

    @FXML
    private Label lblPontosJogador6;

    @FXML
    private Label lblPontosJogador7;

    @FXML
    private Label lblPontosJogador8;

    @FXML
    private Label lblPontosJogador9;

    @FXML
    private Label lblPontosJogador10;

    @FXML
    private Label lblEstado;

    @FXML
    void actionBtnConfigs(ActionEvent event) {
        //meuControlador.setScreen(Main.cenaConfiguracoes);
        lblEstado.setVisible(true);
    }

    @FXML
    void actionBtnConquistas(ActionEvent event) {
        //meuControlador.setScreen(Main.cenaConquistas);
        lblEstado.setVisible(true);
    }

    @FXML
    void actionBtnConteudo(ActionEvent event) {
        //meuControlador.setScreen(Main.cenaConteudo);
        lblEstado.setVisible(true);
    }

    @FXML
    void actionBtnJogar(ActionEvent event) {
        meuControlador.loadScreen(Main.cenaDificuldade, Main.cenaDificuldadeLocal);
        meuControlador.setScreen(Main.cenaDificuldade);
        meuControlador.unloadScreen(Main.cenaRanking);
    }

    @FXML
    void actionBtnMenu(ActionEvent event) {
        meuControlador.loadScreen(Main.cenaMenu, Main.cenaMenuLocal);
        meuControlador.setScreen(Main.cenaMenu);
        meuControlador.unloadScreen(Main.cenaRanking);
        lblEstado.setVisible(false);
    }

    @FXML
    void actionBtnPerfil(ActionEvent event) {

    }

    @FXML
    void actionBtnSobre(ActionEvent event) {
        //meuControlador.setScreen(Main.cenaSobre);
        lblEstado.setVisible(true);
    }

    @FXML
    void actionBtnSair(ActionEvent event) {
        meuControlador.loadScreen(Main.cenaLogin, Main.cenaLoginLocal);
        meuControlador.setScreen(Main.cenaLogin);
        meuControlador.unloadScreen(Main.cenaRanking);
        lblEstado.setVisible(false);
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

    public void atualizaRanking(List<Jogador> retorno) {
        for (int i = 0; i <= 9; i++) {
            listanome[i].setText(retorno.get(i).getNome());
            listapontos[i].setText(String.valueOf(retorno.get(i).getPontos()));
        }
    }

    public void atualizarAvatarPerfil(int id) {
        if (id == 1) {
            btnPerfil.getStyleClass().set(1, "btn-avatar-bomberman");
            personagem.setPersonagem("bomberman");
        } else if (id == 2) {
            btnPerfil.getStyleClass().set(1, "btn-avatar-crash");
            personagem.setPersonagem("crash");
        } else if (id == 3) {
            btnPerfil.getStyleClass().set(1, "btn-avatar-donkeykong");
            personagem.setPersonagem("donkeykong");
        } else if (id == 4) {
            btnPerfil.getStyleClass().set(1, "btn-avatar-dukenukem");
            personagem.setPersonagem("dukenukem");
        } else if (id == 5) {
            btnPerfil.getStyleClass().set(1, "btn-avatar-kratos");
            personagem.setPersonagem("kratos");
        } else if (id == 6) {
            btnPerfil.getStyleClass().set(1, "btn-avatar-laracroft");
            personagem.setPersonagem("laracroft");
        } else if (id == 7) {
            btnPerfil.getStyleClass().set(1, "btn-avatar-mario");
            personagem.setPersonagem("mario");
        } else if (id == 8) {
            btnPerfil.getStyleClass().set(1, "btn-avatar-megaman");
            personagem.setPersonagem("megaman");
        } else if (id == 9) {
            btnPerfil.getStyleClass().set(1, "btn-avatar-pacman");
            personagem.setPersonagem("pacman");
        } else if (id == 10) {
            btnPerfil.getStyleClass().set(1, "btn-avatar-ryu");
            personagem.setPersonagem("ryu");
        } else if (id == 11) {
            btnPerfil.getStyleClass().set(1, "btn-avatar-sonic");
            personagem.setPersonagem("sonic");
        } else if (id == 12) {
            btnPerfil.getStyleClass().set(1, "btn-avatar-zelda");
            personagem.setPersonagem("zelda");
        }
    }
}
