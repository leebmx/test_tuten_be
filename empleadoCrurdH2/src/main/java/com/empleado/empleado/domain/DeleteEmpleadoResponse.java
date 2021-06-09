package com.empleado.empleado.domain;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeleteEmpleadoResponse implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5999011867207216564L;
	private MensajeriaOp mensajeriaOp;

}
