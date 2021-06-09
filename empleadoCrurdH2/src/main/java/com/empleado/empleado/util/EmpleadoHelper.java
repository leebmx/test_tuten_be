package com.empleado.empleado.util;

import java.util.Date;
import java.util.List;

import com.empleado.empleado.domain.CrearEmpleadoRequest;
import com.empleado.empleado.domain.DeleteEmpleadoRequest;
import com.empleado.empleado.domain.GetIdEmpleadoRequest;
import com.empleado.empleado.domain.MensajeriaOp;
import com.empleado.empleado.domain.UpdateEmpleadoRequest;

import lombok.extern.slf4j.Slf4j;

/** The Constant log. */
@Slf4j
public class EmpleadoHelper {
	
	/**
	 * Validar crear.
	 *
	 * @param request the request
	 */
	public static void validarCrear(CrearEmpleadoRequest request) {
		validarObjeto(request);
		validarObjeto(request.getEmpleadoDto());
		validarDatoString(request.getEmpleadoDto().getRut(), Constantes.SVAR_RUT);
		validarDatoString(request.getEmpleadoDto().getNombre(), Constantes.SVAR_NOMBRE);
		validarDatoString(request.getEmpleadoDto().getApellidoPaterno(), Constantes.SVAR_AP);
		validarDatoString(request.getEmpleadoDto().getApellidoMaterno(), Constantes.SVAR_AM);
		validarDatoString(request.getEmpleadoDto().getCorreo(), Constantes.SVAR_MAIL);
//		validarDatoDate(request.getEmpleadoDto().getFechaIncorporacion(), Constantes.SVAR_FFECHA_I);	
	}
	
	public static void validarFindById(GetIdEmpleadoRequest request) {
		validarObjeto(request);
		validarDatoLong(request.getId(), Constantes.SVAR_ID);		
	}
	
	public static void validarupdate(UpdateEmpleadoRequest request) {
		validarObjeto(request);
		validarObjeto(request.getEmpleadoDto());
		validarDatoString(request.getEmpleadoDto().getRut(), Constantes.SVAR_RUT);
		validarDatoString(request.getEmpleadoDto().getNombre(), Constantes.SVAR_NOMBRE);
		validarDatoString(request.getEmpleadoDto().getApellidoPaterno(), Constantes.SVAR_AP);
		validarDatoString(request.getEmpleadoDto().getApellidoMaterno(), Constantes.SVAR_AM);
		validarDatoString(request.getEmpleadoDto().getCorreo(), Constantes.SVAR_MAIL);
//		validarDatoDate(request.getEmpleadoDto().getFechaIncorporacion(), Constantes.SVAR_FFECHA_I);
		validarDatoLong(request.getEmpleadoDto().getId(), Constantes.SVAR_ID);		
	}
	
	public static void validarDelete(DeleteEmpleadoRequest request) {
		validarObjeto(request);
		validarDatoLong(request.getId(), Constantes.SVAR_ID);		
	}
	
	
	/**
	 * Validar dto.
	 *
	 * @param <T> the generic type
	 * @param dto the dto
	 */
	public static <T> void validarObjeto(T dto) {
		if(null == dto) {
			log.error(Constantes.SMSJ_ERROR_400);
			throw new RuntimeException(Constantes.SMSJ_ERROR_400);
		}
	}
	/**
	 * Validar entity.
	 *
	 * @param entity the entity
	 */
	public static <T> void validarEntity(T entity, Object id) {
		if(null == entity || null == id) {
			log.error(Constantes.SMSJ_ERROR_204);
			throw new RuntimeException(Constantes.SMSJ_ERROR_204);
		}
	}
	
	/**
	 * Validar entity.
	 *
	 * @param entity the entity
	 */
	public static <T> void validarEntityList(List<T> list) {
		if(null == list || list.isEmpty()) {
			log.error(Constantes.SMSJ_ERROR_204);
			throw new RuntimeException(Constantes.SMSJ_ERROR_204);
		}
	}
	
	/**
	 * Validar dato string.
	 *
	 * @param dato the dato
	 * @param nomeDato the nome dato
	 */
	public static void validarDatoString(String dato, String nomeDato) {
		if(null == dato || dato.isEmpty()) {
			log.error(Constantes.SMSJ_ERROR_400.concat(Constantes.SMSJ_ERROR_IN_DATO).concat(nomeDato));
			throw new RuntimeException(Constantes.SMSJ_ERROR_400.concat(Constantes.SMSJ_ERROR_IN_DATO).concat(nomeDato));
		}
	}

	/**
	 * Validar dato long.
	 *
	 * @param dato the dato
	 * @param nomeDato the nome dato
	 */
	public static void validarDatoLong(Long dato, String nomeDato) {
		if(null == dato) {
			log.error(Constantes.SMSJ_ERROR_400.concat(Constantes.SMSJ_ERROR_IN_DATO).concat(nomeDato));
			throw new RuntimeException(Constantes.SMSJ_ERROR_400.concat(Constantes.SMSJ_ERROR_IN_DATO).concat(nomeDato));
		}
	}
	
	/**
	 * Validar dato Date.
	 *
	 * @param dato the dato
	 * @param nomeDato the nome dato
	 */
	public static void validarDatoDate(Date dato, String nomeDato) {
		if(null == dato) {
			log.error(Constantes.SMSJ_ERROR_400.concat(Constantes.SMSJ_ERROR_IN_DATO).concat(nomeDato));
			throw new RuntimeException(Constantes.SMSJ_ERROR_400.concat(Constantes.SMSJ_ERROR_IN_DATO).concat(nomeDato));
		}
	}
	
	
	public static MensajeriaOp setError(String error) {
		MensajeriaOp resp = new MensajeriaOp();
		try {
			 String[] e = error.split("-");
			 resp.setCod(e[0]);
			 resp.setMsj(e[1]);
			 resp.setDetalle(3==e.length?e[2]:null);
		} catch (Exception e) {
			log.error(Constantes.SMSJ_ERROR_PROCESAR_E);
			resp.setMsj(Constantes.SMSJ_ERROR_503M);
			resp.setCod(Constantes.SCOD_ERROR_503);
		}		
		return resp;
	}

	public static MensajeriaOp setMensajeriaX(String msj) {
		MensajeriaOp resp = setError( msj);
		return resp;
	}

	public static MensajeriaOp setErrorServiceImpl(Exception e) {
		MensajeriaOp resp = new MensajeriaOp();;
		
		if (e.getMessage().contains(Constantes.SMSJ_ERROR_400) || e.getMessage().contains(Constantes.SMSJ_ERROR_204)) {
			resp = setError( e.getMessage());
		} else {
			resp = setError(Constantes.SMSJ_ERROR_503.concat(Constantes.SMSJ_ERROR_BD));
		}
		
		return resp;
	}

}
