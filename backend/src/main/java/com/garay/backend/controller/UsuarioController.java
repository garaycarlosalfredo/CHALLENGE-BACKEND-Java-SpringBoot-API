package com.garay.backend.controller;


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

import com.garay.backend.email.SendGridEmailer;
import com.garay.backend.entity.Usuario;
import com.garay.backend.service.UsuarioService;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;

@RestController

@RequestMapping()
public class UsuarioController {
	@Autowired
	UsuarioService usuarioService;
	
	
	@PostMapping("/auth/register")
	public Usuario guardarUsuario(@RequestBody Usuario usuario) {
		return usuarioService.guardarUsuario(usuario);
	}
	
	
/*
	@GetMapping()
	public List<Usuario> obtenerPartes(){		
		return usuarioService.obtenerUsuarios();
	}
	
	@PutMapping()
	public Usuario actualizarUsuario(@RequestBody Usuario usuario) {
		return this.usuarioService.actualizarUsuario(usuario);
	}
	
	@DeleteMapping( path = "/{id}") 
	public String eliminarUsuarioPorId(@PathVariable("id") Integer id) {
		boolean ok = this.usuarioService.eliminarUsuarioPorId(id);
		if(ok) {
			return "Se eliminó correctamente con id = " + id;
		}else {
			return "No se pudo eliminar correctamente con id = " + id;
		}
	}*/
		
}
