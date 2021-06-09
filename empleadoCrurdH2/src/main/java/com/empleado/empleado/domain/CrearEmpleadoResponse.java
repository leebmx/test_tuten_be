package com.empleado.empleado.domain;

import java.io.Serializable;

import com.empleado.empleado.dto.EmpleadoDto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CrearEmpleadoResponse implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1447609641024040334L;
	
	@ApiModelProperty(notes = "Objeto de mensajeria personalizable")
	private MensajeriaOp mensajeriaOp;
	
	@ApiModelProperty(notes = "Datos del Empleado")
	private EmpleadoDto empleadoDto;

}
