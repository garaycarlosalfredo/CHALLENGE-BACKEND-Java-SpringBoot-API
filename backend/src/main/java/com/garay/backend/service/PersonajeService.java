package com.garay.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.garay.backend.entity.Personaje;
import com.garay.backend.repository.PersonajeRepository;

@Service
public class PersonajeService {
	@Autowired
	PersonajeRepository personajeRepository;
	
	public List<Personaje> obtenerTodosPersonajes(){
		return (List<Personaje>) personajeRepository.findAll();
	}
	//======================BUSQUEDAS===================================
	//[BUSCAR POR NOMBRE]
	public List<Personaje> obtenerPersonajePorNombre(String nombre) {
		return personajeRepository.findByNombre(nombre);
	}
	
	//[BUSCAR POR EDAD]
	public List<Personaje> obtenerPersonajePorEdad(Integer edad) {
		return personajeRepository.findByEdad(edad);
	}
	
	//[BUSCAR POR ID PELICULA]
	public List<Personaje> obtenerPersonajePorPelicula(Integer id) {
		return personajeRepository.findByPeliAsociadoId(id);
	}
	//======================AGREGAR===================================
	public Personaje agregarPersonaje(Personaje personaje) {
		return personajeRepository.save(personaje);
	}
	//======================MODIFICAR===================================	
	public Personaje modificarPersonaje(Personaje personaje) {
		return personajeRepository.save(personaje);
	}
	
	//======================BORRAR===================================	
	public boolean eliminarPersonajePorId(Integer id) {
		try {
			personajeRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
}
