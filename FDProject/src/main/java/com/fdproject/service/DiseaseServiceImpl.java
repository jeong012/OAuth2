package com.fdproject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fdproject.domain.DiseaseDTO;
import com.fdproject.mapper.DiseaseMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DiseaseServiceImpl implements DiseaseService{

    private final DiseaseMapper diseaseMapper;

    /** 회원가입 - 질병 리스트 조회 사용*/
	@Override
	public List<DiseaseDTO> getUserDiseaseList() {
		
        List<DiseaseDTO> diseaseList = new ArrayList<>();
        diseaseList = diseaseMapper.userDiseaseList();
        
		return diseaseList;
	}

}
