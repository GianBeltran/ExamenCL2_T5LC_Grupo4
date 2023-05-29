package com.pe.cibertec.ExamenCL2.modelo.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResultadoResponse {
	private Boolean respuesta;
	private String mensaje;
}
