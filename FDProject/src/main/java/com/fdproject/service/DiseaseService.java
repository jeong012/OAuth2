package com.fdproject.service;

import java.util.List;

import com.fdproject.domain.DiseaseDTO;

public interface DiseaseService {

	/** 질병 리스트 */
	List<DiseaseDTO> getDiseaseList();
	
}
