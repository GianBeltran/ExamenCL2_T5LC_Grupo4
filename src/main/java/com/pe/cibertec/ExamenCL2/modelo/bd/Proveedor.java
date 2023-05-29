package com.pe.cibertec.ExamenCL2.modelo.bd;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "proveedor")


public class Proveedor {
	
	@Id
	@Column(name ="idProv")
	private Integer	idProv;
	@Column(name = "nombreProv")
	private String nombreProv;
	@Column(name = "direccionProv")
	private String direccionProv;
	@Column(name = "telefonoProv")
	private String telefonoProv;
	@Column(name = "correoProv")
	private String correoProv;
	
}
