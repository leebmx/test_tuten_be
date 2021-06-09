package com.empleado.empleado.service.feingcliente;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.empleado.empleado.domain.BookingsResponse;
import com.empleado.empleado.domain.LoginResponse;
import com.empleado.empleado.dto.BookingsDto;

@FeignClient(name = "user", url = "https://dev.tuten.cl:443/TutenREST/rest")
public interface EmpleadoFeignCliente {
	
//	@Headers("Accept:application/json, Password: {pass}, App: {app}")
	@RequestMapping(method = RequestMethod.PUT, value = "/user/testapis@tuten.cl",
			consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, 
			headers = {"content-type=application/json", "Password={pass}", "App={app}"})
	LoginResponse login(@PathVariable(value = "pass") String pass, @PathVariable(value = "app") String app);

	
	@RequestMapping(method = RequestMethod.GET, value = "/user/contacto%40tuten.cl/bookings?current={current}",
			consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, 
			headers = {"Accepte=application/json", "content-type=application/json", "Adminemail={adminemail}", "Token={token}", "App={app}", "Email={email}"})
	List<BookingsDto> getbooking( 
			@PathVariable(value = "adminemail") String adminemail,
			@PathVariable(value = "email") String email,
			@PathVariable(value = "current") Boolean current,
			@PathVariable(value = "token") String token, 
			@PathVariable(value = "app") String app);

}
