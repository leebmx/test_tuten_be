package com.empleado.empleado.service.impl;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

import com.empleado.empleado.controller.EmpleadoController;
import com.empleado.empleado.domain.CrearEmpleadoRequest;
import com.empleado.empleado.domain.CrearEmpleadoResponse;
import com.empleado.empleado.domain.DeleteEmpleadoResponse;
import com.empleado.empleado.domain.GetAllEmpleadoResponse;
import com.empleado.empleado.domain.GetIdEmpleadoResponse;
import com.empleado.empleado.domain.UpdateEmpleadoRequest;
import com.empleado.empleado.domain.UpdateEmpleadoResponse;
import com.empleado.empleado.dto.EmpleadoDto;
import com.empleado.empleado.entity.EmpleadoEntity;
import com.empleado.empleado.mapper.EmpleadoMapper;
import com.empleado.empleado.repository.EmpleadoRepository;
import com.empleado.empleado.service.EmpleadoService;
import com.empleado.empleado.util.Constantes;
import com.empleado.empleado.util.EmpleadoHelperTest;

import lombok.extern.slf4j.Slf4j;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@SpringBootTest
public class EmpleadoServiceImplTest {
	
	@InjectMocks
	private EmpleadoServiceImpl empleadoServiceImpl;
	
	@Mock
	private EmpleadoMapper mapper;
	
	@Mock
	private EmpleadoRepository repository;
	
	PodamFactory factory = new PodamFactoryImpl();
	
	@Test
	public void create() {
		//Dumy
		CrearEmpleadoRequest request = factory.manufacturePojo(CrearEmpleadoRequest.class);
		CrearEmpleadoResponse response = factory.manufacturePojo(CrearEmpleadoResponse.class);
		EmpleadoEntity entity = factory.manufacturePojo(EmpleadoEntity.class);

		//Mock
		Mockito.when(mapper.convertToEntity(request.getEmpleadoDto())).thenReturn(entity);
		Mockito.when(repository.save(entity)).thenReturn(entity);
		
		//Call
		response = empleadoServiceImpl.create(request);
		
		//Validate
		assertTrue(response != null);
	}
	
	@Test
	public void createExpetion() {
		//Dumy
		CrearEmpleadoRequest request = factory.manufacturePojo(CrearEmpleadoRequest.class);
		CrearEmpleadoResponse response = factory.manufacturePojo(CrearEmpleadoResponse.class);
		EmpleadoEntity entity = factory.manufacturePojo(EmpleadoEntity.class);

		//Mock
		Mockito.when(mapper.convertToEntity(request.getEmpleadoDto())).thenReturn(entity);
		Mockito.when(repository.save(entity)).thenThrow(new RuntimeException(Constantes.SMSJ_ERROR_503));
		
		//Call
		response = empleadoServiceImpl.create(request);
		
		//Validate
		assertTrue(response != null);
	}
	
	@Test
	public void createExpetion2() {
		//Dumy
		CrearEmpleadoRequest request = factory.manufacturePojo(CrearEmpleadoRequest.class);
		CrearEmpleadoResponse response = factory.manufacturePojo(CrearEmpleadoResponse.class);
		EmpleadoEntity entity = factory.manufacturePojo(EmpleadoEntity.class);

		//Mock
		Mockito.when(mapper.convertToEntity(request.getEmpleadoDto())).thenReturn(entity);
		Mockito.when(repository.save(entity)).thenThrow(new RuntimeException(Constantes.SMSJ_ERROR_400));
		
		//Call
		response = empleadoServiceImpl.create(request);
		
		//Validate
		assertTrue(response != null);
	}
	
	@Test
	public void getAll() {
		//Dumy
		GetAllEmpleadoResponse response = new GetAllEmpleadoResponse();
		EmpleadoDto emp = factory.manufacturePojo(EmpleadoDto.class);
		List<EmpleadoDto> list = new ArrayList<EmpleadoDto>();
		list.add(emp);
		response.setEmpleadoList(list);
		
		EmpleadoEntity entity = factory.manufacturePojo(EmpleadoEntity.class);
		List<EmpleadoEntity> listE = new ArrayList<EmpleadoEntity>();
		listE.add(entity);
		
		//Mock
		Mockito.when(repository.findAll()).thenReturn(listE);
		
		//Call
		response = empleadoServiceImpl.getAll();
		
		//Validate
		assertTrue(response != null);
	}
	
	@Test
	public void getAllException() {
		//Dumy
		GetAllEmpleadoResponse response = new GetAllEmpleadoResponse();
		EmpleadoDto emp = factory.manufacturePojo(EmpleadoDto.class);
		List<EmpleadoDto> list = new ArrayList<EmpleadoDto>();
		list.add(emp);
		response.setEmpleadoList(list);
		
		//Mock
		Mockito.when(repository.findAll()).thenThrow(new RuntimeException(Constantes.SMSJ_ERROR_400));
		
		//Call
		response = empleadoServiceImpl.getAll();
		
		//Validate
		assertTrue(response != null);
	}
	
