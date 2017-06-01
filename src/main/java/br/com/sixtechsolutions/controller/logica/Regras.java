package br.com.sixtechsolutions.controller.logica;

import br.com.sixtechsolutions.ControladorDeCenas;
import br.com.sixtechsolutions.Main;
import br.com.sixtechsolutions.model.dao.JogadorDAO;
import br.com.sixtechsolutions.model.database.Database;
import br.com.sixtechsolutions.model.database.DatabaseFactory;
import java.sql.Connection;
import java.util.Timer;
import java.util.TimerTask;
import javafx.scene.control.Button;

public class Regras extends Tempo {

    private long tempo = (1000 * 5);
    Timer timer;
    TimerTask tarefa;
    private final Database database = DatabaseFactory.getDatabase("mysql");
    private final Connection connection = database.conectar();
    private final JogadorDAO jogadorDAO = new JogadorDAO();
    private final DadosJogador dados = new DadosJogador();

    public void iniciaJogo(Button[] listabuttos) {

        personagem.MudarPosicaoFiguras();
        resultado.verificarTotalBtnCerto();
        exibirTodosBotoes(listabuttos);
        exibirTodosBotoes(listabuttos);
        iniciarTempo(listabuttos);
        iniciarTime();
    }

    public void pausaJogo() {
        System.out.println("Jogo pausado");
    }

    public void novoNivel(Button[] listabuttos) {
        personagem.MudarPosicaoFiguras();
        resultado.verificarTotalBtnCerto();
        exibirTodosBotoes(listabuttos);
        diminuirTempo();
        zerarTempo();
        iniciarTempo(listabuttos);
        iniciarTime();
        System.out.println("Novo Nível");
    }

    public void fimJogo(Button[] lista) {
        exibirTodosBotoesBloquados(lista);
        resultado.setTrava(true);
        System.out.println("Game Over");

    }

    public void verificaJogada(Button[] listabuttos, ControladorDeCenas meuControlador) {
        if (resultado.getTotalAcertos() == resultado.getTotalBtnCertos()) {
            novoNivel(listabuttos);
        }
        if (resultado.getTotalErros() >= 3) {
            fimJogo(listabuttos);
            irParaGameOver(meuControlador);
            iniciar();
        }
    }

    public void irParaGameOver(ControladorDeCenas meuControlador) {
        timer = new Timer();
        tarefa = new TimerTask() {
            @Override
            public void run() {
                jogadorDAO.setConnection(connection);
                jogadorDAO.inserirJogada(dados.getLogin(), resultado.getTotalAcertos(),
                        resultado.getTotalErros(), resultado.getPontos());
                meuControlador.loadScreen(Main.cenaGameOver, Main.cenaGameOverLocal);
                meuControlador.setScreen(Main.cenaGameOver);
                meuControlador.unloadScreen(Main.cenaJogada);
                database.desconectar(connection);
                timer.cancel();
            }
        };
    }

    public void iniciar() {
        timer.scheduleAtFixedRate(tarefa, tempo, tempo);
    }
}
