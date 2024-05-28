package br.mackenzie.webapp.editora;

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
public class EditoraController {

	@Autowired
	private EditoraRepository editoraRepository;

	@GetMapping("/api/editoras")
	Iterable<Editora> getEditora() {
		return editoraRepository.findAll();
	}
	
	@GetMapping("/api/editoras/{id}")
	Optional<Editora> getEditora(@PathVariable long id) {
		return editoraRepository.findById(id);
	}
	
	@PostMapping("/api/editoras")
	Editora createEditora(@RequestBody Editora e) {
		Editora createdEditora = editoraRepository.save(e);
		return createdEditora;
	}
	
	@PutMapping("/api/editoras/{editoraId}")
	Optional<Editora> updateEditora(@RequestBody Editora editoraReq, @PathVariable long editoraId) {
		Optional<Editora> opt = editoraRepository.findById(editoraId);
		if (opt.isPresent()) {
			if (editoraReq.getId() == editoraId) {
				editoraRepository.save(editoraReq);
				return opt;
			}
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Erro ao alterar dados da editora com id " + editoraId);
	}	
	
	@DeleteMapping("/api/editoras/{id}")
	void deleteEditora(@PathVariable long id) {
		editoraRepository.deleteById(id);
	}	
	
}
