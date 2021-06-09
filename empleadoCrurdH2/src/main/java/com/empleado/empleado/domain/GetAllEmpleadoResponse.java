package com.empleado.empleado.domain;

import java.io.Serializable;
import java.util.List;

import com.empleado.empleado.dto.EmpleadoDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetAllEmpleadoResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5699837087139896684L;
	private MensajeriaOp mensajeriaOp;
	private List<EmpleadoDto> empleadoList;
}
