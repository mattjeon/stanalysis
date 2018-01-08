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

import com.mattjeon.stock.mapper.FundamentalMapper;
import com.mattjeon.stock.vo.FundamentalVo;

/**
 * Created by jeon-yeongsu on 2014. 6. 17..
 */
@Service(value = "fundamentalService")
public class FundamentalService {
    
    @Resource(name = "fundamentalMapper")
    private FundamentalMapper fundamentalMapper;

    public FundamentalVo getFundamental(String companyCode) {
    	
    	return this.fundamentalMapper.getFundamental(companyCode);
    }

    public List<FundamentalVo> getGoodCompanyList() {
    	return this.fundamentalMapper.getGoodCompanyList();
    }
    
    public List<FundamentalVo> getFundamentalBatchList() {
    	return this.fundamentalMapper.getGoodCompanyList();
    }

}

