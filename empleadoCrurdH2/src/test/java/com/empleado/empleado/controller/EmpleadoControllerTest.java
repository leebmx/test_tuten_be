package com.empleado.empleado.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.empleado.empleado.domain.CrearEmpleadoRequest;
import com.empleado.empleado.domain.CrearEmpleadoResponse;
import com.empleado.empleado.domain.DeleteEmpleadoResponse;
import com.empleado.empleado.domain.GetAllEmpleadoResponse;
import com.empleado.empleado.domain.GetIdEmpleadoResponse;
import com.empleado.empleado.domain.UpdateEmpleadoRequest;
import com.empleado.empleado.domain.UpdateEmpleadoResponse;
import com.empleado.empleado.dto.EmpleadoDto;
import com.empleado.empleado.service.EmpleadoService;

import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@SpringBootTest
public class EmpleadoControllerTest {
	
	@InjectMocks
	private EmpleadoController empleadoController;

	@Mock
	private EmpleadoService services;
	
	PodamFactory factory = new PodamFactoryImpl();
	
	
	@Test
	public void crear() throws Exception{
		//Dumy
		CrearEmpleadoRequest request = factory.manufacturePojo(CrearEmpleadoRequest.class);
		CrearEmpleadoResponse response = factory.manufacturePojo(CrearEmpleadoResponse.class);

		//Mock
		Mockito.when(services.create(request)).thenReturn(response);
		
		//Call
		response = empleadoController.crear(request);
		
		//Validate
		assertTrue(response != null);
	}
	
	@Test
	public void getAll() throws Exception{
		//Dumy
//		GetAllEmpleadoResponse response = factory.manufacturePojo(GetAllEmpleadoResponse.class);
		GetAllEmpleadoResponse response = new GetAllEmpleadoResponse();
		EmpleadoDto emp = factory.manufacturePojo(EmpleadoDto.class);
		List<EmpleadoDto> list = new ArrayList<EmpleadoDto>();
		list.add(emp);
		response.setEmpleadoList(list);

		//Mock
		Mockito.when(services.getAll()).thenReturn(response);
		
		//Call
		response = empleadoController.getAll();
		
		//Validate
		assertTrue(response != null);
	}
	
	@Test
	public void findById() throws Exception{
		//Dumy
		GetIdEmpleadoResponse response = factory.manufacturePojo(GetIdEmpleadoResponse.class);
		Long id= Long.valueOf(1);

		//Mock
		Mockito.when(services.findById(id)).thenReturn(response);
		
		//Call
		response = empleadoController.findById(id);
		
		//Validate
		assertTrue(response != null);
	}
	
	@Test
	public void upadte() throws Exception{
		//Dumy
		UpdateEmpleadoRequest request = factory.manufacturePojo(UpdateEmpleadoRequest.class);
		UpdateEmpleadoResponse response = factory.manufacturePojo(UpdateEmpleadoResponse.class);

		//Mock
		Mockito.when(services.update(request)).thenReturn(response);
		
		//Call
		response = empleadoController.update(request);
		
		//Validate
		assertTrue(response != null);
	}
	
	@Test
	public void delete() throws Exception{
		//Dumy
		DeleteEmpleadoResponse response = factory.manufacturePojo(DeleteEmpleadoResponse.class);
		Long id= Long.valueOf(1);

		//Mock
		Mockito.when(services.delete(id)).thenReturn(response);
		
		//Call
		response = empleadoController.delete(id);
		
		//Validate
		assertTrue(response != null);
	}
}
