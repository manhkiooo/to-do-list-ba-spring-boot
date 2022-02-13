package com.manhpv.converter;

import org.springframework.stereotype.Component;

import com.manhpv.dto.WorkDto;
import com.manhpv.entity.WorkEntity;

@Component
public class WorkConverter {

	public WorkEntity toEntity(WorkDto workDto) {
		WorkEntity workEntity = new WorkEntity();
		workEntity.setName(workDto.getWorkName());
		workEntity.setStratDate(workDto.getStartDate());
		workEntity.setEndDate(workDto.getEndDate());
		workEntity.setStatus(workDto.getStatus());
		return workEntity;
	}
	
	public WorkDto toDto(WorkEntity workEntity) {
		WorkDto workDto = new WorkDto();
		workDto.setWorkName(workEntity.getName());
		workDto.setStartDate(workEntity.getStratDate());
		workDto.setEndDate(workEntity.getEndDate());
		workDto.setStatus(workEntity.getStatus());
		workDto.setId(workEntity.getId());
		return workDto;
	}
}
