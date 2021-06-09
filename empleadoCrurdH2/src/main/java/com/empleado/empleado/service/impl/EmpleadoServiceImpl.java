package com.empleado.empleado.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
import com.empleado.empleado.dto.BookingsDto;
import com.empleado.empleado.entity.EmpleadoEntity;
import com.empleado.empleado.mapper.EmpleadoMapper;
import com.empleado.empleado.repository.EmpleadoRepository;
import com.empleado.empleado.service.EmpleadoService;
import com.empleado.empleado.service.feingcliente.EmpleadoFeignCliente;
import com.empleado.empleado.util.Constantes;
import com.empleado.empleado.util.EmpleadoHelper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EmpleadoServiceImpl implements EmpleadoService {
	
	@Autowired
	private EmpleadoMapper mapper;
	
	@Autowired
	private EmpleadoRepository repository;
	
	@Autowired
	private EmpleadoFeignCliente feignCliente;
	
	public CrearEmpleadoResponse create(CrearEmpleadoRequest request) {
		CrearEmpleadoResponse resp = new CrearEmpleadoResponse();
		try {
			EmpleadoHelper.validarCrear(request);
			request.getEmpleadoDto().setFechaIncorporacion(new Date());
			EmpleadoEntity entity = repository.save(mapper.convertToEntity(request.getEmpleadoDto()));
			EmpleadoHelper.validarEntity(entity, entity.getId());
			
			resp.setEmpleadoDto(mapper.convertToDto(entity));
			resp.setMensajeriaOp(EmpleadoHelper.setMensajeriaX(Constantes.SMSJ_ERROR_200));
		} catch (Exception e) {
			log.error(Constantes.SMSJ_ERROR_LOG_CREAR, e);
			resp.setMensajeriaOp(EmpleadoHelper.setErrorServiceImpl(e));
		}
		return resp;
	}
	
	public GetAllEmpleadoResponse getAll() {
		GetAllEmpleadoResponse resp = new GetAllEmpleadoResponse();
		try {
			List<EmpleadoEntity> list = repository.findAll().stream().collect(Collectors.toList());
			EmpleadoHelper.validarEntityList(list);
			
			resp.setEmpleadoList(mapper.convertToDtoList(list));
			resp.setMensajeriaOp(EmpleadoHelper.setMensajeriaX(Constantes.SMSJ_ERROR_200));
		} catch (Exception e) {
			log.error(Constantes.SMSJ_ERROR_LOG_GETALL, e);
			resp.setMensajeriaOp(EmpleadoHelper.setErrorServiceImpl(e));
		}	
		return resp;
	}
	
	public GetIdEmpleadoResponse findById(Long id) {
		GetIdEmpleadoResponse resp = new GetIdEmpleadoResponse();
		try {
			EmpleadoHelper.validarDatoLong(id, Constantes.SVAR_ID);
			Optional<EmpleadoEntity> op = repository.findById(id);
			if (op.isPresent()) {
				EmpleadoHelper.validarEntity(op.get(), op.get().getId());
				EmpleadoHelper.validarEntity(op.get(), op.get().getRut());
				resp.setEmpleadoDto(mapper.convertToDto(op.get()));
				resp.setMensajeriaOp(EmpleadoHelper.setMensajeriaX(Constantes.SMSJ_ERROR_200));
			} else {
				resp.setMensajeriaOp(EmpleadoHelper.setMensajeriaX(Constantes.SMSJ_ERROR_204));
			}
		} catch (Exception e) {
			log.error(Constantes.SMSJ_ERROR_LOG_FINDBYID, e);
			resp.setMensajeriaOp(EmpleadoHelper.setErrorServiceImpl(e));
		}	
		return resp;
	}
	
	public UpdateEmpleadoResponse update(UpdateEmpleadoRequest request) {
		UpdateEmpleadoResponse resp = new UpdateEmpleadoResponse();
		try {
			EmpleadoHelper.validarupdate(request);
			EmpleadoEntity entity = repository.findById(request.getEmpleadoDto().getId())
    				.map(updateModel -> {
                                    updateModel.setRut(request.getEmpleadoDto().getRut());
                                    updateModel.setNombre(request.getEmpleadoDto().getNombre());
                                    updateModel.setApellidoPaterno(request.getEmpleadoDto().getApellidoPaterno());
                                    updateModel.setApellidoMaterno(request.getEmpleadoDto().getApellidoMaterno());
                                    updateModel.setCorreo(request.getEmpleadoDto().getCorreo());
                                    updateModel.setFechaIncorporacion(request.getEmpleadoDto().getFechaIncorporacion());
	
				return repository.save(updateModel);
            }).orElse(null);
			EmpleadoHelper.validarEntity(entity, entity.getId());
			resp.setEmpleadoDto(mapper.convertToDto(entity));
			resp.setMensajeriaOp(EmpleadoHelper.setMensajeriaX(Constantes.SMSJ_ERROR_200));
		} catch (Exception e) {
			log.error(Constantes.SMSJ_ERROR_LOG_UPDATE, e);
			resp.setMensajeriaOp(EmpleadoHelper.setErrorServiceImpl(e));
		}	
		return resp;
	}
	
	public DeleteEmpleadoResponse delete(Long id) {
		DeleteEmpleadoResponse resp = new DeleteEmpleadoResponse();
		try {
			EmpleadoHelper.validarDatoLong(id, Constantes.SVAR_ID);
			repository.findById(id).ifPresent(o -> repository.delete(o));
			resp.setMensajeriaOp(EmpleadoHelper.setMensajeriaX(Constantes.SMSJ_ERROR_200));			
		} catch (Exception e) {
			log.error(Constantes.SMSJ_ERROR_LOG_DELETE, e);
			resp.setMensajeriaOp(EmpleadoHelper.setErrorServiceImpl(e));
		}	
		return resp;
	}
	
	public LoginResponse login(LoginRequest request) {
		LoginResponse resp = new LoginResponse();
		try {
			EmpleadoHelper.validarDatoString(request.getEmail(), "Email");
			EmpleadoHelper.validarDatoString(request.getPassword(), "password");
			EmpleadoHelper.validarDatoString(request.getApp(), "App");
			resp= feignCliente.login(request.getPassword(), request.getApp());
//			resp.setMensajeriaOp(EmpleadoHelper.setMensajeriaX(Constantes.SMSJ_ERROR_200));			
		} catch (Exception e) {
			log.error("Login ", e);
//			resp.setMensajeriaOp(EmpleadoHelper.setErrorServiceImpl(e));
		}	
		return resp;
	}
	
	public BookingsResponse getbooking(BookingsRequest request) {
		BookingsResponse resp = new BookingsResponse();
		List<BookingsDto> list = new ArrayList<BookingsDto>();
		try {
			EmpleadoHelper.validarDatoString(request.getAdminemail(), "Adminemail");
			EmpleadoHelper.validarDatoString(request.getEmail(), "Email");
			EmpleadoHelper.validarDatoString(request.getApp(), "App");
			EmpleadoHelper.validarDatoString(request.getToken(), "Token");
			list= feignCliente.getbooking(request.getAdminemail(), request.getEmail(),request.isCurrent(),  request.getToken(), request.getApp());
//			resp.setMensajeriaOp(EmpleadoHelper.setMensajeriaX(Constantes.SMSJ_ERROR_200));
			resp.setList(list);
		} catch (Exception e) {
			log.error("Login ", e);
//			resp.setMensajeriaOp(EmpleadoHelper.setErrorServiceImpl(e));
		}	
		return resp;
	}
	
	
}
