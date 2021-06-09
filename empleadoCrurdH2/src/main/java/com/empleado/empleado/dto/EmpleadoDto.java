package com.empleado.empleado.dto;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * To string.
 *
 * @return the java.lang. string
 */
@Data

/**
 * Instantiates a new empleado dto.
 */
@NoArgsConstructor

/**
 * Instantiates a new empleado dto.
 *
 * @param id the id
 * @param rut the rut
 * @param nombre the nombre
 * @param apellidoPaterno the apellido paterno
 * @param apellidoMaterno the apellido materno
 * @param correo the correo
 * @param fechaIncorporacion the fecha incorporacion
 */
@AllArgsConstructor

/**
 * To string.
 *
 * @return the java.lang. string
 */
@Builder
public class EmpleadoDto {
	
	/** The id. */
	@ApiModelProperty(notes = "id generado poe la base de datos")
	private Long id;
	
	/** The rut. */
	@ApiModelProperty(notes = "Rut de empleado sin fotmato")
	private String rut;
	
	/** The nombre. */
	@ApiModelProperty(notes = "Nombre del empleado")
	private String nombre;
	
	/** The apellido paterno. */
	@ApiModelProperty(notes = "Apellido paterno del empleado")
	private String apellidoPaterno;
	
	/** The apellido materno. */
	@ApiModelProperty(notes = "Apellido materno del empleado")
	private String apellidoMaterno;
	
	/** The correo. */
	@ApiModelProperty(notes = "Correo del empleado")
	private String correo;
	
	/** The fecha incorporacion. */
	@ApiModelProperty(notes = "fecha de incorporacion del empleado")
	private Date fechaIncorporacion;
}
