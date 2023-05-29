package com.pe.cibertec.ExamenCL2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pe.cibertec.ExamenCL2.modelo.bd.Ubicacion;
import com.pe.cibertec.ExamenCL2.repository.UbicacionRepository;

@Service
public class UbicacionService {
	@Autowired
	private UbicacionRepository ubicacionRepository;
	
	public List<Ubicacion> listarUbicaciones(){
		return ubicacionRepository.findAll();
	}
	public void registrarUbicacion(Ubicacion ubicacion) {
		ubicacionRepository.save(ubicacion);
	}
	public void eliminarUbicacion(Integer idubi) {
		ubicacionRepository.deleteById(idubi);
	}
}
