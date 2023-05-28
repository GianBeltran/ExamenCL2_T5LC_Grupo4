package com.pe.cibertec.ExamenCL2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pe.cibertec.ExamenCL2.modelo.Categoria;
import com.pe.cibertec.ExamenCL2.repository.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public List<Categoria> listarCategorias(){
		return categoriaRepository.findAll();
	}
	
	public void registrarCategoria(Categoria categoria) {
		categoriaRepository.save(categoria);
	}

}
