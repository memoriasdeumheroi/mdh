package br.com.sixtechsolutions.controller.logica;

public class Resultado {

    static private int totalBtnCertos;
    static private int totalAcertos = 0;
    static private int totalErros = 0;
    static private int pontos;

    Personagem personagem = new Personagem();

    public void verificarSeAcertou(int btn) {
        if (personagem.getReferencia(btn) == 1) {
            Resultado.totalAcertos++;
            pontos += 1250;
        } else {
            Resultado.totalErros++;
        }
    }

    public void verificarTotalBtnCerto() {
        for (int i = 0; i < personagem.getReferencia().length; i++) {
            if (personagem.getReferencia(i) == 1) {
                Resultado.totalBtnCertos++;
            }
        }
    }

    public int getTotalBtnCertos() {
        return totalBtnCertos;
    }

    public int getTotalAcertos() {
        return totalAcertos;
    }

    public int getTotalErros() {
        return totalErros;
    }

    public int getPontos() {
        return pontos;
    }

}
