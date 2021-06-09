package com.empleado.empleado.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MensajeriaOp {
	/** The cod. */
	@ApiModelProperty(notes = "Codigo de eror ej.: 200, 204, 400, 401, 403, 404, 412, 500, 503")
	private String cod;

	/** The msj. */
	@ApiModelProperty(notes = "Mensaje de error especificado en el manejo de excepciones")
	private String msj;

	/** The msj. */
	@ApiModelProperty(notes = "Detalle del mensaje de error ej.: Parametro obligatorio no informado")
	private String detalle;
}
