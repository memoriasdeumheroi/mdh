package br.com.sixtechsolutions.controller.logica;

import java.util.Random;

public class Personagem {

    private static final int[] referencia = new int[12];
    private static String personagem;

    Random random = new Random();

    public void MudarPosicaoFiguras() {
        for (int i = 0; i < referencia.length; i++) {
            referencia[i] = random.nextInt(2) + 1;
            if (referencia[i] == 1) {
            }
        }
    }

    public int[] getReferencia() {
        return referencia;
    }

    public int getReferencia(int i) {
        return referencia[i];
    }

    public void setPersonagem(String personagem) {
        Personagem.personagem = personagem;
    }

    public String getPersonagem() {
        return personagem;
    }
}
