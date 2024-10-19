package application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import application.record.GeneroDTO;
import application.service.GeneroService;

@RestController
@RequestMapping("/generos")
public class GeneroController {
    @Autowired
    private GeneroService generoSrv;

    @GetMapping
    public Iterable<GeneroDTO> getAll() {
        return generoSrv.fetchAll();
    }

    @GetMapping("/{id}")
    public GeneroDTO getOne(@PathVariable long id) {
        return generoSrv.fetchById(id);
    }

    @PostMapping
    public GeneroDTO insert(@RequestBody GeneroDTO genero) {
        return generoSrv.add(genero);
    }

    @PutMapping("/{id}")
    public GeneroDTO update(@RequestBody GeneroDTO genero, @PathVariable long id) {
        return generoSrv.update(id, genero);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        generoSrv.deleteById(id);
    }
}
