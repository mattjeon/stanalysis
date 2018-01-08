package com.mattjeon.stock.controller;

import com.mattjeon.stock.service.CommonService;
import com.mattjeon.stock.vo.CommonVo;

import org.springframework.stereotype.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RequestMapping("/common")
@Controller(value = "commonController")
public class CommonController {

    @Resource(name = "commonService")
    private CommonService commonService;

    @RequestMapping(value = "/getCompany/{companyCode}", method = RequestMethod.GET)
    public @ResponseBody CommonVo getCompany(@PathVariable String companyCode) throws Exception {
        return this.commonService.getCompany(companyCode);
    }

    @RequestMapping(value = "/getAllCompanyList", method = RequestMethod.GET)
    public @ResponseBody List<CommonVo> getAllCompanyList() throws Exception {
        return this.commonService.getAllCompanyList();
    }

    
    @RequestMapping(value = "/getAllIndustryList", method = RequestMethod.GET)
    public @ResponseBody List<CommonVo> getAllIndustryList() throws Exception {
        return this.commonService.getAllIndustryList();
    }
}