package br.com.sixtechsolutions.controller.logica;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Jogada {

    public Exibe exibe = new Exibe();
    public Resultado resultado = new Resultado();
    public Personagem personagem = new Personagem();

    public void exibirTodosBotoes(Button[] btnA) {
        for (int i = 0; i < personagem.getReferencia().length; i++) {
            btnA[i].setDisable(true);
            if (personagem.getReferencia(i) == 1) {
                btnA[i].getStyleClass().set(1, "c1-" + personagem.getPersonagem());
            } else {
                btnA[i].getStyleClass().set(1, "c2-" + personagem.getPersonagemRival());
            }
        }
    }

    public void exibirUmBotao(Button btnA, int btn) {
        if (personagem.getReferencia(btn) == 1) {
            btnA.getStyleClass().set(1, "c1-" + personagem.getPersonagem());
            btnA.setDisable(true);
        } else {
            btnA.getStyleClass().set(1, "c2-" + personagem.getPersonagemRival());
            btnA.setDisable(true);
        }
    }

    public void esconderBotoes(Button[] btnA) {
        for (int i = 0; i < personagem.getReferencia().length; i++) {
            btnA[i].getStyleClass().set(1, "c0-fundo-transparente");
            btnA[i].setDisable(false);
        }
    }

    public void cliclouBotao(Button[] btnlista, Button btnA, Label exibePontos, int btn) {
        btnlista[btn].setDisable(true);
        resultado.verificarSeAcertou(btn);
        exibe.setExibePotuacao(exibePontos);
        exibirUmBotao(btnA, btn);
    }
}
