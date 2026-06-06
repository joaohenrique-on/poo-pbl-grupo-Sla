package dev.java10x.ProjetoDDD.domain.doaçao;

public class verificarvalorvalido {

    public boolean validar(double valor) {
        return valor > 0;
    }

    public String mensagem(double valor) {
        if (validar(valor)) {
            return "Valor válido para doação";
        }
        return "Valor inválido: deve ser maior que zero";
    }
}

