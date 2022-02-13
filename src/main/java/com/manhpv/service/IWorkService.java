package com.manhpv.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.manhpv.dto.WorkDto;

public interface IWorkService {
	WorkDto save(WorkDto workDto);
	int delete(long id);
	int totalItem();
	List<WorkDto> findAll(Pageable pageable);
}
