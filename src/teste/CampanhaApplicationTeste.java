package dev.java10x.ProjetoDDD.application;

import dev.java10x.ProjetoDDD.domain.Campanha;
import dev.java10x.ProjetoDDD.infrastructure.CampanhaRepositoryMemoria;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CampanhaApplicationTeste {

    @Test
    void deveCriarCampanha() {

        CampanhaRepositoryMemoria repository = new CampanhaRepositoryMemoria();

        CampanhaApplication service = new CampanhaApplication(repository);

        Campanha campanha = service.criarCampanha("1", "Teste", 1000);

        assertNotNull(campanha);
    }

    @Test
    void deveAlterarStatus() {

        CampanhaRepositoryMemoria repository = new CampanhaRepositoryMemoria();

        Campanha campanha = new Campanha("1", "Teste", 1000);

        repository.salvar(campanha);

        CampanhaApplication service = new CampanhaApplication(repository);

        service.mudarStatus("1", false);

        assertFalse(campanha.isAtiva());
    }
}