package ps2.restapidb;

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
public class LivroController {

	@Autowired
	private LivroRepository livroRepository;

	@GetMapping("/api/livro")
	Iterable<Livro> getLivro() {
		return livroRepository.findAll();
	}
	
	@GetMapping("/api/livro/{id}")
	Optional<Livro> getLivro(@PathVariable long id) {
		return livroRepository.findById(id);
	}
	
	@PostMapping("/api/livro")
	Livro createLivro(@RequestBody Livro l) {
		Livro createdLivro = livroRepository.save(l);
		return createdLivro;
	}
	
	@PutMapping("/api/livro/{livroId}")
	Optional<Livro> updateLivro(@RequestBody Livro livroReq, @PathVariable long livroId) {
		Optional<Livro> opt = livroRepository.findById(livroId);
		if (opt.isPresent()) {
			if (livroReq.getId() == livroId) {
				livroRepository.save(livroReq);
				return opt;
			}
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Erro ao alterar dados do livro com id " + livroId);
	}	
	
	@DeleteMapping("/api/livro/{id}")
	void deleteLivro(@PathVariable long id) {
		livroRepository.deleteById(id);
	}	
	
}