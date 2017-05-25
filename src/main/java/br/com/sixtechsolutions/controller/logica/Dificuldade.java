package br.com.sixtechsolutions.controller.logica;

public class Dificuldade {

    private static float tempoExibicao = 5;

    public float getTempoExibicao() {
        return tempoExibicao;
    }

    public void setTempoExibicao(float tempoExibicao) {
        this.tempoExibicao -= tempoExibicao;
    }

}
