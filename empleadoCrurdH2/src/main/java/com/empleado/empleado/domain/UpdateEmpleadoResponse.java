package com.empleado.empleado.domain;

import java.io.Serializable;

import com.empleado.empleado.dto.EmpleadoDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateEmpleadoResponse implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7254572213838962150L;
	private MensajeriaOp mensajeriaOp;
	private EmpleadoDto empleadoDto;

}