	@Test
	public void findById() {
		//Dumy
		Long id= Long.valueOf(1);
		GetIdEmpleadoResponse response = factory.manufacturePojo(GetIdEmpleadoResponse.class);
		EmpleadoEntity entity = factory.manufacturePojo(EmpleadoEntity.class);
		Optional<EmpleadoEntity> op = Optional.of(entity);

		//Mock
		Mockito.when(repository.findById(id)).thenReturn(op);
		
		//Call
		response = empleadoServiceImpl.findById(id);
		
		//Validate
		assertTrue(response != null);
	}
	
	@Test
	public void findByIdEmpty() {
		//Dumy
		Long id= Long.valueOf(1);
		GetIdEmpleadoResponse response = factory.manufacturePojo(GetIdEmpleadoResponse.class);
		EmpleadoEntity entity = factory.manufacturePojo(EmpleadoEntity.class);
		Optional<EmpleadoEntity> op = Optional.empty();

		//Mock
		Mockito.when(repository.findById(id)).thenReturn(op);
		
		//Call
		response = empleadoServiceImpl.findById(id);
		
		//Validate
		assertTrue(response != null);
	}
	
	@Test
	public void findByIdException() {
		//Dumy
		Long id= Long.valueOf(1);
		GetIdEmpleadoResponse response = factory.manufacturePojo(GetIdEmpleadoResponse.class);

		//Mock
		Mockito.when(repository.findById(id)).thenThrow(new RuntimeException(Constantes.SMSJ_ERROR_503));
		
		//Call
		response = empleadoServiceImpl.findById(id);
		
		//Validate
		assertTrue(response != null);
	}
	
	@Test
	public void update() {
		//Dumy
		Long id= Long.valueOf(1);
		UpdateEmpleadoRequest request = factory.manufacturePojo(UpdateEmpleadoRequest.class);
		UpdateEmpleadoResponse response = factory.manufacturePojo(UpdateEmpleadoResponse.class);
		EmpleadoEntity entity = factory.manufacturePojo(EmpleadoEntity.class);
		entity.setId(id);
		request.getEmpleadoDto().setId(id);
		Optional<EmpleadoEntity> op = Optional.of(entity);
		

		//Mock
		Mockito.when(repository.findById(id)).thenReturn(op);
		Mockito.when(repository.save(entity)).thenReturn(entity);
		
		//Call
		response = empleadoServiceImpl.update(request);
		
		//Validate
		assertTrue(response != null);
	}
	
	@Test
	public void updateException() {
		//Dumy
		UpdateEmpleadoRequest request = factory.manufacturePojo(UpdateEmpleadoRequest.class);
		UpdateEmpleadoResponse response = factory.manufacturePojo(UpdateEmpleadoResponse.class);
		EmpleadoEntity entity = factory.manufacturePojo(EmpleadoEntity.class);

		//Mock
		Mockito.when(repository.save(entity)).thenThrow(new RuntimeException(Constantes.SMSJ_ERROR_503));
		
		//Call
		response = empleadoServiceImpl.update(request);
		
		//Validate
		assertTrue(response != null);
	}
	
	@Test
	public void delete() {
		//Dumy
		Long id= Long.valueOf(1);
		DeleteEmpleadoResponse response = factory.manufacturePojo(DeleteEmpleadoResponse.class);
		EmpleadoEntity entity = factory.manufacturePojo(EmpleadoEntity.class);
		Optional<EmpleadoEntity> op = Optional.of(entity);

		//Mock
		Mockito.when(repository.findById(id)).thenReturn(op);
		
		//Call
		response = empleadoServiceImpl.delete(id);
		
		//Validate
		assertTrue(response != null);
	}
	
	@Test
	public void deleteEmpty() {
		//Dumy
		Long id= Long.valueOf(1);
		DeleteEmpleadoResponse response = factory.manufacturePojo(DeleteEmpleadoResponse.class);		
		Optional<EmpleadoEntity> op = Optional.empty();

		//Mock
		Mockito.when(repository.findById(id)).thenReturn(op);
		
		//Call
		response = empleadoServiceImpl.delete(id);
		
		//Validate
		assertTrue(response != null);
	}
	
	@Test
	public void deleteException() {
		//Dumy
		Long id= Long.valueOf(1);
		DeleteEmpleadoResponse response = factory.manufacturePojo(DeleteEmpleadoResponse.class);		
		Optional<EmpleadoEntity> op = Optional.empty();

		//Mock
		Mockito.when(repository.findById(id)).thenThrow(new RuntimeException(Constantes.SMSJ_ERROR_503));
		
		//Call
		response = empleadoServiceImpl.delete(id);
		
		//Validate
		assertTrue(response != null);
	}
}
