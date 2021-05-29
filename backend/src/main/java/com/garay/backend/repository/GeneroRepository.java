package com.garay.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.garay.backend.entity.Genero;

@Repository
public interface GeneroRepository extends CrudRepository<Genero, Integer>{
	public abstract Optional<Genero> findById(Integer id);
}
