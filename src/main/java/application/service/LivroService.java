package application.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import application.model.Genero;
import application.model.Livro;
import application.record.LivroDTO;
import application.repository.LivroRepository;

@Service
public class LivroService {
    @Autowired
    private LivroRepository livroRepo;

    public Iterable<LivroDTO> fetchAll() {
        return livroRepo.findAll().stream().map(LivroDTO::new).toList();
    }

    public LivroDTO add(LivroDTO livro) {
        return new LivroDTO(livroRepo.save(new Livro(livro)));
    }

    public LivroDTO update(long id, LivroDTO livro) {
        Optional<Livro> result = livroRepo.findById(id);
        if(result.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Livro Não Encontrado"
            );
        }
        result.get().setTitulo(livro.titulo());
        result.get().setGenero(new Genero(livro.genero()));
        return new LivroDTO(livroRepo.save(result.get()));
    }

    public void deleteById(long id) {
        if(!livroRepo.existsById(id)) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Livro Não Encontrado"
            );
        }
        livroRepo.deleteById(id);
    }
}
