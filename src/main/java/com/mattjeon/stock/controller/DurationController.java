/*
 * Copyright (c) 2014. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.mattjeon.stock.controller;

import com.mattjeon.stock.service.DurationService;
import com.mattjeon.stock.vo.DurationVo;

import org.springframework.stereotype.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RequestMapping("/duration")
@Controller(value = "durationController")
public class DurationController {

    @Resource(name = "durationService")
    private DurationService durationService;
    

    @RequestMapping(value = "/getInvestorDurationIncome/{companyCode}/{fromDate}/{toDate}", method = RequestMethod.GET)
    public @ResponseBody DurationVo getInvestorDurationIncome(@PathVariable("companyCode") String companyCode, @PathVariable("fromDate") String fromDate, @PathVariable("toDate") String toDate) throws Exception {
      return this.durationService.getInvestorDurationIncome(companyCode, fromDate, toDate);
    }
    
    
    @RequestMapping(value = "/getCompanyCommercialBand/{companyCode}/{fromDate}/{toDate}", method = RequestMethod.GET)
    public @ResponseBody List<DurationVo> getCompanyCommercialBand(@PathVariable("companyCode") String companyCode, @PathVariable("fromDate") String fromDate, @PathVariable("toDate") String toDate) throws Exception {
      return this.durationService.getCompanyCommercialBand(companyCode, fromDate, toDate);
    }

    
    
    @RequestMapping(value = "/getIndustryInvestorSumByDurationList/{fromCode}/{toCode}/{fromDate}/{toDate}/{sortBy}", method = RequestMethod.GET)
    public @ResponseBody List<DurationVo> getIndustryInvestorSumByDurationList(@PathVariable("fromCode") String fromCode, @PathVariable("toCode") String toCode, @PathVariable("fromDate") String fromDate, @PathVariable("toDate") String toDate, @PathVariable("sortBy") String sortBy) throws Exception {
    	return this.durationService.getIndustryInvestorSumByDurationList(fromCode, toCode, fromDate, toDate, sortBy);
    }
 
    @RequestMapping(value = "/getCompanyInvestorSumByDurationList/{fromCode}/{toCode}/{fromDate}/{toDate}/{sortBy}", method = RequestMethod.GET)
    public @ResponseBody List<DurationVo> getCompanyInvestorSumByDurationList(@PathVariable("fromCode") String fromCode, @PathVariable("toCode") String toCode, @PathVariable("fromDate") String fromDate, @PathVariable("toDate") String toDate, @PathVariable("sortBy") String sortBy) throws Exception {
    	return this.durationService.getCompanyInvestorSumByDurationList(fromCode, toCode, fromDate, toDate, sortBy);
    }
        
}
