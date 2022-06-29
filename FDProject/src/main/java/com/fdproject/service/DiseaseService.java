package com.fdproject.service;

import java.util.List;

import com.fdproject.domain.DiseaseDTO;

public interface DiseaseService {

    /** 회원가입 - 질병 리스트 조회 사용*/
	List<DiseaseDTO> getUserDiseaseList();
	
}
