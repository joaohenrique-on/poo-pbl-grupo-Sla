package dev.java10x.ProjetoDDD.domain;

import lombok.*;
<<<<<<< HEAD

public class Usuario {

    private final @Getter String id;
    private @Getter @Setter String nome;

    public Usuario(String id,String nome) {
=======

public class usuario {

    private final @Getter String id;
    private @Getter @Setter String nome;

    public usuario(String id,String nome) {
>>>>>>> 6ba1ade72d070222e8ec76ee16f41cb66793e534

        this.id = id;
        this.nome = nome;
    }

    public Doacao realizarDoacao(Campanha campanha, double valor) {

        if (valor <= 0) {
            throw new IllegalArgumentException("Valor inválido");
        }

        Doacao doacao = new Doacao(this, valor);

<<<<<<< HEAD
        campanha.receberdoacao(doacao);
=======
        campanha.receberDoacao(doacao);
>>>>>>> 6ba1ade72d070222e8ec76ee16f41cb66793e534

        return doacao;
    }
}


    