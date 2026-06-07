package dev.java10x.ProjetoDDD.domain;

import lombok.*;

public class Usuario {

    private final @Getter String id;
    private @Getter @Setter String nome;

    public Usuario(String id,String nome) {

        this.id = id;
        this.nome = nome;
    }

    public Doacao realizarDoacao(Campanha campanha, double valor) {

        if (valor <= 0) {
            throw new IllegalArgumentException("Valor inválido");
        }

        Doacao doacao = new Doacao(this, valor);

        campanha.receberDoacao(doacao);

        return doacao;
    }
}


    