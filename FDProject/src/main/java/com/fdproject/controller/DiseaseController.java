package com.fdproject.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fdproject.domain.DiseaseDTO;
import com.fdproject.service.DiseaseService;
import com.fdproject.util.UiUtils;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping(value = "/disease")
@RequiredArgsConstructor
public class DiseaseController extends UiUtils {

    private final DiseaseService diseaseService;
    
    /** 질병 리스트 */
    @ResponseBody
    @GetMapping(value = "/getList")
    public HashMap<String, Object> getDiseaseList(Model model) {
        List<DiseaseDTO> diseaseList = diseaseService.getDiseaseList();
        
        HashMap<String, Object> diseaseMap = new HashMap<String, Object>();
        diseaseMap.put("diseaseList", diseaseList);
        return diseaseMap;
    }
}
