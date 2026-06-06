package dev.java10x.ProjetoDDD.domain.campanha;

public class bateuameta {

    public boolean verificar(double totalRecebido, double objetivo) {
        return totalRecebido >= objetivo;
    }

    public String mensagem(double totalRecebido, double objetivo) {
        if (verificar(totalRecebido, objetivo)) {
            return "Meta atingida";
        }
        return "Meta ainda não foi atingida";
    }
}

