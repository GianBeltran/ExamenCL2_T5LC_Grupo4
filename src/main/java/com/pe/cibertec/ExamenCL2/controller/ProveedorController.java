package com.pe.cibertec.ExamenCL2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pe.cibertec.ExamenCL2.modelo.bd.Proveedor;
import com.pe.cibertec.ExamenCL2.modelo.request.ProveedorRequest;
import com.pe.cibertec.ExamenCL2.modelo.response.ResultadoResponse;
import com.pe.cibertec.ExamenCL2.service.ProveedorService;

@Controller
@RequestMapping("/Proveedor")
public class ProveedorController {

	@Autowired
	private ProveedorService proveedorService;
	
	@GetMapping("/frmMantProveedor")
	public String frmMantProveedor(Model model) {
		model.addAttribute("listarProveedor",
			proveedorService.listarProveedor());
		return "Proveedor/frmMantProveedor";
	}

	
	@PostMapping("/frmRegProveedor")
	@ResponseBody
	public ResultadoResponse registrarProveedor(@RequestBody
			ProveedorRequest proveedorRequest) {
		String mensaje = "Proveedor registrado correctamente";
		Boolean respuesta = true;
		try {					
			Proveedor objProveedor = new Proveedor();
			if(proveedorRequest.getIdProv()>0) {
				objProveedor.setIdProv(proveedorRequest.getIdProv());
			}
			objProveedor.setNombreProv(proveedorRequest.getNombreProv());
			objProveedor.setDireccionProv(proveedorRequest.getDireccionProv());
			objProveedor.setTelefonoProv(proveedorRequest.getTelefono());
			objProveedor.setCorreoProv(proveedorRequest.getCorreoProv());
		}catch(Exception e){
			mensaje = "Proveedor no registrado";
			respuesta = false;
		}
		return ResultadoResponse.builder().
				mensaje(mensaje)
				.respuesta(respuesta)
				.build();
	}
	
	
	@PostMapping("/actualizarProveedor")
	@ResponseBody
	public ResultadoResponse actualizarProveedor(@RequestBody ProveedorRequest proveedorRequest) {
	    String mensaje = "Proveedor actualizada correctamente";
	    Boolean respuesta = true;
	    try {
	        Proveedor objProveedor = new Proveedor();
	        objProveedor.setIdProv(proveedorRequest.getIdProv());
	        objProveedor.setNombreProv(proveedorRequest.getNombreProv());
	        objProveedor.setDireccionProv(proveedorRequest.getDireccionProv());
	        objProveedor.setTelefonoProv(proveedorRequest.getTelefono());
	        objProveedor.setCorreoProv(proveedorRequest.getCorreoProv());
	        proveedorService.registrarProveedor(objProveedor);
	    } catch (Exception e) {
	        mensaje = "Error al actualizar la proveedor";
	        respuesta = false;
	    }
	    return ResultadoResponse.builder()
	            .mensaje(mensaje)
	            .respuesta(respuesta)
	            .build();
	}
	
	
	@DeleteMapping("/eliminarProveedor")
	@ResponseBody
	public ResultadoResponse eliminarProveedor(@RequestBody ProveedorRequest proveedorRequest) {
		String mensaje = "Proveedor eliminado correctamente";
		Boolean respuesta = true;
		try {
			proveedorService.eliminarProveedor(proveedorRequest.getIdProv());
		} catch (Exception e) {
			mensaje = "Proveedor no eliminado";
			respuesta = false;
		}
		return ResultadoResponse.builder()
								.mensaje(mensaje)
								.respuesta(respuesta)
								.build();
	}
	

	@GetMapping("/listarProveedor")
	@ResponseBody
	public List<Proveedor> listarProveedor(){
		return proveedorService.listarProveedor();
	}
	

	
}
