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
import com.mattjeon.stock.mapper.RecommendMapper;
import com.mattjeon.stock.vo.FundamentalVo;
import com.mattjeon.stock.vo.IndicatorVo;
import com.mattjeon.stock.vo.RecommendVo;
/**
 * Created by jeon-yeongsu on 2014. 6. 17..
 */
@Service(value = "recommendService")
public class RecommendService {
	
    @Resource(name = "recommendMapper")
    private RecommendMapper recommendMapper;
   
    @Resource(name = "fundamentalMapper")
    private FundamentalMapper fundamentalMapper;

    @Resource(name = "fundamentalService")
    private FundamentalService fundamentalService;
    
    @Resource(name = "technicalService")
    private TechnicalService technicalService;
    
    public String addRecommendCompany() {
    	int resultCode = 0;
        List<IndicatorVo> listIndicatorVo = null;
    	List<FundamentalVo> listFundamentalVo  = null;
    	
    	// 재무우량 종목
    	listFundamentalVo  = this.fundamentalService.getGoodCompanyList();
    	
    	System.out.println("분석대상종목수: " + listFundamentalVo.size() );
    	for(int i = 0; i < listFundamentalVo.size(); i++){
    		listIndicatorVo = technicalService.getTechnicalResult(listFundamentalVo.get(i).getCompanyCode(), "C");
    		
    		System.out.println("#### " +i + "###");
    		System.out.println("#### "+listIndicatorVo.get(listIndicatorVo.size()-1).getCompanyCode() +":"+ listIndicatorVo.get(listIndicatorVo.size()-1).getCompanyName() );
    		System.out.println("#### "+listIndicatorVo.get(listIndicatorVo.size()-1).getRegDate() +":"+ listIndicatorVo.get(listIndicatorVo.size()-1).getTradeSignal() );
        	
            // 거래신호 종목.(접근가능 및 신호 종목, 주의접근은 제외함)
        	if( listIndicatorVo.get(listIndicatorVo.size()-1).getTradeSignal() != 0 ){
    			resultCode = this.recommendMapper.addRecommendCompany(listIndicatorVo.get(listIndicatorVo.size()-1));
        	}
    	}//End for

    	return Integer.toString(resultCode);
    }
    
    
    public List<RecommendVo> getRecommendCompanyDateList() {
    	List<RecommendVo> listRecommendVo  = null;
    	listRecommendVo  = this.recommendMapper.getRecommendCompanyDateList();
    	return listRecommendVo;
    }
    
    
    public List<RecommendVo> getRecommendCompanyListByCondition(String regDate, String conditionType) {

    	List<RecommendVo> listRecommendVo  = null;
    	if( "daily".equals(conditionType)){
    		listRecommendVo = this.recommendMapper.getRecommendCompanyListBySignal(regDate);
    	}else if( "monthly".equals(conditionType)){
    		listRecommendVo = this.recommendMapper.getRecommendCompanyListByMonthlyReview(regDate);
    	}else if( "all_recommend".equals(conditionType)){
    		listRecommendVo = this.recommendMapper.getRecommendCompanyListByAllRecommend(regDate);
    	}

    	return listRecommendVo;
    }
    
    
}

