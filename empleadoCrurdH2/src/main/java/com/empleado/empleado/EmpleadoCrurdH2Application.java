package com.empleado.empleado;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
//@EnableFeignClients(basePackages = {"com.empleado.empleado.service.feingcliente","com.empleado.empleado.controller"})
public class EmpleadoCrurdH2Application {

	public static void main(String[] args) {
		SpringApplication.run(EmpleadoCrurdH2Application.class, args);
	}

}
