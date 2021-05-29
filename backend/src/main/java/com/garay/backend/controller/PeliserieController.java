package com.garay.backend.controller;

import java.util.Date;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.garay.backend.entity.Peliserie;
import com.garay.backend.entity.Personaje;
import com.garay.backend.service.PeliserieService;


@RestController
@RequestMapping("/movies")
public class PeliserieController {
	@Autowired
	PeliserieService peliserieService;
	
	/*@GetMapping()
	public List<Peliserie> obtenerTodasPeliseries(){
		return peliserieService.obtenerTodasPeliseries();
	}*/
	
	@GetMapping()
	public List<Peliserie> seleccionarBusqueda(
			@RequestParam(required = false, defaultValue = "") String name,
			@RequestParam(required = false, defaultValue = "-1") Integer genre,
			@RequestParam(required = false, defaultValue = "") String order) {
		
		if(!name.isEmpty()) {return obtenerPeliseriePorTitulo(name);}	
		if(!genre.equals(-1)) {return obtenerPeliseriePorGenero(genre);}	
		if(!order.isEmpty()) {
			if(order.equalsIgnoreCase("asc")){
					return obtenerPeliseriePorFechaAsc();
				}else {
					return obtenerPeliseriePorFechaDesc();
				}

			}
		
		return obtenerTodasPeliseries();
	}
	
	public List<Peliserie> obtenerPeliseriePorTitulo(String titulo) {
		return peliserieService.obtenerPeliseriePorTitulo(titulo);	
	}
		
	public List<Peliserie> obtenerPeliseriePorFechaAsc() {
		return peliserieService.obtenerTodasPeliseriesPorAsc();
	}
	
	public List<Peliserie> obtenerPeliseriePorFechaDesc() {
		return peliserieService.obtenerTodasPeliseriesPorDesc();
	}
	
	public List<Peliserie> obtenerPeliseriePorGenero(Integer genre){
		return peliserieService.obtenerPeliseriePorGenero(genre);
	}
	
	public List<Peliserie> obtenerTodasPeliseries(){
		return peliserieService.obtenerTodasPeliseries();
	}
	
	@PostMapping()
	public Peliserie agregarPeliserie(@RequestBody Peliserie peliserie) {
		return peliserieService.agregarPeliserie(peliserie);
	}
	
	@PutMapping()
	public Peliserie modificarPeliserie(@RequestBody Peliserie peliserie) {
		return peliserieService.agregarPeliserie(peliserie);
	}
	
	@DeleteMapping( path = "/{id}") 
	public String eliminarUsuarioPorId(@PathVariable("id") Integer id) {
		boolean ok = this.peliserieService.eliminarPeliseriePorId(id);
		if(ok) {
			return "Se eliminó correctamente la pelicula / Serie id =" + id;
		}else {
			return "No se pudo eliminar correctamente la pelicula / Serie id =" + id;
		}
	}
	
}
