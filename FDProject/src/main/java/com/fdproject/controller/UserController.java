package com.fdproject.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fdproject.domain.DiseaseDTO;
import com.fdproject.domain.DrugDTO;
import com.fdproject.service.DiseaseService;
import com.fdproject.service.DrugService;
import com.fdproject.util.UiUtils;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping(value = "/user")
@RequiredArgsConstructor
public class UserController extends UiUtils {

    private final DiseaseService diseaseService;
    private final DrugService drugService;

	@GetMapping(value="/joinForm")
	public String getJoinForm(){
		return "user/joinForm";
	}

	@GetMapping(value="/joinForm2")
	public String getJoinForm2(){
		return "user/joinForm2";
	}
	
	@GetMapping(value="/loginForm")
	public String getLoginForm(){
		return "user/loginForm";
	}

    /** 회원가입 - 질병 리스트 조회 사용*/
    @ResponseBody
    @GetMapping("/disease/getList.do")
    public HashMap<String, Object> getUserDiseaseList(Model model) {
        List<DiseaseDTO> diseaseList = diseaseService.getUserDiseaseList();
        
        HashMap<String, Object> diseaseMap = new HashMap<String, Object>();
        diseaseMap.put("diseaseList", diseaseList);
        return diseaseMap;
    }

    /** 회원가입 - 약 리스트 조회 사용*/
    @ResponseBody
    @GetMapping("/drug/getList.do")
    public HashMap<String, Object> getUserDrugList(Model model) {
        List<DrugDTO> drugList = drugService.getUserDrugList();
        
        HashMap<String, Object> drugMap = new HashMap<String, Object>();
        drugMap.put("drugList", drugList);
        return drugMap;
    }
    
    @ResponseBody
    @PostMapping("/join.do")
    public HashMap<String, Object> join(Model model, HttpServletRequest request) {
    	System.out.println(request.getParameter("drugMap"));
    	System.out.println(request.getParameter("diseaseMap"));
    	
    	HashMap<String, Object> resultMap = new HashMap<String, Object>();
    	resultMap.put("result", "success");
    	
    	return resultMap;
    }
    
    
}
