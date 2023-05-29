package com.pe.cibertec.ExamenCL2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.pe.cibertec.ExamenCL2.modelo.bd.Proveedor;
import com.pe.cibertec.ExamenCL2.repository.ProveedorRepository;



public class ProveedorService {
	
	@Autowired
	private ProveedorRepository proveedorRepository;
	
	public List<Proveedor> listarProveedor(){
		return proveedorRepository.findAll();
	}
	
	public void registrarProveedor(Proveedor proveedor) {
		proveedorRepository.save(proveedor);
	}	
	
	public void eliminarProveedor(Integer idProv) {
		proveedorRepository.deleteById(idProv);
	}
	
}
