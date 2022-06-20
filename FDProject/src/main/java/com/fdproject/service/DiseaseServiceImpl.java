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

	@Override
	public List<DiseaseDTO> getDiseaseList() {
		
        List<DiseaseDTO> diseaseList = new ArrayList<>();
        diseaseList = diseaseMapper.diseaseList();
        
		return diseaseList;
	}

}
