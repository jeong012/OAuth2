package com.fdproject.domain;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.fdproject.paging.Criteria;
import com.fdproject.paging.PaginationInfo;

import lombok.Data;

@Data
public class CommonDTO extends Criteria{
	
	/** 페이징 정보*/
	private PaginationInfo paginationInfo;
    
    /** 삭제 여부 */
    private String deleteYn;

}