package com.empleado.empleado.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.empleado.empleado.domain.CrearEmpleadoResponse;
import com.empleado.empleado.domain.HoraRequest;
import com.empleado.empleado.domain.HoraResponse;
import com.empleado.empleado.util.EmpleadoHelper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@CrossOrigin(origins="http://localhost:4200")
//@RequestMapping(value = "/Hora")
@Api(value="onlinestore", description="Operaciones relacionadas con los empleados")
public class HoraController {
	
	@RequestMapping(value = "/getHora", method= RequestMethod.POST, produces = "application/json")
	@ApiOperation(value = "Operacion que permite obtener la hora en UTC", response = CrearEmpleadoResponse.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "operacion exitosa"),
//			@ApiResponse(code = 201, message = "operacion exitosa, creado"),
			@ApiResponse(code = 401, message = "Acceso No Autorizado"),
			@ApiResponse(code = 403, message = "Acceso prohibido"),
			@ApiResponse(code = 404, message = "Recurso no encontrado")
	})
	public HoraResponse crear(@RequestBody HoraRequest request) {
		HoraResponse response = new HoraResponse();
	
		try {
			EmpleadoHelper.validarObjeto(request);
			
			DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
			Date date = dateFormat.parse(request.getHora());
//			LocalDateTime dateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
			
			Calendar calendar = Calendar.getInstance();
		    calendar.setTime(date);
		    Calendar.getInstance(TimeZone.getTimeZone("UTC"));
		    calendar.add(Calendar.HOUR, request.getTimezone());
		    
		    response.setTime(dateFormat.format(calendar.getTime()).toString());
		    response.setTimezone("UTC");
		    
		} catch (Exception e) {
			EmpleadoHelper.setErrorServiceImpl(e);
		}		
		return response;
	}

}
