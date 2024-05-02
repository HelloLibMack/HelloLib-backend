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
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@GetMapping("/api/usuario")
	Iterable<Usuario> getUsuario() {
		return usuarioRepository.findAll();
	}
	
	@GetMapping("/api/usuario/{id}")
	Optional<Usuario> getUsuario(@PathVariable long id) {
		return usuarioRepository.findById(id);
	}
	
	@PostMapping("/api/usuario")
	Usuario createUsuario(@RequestBody Usuario u) {
		Usuario createdUsuario = usuarioRepository.save(u);
		return createdUsuario;
	}
	
	@PutMapping("/api/usuario/{usuarioId}")
	Optional<Usuario> updateUsuario(@RequestBody Usuario usuarioReq, @PathVariable long usuarioId) {
		Optional<Usuario> opt = usuarioRepository.findById(usuarioId);
		if (opt.isPresent()) {
			if (usuarioReq.getId() == usuarioId) {
				usuarioRepository.save(usuarioReq);
				return opt;
			}
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Erro ao alterar dados do usuario com id " + usuarioId);
	}	
	
	@DeleteMapping("/api/usuario/{id}")
	void deleteUsuario(@PathVariable long id) {
		usuarioRepository.deleteById(id);
	}	
	
}