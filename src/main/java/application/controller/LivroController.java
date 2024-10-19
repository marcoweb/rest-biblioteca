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

import application.record.LivroDTO;
import application.service.LivroService;

@RestController
@RequestMapping("/livros")
public class LivroController {
    @Autowired
    private LivroService livroSrv;

    @GetMapping
    public Iterable<LivroDTO> getAll() {
        return livroSrv.fetchAll();
    }

    @PostMapping
    public LivroDTO insert(@RequestBody LivroDTO livro) {
        return livroSrv.add(livro);
    }

    @PutMapping("/{id}")
    public LivroDTO update(@PathVariable long id, @RequestBody LivroDTO livro) {
        return livroSrv.update(id, livro);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        livroSrv.deleteById(id);
    }
}
