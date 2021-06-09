package com.empleado.empleado.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TutenUserProfessional {
	
	private TutenUser1 tutenUser1;
	private String streetAddress;

}
