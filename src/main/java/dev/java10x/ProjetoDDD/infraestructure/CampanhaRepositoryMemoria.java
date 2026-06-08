package dev.java10x.ProjetoDDD.infraestructure;

import dev.java10x.ProjetoDDD.domain.Campanha;
import dev.java10x.ProjetoDDD.domain.CampanhaRepository;
import java.util.ArrayList;
import java.util.List;

public class CampanhaRepositoryMemoria
        implements CampanhaRepository {

    private final List<Campanha> campanhas =
            new ArrayList<>();

    @Override
public void salvar(Campanha campanha) {

    Campanha existente = buscarPorId(campanha.getId());

    if (existente != null) {
        campanhas.remove(existente);
    }

    campanhas.add(campanha);
}

    @Override
    public Campanha buscarPorId(String id) {

        for (Campanha campanha : campanhas) {

            if (campanha.getId().equals(id)) {
                return campanha;
            }

        }

        return null;
    }
}