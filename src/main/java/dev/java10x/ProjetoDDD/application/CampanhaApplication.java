package dev.java10x.ProjetoDDD.application;

import dev.java10x.ProjetoDDD.domain.*;

public class CampanhaApplication {

    private final CampanhaRepository campanhaRepository;

    public CampanhaApplication(CampanhaRepository campanhaRepository) {

        this.campanhaRepository = campanhaRepository;
    }

    public Campanha criarCampanha(String id, String nome, double objetivo) {

        Campanha campanha = new Campanha(id, nome, objetivo);

        campanhaRepository.salvar(campanha);

        return campanha;
    }

    public void mudarStatus(String campanhaId, boolean ativa) {

        Campanha campanha = campanhaRepository.buscarPorId(campanhaId);

        if (campanha == null) {
            throw new IllegalArgumentException("Campanha não encontrada");
        }

        if (ativa) {
            campanha.abrirCampanha();
        } else {
            campanha.encerrarCampanha();
        }
    }

    public String visualizarStatus(String campanhaId) {

        Campanha campanha = campanhaRepository.buscarPorId(campanhaId);

        if (campanha == null) {
            throw new IllegalArgumentException("Campanha não encontrada");
        }

        if (campanha.isAtiva()) {
            return "Campanha ativa";
        }

        return "Campanha encerrada";
    }

    public String visualizarMeta(String campanhaId) {

        Campanha campanha = campanhaRepository.buscarPorId(campanhaId);

        if (campanha == null) {
            throw new IllegalArgumentException("Campanha não encontrada");
        }

        if (campanha.bateuMeta()) {
            return "Meta atingida";
        }

        return "Meta não atingida";
    }
}