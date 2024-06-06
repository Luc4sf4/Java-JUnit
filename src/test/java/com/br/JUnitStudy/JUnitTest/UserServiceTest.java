package com.br.JUnitStudy.JUnitTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import model.Usuario;
import repository.UsuarioRepository;
import service.UsuarioService;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

	@InjectMocks
	private UsuarioService usuarioService;

	@Mock
	private UsuarioRepository usuarioRepository;

	private Usuario usuario;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);

		usuario = new Usuario();
		usuario.setNome("Nome Teste");
		usuario.setSobreNome("Sobrenome Teste");
		usuarioRepository.save(usuario);
	}

	@Test
	public void testSaveUser() {
		 Usuario novoUsuario = new Usuario();
	        novoUsuario.setNome("Novo Nome");
	        novoUsuario.setSobreNome("Novo Sobrenome");

	        when(usuarioRepository.save(novoUsuario)).thenReturn(novoUsuario);

	        Usuario criado = usuarioService.saveUsuario(novoUsuario);
	        assertNotNull(criado);
	        assertEquals("Novo Nome", criado.getNome());
	        assertEquals("Novo Sobrenome", criado.getSobreNome());
	}

}
