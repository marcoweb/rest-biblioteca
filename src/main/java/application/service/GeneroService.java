package application.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import application.model.Genero;
import application.record.GeneroDTO;
import application.repository.GeneroRepository;

@Service
public class GeneroService {
    @Autowired
    private GeneroRepository generoRepo;

    public Iterable<GeneroDTO> fetchAll() {
        return generoRepo.findAll().stream().map(GeneroDTO::new).toList();
    }

    public GeneroDTO fetchById(long id) {
        Optional<Genero> result = generoRepo.findById(id);
        if(result.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Gênero Não Encontrado"
            );
        }
        return new GeneroDTO(result.get());
    }

    public GeneroDTO add(GeneroDTO genero) {
        return new GeneroDTO(generoRepo.save(new Genero(genero)));
    }

    public GeneroDTO update(long id, GeneroDTO genero) {
        Optional<Genero> result = generoRepo.findById(id);
        if(result.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Gênero Não Encontrado"
            );
        }
        result.get().setNome(genero.nome());
        return new GeneroDTO(generoRepo.save(result.get()));
    }

    public void deleteById(long id) {
        if(!generoRepo.existsById(id)) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Gênero Não Encontrado"
            );
        }
        generoRepo.deleteById(id);
    }
}
