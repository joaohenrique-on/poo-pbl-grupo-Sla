package dev.java10x.ProjetoDDD.domain;

import lombok.*;

public class doacao {

  private final @Getter usuario doador;
  private final @Getter double valor;

  public doacao(usuario doador, double valor){

  if (valor <= 0) { 
    throw new IllegalArgumentException("Valor deve ser maior que zero");
  }
    
    this.doador = doador;
    this.valor = valor;

  }


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
