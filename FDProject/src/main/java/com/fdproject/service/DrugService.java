package com.fdproject.service;

import java.util.List;

import com.fdproject.domain.DrugDTO;

public interface DrugService {

    List<DrugDTO> getDrugList(String id, DrugDTO params);
    
    /** 회원가입 - 약 리스트 조회 사용*/
    List<DrugDTO> getUserDrugList();

}
