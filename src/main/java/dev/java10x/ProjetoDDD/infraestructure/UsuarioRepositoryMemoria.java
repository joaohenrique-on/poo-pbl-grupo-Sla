package dev.java10x.ProjetoDDD.infraestructure;

import dev.java10x.ProjetoDDD.domain.Usuario;
import dev.java10x.ProjetoDDD.domain.UsuarioRepository;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRepositoryMemoria
        implements UsuarioRepository {

    private final List<Usuario> usuarios =
            new ArrayList<>();

    @Override
public void salvar(Usuario usuario) {

    Usuario existente = buscarPorId(usuario.getId());

    if (existente != null) {
       usuarios.remove(existente);
    }
   usuarios.add(usuario);
}

    @Override
    public Usuario buscarPorId(String id) {

        for (Usuario usuario : usuarios) {

            if (usuario.getId().equals(id)) {
                return usuario;
            }

        }

        return null;
    }
}
