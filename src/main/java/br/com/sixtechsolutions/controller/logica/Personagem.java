package br.com.sixtechsolutions.controller.logica;

import java.util.Random;

public class Personagem {

    private static final int[] referencia = new int[12];
    public static String personagem = "mario";
    public static String personagemRival = "sonic";

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
        System.out.println(personagem);
    }

    public String getPersonagem() {
        return personagem;
    }

    public void setPersonagemRival(String personagemRival) {
        Personagem.personagemRival = personagemRival;
    }

    public String getPersonagemRival() {
        return personagemRival;
    }

}
