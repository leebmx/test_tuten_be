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
public class UpdateEmpleadoRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6191246841001879420L;
	private EmpleadoDto empleadoDto;
}
