package application.model;

import application.record.LivroDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "livros")
@Getter
@Setter
@NoArgsConstructor
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String titulo;
    @ManyToOne
    @JoinColumn(name = "id_genero")
    private Genero genero;

    public Livro(LivroDTO livro) {
        this.id = livro.id();
        this.titulo = livro.titulo();
        this.genero = new Genero(livro.genero());
    }
}
