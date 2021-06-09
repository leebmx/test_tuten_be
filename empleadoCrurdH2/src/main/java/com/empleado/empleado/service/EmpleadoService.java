package com.empleado.empleado.service;

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

public interface EmpleadoService {
	CrearEmpleadoResponse create (CrearEmpleadoRequest request);
	
	GetAllEmpleadoResponse getAll();
	
	GetIdEmpleadoResponse findById(Long id);
	
	UpdateEmpleadoResponse update(UpdateEmpleadoRequest request);
	
	DeleteEmpleadoResponse delete(Long id);
	
	LoginResponse login(LoginRequest request);
	
	BookingsResponse getbooking(BookingsRequest request);

}
