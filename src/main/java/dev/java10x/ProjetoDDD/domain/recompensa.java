package dev.java10x.ProjetoDDD.domain;

public class recompensa {

    public boolean verificar(double valorDoado, double valorRecompensa) {
        return valorDoado >= valorRecompensa;
    }

    public String mensagem(double valorDoado, double valorRecompensa) {
        if (verificar(valorDoado, valorRecompensa)) {
            return "Valor suficiente para receber a recompensa";
        } else {
            return "Valor insuficiente para receber a recompensa";
        }
    }
}
