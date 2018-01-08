
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
import com.tictactec.ta.lib.Core;
import com.tictactec.ta.lib.MAType;
import com.tictactec.ta.lib.MInteger;


/**
 * Created by jeon-yeongsu on 2014. 6. 17..
 */
@Service(value = "indicatorLogic")
public class IndicatorLogic {
	
	
    public List<IndicatorVo> setTechnicalIndicator(List<IndicatorVo> liv){
        
    	int TOTAL_PERIODS = liv.size();
		
		Core c = new Core();
		int startIdx = 0;
		int endIdx = TOTAL_PERIODS - 1;
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		
		//1. Define InitialVallue (Investors vol, Sum values )
		double[] closePrice = new double[TOTAL_PERIODS];
		double[] openPrice = new double[TOTAL_PERIODS];
		double[] highPrice = new double[TOTAL_PERIODS];
		double[] lowPrice = new double[TOTAL_PERIODS];
		double[] volume = new double[TOTAL_PERIODS];

		double[] closePriceSum = new double[TOTAL_PERIODS]; //상세에서 기간별 평균값을 구하기 위해
		
		double[] personalSum = new double[TOTAL_PERIODS];
		double[] powerSum = new double[TOTAL_PERIODS];
		double[] leaderSum = new double[TOTAL_PERIODS];
		double[] foreignerSum = new double[TOTAL_PERIODS];
		double[] orgSumSum = new double[TOTAL_PERIODS];
		double[] finInvestSum = new double[TOTAL_PERIODS];
		double[] insuranceSum = new double[TOTAL_PERIODS];
		double[] investTrustSum = new double[TOTAL_PERIODS];
		double[] bankSum = new double[TOTAL_PERIODS];
		double[] etcFinSum = new double[TOTAL_PERIODS];
		double[] pensionSum = new double[TOTAL_PERIODS];
		double[] etcCorpSum = new double[TOTAL_PERIODS];
		double[] etcForeignerSum = new double[TOTAL_PERIODS];
		double[] privateFundSum = new double[TOTAL_PERIODS];
		double[] nationSum = new double[TOTAL_PERIODS];

	    double[] personalSumMin = new double[TOTAL_PERIODS];
		double[] powerSumMin = new double[TOTAL_PERIODS];
		double[] leaderSumMin = new double[TOTAL_PERIODS];
		double[] foreignerSumMin = new double[TOTAL_PERIODS];
		double[] orgSumSumMin = new double[TOTAL_PERIODS];
		double[] finInvestSumMin = new double[TOTAL_PERIODS];
		double[] insuranceSumMin = new double[TOTAL_PERIODS];
		double[] investTrustSumMin = new double[TOTAL_PERIODS];
		double[] bankSumMin = new double[TOTAL_PERIODS];
		double[] etcFinSumMin = new double[TOTAL_PERIODS];
		double[] pensionSumMin = new double[TOTAL_PERIODS];
		double[] etcCorpSumMin = new double[TOTAL_PERIODS];
		double[] etcForeignerSumMin = new double[TOTAL_PERIODS];
		double[] privateFundSumMin = new double[TOTAL_PERIODS];
		double[] nationSumMin = new double[TOTAL_PERIODS];

        double[] personalNet = new double[TOTAL_PERIODS];        
        double[] powerNet = new double[TOTAL_PERIODS];
		double[] leaderNet = new double[TOTAL_PERIODS];
        double[] foreignerNet = new double[TOTAL_PERIODS];
        double[] orgSumNet = new double[TOTAL_PERIODS];
        double[] finInvestNet = new double[TOTAL_PERIODS];
        double[] insuranceNet = new double[TOTAL_PERIODS];
        double[] investTrustNet = new double[TOTAL_PERIODS];
        double[] bankNet = new double[TOTAL_PERIODS];
        double[] etcFinNet = new double[TOTAL_PERIODS];
        double[] pensionNet = new double[TOTAL_PERIODS];
        double[] etcCorpNet = new double[TOTAL_PERIODS];
        double[] etcForeignerNet = new double[TOTAL_PERIODS];
        double[] privateFundNet = new double[TOTAL_PERIODS];
        double[] nationNet = new double[TOTAL_PERIODS];
        
        double[] powerNetMax = new double[TOTAL_PERIODS];
        double[] personalNetMax = new double[TOTAL_PERIODS];
		double[] leaderNetMax = new double[TOTAL_PERIODS];
        double[] foreignerNetMax = new double[TOTAL_PERIODS];
        double[] orgSumNetMax = new double[TOTAL_PERIODS];
        double[] finInvestNetMax = new double[TOTAL_PERIODS];
        double[] insuranceNetMax = new double[TOTAL_PERIODS];
        double[] investTrustNetMax = new double[TOTAL_PERIODS];
        double[] etcFinNetMax = new double[TOTAL_PERIODS];
        double[] bankNetMax = new double[TOTAL_PERIODS];
        double[] pensionNetMax = new double[TOTAL_PERIODS];
        double[] privateFundNetMax = new double[TOTAL_PERIODS];
        double[] nationNetMax = new double[TOTAL_PERIODS];
        double[] etcForeignerNetMax = new double[TOTAL_PERIODS];
        double[] etcCorpNetMax = new double[TOTAL_PERIODS];

		double[] personalCorrelLong = new double[TOTAL_PERIODS];
		double[] powerCorrelLong = new double[TOTAL_PERIODS];
		double[] leaderCorrelLong = new double[TOTAL_PERIODS];
		double[] foreignerCorrelLong = new double[TOTAL_PERIODS];
		double[] orgSumCorrelLong = new double[TOTAL_PERIODS];
		double[] finInvestCorrelLong = new double[TOTAL_PERIODS];
		double[] insuranceCorrelLong = new double[TOTAL_PERIODS];
		double[] investTrustCorrelLong = new double[TOTAL_PERIODS];
		double[] bankCorrelLong = new double[TOTAL_PERIODS];
		double[] etcFinCorrelLong = new double[TOTAL_PERIODS];
		double[] pensionCorrelLong = new double[TOTAL_PERIODS];
		double[] etcCorpCorrelLong = new double[TOTAL_PERIODS];
		double[] etcForeignerCorrelLong = new double[TOTAL_PERIODS];
		double[] privateFundCorrelLong = new double[TOTAL_PERIODS];
		double[] nationCorrelLong = new double[TOTAL_PERIODS];
        
		double[] personalCorrelShort = new double[TOTAL_PERIODS];
		double[] powerCorrelShort = new double[TOTAL_PERIODS];
		double[] leaderCorrelShort = new double[TOTAL_PERIODS];
		double[] foreignerCorrelShort = new double[TOTAL_PERIODS];
		double[] orgSumCorrelShort = new double[TOTAL_PERIODS];
		double[] finInvestCorrelShort = new double[TOTAL_PERIODS];
		double[] insuranceCorrelShort = new double[TOTAL_PERIODS];
		double[] investTrustCorrelShort = new double[TOTAL_PERIODS];
		double[] bankCorrelShort = new double[TOTAL_PERIODS];
		double[] etcFinCorrelShort = new double[TOTAL_PERIODS];
		double[] pensionCorrelShort = new double[TOTAL_PERIODS];
		double[] etcCorpCorrelShort = new double[TOTAL_PERIODS];
		double[] etcForeignerCorrelShort = new double[TOTAL_PERIODS];
		double[] privateFundCorrelShort = new double[TOTAL_PERIODS];
		double[] nationCorrelShort = new double[TOTAL_PERIODS];
        
		try{
        //=================
        // 투자주체별 합계, 합계 최저점 관련 지표 산출
        //=================
    	// 시작 시간
        long startTime = System.currentTimeMillis();
		
		for (int i = 0; i < TOTAL_PERIODS ; i++) {
			closePrice[i] = liv.get(i).getClosePrice();
			openPrice[i] = liv.get(i).getOpenPrice();
			highPrice[i] = liv.get(i).getHighPrice();
			lowPrice[i] = liv.get(i).getLowPrice();
			volume[i] = liv.get(i).getVolume();
			
			
			if( i > 0){
				closePriceSum[i] = closePriceSum[i-1] + liv.get(i).getClosePrice();
			    personalSum[i] = personalSum[i-1] + liv.get(i).getPersonal();
			    powerSum[i] = powerSum[i-1] + liv.get(i).getPower();
			    leaderSum[i] = leaderSum[i-1] + liv.get(i).getLeader();
			    foreignerSum[i] = foreignerSum[i-1] + liv.get(i).getForeigner();
			    orgSumSum[i] = orgSumSum[i-1] + liv.get(i).getOrgSum();
			    finInvestSum[i] = finInvestSum[i-1] + liv.get(i).getFinInvest();
			    insuranceSum[i] = insuranceSum[i-1] + liv.get(i).getInsurance();
			    investTrustSum[i] = investTrustSum[i-1] + liv.get(i).getInvestTrust();
			    bankSum[i] = bankSum[i-1] + liv.get(i).getBank();
			    etcFinSum[i] = etcFinSum[i-1] + liv.get(i).getEtcFin();
			    pensionSum[i] = pensionSum[i-1] + liv.get(i).getPension();
			    etcCorpSum[i] = etcCorpSum[i-1] + liv.get(i).getEtcCorp();
			    etcForeignerSum[i] = etcForeignerSum[i-1] + liv.get(i).getEtcForeigner();
			    privateFundSum[i] = privateFundSum[i-1] + liv.get(i).getPrivateFund();
			    nationSum[i] = nationSum[i-1] + liv.get(i).getNation();
		    }else{
			    closePriceSum[i] = liv.get(i).getClosePrice();
		    	personalSum[i] = liv.get(i).getPersonal();
			    powerSum[i] = liv.get(i).getPower();
			    leaderSum[i] = liv.get(i).getLeader();
			    foreignerSum[i] = liv.get(i).getForeigner();
			    orgSumSum[i] = liv.get(i).getOrgSum();
			    finInvestSum[i] = liv.get(i).getFinInvest();
			    insuranceSum[i] = liv.get(i).getInsurance();
			    investTrustSum[i] = liv.get(i).getInvestTrust();
			    bankSum[i] = liv.get(i).getBank();
			    etcFinSum[i] = liv.get(i).getEtcFin();
			    pensionSum[i] = liv.get(i).getPension();
			    etcCorpSum[i] = liv.get(i).getEtcCorp();
			    etcForeignerSum[i] = liv.get(i).getEtcForeigner();
			    privateFundSum[i] = liv.get(i).getPrivateFund();
			    nationSum[i] = liv.get(i).getNation();
		    }

			liv.get(i).setClosePriceSum( closePriceSum[i] );   
		    liv.get(i).setPowerSum( powerSum[i] );
		    liv.get(i).setLeaderSum( leaderSum[i] );
			liv.get(i).setPersonalSum( personalSum[i] );
			liv.get(i).setForeignerSum( foreignerSum[i] );
			liv.get(i).setOrgSumSum( orgSumSum[i] );
			liv.get(i).setFinInvestSum( finInvestSum[i] );
			liv.get(i).setInsuranceSum( insuranceSum[i] );
			liv.get(i).setInvestTrustSum( investTrustSum[i] );
			liv.get(i).setBankSum( bankSum[i] );
			liv.get(i).setEtcFinSum( etcFinSum[i] );
			liv.get(i).setPensionSum( pensionSum[i] );
			liv.get(i).setEtcCorpSum( etcCorpSum[i]);
			liv.get(i).setEtcForeignerSum( etcForeignerSum[i] );
			liv.get(i).setPrivateFundSum( privateFundSum[i] );
			liv.get(i).setNationSum( nationSum[i] );
			
			// SumMin: 최고저점, 누적합계의 최저점
		    // 해당기간까지의 Sum만을 해야 하므로 반드시 여기에 정의함.
			if(i > 0){
				if( personalSum[i] < personalSumMin[i-1]){ personalSumMin[i] = personalSum[i]; }else{  personalSumMin[i] = personalSumMin[i-1]; }
				if( powerSum[i] < powerSumMin[i-1]){ powerSumMin[i] = powerSum[i]; }else{  powerSumMin[i] = powerSumMin[i-1]; }
				if( leaderSum[i] < leaderSumMin[i-1]){ leaderSumMin[i] = leaderSum[i]; }else{  leaderSumMin[i] = leaderSumMin[i-1]; }
				if( foreignerSum[i] < foreignerSumMin[i-1]){ foreignerSumMin[i] = foreignerSum[i]; }else{  foreignerSumMin[i] = foreignerSumMin[i-1]; }
				if( orgSumSum[i] < orgSumSumMin[i-1]){ orgSumSumMin[i] = orgSumSum[i]; }else{  orgSumSumMin[i] = orgSumSumMin[i-1]; }
				if( finInvestSum[i] < finInvestSumMin[i-1]){ finInvestSumMin[i] = finInvestSum[i]; }else{  finInvestSumMin[i] = finInvestSumMin[i-1]; }
				if( insuranceSum[i] < insuranceSumMin[i-1]){ insuranceSumMin[i] = insuranceSum[i]; }else{  insuranceSumMin[i] = insuranceSumMin[i-1]; }
				if( investTrustSum[i] < investTrustSumMin[i-1]){ investTrustSumMin[i] = investTrustSum[i]; }else{  investTrustSumMin[i] = investTrustSumMin[i-1]; }
				if( bankSum[i] < bankSumMin[i-1]){ bankSumMin[i] = bankSum[i]; }else{  bankSumMin[i] = bankSumMin[i-1]; }
				if( etcFinSum[i] < etcFinSumMin[i-1]){ etcFinSumMin[i] = etcFinSum[i]; }else{  etcFinSumMin[i] = etcFinSumMin[i-1]; }
				if( pensionSum[i] < pensionSumMin[i-1]){ pensionSumMin[i] = pensionSum[i]; }else{  pensionSumMin[i] = pensionSumMin[i-1]; }
				if( etcCorpSum[i] < etcCorpSumMin[i-1]){ etcCorpSumMin[i] = etcCorpSum[i]; }else{  etcCorpSumMin[i] = etcCorpSumMin[i-1]; }
				if( etcForeignerSum[i] < etcForeignerSumMin[i-1]){ etcForeignerSumMin[i] = etcForeignerSum[i]; }else{  etcForeignerSumMin[i] = etcForeignerSumMin[i-1]; }
				if( privateFundSum[i] < privateFundSumMin[i-1]){ privateFundSumMin[i] = privateFundSum[i]; }else{  privateFundSumMin[i] = privateFundSumMin[i-1]; }
				if( nationSum[i] < nationSumMin[i-1]){ nationSumMin[i] = nationSum[i]; }else{  nationSumMin[i] = nationSumMin[i-1]; }
			}else{
				personalSumMin[i] = personalSum[i]; 
				powerSumMin[i] = powerSum[i]; 
				leaderSumMin[i] = leaderSum[i]; 
				foreignerSumMin[i] = foreignerSum[i]; 
				orgSumSumMin[i] = orgSumSum[i]; 
				finInvestSumMin[i] = finInvestSum[i]; 
				insuranceSumMin[i] = insuranceSum[i]; 
				investTrustSumMin[i] = investTrustSum[i]; 
				bankSumMin[i] = bankSum[i]; 
				etcFinSumMin[i] = etcFinSum[i]; 
				pensionSumMin[i] = pensionSum[i]; 
				etcCorpSumMin[i] = etcCorpSum[i]; 
				etcForeignerSumMin[i] = etcForeignerSum[i]; 
				privateFundSumMin[i] = privateFundSum[i]; 
				nationSumMin[i] = nationSum[i]; 
			}

		} //End for
		// 종료 시간
        long endTime = System.currentTimeMillis();
        System.out.println("## 투자주체별 합계  소요시간(초.0f) : " + ( endTime - startTime )/1000.0f +"초"); 

        
        //=================
        // 투자주체별 상관도, 분산비율 지표 산출
        //=================
        
     // 시작 시간
        long startTime1 = System.currentTimeMillis();
        
    	int optInTimePeriodCorrelLong = 720;
    	int loopbackCorrelLong = 720;

       	int optInTimePeriodCorrelShort = 60;
    	int loopbackCorrelShort = 60;

    	// 상관도 결과치를 우선 얻어야 하므로 앞의 for문을 일단락하고 다시 for문을 돌려야 함.
		// 상관도는 Sum 변수와 비교하여 처리.
		c.correl(startIdx, endIdx, closePrice, personalSum, optInTimePeriodCorrelLong,  outBegIdx, outNBElement, personalCorrelLong);
		c.correl(startIdx, endIdx, closePrice, powerSum, optInTimePeriodCorrelLong,  outBegIdx, outNBElement, powerCorrelLong);
		c.correl(startIdx, endIdx, closePrice, leaderSum, optInTimePeriodCorrelLong,  outBegIdx, outNBElement, leaderCorrelLong);
		c.correl(startIdx, endIdx, closePrice, foreignerSum, optInTimePeriodCorrelLong,  outBegIdx, outNBElement, foreignerCorrelLong);
		c.correl(startIdx, endIdx, closePrice, orgSumSum, optInTimePeriodCorrelLong,  outBegIdx, outNBElement, orgSumCorrelLong);
		c.correl(startIdx, endIdx, closePrice, finInvestSum, optInTimePeriodCorrelLong,  outBegIdx, outNBElement, finInvestCorrelLong);
		c.correl(startIdx, endIdx, closePrice, insuranceSum, optInTimePeriodCorrelLong,  outBegIdx, outNBElement, insuranceCorrelLong);
		c.correl(startIdx, endIdx, closePrice, investTrustSum, optInTimePeriodCorrelLong,  outBegIdx, outNBElement, investTrustCorrelLong);
		c.correl(startIdx, endIdx, closePrice, bankSum, optInTimePeriodCorrelLong,  outBegIdx, outNBElement, bankCorrelLong);
		c.correl(startIdx, endIdx, closePrice, etcFinSum, optInTimePeriodCorrelLong,  outBegIdx, outNBElement, etcFinCorrelLong);
		c.correl(startIdx, endIdx, closePrice, pensionSum, optInTimePeriodCorrelLong,  outBegIdx, outNBElement, pensionCorrelLong);
		c.correl(startIdx, endIdx, closePrice, etcCorpSum, optInTimePeriodCorrelLong,  outBegIdx, outNBElement, etcCorpCorrelLong);
		c.correl(startIdx, endIdx, closePrice, etcForeignerSum, optInTimePeriodCorrelLong,  outBegIdx, outNBElement, etcForeignerCorrelLong);
		c.correl(startIdx, endIdx, closePrice, privateFundSum, optInTimePeriodCorrelLong,  outBegIdx, outNBElement, privateFundCorrelLong);
		c.correl(startIdx, endIdx, closePrice, nationSum, optInTimePeriodCorrelLong,  outBegIdx, outNBElement, nationCorrelLong);
       
		// 상관도는 Sum 변수와 비교하여 처리.
		c.correl(startIdx, endIdx, closePrice, personalSum, optInTimePeriodCorrelShort,  outBegIdx, outNBElement, personalCorrelShort);
		c.correl(startIdx, endIdx, closePrice, powerSum, optInTimePeriodCorrelShort,  outBegIdx, outNBElement, powerCorrelShort);
		c.correl(startIdx, endIdx, closePrice, leaderSum, optInTimePeriodCorrelShort,  outBegIdx, outNBElement, leaderCorrelShort);
		c.correl(startIdx, endIdx, closePrice, foreignerSum, optInTimePeriodCorrelShort,  outBegIdx, outNBElement, foreignerCorrelShort);
		c.correl(startIdx, endIdx, closePrice, orgSumSum, optInTimePeriodCorrelShort,  outBegIdx, outNBElement, orgSumCorrelShort);
		c.correl(startIdx, endIdx, closePrice, finInvestSum, optInTimePeriodCorrelShort,  outBegIdx, outNBElement, finInvestCorrelShort);
		c.correl(startIdx, endIdx, closePrice, insuranceSum, optInTimePeriodCorrelShort,  outBegIdx, outNBElement, insuranceCorrelShort);
		c.correl(startIdx, endIdx, closePrice, investTrustSum, optInTimePeriodCorrelShort,  outBegIdx, outNBElement, investTrustCorrelShort);
		c.correl(startIdx, endIdx, closePrice, bankSum, optInTimePeriodCorrelShort,  outBegIdx, outNBElement, bankCorrelShort);
		c.correl(startIdx, endIdx, closePrice, etcFinSum, optInTimePeriodCorrelShort,  outBegIdx, outNBElement, etcFinCorrelShort);
		c.correl(startIdx, endIdx, closePrice, pensionSum, optInTimePeriodCorrelShort,  outBegIdx, outNBElement, pensionCorrelShort);
		c.correl(startIdx, endIdx, closePrice, etcCorpSum, optInTimePeriodCorrelShort,  outBegIdx, outNBElement, etcCorpCorrelShort);
		c.correl(startIdx, endIdx, closePrice, etcForeignerSum, optInTimePeriodCorrelShort,  outBegIdx, outNBElement, etcForeignerCorrelShort);
		c.correl(startIdx, endIdx, closePrice, privateFundSum, optInTimePeriodCorrelShort,  outBegIdx, outNBElement, privateFundCorrelShort);
		c.correl(startIdx, endIdx, closePrice, nationSum, optInTimePeriodCorrelShort,  outBegIdx, outNBElement, nationCorrelShort);

		for (int i = 0; i < TOTAL_PERIODS ; i++) {

			if(i>=loopbackCorrelLong){ 
			     liv.get(i).setPersonalCorrelLong( personalCorrelLong[i-loopbackCorrelLong] );
			     liv.get(i).setPowerCorrelLong( powerCorrelLong[i-loopbackCorrelLong] );
			     liv.get(i).setLeaderCorrelLong( leaderCorrelLong[i-loopbackCorrelLong] );
				 liv.get(i).setForeignerCorrelLong( foreignerCorrelLong[i-loopbackCorrelLong] );
				 liv.get(i).setOrgSumCorrelLong( orgSumCorrelLong[i-loopbackCorrelLong] );
				 liv.get(i).setFinInvestCorrelLong( finInvestCorrelLong[i-loopbackCorrelLong] );
				 liv.get(i).setInsuranceCorrelLong( insuranceCorrelLong[i-loopbackCorrelLong] );
				 liv.get(i).setInvestTrustCorrelLong( investTrustCorrelLong[i-loopbackCorrelLong] );
				 liv.get(i).setBankCorrelLong( bankCorrelLong[i-loopbackCorrelLong] );
				 liv.get(i).setEtcFinCorrelLong( etcFinCorrelLong[i-loopbackCorrelLong] );
				 liv.get(i).setPensionCorrelLong( pensionCorrelLong[i-loopbackCorrelLong] );
				 liv.get(i).setEtcCorpCorrelLong( etcCorpCorrelLong[i-loopbackCorrelLong] );
				 liv.get(i).setEtcForeignerCorrelLong( etcForeignerCorrelLong[i-loopbackCorrelLong] );
				 liv.get(i).setPrivateFundCorrelLong( privateFundCorrelLong[i-loopbackCorrelLong] );
				 liv.get(i).setNationCorrelLong( nationCorrelLong[i-loopbackCorrelLong] );
		   }else{ 
			     liv.get(i).setPersonalCorrelLong( 0 );
			     liv.get(i).setPowerCorrelLong( 0 );
			     liv.get(i).setLeaderCorrelLong( 0 );
				 liv.get(i).setForeignerCorrelLong( 0 );
				 liv.get(i).setOrgSumCorrelLong( 0 );
				 liv.get(i).setFinInvestCorrelLong( 0 );
				 liv.get(i).setInsuranceCorrelLong( 0 );
				 liv.get(i).setInvestTrustCorrelLong( 0 );
				 liv.get(i).setBankCorrelLong( 0 );
				 liv.get(i).setEtcFinCorrelLong( 0 );
				 liv.get(i).setPensionCorrelLong( 0 );
				 liv.get(i).setEtcCorpCorrelLong( 0 );
				 liv.get(i).setEtcForeignerCorrelLong( 0 );
				 liv.get(i).setPrivateFundCorrelLong( 0 );
				 liv.get(i).setNationCorrelLong( 0 );
		   } 
		   
			if(i>=loopbackCorrelShort){ 
			     liv.get(i).setPersonalCorrelShort( personalCorrelShort[i-loopbackCorrelShort] );
			     liv.get(i).setPowerCorrelShort( powerCorrelShort[i-loopbackCorrelShort] );
			     liv.get(i).setLeaderCorrelShort( leaderCorrelShort[i-loopbackCorrelShort] );
				 liv.get(i).setForeignerCorrelShort( foreignerCorrelShort[i-loopbackCorrelShort] );
				 liv.get(i).setOrgSumCorrelShort( orgSumCorrelShort[i-loopbackCorrelShort] );
				 liv.get(i).setFinInvestCorrelShort( finInvestCorrelShort[i-loopbackCorrelShort] );
				 liv.get(i).setInsuranceCorrelShort( insuranceCorrelShort[i-loopbackCorrelShort] );
				 liv.get(i).setInvestTrustCorrelShort( investTrustCorrelShort[i-loopbackCorrelShort] );
				 liv.get(i).setBankCorrelShort( bankCorrelShort[i-loopbackCorrelShort] );
				 liv.get(i).setEtcFinCorrelShort( etcFinCorrelShort[i-loopbackCorrelShort] );
				 liv.get(i).setPensionCorrelShort( pensionCorrelShort[i-loopbackCorrelShort] );
				 liv.get(i).setEtcCorpCorrelShort( etcCorpCorrelShort[i-loopbackCorrelShort] );
				 liv.get(i).setEtcForeignerCorrelShort( etcForeignerCorrelShort[i-loopbackCorrelShort] );
				 liv.get(i).setPrivateFundCorrelShort( privateFundCorrelShort[i-loopbackCorrelShort] );
				 liv.get(i).setNationCorrelShort( nationCorrelShort[i-loopbackCorrelShort] );
		   }else{ 
			     liv.get(i).setPersonalCorrelShort( 0 );
			     liv.get(i).setPowerCorrelShort( 0 );
			     liv.get(i).setLeaderCorrelShort( 0 );
				 liv.get(i).setForeignerCorrelShort( 0 );
				 liv.get(i).setOrgSumCorrelShort( 0 );
				 liv.get(i).setFinInvestCorrelShort( 0 );
				 liv.get(i).setInsuranceCorrelShort( 0 );
				 liv.get(i).setInvestTrustCorrelShort( 0 );
				 liv.get(i).setBankCorrelShort( 0 );
				 liv.get(i).setEtcFinCorrelShort( 0 );
				 liv.get(i).setPensionCorrelShort( 0 );
				 liv.get(i).setEtcCorpCorrelShort( 0 );
				 liv.get(i).setEtcForeignerCorrelShort( 0 );
				 liv.get(i).setPrivateFundCorrelShort( 0 );
				 liv.get(i).setNationCorrelShort( 0 );
		   } 
		   
			// Net 순매집 수량 = 누적합계 - 누적 합계 최저점
		   // Collection 계산을 위해 배열변수로 저장하고 있어야 함.
			powerNet[i] = powerSum[i] - powerSumMin[i];
			leaderNet[i] = leaderSum[i] - leaderSumMin[i];
            personalNet[i] = personalSum[i] - personalSumMin[i];
            foreignerNet[i] = foreignerSum[i] - foreignerSumMin[i];
            orgSumNet[i] = orgSumSum[i] - orgSumSumMin[i];
            finInvestNet[i] = finInvestSum[i] - finInvestSumMin[i];
            insuranceNet[i] = insuranceSum[i] - insuranceSumMin[i];
            investTrustNet[i] = investTrustSum[i] - investTrustSumMin[i];
            bankNet[i] = bankSum[i] - bankSumMin[i];
            etcFinNet[i] = etcFinSum[i] - etcFinSumMin[i];
            pensionNet[i] = pensionSum[i] - pensionSumMin[i];
            etcCorpNet[i] = etcCorpSum[i] - etcCorpSumMin[i];
            etcForeignerNet[i] = etcForeignerSum[i] - etcForeignerSumMin[i];
            privateFundNet[i] = privateFundSum[i] - privateFundSumMin[i];
            nationNet[i] = nationSum[i] - nationSumMin[i];
   		
    		// NetMax :  매집 고점 , 최대 순매집 수량 , 최대보유량 
    		//해당 기간까지의 Net만을 대상으로 해야하므로 반드시 여기에 선언
		
			if(i > 0){
				if( personalNet[i] > personalNetMax[i-1]){ personalNetMax[i] = personalNet[i]; }else{  personalNetMax[i] = personalNetMax[i-1]; }
				if( powerNet[i] > powerNetMax[i-1]){ powerNetMax[i] = powerNet[i]; }else{  powerNetMax[i] = powerNetMax[i-1]; }
				if( leaderNet[i] > leaderNetMax[i-1]){ leaderNetMax[i] = leaderNet[i]; }else{  leaderNetMax[i] = leaderNetMax[i-1]; }
				if( foreignerNet[i] > foreignerNetMax[i-1]){ foreignerNetMax[i] = foreignerNet[i]; }else{  foreignerNetMax[i] = foreignerNetMax[i-1]; }
				if( orgSumNet[i] > orgSumNetMax[i-1]){ orgSumNetMax[i] = orgSumNet[i]; }else{  orgSumNetMax[i] = orgSumNetMax[i-1]; }
				if( finInvestNet[i] > finInvestNetMax[i-1]){ finInvestNetMax[i] = finInvestNet[i]; }else{  finInvestNetMax[i] = finInvestNetMax[i-1]; }
				if( insuranceNet[i] > insuranceNetMax[i-1]){ insuranceNetMax[i] = insuranceNet[i]; }else{  insuranceNetMax[i] = insuranceNetMax[i-1]; }
				if( investTrustNet[i] > investTrustNetMax[i-1]){ investTrustNetMax[i] = investTrustNet[i]; }else{  investTrustNetMax[i] = investTrustNetMax[i-1]; }
				if( bankNet[i] > bankNetMax[i-1]){ bankNetMax[i] = bankNet[i]; }else{  bankNetMax[i] = bankNetMax[i-1]; }
				if( etcFinNet[i] > etcFinNetMax[i-1]){ etcFinNetMax[i] = etcFinNet[i]; }else{  etcFinNetMax[i] = etcFinNetMax[i-1]; }
				if( pensionNet[i] > pensionNetMax[i-1]){ pensionNetMax[i] = pensionNet[i]; }else{  pensionNetMax[i] = pensionNetMax[i-1]; }
				if( etcCorpNet[i] > etcCorpNetMax[i-1]){ etcCorpNetMax[i] = etcCorpNet[i]; }else{  etcCorpNetMax[i] = etcCorpNetMax[i-1]; }
				if( etcForeignerNet[i] > etcForeignerNetMax[i-1]){ etcForeignerNetMax[i] = etcForeignerNet[i]; }else{  etcForeignerNetMax[i] = etcForeignerNetMax[i-1]; }
				if( privateFundNet[i] > privateFundNetMax[i-1]){ privateFundNetMax[i] = privateFundNet[i]; }else{  privateFundNetMax[i] = privateFundNetMax[i-1]; }
				if( nationNet[i] > nationNetMax[i-1]){ nationNetMax[i] = nationNet[i]; }else{  nationNetMax[i] = nationNetMax[i-1]; }
			}else{
				personalNetMax[i] = personalNet[i]; 
				powerNetMax[i] = powerNet[i]; 
				leaderNetMax[i] = leaderNet[i]; 
				foreignerNetMax[i] = foreignerNet[i]; 
				orgSumNetMax[i] = orgSumNet[i]; 
				finInvestNetMax[i] = finInvestNet[i]; 
				insuranceNetMax[i] = insuranceNet[i]; 
				investTrustNetMax[i] = investTrustNet[i]; 
				bankNetMax[i] = bankNet[i]; 
				etcFinNetMax[i] = etcFinNet[i]; 
				pensionNetMax[i] = pensionNet[i]; 
				etcCorpNetMax[i] = etcCorpNet[i]; 
				etcForeignerNetMax[i] = etcForeignerNet[i]; 
				privateFundNetMax[i] = privateFundNet[i]; 
				nationNetMax[i] = nationNet[i]; 
			}
			
			// 분산비율 : 순매집수량 / 매집 고점 
			if ( powerNetMax[i]  != 0 ){ 
				liv.get(i).setPowerAccr( powerNet[i] / powerNetMax[i] * 100 );
			}else{ liv.get(i).setPowerAccr( 100.0 ); }
			if ( leaderNetMax[i]  != 0 ){ 
				liv.get(i).setLeaderAccr( leaderNet[i] / leaderNetMax[i] * 100 );
			}else{ liv.get(i).setLeaderAccr( 100.0 ); }
	        if ( personalNetMax[i] != 0 ){ 
	        	liv.get(i).setPersonalAccr(  personalNet[i] / personalNetMax[i] * 100 );
			}else{ liv.get(i).setPersonalAccr(  100.0 );	}
			if ( foreignerNetMax[i]  != 0 ){ 
				liv.get(i).setForeignerAccr(   foreignerNet[i] / foreignerNetMax[i]  * 100 );
			}else{  liv.get(i).setForeignerAccr(  100.0 ); }
			if ( orgSumNetMax[i] != 0 ){ 
				liv.get(i).setOrgSumAccr(  orgSumNet[i] / orgSumNetMax[i] * 100 );
			}else{ liv.get(i).setOrgSumAccr(  100.0 ); }
			if ( finInvestNetMax[i]  != 0 ){ 
				liv.get(i).setFinInvestAccr(   finInvestNet[i] / finInvestNetMax[i] * 100 );
			}else{ liv.get(i).setFinInvestAccr(  100.0 ); }
			if ( insuranceNetMax[i]  != 0 ){ 
				liv.get(i).setInsuranceAccr(   insuranceNet[i] / insuranceNetMax[i] * 100 );
			}else{ liv.get(i).setInsuranceAccr(  100.0 ); }
			if (investTrustNetMax[i]  != 0 ){ 
				liv.get(i).setInvestTrustAccr(   investTrustNet[i] / investTrustNetMax[i] * 100 );
			}else{ liv.get(i).setInvestTrustAccr(  100.0 ); }
			if (bankNetMax[i]  != 0 ){ 
				liv.get(i).setBankAccr(   bankNet[i] / bankNetMax[i] * 100 );
			}else{ liv.get(i).setBankAccr(  100.0 ); }
			if ( etcFinNetMax[i]  != 0 ){ 
				liv.get(i).setEtcFinAccr(   etcFinNet[i] /etcFinNetMax[i] * 100 );
			}else{ liv.get(i).setEtcFinAccr(  100.0 ); }
			if ( pensionNetMax[i]  != 0 ){
				liv.get(i).setPensionAccr(   pensionNet[i] /pensionNetMax[i] * 100 );
			}else{ liv.get(i).setPensionAccr(  100.0 ); }
			if ( etcCorpNetMax[i]  != 0 ){
				liv.get(i).setEtcCorpAccr(   etcCorpNet[i] / etcCorpNetMax[i] * 100 );
			}else{ liv.get(i).setEtcCorpAccr(  100.0 ); }
			if ( etcForeignerNetMax[i]  != 0 ){
				liv.get(i).setEtcForeignerAccr(   etcForeignerNet[i] / etcForeignerNetMax[i] * 100 );
			}else{ liv.get(i).setEtcForeignerAccr(  100.0 ); }
			if (privateFundNetMax[i]  != 0 ){
				liv.get(i).setPrivateFundAccr(   privateFundNet[i] / privateFundNetMax[i] * 100 );
			}else{ liv.get(i).setPrivateFundAccr(  100.0 ); }
			if ( nationNetMax[i]  != 0 ){
				liv.get(i).setNationAccr(   nationNet[i] / nationNetMax[i] * 100 );
			}else{ liv.get(i).setNationAccr(  100.0 ); }

		}	

		// 종료 시간
        long endTime1 = System.currentTimeMillis();
        System.out.println("## 투자주체별 상관/분산비율  소요시간(초.0f) : " + ( endTime1 - startTime1 )/1000.0f +"초"); 
        

        // 시작 시간
        long startTime4 = System.currentTimeMillis();
		

		// SMA
        int optInTimePeriodMA5 = 5;
        int optInTimePeriodMA20 = 20;
        int optInTimePeriodMA60 = 60;
        int optInTimePeriodMA240 = 240;
        int optInTimePeriodMA720 = 720;

        double[] ma5 = new double[TOTAL_PERIODS];
        double[] ma20 = new double[TOTAL_PERIODS];
        double[] ma60 = new double[TOTAL_PERIODS];
        double[] ma240 = new double[TOTAL_PERIODS];
        double[] ma720 = new double[TOTAL_PERIODS];

        double[] volume20 = new double[TOTAL_PERIODS];
        
		//
        c.sma(startIdx, endIdx, closePrice, optInTimePeriodMA5, outBegIdx, outNBElement, ma5);
        c.sma(startIdx, endIdx, closePrice, optInTimePeriodMA20, outBegIdx, outNBElement, ma20);
        c.sma(startIdx, endIdx, volume, optInTimePeriodMA20, outBegIdx, outNBElement, volume20);
        c.sma(startIdx, endIdx, closePrice, optInTimePeriodMA60, outBegIdx, outNBElement, ma60);        
        c.sma(startIdx, endIdx, closePrice, optInTimePeriodMA240, outBegIdx, outNBElement, ma240);   
        c.sma(startIdx, endIdx, closePrice, optInTimePeriodMA720, outBegIdx, outNBElement, ma720);   
        
        //Bollinger Band 20, 2, 2
        int optInTimePeriodBollinger = 20;
        int optInNbDevUp = 2;
        int optInNbDevDn = 2;
        MAType optInMAType = MAType.Sma;
        int loopbackBollinger = optInTimePeriodBollinger-1;
        double[] upperBand = new double[TOTAL_PERIODS];
        double[] middleBand = new double[TOTAL_PERIODS];
        double[] lowerBand = new double[TOTAL_PERIODS];
        c.bbands(startIdx, endIdx, closePrice, optInTimePeriodBollinger, optInNbDevUp, optInNbDevDn, optInMAType, outBegIdx, outNBElement, upperBand, middleBand, lowerBand);
        
        //RSI
        //daily 14 , 9(signal)   
        int optInTimePeriodRSI = 14;
        int optInTimePeriodRSISingal=9;
        int loopbackRSI = optInTimePeriodRSI;
        int loopbackRSISignal = optInTimePeriodRSISingal;
        double[] rsi = new double[TOTAL_PERIODS];
        double[] rsiSignal = new double[TOTAL_PERIODS];
        c.rsi(startIdx, endIdx, closePrice, optInTimePeriodRSI, outBegIdx, outNBElement, rsi);
        c.sma(startIdx, endIdx, rsi, optInTimePeriodRSISingal, outBegIdx, outNBElement, rsiSignal);

        // Stochastic daily 5, 3, 3, 8 
        int optInFastK_Period = 5;
        int optInSlowK_Period = 3;
        int optInSlowD_Period = 3;
        int loopbackStoch = 8;
        MAType optInSlowK_MAType = MAType.Sma;
        MAType optInSlowD_MAType = MAType.Sma;
        double[] slowK = new double[TOTAL_PERIODS];
        double[] slowD = new double[TOTAL_PERIODS];
        
        c.stoch(startIdx, endIdx, highPrice, lowPrice, closePrice, optInFastK_Period, optInSlowK_Period, optInSlowK_MAType, optInSlowD_Period, optInSlowD_MAType, outBegIdx, outNBElement, slowK, slowD);


		 // MACD daily  12, 26, 9, 33 
        int optInFastPeriod = 12;
        int optInSlowPeriod = 26;
        int optInSignalPeriod = 9;
        int loopbackMACD = 33;
        double[] macd = new double[TOTAL_PERIODS];
        double[] macdSignal = new double[TOTAL_PERIODS];
        double[] macdHist = new double[TOTAL_PERIODS];
        
        c.macd(startIdx, endIdx, closePrice, optInFastPeriod, optInSlowPeriod, optInSignalPeriod, outBegIdx, outNBElement, macd, macdSignal, macdHist);

       //================================
		//OutPut Setting to Generic Class
       //================================
        
        double totalNetMax = 0.0;
    
	    for (int i = 0; i < TOTAL_PERIODS ; i++) {
			
      	   // SMA
      	   if(i>=(optInTimePeriodMA5-1)){ 
    			 liv.get(i).setPowerLds5( powerSum[i] - powerSum[i-(optInTimePeriodMA5-1)] );
    			 liv.get(i).setLeaderLds5( leaderSum[i] - leaderSum[i-(optInTimePeriodMA5-1)] );
      			 liv.get(i).setForeignerLds5( foreignerSum[i] - foreignerSum[i-(optInTimePeriodMA5-1)] );
      			 liv.get(i).setOrgSumLds5( orgSumSum[i] - orgSumSum[i-(optInTimePeriodMA5-1)] );
      			 liv.get(i).setPersonalLds5( personalSum[i] - personalSum[i-(optInTimePeriodMA5-1)]  );
         		 liv.get(i).setForeignerLds5( foreignerSum[i] - foreignerSum[i-(optInTimePeriodMA5-1)]  );
         		 liv.get(i).setFinInvestLds5( finInvestSum[i] - finInvestSum[i-(optInTimePeriodMA5-1)]  );
         		 liv.get(i).setInsuranceLds5( insuranceSum[i] - insuranceSum[i-(optInTimePeriodMA5-1)] );
         		 liv.get(i).setInvestTrustLds5( investTrustSum[i] - investTrustSum[i-(optInTimePeriodMA5-1)]  );
         		 liv.get(i).setBankLds5( bankSum[i] - bankSum[i-(optInTimePeriodMA5-1)]  );
         		 liv.get(i).setEtcFinLds5( etcFinSum[i] - etcFinSum[i-(optInTimePeriodMA5-1)] );
         		 liv.get(i).setPensionLds5( pensionSum[i] - pensionSum[i-(optInTimePeriodMA5-1)]  );
         		 liv.get(i).setEtcCorpLds5( etcCorpSum[i] - etcCorpSum[i-(optInTimePeriodMA5-1)]  );
         		 liv.get(i).setEtcForeignerLds5( etcForeignerSum[i] - etcForeignerSum[i-(optInTimePeriodMA5-1)] );
         		 liv.get(i).setPrivateFundLds5( privateFundSum[i] - privateFundSum[i-(optInTimePeriodMA5-1)]  );
         		 liv.get(i).setNationLds5( nationSum[i] - nationSum[i-(optInTimePeriodMA5-1)]  );
        		 liv.get(i).setMa5( ma5[i-(optInTimePeriodMA5-1)] );
       	   }else{ 
    			 liv.get(i).setPowerLds5(0);
    			 liv.get(i).setLeaderLds5(0);
      			 liv.get(i).setForeignerLds5(0);
      			 liv.get(i).setOrgSumLds5(0);
      			 liv.get(i).setPersonalLds5(0);
        		 liv.get(i).setForeignerLds5(0);
        		 liv.get(i).setFinInvestLds5(0);
        		 liv.get(i).setInsuranceLds5(0);
        		 liv.get(i).setInvestTrustLds5(0);
        		 liv.get(i).setBankLds5(0);
        		 liv.get(i).setEtcFinLds5(0);
        		 liv.get(i).setPensionLds5(0);
        		 liv.get(i).setEtcCorpLds5(0);
        		 liv.get(i).setEtcForeignerLds5(0);
        		 liv.get(i).setPrivateFundLds5(0);
        		 liv.get(i).setNationLds5(0);
        		 liv.get(i).setMa5(0);
        	   }
      	 
      	   if(i>=(optInTimePeriodMA20-1)){ 
  			 liv.get(i).setPowerLds20( powerSum[i] - powerSum[i-(optInTimePeriodMA20-1)] );
			 liv.get(i).setLeaderLds20( leaderSum[i] - leaderSum[i-(optInTimePeriodMA20-1)] );
  			 liv.get(i).setForeignerLds20( foreignerSum[i] - foreignerSum[i-(optInTimePeriodMA20-1)] );
  			 liv.get(i).setOrgSumLds20( orgSumSum[i] - orgSumSum[i-(optInTimePeriodMA20-1)] );
  			 liv.get(i).setPersonalLds20( personalSum[i] - personalSum[i-(optInTimePeriodMA20-1)]  );
     		 liv.get(i).setForeignerLds20( foreignerSum[i] - foreignerSum[i-(optInTimePeriodMA20-1)]  );
     		 liv.get(i).setFinInvestLds20( finInvestSum[i] - finInvestSum[i-(optInTimePeriodMA20-1)]  );
     		 liv.get(i).setInsuranceLds20( insuranceSum[i] - insuranceSum[i-(optInTimePeriodMA20-1)] );
     		 liv.get(i).setInvestTrustLds20( investTrustSum[i] - investTrustSum[i-(optInTimePeriodMA20-1)]  );
     		 liv.get(i).setBankLds20( bankSum[i] - bankSum[i-(optInTimePeriodMA20-1)]  );
     		 liv.get(i).setEtcFinLds20( etcFinSum[i] - etcFinSum[i-(optInTimePeriodMA20-1)] );
     		 liv.get(i).setPensionLds20( pensionSum[i] - pensionSum[i-(optInTimePeriodMA20-1)]  );
     		 liv.get(i).setEtcCorpLds20( etcCorpSum[i] - etcCorpSum[i-(optInTimePeriodMA20-1)]  );
     		 liv.get(i).setEtcForeignerLds20( etcForeignerSum[i] - etcForeignerSum[i-(optInTimePeriodMA20-1)] );
     		 liv.get(i).setPrivateFundLds20( privateFundSum[i] - privateFundSum[i-(optInTimePeriodMA20-1)]  );
     		 liv.get(i).setNationLds20( nationSum[i] - nationSum[i-(optInTimePeriodMA20-1)]  );
      		 liv.get(i).setMa20( ma20[i-(optInTimePeriodMA20-1)]  );
     		 liv.get(i).setVolume20( volume20[i-(optInTimePeriodMA20-1)]  );
      	   }else{ 
  			 liv.get(i).setPowerLds20(0);
  			 liv.get(i).setLeaderLds20(0);
  			 liv.get(i).setForeignerLds20(0);
  			 liv.get(i).setOrgSumLds20(0);
  			 liv.get(i).setPersonalLds20(0);
    		 liv.get(i).setForeignerLds20(0);
    		 liv.get(i).setFinInvestLds20(0);
    		 liv.get(i).setInsuranceLds20(0);
    		 liv.get(i).setInvestTrustLds20(0);
    		 liv.get(i).setBankLds20(0);
    		 liv.get(i).setEtcFinLds20(0);
    		 liv.get(i).setPensionLds20(0);
    		 liv.get(i).setEtcCorpLds20(0);
    		 liv.get(i).setEtcForeignerLds20(0);
    		 liv.get(i).setPrivateFundLds20(0);
    		 liv.get(i).setNationLds20(0);
    		 liv.get(i).setMa20(0);
    		 liv.get(i).setVolume20(0);
      	   }
 

      	   if(i>=(optInTimePeriodMA60-1)){ 
			 liv.get(i).setPowerLds60( powerSum[i] - powerSum[i-(optInTimePeriodMA60-1)] );
			 liv.get(i).setLeaderLds60( leaderSum[i] - leaderSum[i-(optInTimePeriodMA60-1)] );
  			 liv.get(i).setForeignerLds60( foreignerSum[i] - foreignerSum[i-(optInTimePeriodMA60-1)] );
  			 liv.get(i).setOrgSumLds60( orgSumSum[i] - orgSumSum[i-(optInTimePeriodMA60-1)] );
  			 liv.get(i).setPersonalLds60( personalSum[i] - personalSum[i-(optInTimePeriodMA60-1)]  );
     		 liv.get(i).setForeignerLds60( foreignerSum[i] - foreignerSum[i-(optInTimePeriodMA60-1)]  );
     		 liv.get(i).setFinInvestLds60( finInvestSum[i] - finInvestSum[i-(optInTimePeriodMA60-1)]  );
     		 liv.get(i).setInsuranceLds60( insuranceSum[i] - insuranceSum[i-(optInTimePeriodMA60-1)] );
     		 liv.get(i).setInvestTrustLds60( investTrustSum[i] - investTrustSum[i-(optInTimePeriodMA60-1)]  );
     		 liv.get(i).setBankLds60( bankSum[i] - bankSum[i-(optInTimePeriodMA60-1)]  );
     		 liv.get(i).setEtcFinLds60( etcFinSum[i] - etcFinSum[i-(optInTimePeriodMA60-1)] );
     		 liv.get(i).setPensionLds60( pensionSum[i] - pensionSum[i-(optInTimePeriodMA60-1)]  );
     		 liv.get(i).setEtcCorpLds60( etcCorpSum[i] - etcCorpSum[i-(optInTimePeriodMA60-1)]  );
     		 liv.get(i).setEtcForeignerLds60( etcForeignerSum[i] - etcForeignerSum[i-(optInTimePeriodMA60-1)] );
     		 liv.get(i).setPrivateFundLds60( privateFundSum[i] - privateFundSum[i-(optInTimePeriodMA60-1)]  );
     		 liv.get(i).setNationLds60( nationSum[i] - nationSum[i-(optInTimePeriodMA60-1)]  );
      		 liv.get(i).setMa60( ma60[i-(optInTimePeriodMA60-1)] );
      	   }else{ 
      		 liv.get(i).setPowerLds60(0);
      		 liv.get(i).setLeaderLds60(0);
      		 liv.get(i).setForeignerLds60(0);
  			 liv.get(i).setOrgSumLds60(0);
  			 liv.get(i).setPersonalLds60(0);
    		 liv.get(i).setForeignerLds60(0);
    		 liv.get(i).setFinInvestLds60(0);
    		 liv.get(i).setInsuranceLds60(0);
    		 liv.get(i).setInvestTrustLds60(0);
    		 liv.get(i).setBankLds60(0);
    		 liv.get(i).setEtcFinLds60(0);
    		 liv.get(i).setPensionLds60(0);
    		 liv.get(i).setEtcCorpLds60(0);
    		 liv.get(i).setEtcForeignerLds60(0);
    		 liv.get(i).setPrivateFundLds60(0);
    		 liv.get(i).setNationLds60(0);
      		 liv.get(i).setMa60(0);
      	   }
      	   
      	   if(i>=(optInTimePeriodMA240-1)){ 
  			 liv.get(i).setPowerLds240( powerSum[i] - powerSum[i-(optInTimePeriodMA240-1)] );
			 liv.get(i).setLeaderLds240( leaderSum[i] - leaderSum[i-(optInTimePeriodMA240-1)] );
  			 liv.get(i).setForeignerLds240( foreignerSum[i] - foreignerSum[i-(optInTimePeriodMA240-1)] );
  			 liv.get(i).setOrgSumLds240( orgSumSum[i] - orgSumSum[i-(optInTimePeriodMA240-1)] );
  			 liv.get(i).setPersonalLds240( personalSum[i] - personalSum[i-(optInTimePeriodMA240-1)]  );
     		 liv.get(i).setForeignerLds240( foreignerSum[i] - foreignerSum[i-(optInTimePeriodMA240-1)]  );
     		 liv.get(i).setFinInvestLds240( finInvestSum[i] - finInvestSum[i-(optInTimePeriodMA240-1)]  );
     		 liv.get(i).setInsuranceLds240( insuranceSum[i] - insuranceSum[i-(optInTimePeriodMA240-1)] );
     		 liv.get(i).setInvestTrustLds240( investTrustSum[i] - investTrustSum[i-(optInTimePeriodMA240-1)]  );
     		 liv.get(i).setBankLds240( bankSum[i] - bankSum[i-(optInTimePeriodMA240-1)]  );
     		 liv.get(i).setEtcFinLds240( etcFinSum[i] - etcFinSum[i-(optInTimePeriodMA240-1)] );
     		 liv.get(i).setPensionLds240( pensionSum[i] - pensionSum[i-(optInTimePeriodMA240-1)]  );
     		 liv.get(i).setEtcCorpLds240( etcCorpSum[i] - etcCorpSum[i-(optInTimePeriodMA240-1)]  );
     		 liv.get(i).setEtcForeignerLds240( etcForeignerSum[i] - etcForeignerSum[i-(optInTimePeriodMA240-1)] );
     		 liv.get(i).setPrivateFundLds240( privateFundSum[i] - privateFundSum[i-(optInTimePeriodMA240-1)]  );
     		 liv.get(i).setNationLds240( nationSum[i] - nationSum[i-(optInTimePeriodMA240-1)]  );
     		 liv.get(i).setMa240( ma240[i-(optInTimePeriodMA240-1)] );
      	   }else{ 
    		 liv.get(i).setPowerLds240(0);
    		 liv.get(i).setLeaderLds240(0);
  			 liv.get(i).setForeignerLds240(0);
  			 liv.get(i).setOrgSumLds240(0);
  			 liv.get(i).setPersonalLds240(0);
    		 liv.get(i).setForeignerLds240(0);
    		 liv.get(i).setFinInvestLds240(0);
    		 liv.get(i).setInsuranceLds240(0);
    		 liv.get(i).setInvestTrustLds240(0);
    		 liv.get(i).setBankLds240(0);
    		 liv.get(i).setEtcFinLds240(0);
    		 liv.get(i).setPensionLds240(0);
    		 liv.get(i).setEtcCorpLds240(0);
    		 liv.get(i).setEtcForeignerLds240(0);
    		 liv.get(i).setPrivateFundLds240(0);
    		 liv.get(i).setNationLds240(0);
    		 liv.get(i).setMa240(0);
      	   }
      	   
      	 if(i>=(optInTimePeriodMA720-1)){ 
  			 liv.get(i).setPowerLds720( powerSum[i] - powerSum[i-(optInTimePeriodMA720-1)] );
			 liv.get(i).setLeaderLds720( leaderSum[i] - leaderSum[i-(optInTimePeriodMA720-1)] );
  			 liv.get(i).setForeignerLds720( foreignerSum[i] - foreignerSum[i-(optInTimePeriodMA720-1)] );
  			 liv.get(i).setOrgSumLds720( orgSumSum[i] - orgSumSum[i-(optInTimePeriodMA720-1)] );
  			 liv.get(i).setPersonalLds720( personalSum[i] - personalSum[i-(optInTimePeriodMA720-1)]  );
     		 liv.get(i).setForeignerLds720( foreignerSum[i] - foreignerSum[i-(optInTimePeriodMA720-1)]  );
     		 liv.get(i).setFinInvestLds720( finInvestSum[i] - finInvestSum[i-(optInTimePeriodMA720-1)]  );
     		 liv.get(i).setInsuranceLds720( insuranceSum[i] - insuranceSum[i-(optInTimePeriodMA720-1)] );
     		 liv.get(i).setInvestTrustLds720( investTrustSum[i] - investTrustSum[i-(optInTimePeriodMA720-1)]  );
     		 liv.get(i).setBankLds720( bankSum[i] - bankSum[i-(optInTimePeriodMA720-1)]  );
     		 liv.get(i).setEtcFinLds720( etcFinSum[i] - etcFinSum[i-(optInTimePeriodMA720-1)] );
     		 liv.get(i).setPensionLds720( pensionSum[i] - pensionSum[i-(optInTimePeriodMA720-1)]  );
     		 liv.get(i).setEtcCorpLds720( etcCorpSum[i] - etcCorpSum[i-(optInTimePeriodMA720-1)]  );
     		 liv.get(i).setEtcForeignerLds720( etcForeignerSum[i] - etcForeignerSum[i-(optInTimePeriodMA720-1)] );
     		 liv.get(i).setPrivateFundLds720( privateFundSum[i] - privateFundSum[i-(optInTimePeriodMA720-1)]  );
     		 liv.get(i).setNationLds720( nationSum[i] - nationSum[i-(optInTimePeriodMA720-1)]  );
     		 liv.get(i).setMa720( ma720[i-(optInTimePeriodMA720-1)] );
     		 
 		    
 			totalNetMax = Math.abs(liv.get(i).getPersonalLds720()) + Math.abs(liv.get(i).getForeignerLds720()) + Math.abs(liv.get(i).getFinInvestLds720())
 					+ Math.abs(liv.get(i).getInsuranceLds720()) + Math.abs(liv.get(i).getInvestTrustLds720()) + Math.abs(liv.get(i).getEtcFinLds720())
 					+ Math.abs(liv.get(i).getBankLds720()) + Math.abs(liv.get(i).getPensionLds720()) + Math.abs(liv.get(i).getPrivateFundLds720())
 					+ Math.abs(liv.get(i).getNationLds720()) + Math.abs(liv.get(i).getEtcForeignerLds720()) + Math.abs(liv.get(i).getEtcCorpLds720());

 			if(totalNetMax == 0.0 ) totalNetMax = 1;
      		
      		// 주가 선도 비중 
      		liv.get(i).setPersonalLeadingRatio( Math.abs(liv.get(i).getPersonalLds720())/totalNetMax*100 );
      		liv.get(i).setForeignerLeadingRatio( Math.abs(liv.get(i).getForeignerLds720())/totalNetMax*100 );
      		liv.get(i).setFinInvestLeadingRatio( Math.abs(liv.get(i).getFinInvestLds720())/totalNetMax*100 );
      		liv.get(i).setInsuranceLeadingRatio( Math.abs(liv.get(i).getInsuranceLds720())/totalNetMax*100 );
      		liv.get(i).setInvestTrustLeadingRatio( Math.abs(liv.get(i).getInvestTrustLds720())/totalNetMax*100 );
      		liv.get(i).setBankLeadingRatio( Math.abs(liv.get(i).getBankLds720())/totalNetMax*100 );
      		liv.get(i).setEtcFinLeadingRatio( Math.abs(liv.get(i).getEtcFinLds720())/totalNetMax*100 );
      		liv.get(i).setPensionLeadingRatio( Math.abs(liv.get(i).getPensionLds720())/totalNetMax*100 );
      		liv.get(i).setEtcCorpLeadingRatio( Math.abs(liv.get(i).getEtcCorpLds720())/totalNetMax*100 );
      		liv.get(i).setEtcForeignerLeadingRatio( Math.abs(liv.get(i).getEtcForeignerLds720())/totalNetMax*100 );
      		liv.get(i).setPrivateFundLeadingRatio( Math.abs(liv.get(i).getPrivateFundLds720())/totalNetMax*100 );
      		liv.get(i).setNationLeadingRatio( Math.abs(liv.get(i).getNationLds720())/totalNetMax*100 );
      		liv.get(i).setOrgSumLeadingRatio( Math.abs(liv.get(i).getOrgSumLds720()/totalNetMax*100));
      		liv.get(i).setLeaderLeadingRatio( Math.abs(liv.get(i).getLeaderLds720()/totalNetMax*100));
      		liv.get(i).setPowerLeadingRatio( Math.abs(liv.get(i).getPowerLds720()/totalNetMax*100));
/*      		liv.get(i).setOrgSumLeadingRatio(
      				Math.abs(liv.get(i).getFinInvestLds720()+ liv.get(i).getInsuranceLds720()
 					+ liv.get(i).getInvestTrustLds720() + liv.get(i).getEtcFinLds720() +
 		            + liv.get(i).getBankLds720() + liv.get(i).getPensionLds720() + liv.get(i).getPrivateFundLds720()
 		        	+ liv.get(i).getNationLds720() +liv.get(i).getEtcForeignerLds720()+liv.get(i).getEtcCorpLds720())/totalNetMax*100);
      		liv.get(i).setPowerLeadingRatio(Math.abs(liv.get(i).getForeignerLds720()+liv.get(i).getFinInvestLds720()+ liv.get(i).getInsuranceLds720()
 					+ liv.get(i).getInvestTrustLds720() + liv.get(i).getEtcFinLds720() +
 		            + liv.get(i).getBankLds720() + liv.get(i).getPensionLds720() + liv.get(i).getPrivateFundLds720()
 		        	+ liv.get(i).getNationLds720() +liv.get(i).getEtcForeignerLds720()+liv.get(i).getEtcCorpLds720())/totalNetMax*100);
      		liv.get(i).setLeaderLeadingRatio(Math.abs(liv.get(i).getForeignerLds720()+
      				+ liv.get(i).getInvestTrustLds720() + liv.get(i).getPensionLds720() )/totalNetMax*100);
*/
      		
     		liv.get(i).setPersonalWL(liv.get(i).getPersonalCorrelLong()*liv.get(i).getPersonalLeadingRatio());
     		liv.get(i).setPowerWL(liv.get(i).getPowerCorrelLong()*liv.get(i).getPowerLeadingRatio());
     		liv.get(i).setLeaderWL(liv.get(i).getLeaderCorrelLong()*liv.get(i).getLeaderLeadingRatio());
     		liv.get(i).setForeignerWL(liv.get(i).getForeignerCorrelLong()*liv.get(i).getForeignerLeadingRatio());
     		liv.get(i).setOrgSumWL(liv.get(i).getOrgSumCorrelLong()*liv.get(i).getOrgSumLeadingRatio());
     		liv.get(i).setFinInvestWL(liv.get(i).getFinInvestCorrelLong()*liv.get(i).getFinInvestLeadingRatio());
     		liv.get(i).setInsuranceWL(liv.get(i).getInsuranceCorrelLong()*liv.get(i).getInsuranceLeadingRatio());
     		liv.get(i).setInvestTrustWL(liv.get(i).getInvestTrustCorrelLong()*liv.get(i).getInvestTrustLeadingRatio());
     		liv.get(i).setBankWL(liv.get(i).getBankCorrelLong()*liv.get(i).getBankLeadingRatio());
     		liv.get(i).setEtcFinWL(liv.get(i).getEtcFinCorrelLong()*liv.get(i).getEtcFinLeadingRatio());
     		liv.get(i).setPensionWL(liv.get(i).getPensionCorrelLong()*liv.get(i).getPensionLeadingRatio());
     		liv.get(i).setPrivateFundWL(liv.get(i).getPrivateFundCorrelLong()*liv.get(i).getPrivateFundLeadingRatio());
     		liv.get(i).setNationWL(liv.get(i).getNationCorrelLong()*liv.get(i).getNationLeadingRatio());
     		liv.get(i).setEtcForeignerWL(liv.get(i).getEtcForeignerCorrelLong()*liv.get(i).getEtcForeignerLeadingRatio());
     		liv.get(i).setEtcCorpWL(liv.get(i).getEtcCorpCorrelLong()*liv.get(i).getEtcCorpLeadingRatio());

      	   }else{ 
    		 liv.get(i).setPowerLds720(0);
    		 liv.get(i).setLeaderLds720(0);
    		 liv.get(i).setForeignerLds720(0);
  			 liv.get(i).setOrgSumLds720(0);
  			 liv.get(i).setPersonalLds720(0);
    		 liv.get(i).setForeignerLds720(0);
    		 liv.get(i).setFinInvestLds720(0);
    		 liv.get(i).setInsuranceLds720(0);
    		 liv.get(i).setInvestTrustLds720(0);
    		 liv.get(i).setBankLds720(0);
    		 liv.get(i).setEtcFinLds720(0);
    		 liv.get(i).setPensionLds720(0);
    		 liv.get(i).setEtcCorpLds720(0);
    		 liv.get(i).setEtcForeignerLds720(0);
    		 liv.get(i).setPrivateFundLds720(0);
    		 liv.get(i).setNationLds720(0);
    		 liv.get(i).setMa720(0);
      	   }

 
		   //Bollinger Band
	       if(i>= loopbackBollinger){ 
	    	   liv.get(i).setUpperBand( upperBand[i-loopbackBollinger] ); 
	    	   liv.get(i).setMiddleBand( middleBand[i-loopbackBollinger] ); 
	    	   liv.get(i).setLowerBand( lowerBand[i-loopbackBollinger] );
	    	   
	       	}else{
	       	   liv.get(i).setUpperBand( 0 ); 
	    	   liv.get(i).setMiddleBand( 0 ); 
	    	   liv.get(i).setLowerBand( 0 );
	       	}
	       
	       //RSI
	       if(i>= ( loopbackRSI+loopbackRSISignal -1 ) ){ 
	    	   liv.get(i).setRsi(rsi[i-loopbackRSI]); 
	    	   liv.get(i).setRsiSignal(rsiSignal[i- ( loopbackRSI + loopbackRSISignal - 1) ]);
	    	   liv.get(i).setRsiHist(liv.get(i).getRsi()-liv.get(i).getRsiSignal());
	       }else{ 
	    	   liv.get(i).setRsi(0); 
	    	   liv.get(i).setRsiSignal(0);
	    	   liv.get(i).setRsiHist(0);
	       } 
	       
	       //Stoch
	       if(i>= loopbackStoch){ 
	    	   liv.get(i).setSlowK( slowK[i-loopbackStoch] ); 
	    	   liv.get(i).setSlowD( slowD[i-loopbackStoch] );  
	    	   liv.get(i).setStochHist(liv.get(i).getSlowK()-liv.get(i).getSlowD());
	       }else{ 
	    	   liv.get(i).setSlowK( 0 ); 
	    	   liv.get(i).setSlowD( 0 );
	    	   liv.get(i).setStochHist(0);
	       } 
	       
      	   //MACD
	       if(i>= loopbackMACD){ 
	    		liv.get(i).setMacd(macd[i- loopbackMACD]);
	    	    liv.get(i).setMacdSignal(macdSignal[i- loopbackMACD]);
	    		liv.get(i).setMacdHist(macdHist[i- loopbackMACD]);
	    		liv.get(i).setMacdRate(liv.get(i).getMacd()*100/liv.get(i).getClosePrice());
	       }else{ 
	    		liv.get(i).setMacd(0);
	    	    liv.get(i).setMacdSignal(0);
	    		liv.get(i).setMacdHist(0);
	    		liv.get(i).setMacdRate(0);
	       } 
	    }
		// 종료 시간
        long endTime4 = System.currentTimeMillis();
        System.out.println("## 주가관련지표  소요시간(초.0f) : " + ( endTime4 - startTime4 )/1000.0f +"초"); 
		}catch(Exception e)
		{
			StackTraceElement[] elem = e.getStackTrace();
			   for ( int i = 0; i < elem.length; i++ )
				   System.out.println("예외 " + elem[i] +""); 
		}
	        
	  return liv;
    }

}