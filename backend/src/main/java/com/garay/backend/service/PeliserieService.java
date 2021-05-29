package com.garay.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.garay.backend.entity.Peliserie;
import com.garay.backend.entity.Personaje;
import com.garay.backend.repository.PeliserieRepository;

@Service
public class PeliserieService {
	@Autowired
	PeliserieRepository peliserieRepository;
	
	

	
	//[BUSQUEDAS]
	//Todo
	public List<Peliserie> obtenerTodasPeliseries() {
		return peliserieRepository.findAll();
	}
	//ASC
	public List<Peliserie> obtenerTodasPeliseriesPorAsc() {
		return peliserieRepository.findAllByOrderByFechaAsc();
	}
	
	//Desc
	public List<Peliserie> obtenerTodasPeliseriesPorDesc() {
		return peliserieRepository.findAllByOrderByFechaDesc();
	}	
	
	//Por genero
	public List<Peliserie> obtenerPeliseriePorGenero(Integer id){
		return peliserieRepository.findByGeneroId(id);
	}
	
	//Por Titulo
	public List<Peliserie> obtenerPeliseriePorTitulo(String titulo) {
		return peliserieRepository.findByTitulo(titulo);
	}
	
	//[CRUD]
	public Peliserie agregarPeliserie(Peliserie peliserie) {
		return peliserieRepository.save(peliserie);
	}
	
	public Peliserie modificarPeliserie(Peliserie peliserie) {
		return peliserieRepository.save(peliserie);
	}
	
	public boolean eliminarPeliseriePorId(Integer id) {
		try {
			peliserieRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
}
