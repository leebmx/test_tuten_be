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
public class DeleteEmpleadoRequest implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4657748113704633480L;
	private Long Id;

}
