package com.pe.cibertec.ExamenCL2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pe.cibertec.ExamenCL2.modelo.Cliente;
import com.pe.cibertec.ExamenCL2.repository.ClienteRepository;


@Service
public class ClienteService {

	@Autowired
	private ClienteRepository ClienteRepository;
	
	public List<Cliente> listarCliente(){
		return ClienteRepository.findAll();
	}
	
	public void registrarCliente(Cliente cliente) {
		ClienteRepository.save(cliente);
	}
	
	public void eliminarCliente(Integer idCliente) {
		ClienteRepository.deleteById(idCliente);
	}
}
