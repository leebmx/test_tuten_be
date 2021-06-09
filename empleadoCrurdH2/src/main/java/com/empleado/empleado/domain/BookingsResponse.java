package com.empleado.empleado.domain;

import java.util.List;

import com.empleado.empleado.dto.BookingsDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookingsResponse {
	private List<BookingsDto> list;
}
