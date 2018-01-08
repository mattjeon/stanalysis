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

import com.mattjeon.stock.mapper.RawDataMapper;
import com.mattjeon.stock.vo.IndicatorVo;
import com.mattjeon.stock.vo.AdDetailVo;


/**
 * Created by jeon-yeongsu on 2014. 6. 17..
 */
@Service(value = "technicalService")
public class TechnicalService {
	
    @Resource(name = "rawDataMapper")
    private RawDataMapper rawDataMapper;
    
    @Resource(name = "indicatorLogic")
    private IndicatorLogic indicatorLogic;

    @Resource(name = "tradeStrategyLogic")
    private TradeStrategyLogic tradeStrategyLogic;
	

    public List<IndicatorVo> getTechnicalResult(String companyCode, String ciType ) {
    	List<IndicatorVo> listIndicatorVo = null;
    	
    	if( "C".equals(ciType)){
    		listIndicatorVo  = this.rawDataMapper.getCompanyRawData(companyCode);
    	}else if( "I".equals(ciType)){
    		listIndicatorVo  = this.rawDataMapper.getIndustryRawData(companyCode);
    	}

    	// 지표 산출
    	listIndicatorVo = indicatorLogic.setTechnicalIndicator(listIndicatorVo);
    	// 조건식  산출
    	listIndicatorVo = tradeStrategyLogic.setTradeSignal(listIndicatorVo);
    	    	
    	return listIndicatorVo;
    }

    
    public  AdDetailVo getAdDetail(String companyCode, String ciType, String regDate ) {
    	List<IndicatorVo> listIndicatorVo = null;
    	AdDetailVo adDetailVo = new AdDetailVo();
    	
    	if( "C".equals(ciType)){
    		listIndicatorVo  = this.rawDataMapper.getCompanyRawData(companyCode);
    	}else if( "I".equals(ciType)){
    		listIndicatorVo  = this.rawDataMapper.getIndustryRawData(companyCode);
    	}

      	// 지표 산출
    	listIndicatorVo = indicatorLogic.setTechnicalIndicator(listIndicatorVo);
    	
    	//LDS 관련 수치 셋팅
    	//adDetailVo = indicatorLogic.setAdDetail(listIndicatorVo, regDate);
    	    	
    	return adDetailVo;
    }

}

