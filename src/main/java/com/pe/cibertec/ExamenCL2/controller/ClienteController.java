package com.pe.cibertec.ExamenCL2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pe.cibertec.ExamenCL2.modelo.Cliente;
import com.pe.cibertec.ExamenCL2.service.ClienteService;
import com.pe.cibertec.ExamenCL2.modelo.request.ClienteRequest;
import com.pe.cibertec.ExamenCL2.modelo.response.ResultadoResponse;



public class ClienteController {
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/frmCliente")
	@ResponseBody
	public String frmMantCliente(Model model) {
		model.addAttribute("listacliente", clienteService.listarCliente());
		return "cliente/frmcliente";
	}
	
	@PostMapping("/registrarCliente")
	@ResponseBody
	public ResultadoResponse registrarCliente(@RequestBody ClienteRequest clienteRequest) {
		String mensaje ="Cliente registrado correctamente";
		Boolean respuesta = true;
		try {			

			Cliente objCliente = new Cliente();
			if(clienteRequest.getidCliente() > 0) {
				objCliente.setidCliente(clienteRequest.getidCliente());
			}
			objCliente.setnombreCliente(clienteRequest.getnombreCliente());
			objCliente.setdireccionCliente(clienteRequest.getdireccionCliente());
			objCliente.settelefonoCliente(clienteRequest.gettelefonoCliente());
			objCliente.setcorreoCliente(clienteRequest.getcorreoCliente());

			ClienteService.registrarCliente(objCliente);
		}catch(Exception ex) {
			mensaje = "Cliente no registrado";
			respuesta = false;
		}
		return ResultadoResponse.builder()
				.mensaje(mensaje)
				.respuesta(respuesta)
				.build();
	}
	
	@PostMapping("/actualizarCliente")
	@ResponseBody
	public ResultadoResponse actualizarCliente(@RequestBody ClienteRequest clienteRequest) {
	    String mensaje = "Cliente actualizado correctamente";
	    Boolean respuesta = true;
	    try {
	        Cliente objCliente = new Cliente();
	        objCliente.setidCliente(ClienteRequest.getidCliente());
	        objCliente.setnombreCliente(clienteRequest.getnombreCliente());
			objCliente.setdireccionCliente(clienteRequest.getdireccionCliente());
			objCliente.settelefonoCliente(clienteRequest.gettelefonoCliente());
			objCliente.setcorreoCliente(clienteRequest.getcorreoCliente());
	        clienteService.registrarCliente(objCliente);
	    } catch (Exception e) {
	        mensaje = "Error al actualizar el cliente";
	        respuesta = false;
	    }
	    return ResultadoResponse.builder()
	            .mensaje(mensaje)
	            .respuesta(respuesta)
	            .build();
	}
	
	@DeleteMapping("/eliminarCliente")
	@ResponseBody
	public ResultadoResponse eliminarCliente(@RequestBody
			ClienteRequest clienteRequest) {
		String mensaje = "Cliente eliminado correctamente";
		Boolean respuesta = true;
		try {
			clienteService.eliminarCliente(clienteRequest.getidCliente());
		}catch (Exception e) {
			mensaje = "Cliente no eliminado";
			respuesta = false;
		}
		return ResultadoResponse.builder()
				.mensaje(mensaje)
				.respuesta(respuesta)
				.build();
	}
	@GetMapping("/listarCliente")
	@ResponseBody
	public List<Cliente> listarCliente(){
		return clienteService.listarCliente();
	}

}
