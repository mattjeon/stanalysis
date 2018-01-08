/*
 * Copyright (c) 2014. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.mattjeon.stock.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mattjeon.stock.mapper.DurationMapper;
import com.mattjeon.stock.vo.DurationVo;


/**
 * Created by jeon-yeongsu on 2014. 6. 17..
 */
@Service(value = "durationService")
public class DurationService {
	
    @Resource(name = "durationMapper")
    private DurationMapper durationMapper;
    
    
    public DurationVo getInvestorDurationIncome(String companyCode, String fromDate, String toDate) {
    	DurationVo technicalVo  = null;
    	
    	technicalVo  = this.durationMapper.getInvestorDurationIncome(companyCode, fromDate, toDate);
    	
    	return technicalVo;
    }
   
    
    public List<DurationVo> getCompanyCommercialBand(String companyCode, String fromDate, String toDate ) {
    	List<DurationVo> listTechnicalVo = null;

    	listTechnicalVo  = this.durationMapper.getCompanyCommercialBand(companyCode,  fromDate,  toDate);
     	    	
    	return listTechnicalVo;
    }

    
    
    public List<DurationVo> getIndustryInvestorSumByDurationList(String fromCode, String toCode, String fromDate, String toDate, String  sortBy ) {
    	List<DurationVo> listTechnicalVo  = null;

    	if ("power".equals(sortBy)){
    		listTechnicalVo  = this.durationMapper.getIndustryInvestorSumByDurationListByPower(fromCode, toCode, fromDate, toDate);
    	}else if ("foreigner".equals(sortBy)){
    		listTechnicalVo  = this.durationMapper.getIndustryInvestorSumByDurationListByForeigner(fromCode, toCode, fromDate, toDate);
    	}else if ("orgSum".equals(sortBy)){
    		listTechnicalVo  = this.durationMapper.getIndustryInvestorSumByDurationListByOrgSum(fromCode, toCode, fromDate, toDate);
    	}else if ("leader".equals(sortBy)){
    		listTechnicalVo  = this.durationMapper.getIndustryInvestorSumByDurationListByLeader(fromCode, toCode, fromDate, toDate);
    	}
    	
      	return listTechnicalVo;
    }

    public List<DurationVo> getCompanyInvestorSumByDurationList(String fromCode, String toCode, String fromDate, String toDate, String  sortBy ) {
    	List<DurationVo> listTechnicalVo  = null;

    	if ("power".equals(sortBy)){
    		listTechnicalVo  = this.durationMapper.getCompanyInvestorSumByDurationListByPower(fromCode, toCode, fromDate, toDate);
    	}else if ("foreigner".equals(sortBy)){
    		listTechnicalVo  = this.durationMapper.getCompanyInvestorSumByDurationListByForeigner(fromCode, toCode, fromDate, toDate);
    	}else if ("orgSum".equals(sortBy)){
    		listTechnicalVo  = this.durationMapper.getCompanyInvestorSumByDurationListByOrgSum(fromCode, toCode, fromDate, toDate);
    	}else if ("leader".equals(sortBy)){
    		listTechnicalVo  = this.durationMapper.getCompanyInvestorSumByDurationListByLeader(fromCode, toCode, fromDate, toDate);
    	}
    	
      	return listTechnicalVo;
    }
 
}

