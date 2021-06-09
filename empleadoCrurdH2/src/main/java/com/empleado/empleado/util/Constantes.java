package com.empleado.empleado.util;

public class Constantes {
	
	/* *********************
	 *  Errores Generales
	 ***********************/
	
	/** The Constant SMSJ_ERROR_200, operacion exitosa. */
	public static final String SMSJ_ERROR_200 = "200-operacion exitosa.-";

	/** The Constant SMSJ_ERROR_204, sin contenido */
	public static final String SMSJ_ERROR_204 = "204-No se encontraron resultados.-";

	/** The Constant SMSJ_ERROR_400. solicitud incorrecta*/
	public static final String SMSJ_ERROR_400 = "400-Solicitud incorrecta.-";

	/** The Constant SMSJ_ERROR_401. No autorizado*/
	public static final String SMSJ_ERROR_401 = "401-Acceso No Autorizado.-";

	/** The Constant SMSJ_ERROR_403. prohibido*/
	public static final String SMSJ_ERROR_403 = "403-Acceso prohibido.-";

	/** The Constant SMSJ_ERROR_404. no encontrado*/
	public static final String SMSJ_ERROR_404 = "404-Recurso no encontrado.-";

	/** The Constant SMSJ_ERROR_412. precondicion fallida*/
	public static final String SMSJ_ERROR_412 = "412-Precondicion fallida.-";

	/** The Constant SMSJ_ERROR_500. Error interno del servidor:*/
	public static final String SMSJ_ERROR_500 = "500-Error interno del servidor.-";

	/** The Constant SMSJ_ERROR_503. Servicio no disponible*/
	public static final String SMSJ_ERROR_503 = "503-Servicio no disponible.-";
	

	/* *********************
	 *  Errores Especificos
	 ***********************/
	/** The Constant SMSJ_ERROR_LOG_IN_DTO. */
	public static final String SMSJ_ERROR_IN_DTO = "Error objeto de entrada nulo";
	
	/** The Constant SMSJ_ERROR_IN_DATO. */
	public static final String SMSJ_ERROR_IN_DATO = "falta dato obligatorio, ";
	
	public static final String SCOD_ERROR_503 = "503";
	public static final String SMSJ_ERROR_503M = "Servicio no disponible.-";
	public static final String SMSJ_ERROR_BD = "Error de Base de Datos";

	
	/* *********************
	 *  Error Log
	 ***********************/
	/** The Constant SMSJ_ERROR_LOG_CREAR. */
	public static final String SMSJ_ERROR_LOG_CREAR = "Error al crear Empleado.";
	public static final String SMSJ_ERROR_LOG_GETALL = "Error al obbtener todos los Empleados.";
	public static final String SMSJ_ERROR_LOG_FINDBYID = "Error al obtener Empleado.";
	public static final String SMSJ_ERROR_LOG_UPDATE = "Error al actualizar Empleado.";
	public static final String SMSJ_ERROR_LOG_DELETE = "Error al eliminar Empleado.";
	
	/** The Constant SMSJ_ERROR_PROCESAR_E. */
	public static final String SMSJ_ERROR_PROCESAR_E = "Error al procesar error";
	
	/* *********************
	 *  Variables
	 ***********************/
	
	public static final String SVAR_ID = "id";
	public static final String SVAR_RUT = "rut";
	public static final String SVAR_NOMBRE = "nombre";
	public static final String SVAR_AP = "apellidoPaterno";
	public static final String SVAR_AM = "apellidoMaterno";
	public static final String SVAR_MAIL = "correo";
	public static final String SVAR_FFECHA_I = "fechaIncorporacion";

}
