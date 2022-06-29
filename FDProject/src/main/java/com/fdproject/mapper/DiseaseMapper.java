package com.fdproject.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.fdproject.domain.DiseaseDTO;

@Mapper
public interface DiseaseMapper {

    /** 회원가입 - 질병 리스트 조회 사용*/
    List<DiseaseDTO> userDiseaseList();

}
