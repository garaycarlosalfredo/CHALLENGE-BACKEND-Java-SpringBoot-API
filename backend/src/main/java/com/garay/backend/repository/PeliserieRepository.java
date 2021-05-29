package com.garay.backend.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.garay.backend.entity.Peliserie;

@Repository
public interface PeliserieRepository extends CrudRepository<Peliserie, Integer>{
	public abstract List<Peliserie> findAll();
	//Buscquedas nombre, ordenados por fecha
	public abstract List<Peliserie> findAllByOrderByFechaAsc();
	public abstract List<Peliserie> findAllByOrderByFechaDesc();
	public abstract List<Peliserie> findByTitulo(String titulo);
	public abstract List<Peliserie> findByGeneroId(Integer id);
}
