package dev.java10x.ProjetoDDD.domain;

public interface CampanhaRepository {

    void salvar(Campanha campanha);

    Campanha buscarPorId(String id);

}