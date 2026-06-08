package dev.java10x.ProjetoDDD.domain;

public interface UsuarioRepository {

    void salvar(Usuario usuario);

    Usuario buscarPorId(String id);

}

