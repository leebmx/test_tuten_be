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
public class GetIdEmpleadoRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7412800347073150057L;
	private long id;
}
