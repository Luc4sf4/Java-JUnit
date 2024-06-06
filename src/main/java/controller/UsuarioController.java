package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Usuario;
import service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService service;

	@PostMapping
	public Usuario criarUsuario(@RequestBody Usuario usuario) {
		return service.saveUsuario(usuario);
	}

	@PutMapping("/{id}")
	public Usuario atualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
		return service.atualizarUsuario(id, usuario);
	}

	@DeleteMapping("/{id}")
	public void deletarUsuario(@PathVariable Long id) {
		service.deletarUsuario(id);
	}
	
	@GetMapping
    public List<Usuario> getTodosUsuarios() {
        return service.getTodosUsuarios();
    }
	
	 @GetMapping("/{id}")
	    public Usuario getUsuarioPorId(@PathVariable Long id) {
	        return service.getUsuarioPorId(id);
	    }
}
