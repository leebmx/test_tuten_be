package com.empleado.empleado.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.empleado.empleado.domain.BookingsRequest;
import com.empleado.empleado.domain.BookingsResponse;
import com.empleado.empleado.domain.CrearEmpleadoRequest;
import com.empleado.empleado.domain.CrearEmpleadoResponse;
import com.empleado.empleado.domain.DeleteEmpleadoResponse;
import com.empleado.empleado.domain.GetAllEmpleadoResponse;
import com.empleado.empleado.domain.GetIdEmpleadoResponse;
import com.empleado.empleado.domain.LoginRequest;
import com.empleado.empleado.domain.LoginResponse;
import com.empleado.empleado.domain.UpdateEmpleadoRequest;
import com.empleado.empleado.domain.UpdateEmpleadoResponse;
import com.empleado.empleado.service.EmpleadoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value = "/empleado")
@Api(value="onlinestore", description="Operaciones relacionadas con los empleados")
public class EmpleadoController {
	
	@Autowired
	private EmpleadoService services;
	
	@RequestMapping(value = "/create", method= RequestMethod.POST, produces = "application/json")
	@ApiOperation(value = "Operacion que permite crear empleado", response = CrearEmpleadoResponse.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "operacion exitosa"),
//			@ApiResponse(code = 201, message = "operacion exitosa, creado"),
			@ApiResponse(code = 401, message = "Acceso No Autorizado"),
			@ApiResponse(code = 403, message = "Acceso prohibido"),
			@ApiResponse(code = 404, message = "Recurso no encontrado")
	})
	public CrearEmpleadoResponse crear(@RequestBody CrearEmpleadoRequest request) {
		return services.create(request);
	}
	
	@RequestMapping(value = "/get/all", method= RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "Operacion que permite obtener todos los empleados", response = GetAllEmpleadoResponse.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "operacion exitosa"),
			@ApiResponse(code = 204, message = "No se encontraron resultados"),
			@ApiResponse(code = 401, message = "Acceso No Autorizado"),
			@ApiResponse(code = 403, message = "Acceso prohibido"),
			@ApiResponse(code = 404, message = "Recurso no encontrado")
	})
	public GetAllEmpleadoResponse getAll() {
		return services.getAll();
	}
	
	@RequestMapping(value = "/get/{id}", method= RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "Operacion que permite obtener empleado por id", response = GetIdEmpleadoResponse.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "operacion exitosa"),
			@ApiResponse(code = 204, message = "No se encontraron resultados"),
			@ApiResponse(code = 401, message = "Acceso No Autorizado"),
			@ApiResponse(code = 403, message = "Acceso prohibido"),
			@ApiResponse(code = 404, message = "Recurso no encontrado")
	})
	public GetIdEmpleadoResponse findById(@PathVariable Long id) {
		return services.findById(id);
	}
	
	@RequestMapping(value = "/update", method= RequestMethod.PUT, produces = "application/json")
	@ApiOperation(value = "Operacion que permite actualizar empleado", response = UpdateEmpleadoResponse.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "operacion exitosa"),
			@ApiResponse(code = 204, message = "No se encontraron resultados"),
			@ApiResponse(code = 401, message = "Acceso No Autorizado"),
			@ApiResponse(code = 403, message = "Acceso prohibido"),
			@ApiResponse(code = 404, message = "Recurso no encontrado")
	})
	public UpdateEmpleadoResponse update(@RequestBody UpdateEmpleadoRequest request) {
		return services.update(request);
	}
	
	@RequestMapping(value = "/delete/{id}", method= RequestMethod.DELETE, produces = "application/json")
	@ApiOperation(value = "Operacion que permite eliminar empleado informadon el id", response = DeleteEmpleadoResponse.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "operacion exitosa"),
			@ApiResponse(code = 204, message = "No se encontraron resultados"),
			@ApiResponse(code = 401, message = "Acceso No Autorizado"),
			@ApiResponse(code = 403, message = "Acceso prohibido")
	})
	public DeleteEmpleadoResponse delete(@PathVariable Long id) {
		return services.delete(id);
	}

	@RequestMapping(value = "/login", method= RequestMethod.POST, produces = "application/json")
	@ApiOperation(value = "Operacion que permite crear empleado", response = CrearEmpleadoResponse.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "operacion exitosa"),
//			@ApiResponse(code = 201, message = "operacion exitosa, creado"),
			@ApiResponse(code = 401, message = "Acceso No Autorizado"),
			@ApiResponse(code = 403, message = "Acceso prohibido"),
			@ApiResponse(code = 404, message = "Recurso no encontrado")
	})
	public LoginResponse login(@RequestBody LoginRequest request) {
		return services.login(request);
	}
	
	@RequestMapping(value = "/booking", method= RequestMethod.POST, produces = "application/json")
	@ApiOperation(value = "Operacion que permite crear empleado", response = CrearEmpleadoResponse.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "operacion exitosa"),
//			@ApiResponse(code = 201, message = "operacion exitosa, creado"),
			@ApiResponse(code = 401, message = "Acceso No Autorizado"),
			@ApiResponse(code = 403, message = "Acceso prohibido"),
			@ApiResponse(code = 404, message = "Recurso no encontrado")
	})
	public BookingsResponse getBooking(@RequestBody BookingsRequest request) {
		return services.getbooking(request);
	}
	
}
