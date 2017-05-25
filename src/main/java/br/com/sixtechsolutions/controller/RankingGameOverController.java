package br.com.sixtechsolutions.controller;

import br.com.sixtechsolutions.CenaControlada;
import br.com.sixtechsolutions.ControladorDeCenas;
import br.com.sixtechsolutions.model.dao.JogadorDAO;
import br.com.sixtechsolutions.model.database.Database;
import br.com.sixtechsolutions.model.database.DatabaseFactory;
import br.com.sixtechsolutions.model.dominio.Jogador;
import java.net.URL;
import java.sql.Connection;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class RankingGameOverController implements Initializable, CenaControlada {

    private ControladorDeCenas meuControlador;
    private final Database database = DatabaseFactory.getDatabase("mysql");
    private final Connection connection = database.conectar();
    private final JogadorDAO jogadorDAO = new JogadorDAO();
    private final Label[] listanome = new Label[10];
    private final Label[] listapontos = new Label[10];

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
    }

    @Override
    public void defineCenaPai(ControladorDeCenas screenParent) {
        meuControlador = screenParent;
    }

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Label lblPosicao;

    @FXML
    private Label lblJogador;

    @FXML
    private Label lblPontos;

    @FXML
    private Label lblPosicao1;

    @FXML
    private Label lblPosicao2;

    @FXML
    private Label lblPosicao3;

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

    public void atualizaRanking(List<Jogador> retorno) {
        for (int i = 0; i <= 9; i++) {
            listanome[i].setText(retorno.get(i).getNome());
            listapontos[i].setText(String.valueOf(retorno.get(i).getPontos()));
        }
    }
}
