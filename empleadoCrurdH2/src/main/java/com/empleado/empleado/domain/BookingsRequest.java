package com.empleado.empleado.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookingsRequest {
	private String adminemail;
	private String email;
	private boolean current;
	private String token;
	private String app;

}
