package dev.java10x.ProjetoDDD.application;

import dev.java10x.ProjetoDDD.domain.*;
import dev.java10x.ProjetoDDD.infrastructure.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoacaoApplicationServiceTest {

    @Test
    void deveRealizarDoacao() {

        UsuarioRepositoryMemoria usuarioRepo = new UsuarioRepositoryMemoria();

        CampanhaRepositoryMemoria campanhaRepo = new CampanhaRepositoryMemoria();

        Usuario usuario = new Usuario("1", "Joao");

        Campanha campanha = new Campanha("10", "Animais", 1000);

        usuarioRepo.salvar(usuario);
        campanhaRepo.salvar(campanha);

        DoacaoApplication service = new DoacaoApplication(usuarioRepo, campanhaRepo);

        Doacao doacao = service.realizarDoacao("1", "10", 100);

        assertNotNull(doacao);

        assertEquals(100, campanha.getTotalRecebido());
    }

    @Test
    void deveLiberarRecompensa() {

        Recompensa recompensa = new Recompensa("1", "Camiseta", 100);

        DoacaoApplication service = new DoacaoApplication(null, null);

        String resultado = service.reivindicarRecompensa(recompensa, 150);

        assertEquals("Recompensa liberada: Camiseta", resultado);
    }
}