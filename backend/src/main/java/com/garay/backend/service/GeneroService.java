package com.garay.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.garay.backend.entity.Genero;
import com.garay.backend.entity.Peliserie;
import com.garay.backend.repository.GeneroRepository;

@Service
public class GeneroService {
	
	@Autowired
	GeneroRepository generoRepository;

	//[CRUD]
	public List<Genero> obtenerGeneros(){
		return (List<Genero>) generoRepository.findAll();
	}
	
	public Genero agregarGenero(Genero genero) {
		return generoRepository.save(genero);
	}
	
	public Genero modificarGenero(Genero genero) {
		return generoRepository.save(genero);
	}
	
	public boolean eliminarGeneroPorId(Integer id) {
		try {
			generoRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

}
