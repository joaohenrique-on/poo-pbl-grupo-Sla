package dev.java10x.ProjetoDDD.application;

import dev.java10x.ProjetoDDD.domain.*;

public class DoacaoApplication {

    private final UsuarioRepository usuarioRepository;
    private final CampanhaRepository campanhaRepository;

    public DoacaoApplication(UsuarioRepository usuarioRepository, CampanhaRepository campanhaRepository) {

        this.usuarioRepository = usuarioRepository;
        this.campanhaRepository = campanhaRepository;
    }

    public Doacao realizarDoacao(String usuarioId, String campanhaId, double valor) {

        Usuario usuario = usuarioRepository.buscarPorId(usuarioId);

        if (usuario == null) {  
             throw new IllegalArgumentException("Usuário não encontrado");
        }

        Campanha campanha = campanhaRepository.buscarPorId(campanhaId);

        if (campanha == null) {
            throw new IllegalArgumentException("Campanha não encontrada");
        }

        return usuario.realizarDoacao(campanha, valor);
    }

    public String reivindicarRecompensa(Recompensa recompensa, double valorDoado) {

        if (recompensa.verificar(valorDoado)) {

            return "Recompensa liberada: " + recompensa.getNome();
        }

        return "Valor insuficiente para receber " + recompensa.getNome();
    }
}