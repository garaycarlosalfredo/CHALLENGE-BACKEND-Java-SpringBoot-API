package com.garay.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.garay.backend.entity.Personaje;

@Repository
public interface PersonajeRepository extends CrudRepository<Personaje, Integer>{
	public abstract Optional<Personaje> findAll(Integer id);
	//Buscquedas nombre, edad
	public abstract List<Personaje> findByNombre(String nombre);
	public abstract List<Personaje> findByEdad(Integer edad);
	public abstract List<Personaje> findByPeliAsociadoId(Integer id);
}
