package com.empleado.empleado.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empleado.empleado.entity.EmpleadoEntity;

public interface EmpleadoRepository extends JpaRepository<EmpleadoEntity, Long>{

}
