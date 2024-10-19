package application.record;

import application.model.Genero;

public record GeneroDTO(long id, String nome) {
    public GeneroDTO(Genero genero) {
        this(genero.getId(), genero.getNome());
    }
}