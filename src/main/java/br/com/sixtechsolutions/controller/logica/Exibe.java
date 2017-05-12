package br.com.sixtechsolutions.controller.logica;

import javafx.scene.control.Label;

public class Exibe {

    Resultado resultado = new Resultado();

    public void setExibePotuacao(Label exibicao) {
        exibicao.setText(String.valueOf(resultado.getPontos()));
    }

}
