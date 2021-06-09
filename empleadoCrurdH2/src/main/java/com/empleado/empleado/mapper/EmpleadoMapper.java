package com.empleado.empleado.mapper;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.empleado.empleado.dto.EmpleadoDto;
import com.empleado.empleado.entity.EmpleadoEntity;

/**
 * The Class EmpleadoMapper.
 */
@Component
public class EmpleadoMapper {

	/** The model mapper. */
	@Autowired
	private ModelMapper modelMapper;
	
	/**
	 * Convert to dto.
	 *
	 * @param e the e
	 * @return the empleado dto
	 */
	public EmpleadoDto convertToDto(EmpleadoEntity e) {
		  return modelMapper.map(e, EmpleadoDto.class);
	}
	
	/**
	 * Convert to entity.
	 *
	 * @param dto the dto
	 * @return the empleado entity
	 */
	public EmpleadoEntity convertToEntity(EmpleadoDto dto) {
		  return modelMapper.map(dto, EmpleadoEntity.class);
	}
	
	/**
	 * Convert to dto.
	 *
	 * @param e the e
	 * @return the list
	 */
	public List<EmpleadoDto> convertToDtoList(List<EmpleadoEntity> e) {
		  return (List<EmpleadoDto>) modelMapper.map(e, List.class);
	}
	
	/**
	 * Convert to entity.
	 *
	 * @param dto the dto
	 * @return the list
	 */
	public List<EmpleadoEntity> convertToEntity(List<EmpleadoDto> dto) {
		  return (List<EmpleadoEntity>) modelMapper.map(dto, List.class);
	}
	
}
