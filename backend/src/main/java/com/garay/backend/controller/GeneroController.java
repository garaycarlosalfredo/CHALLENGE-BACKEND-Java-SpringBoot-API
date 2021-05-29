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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.garay.backend.entity.Genero;
import com.garay.backend.entity.Peliserie;
import com.garay.backend.service.GeneroService;
import com.garay.backend.service.PeliserieService;

@RestController
@RequestMapping("/genero")
public class GeneroController {
	@Autowired
	GeneroService generoService;

	
	@GetMapping()
	public List<Genero> obtenerGeneros(){
		return generoService.obtenerGeneros();
		}
	
	@PostMapping()
	public Genero agregarPeliserie(@RequestBody Genero genero) {
		return generoService.agregarGenero(genero);
	}
	
	@PutMapping()
	public Genero modificarPeliserie(@RequestBody Genero genero) {
		return generoService.agregarGenero(genero);
	}
	
	@DeleteMapping( path = "/{id}") 
	public String eliminarUsuarioPorId(@PathVariable("id") Integer id) {
		boolean ok = this.generoService.eliminarGeneroPorId(id);
		if(ok) {
			return "Se eliminó correctamente la pelicula / Serie id =" + id;
		}else {
			return "No se pudo eliminar correctamente la pelicula / Serie id =" + id;
		}
	}
}
