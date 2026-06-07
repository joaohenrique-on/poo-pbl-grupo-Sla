package dev.java10x.ProjetoDDD.domain;

public class doaçao {

    public boolean validar(double valor) {
        return valor > 0;
    }

    public String mensagem(double valor) {
        if (validar(valor)) {
            return "Valor válido para doação";
        } else {
            return "Valor inválido: deve ser maior que zero";
        }
    }
}
