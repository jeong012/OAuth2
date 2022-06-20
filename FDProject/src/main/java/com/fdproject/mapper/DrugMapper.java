package com.fdproject.mapper;

import com.fdproject.domain.DrugDTO;
import com.fdproject.domain.UserDrugDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DrugMapper {

    List<DrugDTO> drugList(DrugDTO drugDTO);

    List<String> selectKeyword();

    List<String> selectKeywords(List<UserDrugDTO> userDrugList);

    List<UserDrugDTO> getUserDrug(UserDrugDTO userDrug);

    int selectDrugTotalCount(DrugDTO drugDTO);

    /** 회원가입 - 약 리스트 조회 사용*/
    List<DrugDTO> userDrugList();
    
}
