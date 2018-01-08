/*
 * Copyright (c) 2014. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.mattjeon.stock.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.mattjeon.stock.vo.IndicatorVo;

/**
 * Created by jeon-yeongsu on 2014. 6. 17..
 */
@Service(value = "tradeStrategyLogic")
public class TradeStrategyLogic {
    
    public List<IndicatorVo> setTradeSignal(List<IndicatorVo> liv){
    	int TOTAL_PERIODS = liv.size();
 //   	int lastIndex = liv.size() - 1;
		
    	try{
			for (int i = 21; i < TOTAL_PERIODS ; i++) {

				// 세력합 매수
				if( i > 1
					&& liv.get(i).getPowerWL() >= 20
					&& liv.get(i).getPowerCorrelShort() > 0
					&& liv.get(i).getPowerLds20() > 0
					&& liv.get(i-1).getPowerLds20() < 0
					&& ( liv.get(i).getPowerLds5() > 0
						|| liv.get(i).getPowerLds5() > liv.get(i).getPowerLds20() )
					&& ( liv.get(i).getClosePrice() < liv.get(i).getMa240()
					    || liv.get(i).getClosePrice() < liv.get(i).getMa720() )
				){
					liv.get(i).setTradeSignal(0x8);
					liv.get(i).setTradeSignalPower(1);
				}
				
				//리더 
				if( i > 1
					&& liv.get(i).getLeaderWL() >= 20
					&& liv.get(i).getLeaderCorrelShort() > 0
					&& liv.get(i).getLeaderLds20() > 0
					&& liv.get(i-1).getLeaderLds20() < 0
					&& ( liv.get(i).getLeaderLds5() > 0
							|| liv.get(i).getLeaderLds5() > liv.get(i).getLeaderLds20() )
					&& ( liv.get(i).getClosePrice() < liv.get(i).getMa240()
						    || liv.get(i).getClosePrice() < liv.get(i).getMa720() )
				){
					liv.get(i).setTradeSignal(liv.get(i).getTradeSignal() + 0x4);
					liv.get(i).setTradeSignalLeader(1);
				}
				
				//외인
				if( i > 1
					&& liv.get(i).getForeignerWL() >= 20
					&& liv.get(i).getForeignerCorrelShort() > 0
					&& liv.get(i).getForeignerLds20() > 0
					&& liv.get(i-1).getForeignerLds20() < 0
					&& ( liv.get(i).getForeignerLds5() > 0
							|| liv.get(i).getForeignerLds5() > liv.get(i).getForeignerLds20() )
					&& ( liv.get(i).getClosePrice() < liv.get(i).getMa240()
						    || liv.get(i).getClosePrice() < liv.get(i).getMa720() )
				){
					liv.get(i).setTradeSignal(liv.get(i).getTradeSignal() + 0x2);
					liv.get(i).setTradeSignalForeigner(1);
				}
				
				//기관 
				if( i > 1
					&& liv.get(i).getOrgSumWL() >= 20
					&& liv.get(i).getOrgSumCorrelShort() > 0
					&& liv.get(i).getOrgSumLds20() > 0
					&& liv.get(i-1).getOrgSumLds20() < 0
					&& ( liv.get(i).getOrgSumLds5() > 0
							|| liv.get(i).getOrgSumLds5() > liv.get(i).getOrgSumLds20() )
					&& ( liv.get(i).getClosePrice() < liv.get(i).getMa240()
						    || liv.get(i).getClosePrice() < liv.get(i).getMa720() )
				){
					liv.get(i).setTradeSignal(liv.get(i).getTradeSignal() + 0x1);
					liv.get(i).setTradeSignalOrgSum(1);
				}
				

				//매도
				if( i > 1
					&& liv.get(i).getPowerWL() >= 15
					&& liv.get(i).getPowerCorrelShort() > 0
					&& liv.get(i).getPowerLds20() < 0
					&& liv.get(i-1).getPowerLds20() > 0
					&& ( liv.get(i).getClosePrice() > liv.get(i).getMa240()
							 && liv.get(i).getClosePrice() > liv.get(i).getMa720() )
					&& liv.get(i).getMacdRate() > 2.0
				){
					liv.get(i).setTradeSignal(-0x8);
					liv.get(i).setTradeSignalPower(-1);
				}

				
				if( i > 1
					&& liv.get(i).getLeaderWL() >= 15
					&& liv.get(i).getLeaderCorrelShort() > 0
					&& liv.get(i).getLeaderLds20() < 0
					&& liv.get(i-1).getLeaderLds20() > 0
					&& ( liv.get(i).getClosePrice() > liv.get(i).getMa240()
							 && liv.get(i).getClosePrice() > liv.get(i).getMa720() )
					&& liv.get(i).getMacdRate() > 2.0
				){
					liv.get(i).setTradeSignal(liv.get(i).getTradeSignal() + -0x4);
					liv.get(i).setTradeSignalLeader(-1);
				}

				if( i > 1
					&& liv.get(i).getForeignerWL() >= 15
					&& liv.get(i).getForeignerCorrelShort() > 0
					&& liv.get(i).getForeignerLds20() < 0
					&& liv.get(i-1).getForeignerLds20() > 0
					&& ( liv.get(i).getClosePrice() > liv.get(i).getMa240()
							 && liv.get(i).getClosePrice() > liv.get(i).getMa720() )
					&& liv.get(i).getMacdRate() > 2.0
				){
					liv.get(i).setTradeSignal(liv.get(i).getTradeSignal() + -0x2);
					liv.get(i).setTradeSignalForeigner(-1);
				}

				if( i > 1
					&& liv.get(i).getOrgSumWL() >= 15
					&& liv.get(i).getOrgSumCorrelShort() > 0
					&& liv.get(i).getOrgSumLds20() < 0
					&& liv.get(i-1).getOrgSumLds20() > 0
					&& ( liv.get(i).getClosePrice() > liv.get(i).getMa240()
							 && liv.get(i).getClosePrice() > liv.get(i).getMa720() )
					&& liv.get(i).getMacdRate() > 2.0
				){
					liv.get(i).setTradeSignal(liv.get(i).getTradeSignal() + -0x1);
					liv.get(i).setTradeSignalOrgSum(-1);
				}

			} //End for
		
    	}catch(Exception e){
    		System.out.println( "E: "+ e.toString() );
    	}
		return liv;
    }


}

