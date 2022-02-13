package com.manhpv.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.manhpv.converter.WorkConverter;
import com.manhpv.dto.WorkDto;
import com.manhpv.entity.WorkEntity;
import com.manhpv.repostory.WorkRepository;

@Service
public class WorkService implements IWorkService {
	@Autowired
	private WorkRepository workRepository;

	@Autowired
	private WorkConverter workConverter;
	
	@Override
	public WorkDto save(WorkDto workDto) {
		WorkEntity workEntity = workConverter.toEntity(workDto);
		if(workDto.getId() != 0)
			workEntity.setId(workDto.getId());
		
		workEntity = workRepository.save(workEntity);
		return workConverter.toDto(workEntity);
	}
	
	@Override
	public int delete(long id) {
		try {
			workRepository.deleteById(id);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}
	
	@Override
	public int totalItem() {
		return (int) workRepository.count();
	}
	
	@Override
	public List<WorkDto> findAll(Pageable pageable) {
		List<WorkDto> result = new ArrayList<WorkDto>();
		List<WorkEntity> listEntity = new ArrayList<WorkEntity>();
		listEntity = workRepository.findAll(pageable).getContent();
		for (WorkEntity userEntity : listEntity) {
			WorkDto workDTO = workConverter.toDto(userEntity);
			result.add(workDTO);
		}
		return result;
	}
}
