package br.com.sixtechsolutions.controller.logica;

import javafx.scene.control.Button;

public class Regras extends Tempo {

    public void iniciaJogo(Button[] listabuttos) {
        personagem.MudarPosicaoFiguras();
        resultado.verificarTotalBtnCerto();
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
        diminuirTempo();
        zerarTempo();
        System.out.println("Novo Nível");
    }

    public void fimJogo(Button[] lista) {
        exibirTodosBotoes(lista);
        System.out.println("Game Over");

    }

    public void verificaJogada(Button[] listabuttos) {
        if (resultado.getTotalAcertos() == resultado.getTotalBtnCertos()) {
            novoNivel(listabuttos);
        }
        if (resultado.getTotalErros() >= 3) {
            fimJogo(listabuttos);
        }
    }
}
