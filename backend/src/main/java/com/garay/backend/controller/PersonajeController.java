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

import com.garay.backend.entity.Personaje;
import com.garay.backend.service.PersonajeService;

@RestController
@RequestMapping("/characters")
public class PersonajeController {
	@Autowired
	PersonajeService personajeService;
	
	
	@GetMapping()
	public List<Personaje> seleccionarBusqueda(
			@RequestParam(required = false, defaultValue = "") String name,
			@RequestParam(required = false, defaultValue = "-99") Integer edad,
			@RequestParam(required = false, defaultValue = "-99") Integer idMovie) {
		
		if(!name.isEmpty()) {return obtenerPersonajePorNombre(name);}		
		if(edad!= -99) 		{return obtenerPersonajePorEdad(edad);}	
		if(idMovie!= -99) 		{return obtenerPersonajePorPelicula(idMovie);}
		
		return obtenerTodosPersonajes();
	}
	
	public List<Personaje> obtenerPersonajePorPelicula(Integer id) {
		return personajeService.obtenerPersonajePorPelicula(id);	
	}
	
	
	public List<Personaje> obtenerPersonajePorEdad(Integer edad) {
		return personajeService.obtenerPersonajePorEdad(edad);	
	}
	
	public List<Personaje> obtenerPersonajePorNombre(String name) {
		return personajeService.obtenerPersonajePorNombre(name);	
	}
	
	public List<Personaje> obtenerTodosPersonajes() {
		return personajeService.obtenerTodosPersonajes();
	}
	
	
	@PostMapping()
	public Personaje agregarPersonaje(@RequestBody Personaje personaje) {
		return personajeService.agregarPersonaje(personaje);
	}
	
	@PutMapping()
	public Personaje modificarPersonaje(@RequestBody Personaje personaje) {
		return personajeService.modificarPersonaje(personaje);
	}
	
	@DeleteMapping( path = "/{id}") 
	public String eliminarUsuarioPorId(@PathVariable("id") Integer id) {
		boolean ok = this.personajeService.eliminarPersonajePorId(id);
		if(ok) {
			return "Se eliminó correctamente el personaje id =" + id;
		}else {
			return "No se pudo eliminar correctamente con id = " + id;
		}
	}
	
/*
	//Lista resumida de los personajes
	//@GetMapping()
	public List<PersonajeListado> obtenerTodosPersonajes() {
		List<PersonajeListado> listaResumen;
		List<Personaje> listaDePersonajes = personajeService.obtenerTodosPersonajes();
		
		listaResumen = listaDePersonajes.stream().map(
				personaje -> {
					
	        return new PersonajeListado(
	        		personaje.getImagen(),
	        		personaje.getNombre());
	        
	    }).collect(Collectors.toList());
		
		return listaResumen;
	}

*/
}
