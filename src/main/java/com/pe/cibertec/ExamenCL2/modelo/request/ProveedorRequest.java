package com.pe.cibertec.ExamenCL2.modelo.request;

import lombok.Data;

@Data
public class ProveedorRequest {
	private Integer idProv;
	private String nombreProv;
	private String direccionProv;
	private String telefono;
	private String correoProv;
}	
