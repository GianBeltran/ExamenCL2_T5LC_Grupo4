package com.pe.cibertec.ExamenCL2.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name ="cliente")

public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCliente;
	@Column(name = "nombreCliente")
	private String nombreCliente;
	@Column(name = "direccionCliente")
	private String direccionCliente;
	@Column(name = "telefonoCliente")
	private String telefonoCliente;	
	@Column(name = "correoCliente")
	private String correoCliente;
}
