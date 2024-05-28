package br.mackenzie.webapp.autor;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


@RestController
public class AutorController {

  @Autowired
  private AutorRepository autorRepository;

  @GetMapping("/api/autores")
  Iterable<Autor> getAutor() {
    return autorRepository.findAll();
  }

  @GetMapping("/api/autores/{id}")
  Optional<Autor> getAutor(@PathVariable long id) {
    return autorRepository.findById(id);
  }

  @PostMapping("/api/autores")
  Autor createAutor(@RequestBody Autor a) {
    Autor createdAutor = autorRepository.save(a);
    return createdAutor;
  }

  @PutMapping("/api/autores/{autorId}")
  Optional<Autor> updateAutor(@RequestBody Autor autorReq, @PathVariable long autorId) {
    Optional<Autor> opt = autorRepository.findById(autorId);
    if (opt.isPresent()) {
      if (autorReq.getId() == autorId) {
        autorRepository.save(autorReq);
        return opt;
      }
    }
    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Erro ao alterar dados do autor com id " + autorId);
  }	

  @DeleteMapping("/api/autores/{id}")
  void deleteAutor(@PathVariable long id) {
    autorRepository.deleteById(id);
  }	

}
