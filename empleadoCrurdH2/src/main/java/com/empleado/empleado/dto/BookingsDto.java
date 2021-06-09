package com.empleado.empleado.dto;

import com.empleado.empleado.dto.TutenUser1;
import com.empleado.empleado.dto.TutenUserProfessional;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookingsDto {
	
//	private String bookingFields;
//	private String bookingChecklistData;
//	private String bookingDurationTime;
//	private String recurrentWeeks;
	
	private String bookingId;
	private TutenUserProfessional tutenUserProfessional;
	private String bookingTime;
	private String bookingPrice;
}
