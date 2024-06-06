package service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Usuario;
import repository.UsuarioRepository;

@Service
public class UsuarioService {

	 @Autowired
	    private UsuarioRepository usuarioRepository;

	 //method to save the user
	    public Usuario saveUsuario(Usuario usuario) {
	        return usuarioRepository.save(usuario);
	    }
	
	    //update the user
	    public Usuario atualizarUsuario(Long id, Usuario usuario) {
	        Optional<Usuario> usuarioExistente = usuarioRepository.findById(id);
	        
	        //isPresent == return true if the Optional has any value
	        
	            if (usuarioExistente.isPresent()) {
	            Usuario user = usuarioExistente.get();
	            user.setNome(usuario.getNome());
	            user.setSobreNome(usuario.getSobreNome());
	            return usuarioRepository.save(user);
	        }
	        return null;
	    }
	    

	    public void deletarUsuario(Long id) {
	        usuarioRepository.deleteById(id);
	    }

	    public List<Usuario> getTodosUsuarios() {
	        return usuarioRepository.findAll();
	    }

	    public Usuario getUsuarioPorId(Long id) {
	        return usuarioRepository.findById(id).orElse(null);
	    }
}
