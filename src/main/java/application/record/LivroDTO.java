package application.record;

import application.model.Livro;

public record LivroDTO(long id, String titulo, GeneroDTO genero) {
    public LivroDTO(Livro livro) {
        this(livro.getId(), livro.getTitulo(), new GeneroDTO(livro.getGenero()));
    }
}
