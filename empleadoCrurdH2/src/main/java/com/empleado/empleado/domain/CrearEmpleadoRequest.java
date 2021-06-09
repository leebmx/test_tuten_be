package com.empleado.empleado.domain;

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
public class CrearEmpleadoRequest {

	@ApiModelProperty(notes = "Objeto de entrada con los datos del Empleado a registrar")
	private EmpleadoDto empleadoDto;
}
