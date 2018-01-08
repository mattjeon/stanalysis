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

import com.mattjeon.stock.mapper.CommonMapper;
import com.mattjeon.stock.vo.CommonVo;

//import org.apache.log4j.Logger;


/**
 * Created by jeon-yeongsu on 2014. 6. 17..
 */
@Service(value = "commonService")
public class CommonService { 
	
	//private Logger log = Logger.getLogger(this.getClass());
	
    @Resource(name = "commonMapper")
    private CommonMapper commonMapper;
    
    public CommonVo getCompany(String companyCode) {
        return this.commonMapper.getCompany(companyCode);
    }
    
    public List<CommonVo> getAllCompanyList() {
        return this.commonMapper.getAllCompanyList();
    }
    
    public List<CommonVo> getAllIndustryList() {
        return this.commonMapper.getAllIndustryList();
    }

}

