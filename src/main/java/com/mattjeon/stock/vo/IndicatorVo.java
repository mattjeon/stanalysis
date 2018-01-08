
/*
 * Copyright (c) 2014. Lorem ipsum dolor sit ametprivate String  consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.mattjeon.stock.vo;
  
/** 
 * Created by jeon-yeongsu on 2014. 6. 17..
 */
public class IndicatorVo {
     
    // 湲곗큹  
	private String companyCode;  
	private String companyName;
	private String regDate;
	
    // 媛�寃�     
	private double openPrice; 
	private double highPrice; 
	private double lowPrice;
	private double closePrice;
	private double updownRatio;
	private double volume; 
	private double volume20;
	private double industryPrice;
	
	private double closePriceSum;
    
	// �닔湲� 
	 private double    personal;
	 private double    power;	
	 private double    leader;
	 private double    foreigner;
	 private double    orgSum;
	 private double    finInvest;
	 private double    insurance;
	 private double    investTrust;
	 private double    bank;
	 private double    etcFin;
	 private double    pension;
	 private double    privateFund;
	 private double    nation;
	 private double    etcForeigner;
	 private double    etcCorp;

	 
	 private double    personalSum;
     private double    powerSum;
     private double    leaderSum;
     private double    foreignerSum;
     private double    orgSumSum;
     private double    finInvestSum;
     private double    insuranceSum;
     private double    investTrustSum;
     private double    bankSum;
     private double    etcFinSum;
     private double    pensionSum;
     private double    privateFundSum;
     private double    nationSum; 
	 private double    etcForeignerSum;
	 private double    etcCorpSum;
	  
    //遺꾩궛鍮꾩쑉  ( 留ㅼ쭛�닔�웾 / 留ㅼ쭛 怨좎젏 )
	 private double    personalAccr;
	 private double    powerAccr;
	 private double    leaderAccr;
	 private double    foreignerAccr;
	 private double    orgSumAccr;
	 private double    finInvestAccr;
	 private double    insuranceAccr;
	 private double    investTrustAccr;
	 private double    bankAccr;
	 private double    etcFinAccr;
	 private double    pensionAccr;
	 private double    privateFundAccr;
	 private double    nationAccr;
	 private double    etcForeignerAccr;
	 private double    etcCorpAccr;
 
     
	 // �꽭�젰媛� ( �쁽 蹂댁쑀 鍮꾩쨷 )
	/* private double    personalRelNetRatio;
	 private double    powerRelNetRatio;	
	 private double    foreignerRelNetRatio;
	 private double    orgSumRelNetRatio;
	 private double    finInvestRelNetRatio;
	 private double    insuranceRelNetRatio;
	 private double    investTrustRelNetRatio;
	 private double    bankRelNetRatio;
	 private double    etcFinRelNetRatio;
	 private double    pensionRelNetRatio;
	 private double    privateFundRelNetRatio;
	 private double    nationRelNetRatio;
	 private double    etcForeignerRelNetRatio;
	 private double    etcCorpRelNetRatio;*/
	 
     //二쇨� �꽑�룄 鍮꾩쨷 (怨쇨굅 �쁺�뼢�젰 )
	 private double    personalLeadingRatio;
	 private double    powerLeadingRatio;	
	 private double    leaderLeadingRatio;
	 private double    foreignerLeadingRatio;
	 private double    orgSumLeadingRatio;
	 private double    finInvestLeadingRatio;
	 private double    insuranceLeadingRatio;
	 private double    investTrustLeadingRatio;
	 private double    bankLeadingRatio;
	 private double    etcFinLeadingRatio;
	 private double    pensionLeadingRatio;
	 private double    privateFundLeadingRatio;
	 private double    nationLeadingRatio;
	 private double    etcForeignerLeadingRatio;
	 private double    etcCorpLeadingRatio;
	    	 
	 //�옣湲� �긽愿��룄

	 private double    personalCorrelLong;
	 private double    powerCorrelLong;
	 private double    leaderCorrelLong;
	 private double    foreignerCorrelLong;
	 private double    orgSumCorrelLong;
	 private double    finInvestCorrelLong;
	 private double    insuranceCorrelLong;
	 private double    investTrustCorrelLong;
	 private double    bankCorrelLong;
	 private double    etcFinCorrelLong;
	 private double    pensionCorrelLong;
	 private double    privateFundCorrelLong;
	 private double    nationCorrelLong;
	 private double    etcForeignerCorrelLong;
	 private double    etcCorpCorrelLong;

	 //�옣湲� �긽愿��룄
	 private double    personalCorrelShort;
	 private double    powerCorrelShort;
	 private double    leaderCorrelShort;
	 private double    foreignerCorrelShort;
	 private double    orgSumCorrelShort;
	 private double    finInvestCorrelShort;
	 private double    insuranceCorrelShort;
	 private double    investTrustCorrelShort;
	 private double    bankCorrelShort;
	 private double    etcFinCorrelShort;
	 private double    pensionCorrelShort;
	 private double    privateFundCorrelShort;
	 private double    nationCorrelShort;
	 private double    etcForeignerCorrelShort;
	 private double    etcCorpCorrelShort;

	//�듅�뙣援щ텇 
	private double personalWL;
	private double powerWL;
	private double leaderWL;
	private double foreignerWL;
	private double orgSumWL;
	private double finInvestWL;
	private double insuranceWL;
	private double investTrustWL;
	private double bankWL;
	private double etcFinWL;
	private double pensionWL;
	private double nationWL;
	private double etcForeignerWL;
	private double privateFundWL;
	private double etcCorpWL; 
	
	private double    personalLds5;
	 private double    powerLds5;	
	 private double    leaderLds5;
	 private double    foreignerLds5;
	 private double    orgSumLds5;
	 private double    finInvestLds5;
	 private double    insuranceLds5;
	 private double    investTrustLds5;
	 private double    bankLds5;
	 private double    etcFinLds5;
	 private double    pensionLds5;
	 private double    privateFundLds5;
	 private double    nationLds5;
	 private double    etcForeignerLds5;
	 private double    etcCorpLds5;

	 private double    personalLds20;
	 private double    powerLds20;	
	 private double    leaderLds20;
	 private double    foreignerLds20;
	 private double    orgSumLds20;
	 private double    finInvestLds20;
	 private double    insuranceLds20;
	 private double    investTrustLds20;
	 private double    bankLds20;
	 private double    etcFinLds20;
	 private double    pensionLds20;
	 private double    privateFundLds20;
	 private double    nationLds20;
	 private double    etcForeignerLds20;
	 private double    etcCorpLds20;

	 private double    personalLds60;
	 private double    powerLds60;	
	 private double    leaderLds60;
	 private double    foreignerLds60;
	 private double    orgSumLds60;
	 private double    finInvestLds60;
	 private double    insuranceLds60;
	 private double    investTrustLds60;
	 private double    bankLds60;
	 private double    etcFinLds60;
	 private double    pensionLds60;
	 private double    privateFundLds60;
	 private double    nationLds60;
	 private double    etcForeignerLds60;
	 private double    etcCorpLds60;
 
	 //1년 LDS
	 private double    personalLds240;
	 private double    powerLds240;	
	 private double    leaderLds240;
	 private double    foreignerLds240;
	 private double    orgSumLds240;
	 private double    etcSumLds240;
	 private double    finInvestLds240;
	 private double    insuranceLds240;
	 private double    investTrustLds240;
	 private double    bankLds240;
	 private double    etcFinLds240;
	 private double    pensionLds240;
	 private double    privateFundLds240;
	 private double    nationLds240;
	 private double    etcForeignerLds240;
	 private double    etcCorpLds240;

	 //1년 LDS
	 private double    personalLds720;
	 private double    powerLds720;	
	 private double    leaderLds720;
	 private double    foreignerLds720;
	 private double    orgSumLds720;
	 private double    etcSumLds720;
	 private double    finInvestLds720;
	 private double    insuranceLds720;
	 private double    investTrustLds720;
	 private double    bankLds720;
	 private double    etcFinLds720;
	 private double    pensionLds720;
	 private double    privateFundLds720;
	 private double    nationLds720;
	 private double    etcForeignerLds720;
	 private double    etcCorpLds720;
	 
	//媛�寃� 吏��몴媛�
	private double ma5;
	private double ma20;
	private double ma60;
	private double ma240;
	private double ma720;

/*	
	private double longTrendRLine;
	private double longTrendSLine;
	
	private double midTrendRLine;
	private double midTrendSLine;

	private double shortTrendRLine;
	private double shortTrendSLine;
	
	private double longTrendRLineC;
	private double longTrendSLineC;
	
	private double midTrendRLineC;
	private double midTrendSLineC;

	private double shortTrendRLineC;
	private double shortTrendSLineC;
*/
    //吏��몴   
	private double macd;
	private double macdSignal;
	private double macdHist;
	private double macdRate;
	private double slowK;
	private double slowD;
	private double stochHist;
	private double rsi;
	private double rsiSignal;
	private double rsiHist;
	private double upperBand;
	private double middleBand; 
	private double lowerBand;
	private double obv;

    private int tradeSignal;
    private int tradeSignalPower;
    private int tradeSignalLeader;
    private int tradeSignalForeigner;
    private int tradeSignalOrgSum;

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public double getOpenPrice() {
		return openPrice;
	}

	public void setOpenPrice(double openPrice) {
		this.openPrice = openPrice;
	}

	public double getHighPrice() {
		return highPrice;
	}

	public void setHighPrice(double highPrice) {
		this.highPrice = highPrice;
	}

	public double getLowPrice() {
		return lowPrice;
	}

	public void setLowPrice(double lowPrice) {
		this.lowPrice = lowPrice;
	}

	public double getClosePrice() {
		return closePrice;
	}

	public void setClosePrice(double closePrice) {
		this.closePrice = closePrice;
	}

	public double getUpdownRatio() {
		return updownRatio;
	}

	public void setUpdownRatio(double updownRatio) {
		this.updownRatio = updownRatio;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	public double getIndustryPrice() {
		return industryPrice;
	}

	public void setIndustryPrice(double industryPrice) {
		this.industryPrice = industryPrice;
	}


	public double getPersonal() {
		return personal;
	}

	public void setPersonal(double personal) {
		this.personal = personal;
	}

	public double getPower() {
		return power;
	}

	public void setPower(double power) {
		this.power = power;
	}

	public double getForeigner() {
		return foreigner;
	}

	public void setForeigner(double foreigner) {
		this.foreigner = foreigner;
	}

	public double getOrgSum() {
		return orgSum;
	}

	public void setOrgSum(double orgSum) {
		this.orgSum = orgSum;
	}

	public double getFinInvest() {
		return finInvest;
	}

	public void setFinInvest(double finInvest) {
		this.finInvest = finInvest;
	}

	public double getInsurance() {
		return insurance;
	}

	public void setInsurance(double insurance) {
		this.insurance = insurance;
	}

	public double getInvestTrust() {
		return investTrust;
	}

	public void setInvestTrust(double investTrust) {
		this.investTrust = investTrust;
	}

	public double getBank() {
		return bank;
	}

	public void setBank(double bank) {
		this.bank = bank;
	}

	public double getEtcFin() {
		return etcFin;
	}

	public void setEtcFin(double etcFin) {
		this.etcFin = etcFin;
	}

	public double getPension() {
		return pension;
	}

	public void setPension(double pension) {
		this.pension = pension;
	}

	public double getPrivateFund() {
		return privateFund;
	}

	public void setPrivateFund(double privateFund) {
		this.privateFund = privateFund;
	}

	public double getNation() {
		return nation;
	}

	public void setNation(double nation) {
		this.nation = nation;
	}

	public double getEtcForeigner() {
		return etcForeigner;
	}

	public void setEtcForeigner(double etcForeigner) {
		this.etcForeigner = etcForeigner;
	}

	public double getEtcCorp() {
		return etcCorp;
	}

	public void setEtcCorp(double etcCorp) {
		this.etcCorp = etcCorp;
	}

	public double getPersonalSum() {
		return personalSum;
	}

	public void setPersonalSum(double personalSum) {
		this.personalSum = personalSum;
	}

	public double getPowerSum() {
		return powerSum;
	}

	public void setPowerSum(double powerSum) {
		this.powerSum = powerSum;
	}

	public double getForeignerSum() {
		return foreignerSum;
	}

	public void setForeignerSum(double foreignerSum) {
		this.foreignerSum = foreignerSum;
	}

	public double getOrgSumSum() {
		return orgSumSum;
	}

	public void setOrgSumSum(double orgSumSum) {
		this.orgSumSum = orgSumSum;
	}

	public double getFinInvestSum() {
		return finInvestSum;
	}

	public void setFinInvestSum(double finInvestSum) {
		this.finInvestSum = finInvestSum;
	}

	public double getInsuranceSum() {
		return insuranceSum;
	}

	public void setInsuranceSum(double insuranceSum) {
		this.insuranceSum = insuranceSum;
	}

	public double getInvestTrustSum() {
		return investTrustSum;
	}

	public void setInvestTrustSum(double investTrustSum) {
		this.investTrustSum = investTrustSum;
	}

	public double getBankSum() {
		return bankSum;
	}

	public void setBankSum(double bankSum) {
		this.bankSum = bankSum;
	}

	public double getEtcFinSum() {
		return etcFinSum;
	}

	public void setEtcFinSum(double etcFinSum) {
		this.etcFinSum = etcFinSum;
	}

	public double getPensionSum() {
		return pensionSum;
	}

	public void setPensionSum(double pensionSum) {
		this.pensionSum = pensionSum;
	}

	public double getPrivateFundSum() {
		return privateFundSum;
	}

	public void setPrivateFundSum(double privateFundSum) {
		this.privateFundSum = privateFundSum;
	}

	public double getNationSum() {
		return nationSum;
	}

	public void setNationSum(double nationSum) {
		this.nationSum = nationSum;
	}

	public double getEtcForeignerSum() {
		return etcForeignerSum;
	}

	public void setEtcForeignerSum(double etcForeignerSum) {
		this.etcForeignerSum = etcForeignerSum;
	}

	public double getEtcCorpSum() {
		return etcCorpSum;
	}

	public void setEtcCorpSum(double etcCorpSum) {
		this.etcCorpSum = etcCorpSum;
	}


/*
	public double getPersonalRelNetRatio() {
		return personalRelNetRatio;
	}

	public void setPersonalRelNetRatio(double personalRelNetRatio) {
		this.personalRelNetRatio = personalRelNetRatio;
	}

	public double getPowerRelNetRatio() {
		return powerRelNetRatio;
	}

	public void setPowerRelNetRatio(double powerRelNetRatio) {
		this.powerRelNetRatio = powerRelNetRatio;
	}

	public double getForeignerRelNetRatio() {
		return foreignerRelNetRatio;
	}

	public void setForeignerRelNetRatio(double foreignerRelNetRatio) {
		this.foreignerRelNetRatio = foreignerRelNetRatio;
	}

	public double getOrgSumRelNetRatio() {
		return orgSumRelNetRatio;
	}

	public void setOrgSumRelNetRatio(double orgSumRelNetRatio) {
		this.orgSumRelNetRatio = orgSumRelNetRatio;
	}

	public double getFinInvestRelNetRatio() {
		return finInvestRelNetRatio;
	}

	public void setFinInvestRelNetRatio(double finInvestRelNetRatio) {
		this.finInvestRelNetRatio = finInvestRelNetRatio;
	}

	public double getInsuranceRelNetRatio() {
		return insuranceRelNetRatio;
	}

	public void setInsuranceRelNetRatio(double insuranceRelNetRatio) {
		this.insuranceRelNetRatio = insuranceRelNetRatio;
	}

	public double getInvestTrustRelNetRatio() {
		return investTrustRelNetRatio;
	}

	public void setInvestTrustRelNetRatio(double investTrustRelNetRatio) {
		this.investTrustRelNetRatio = investTrustRelNetRatio;
	}

	public double getBankRelNetRatio() {
		return bankRelNetRatio;
	}

	public void setBankRelNetRatio(double bankRelNetRatio) {
		this.bankRelNetRatio = bankRelNetRatio;
	}

	public double getEtcFinRelNetRatio() {
		return etcFinRelNetRatio;
	}

	public void setEtcFinRelNetRatio(double etcFinRelNetRatio) {
		this.etcFinRelNetRatio = etcFinRelNetRatio;
	}

	public double getPensionRelNetRatio() {
		return pensionRelNetRatio;
	}

	public void setPensionRelNetRatio(double pensionRelNetRatio) {
		this.pensionRelNetRatio = pensionRelNetRatio;
	}

	public double getPrivateFundRelNetRatio() {
		return privateFundRelNetRatio;
	}

	public void setPrivateFundRelNetRatio(double privateFundRelNetRatio) {
		this.privateFundRelNetRatio = privateFundRelNetRatio;
	}

	public double getNationRelNetRatio() {
		return nationRelNetRatio;
	}

	public void setNationRelNetRatio(double nationRelNetRatio) {
		this.nationRelNetRatio = nationRelNetRatio;
	}

	public double getEtcForeignerRelNetRatio() {
		return etcForeignerRelNetRatio;
	}

	public void setEtcForeignerRelNetRatio(double etcForeignerRelNetRatio) {
		this.etcForeignerRelNetRatio = etcForeignerRelNetRatio;
	}

	public double getEtcCorpRelNetRatio() {
		return etcCorpRelNetRatio;
	}

	public void setEtcCorpRelNetRatio(double etcCorpRelNetRatio) {
		this.etcCorpRelNetRatio = etcCorpRelNetRatio;
	}*/

	public double getPersonalLeadingRatio() {
		return personalLeadingRatio;
	}

	public void setPersonalLeadingRatio(double personalLeadingRatio) {
		this.personalLeadingRatio = personalLeadingRatio;
	}

	public double getPowerLeadingRatio() {
		return powerLeadingRatio;
	}

	public void setPowerLeadingRatio(double powerLeadingRatio) {
		this.powerLeadingRatio = powerLeadingRatio;
	}

	public double getForeignerLeadingRatio() {
		return foreignerLeadingRatio;
	}

	public void setForeignerLeadingRatio(double foreignerLeadingRatio) {
		this.foreignerLeadingRatio = foreignerLeadingRatio;
	}

	public double getOrgSumLeadingRatio() {
		return orgSumLeadingRatio;
	}

	public void setOrgSumLeadingRatio(double orgSumLeadingRatio) {
		this.orgSumLeadingRatio = orgSumLeadingRatio;
	}

	public double getFinInvestLeadingRatio() {
		return finInvestLeadingRatio;
	}

	public void setFinInvestLeadingRatio(double finInvestLeadingRatio) {
		this.finInvestLeadingRatio = finInvestLeadingRatio;
	}

	public double getInsuranceLeadingRatio() {
		return insuranceLeadingRatio;
	}

	public void setInsuranceLeadingRatio(double insuranceLeadingRatio) {
		this.insuranceLeadingRatio = insuranceLeadingRatio;
	}

	public double getInvestTrustLeadingRatio() {
		return investTrustLeadingRatio;
	}

	public void setInvestTrustLeadingRatio(double investTrustLeadingRatio) {
		this.investTrustLeadingRatio = investTrustLeadingRatio;
	}

	public double getBankLeadingRatio() {
		return bankLeadingRatio;
	}

	public void setBankLeadingRatio(double bankLeadingRatio) {
		this.bankLeadingRatio = bankLeadingRatio;
	}

	public double getEtcFinLeadingRatio() {
		return etcFinLeadingRatio;
	}

	public void setEtcFinLeadingRatio(double etcFinLeadingRatio) {
		this.etcFinLeadingRatio = etcFinLeadingRatio;
	}

	public double getPensionLeadingRatio() {
		return pensionLeadingRatio;
	}

	public void setPensionLeadingRatio(double pensionLeadingRatio) {
		this.pensionLeadingRatio = pensionLeadingRatio;
	}

	public double getPrivateFundLeadingRatio() {
		return privateFundLeadingRatio;
	}

	public void setPrivateFundLeadingRatio(double privateFundLeadingRatio) {
		this.privateFundLeadingRatio = privateFundLeadingRatio;
	}

	public double getNationLeadingRatio() {
		return nationLeadingRatio;
	}

	public void setNationLeadingRatio(double nationLeadingRatio) {
		this.nationLeadingRatio = nationLeadingRatio;
	}

	public double getEtcForeignerLeadingRatio() {
		return etcForeignerLeadingRatio;
	}

	public void setEtcForeignerLeadingRatio(double etcForeignerLeadingRatio) {
		this.etcForeignerLeadingRatio = etcForeignerLeadingRatio;
	}

	public double getEtcCorpLeadingRatio() {
		return etcCorpLeadingRatio;
	}

	public void setEtcCorpLeadingRatio(double etcCorpLeadingRatio) {
		this.etcCorpLeadingRatio = etcCorpLeadingRatio;
	}

	public double getPersonalCorrelLong() {
		return personalCorrelLong;
	}

	public void setPersonalCorrelLong(double personalCorrelLong) {
		this.personalCorrelLong = personalCorrelLong;
	}

	public double getPowerCorrelLong() {
		return powerCorrelLong;
	}

	public void setPowerCorrelLong(double powerCorrelLong) {
		this.powerCorrelLong = powerCorrelLong;
	}

	public double getForeignerCorrelLong() {
		return foreignerCorrelLong;
	}

	public void setForeignerCorrelLong(double foreignerCorrelLong) {
		this.foreignerCorrelLong = foreignerCorrelLong;
	}

	public double getOrgSumCorrelLong() {
		return orgSumCorrelLong;
	}

	public void setOrgSumCorrelLong(double orgSumCorrelLong) {
		this.orgSumCorrelLong = orgSumCorrelLong;
	}

	public double getFinInvestCorrelLong() {
		return finInvestCorrelLong;
	}

	public void setFinInvestCorrelLong(double finInvestCorrelLong) {
		this.finInvestCorrelLong = finInvestCorrelLong;
	}

	public double getInsuranceCorrelLong() {
		return insuranceCorrelLong;
	}

	public void setInsuranceCorrelLong(double insuranceCorrelLong) {
		this.insuranceCorrelLong = insuranceCorrelLong;
	}

	public double getInvestTrustCorrelLong() {
		return investTrustCorrelLong;
	}

	public void setInvestTrustCorrelLong(double investTrustCorrelLong) {
		this.investTrustCorrelLong = investTrustCorrelLong;
	}

	public double getBankCorrelLong() {
		return bankCorrelLong;
	}

	public void setBankCorrelLong(double bankCorrelLong) {
		this.bankCorrelLong = bankCorrelLong;
	}

	public double getEtcFinCorrelLong() {
		return etcFinCorrelLong;
	}

	public void setEtcFinCorrelLong(double etcFinCorrelLong) {
		this.etcFinCorrelLong = etcFinCorrelLong;
	}

	public double getPensionCorrelLong() {
		return pensionCorrelLong;
	}

	public void setPensionCorrelLong(double pensionCorrelLong) {
		this.pensionCorrelLong = pensionCorrelLong;
	}

	public double getPrivateFundCorrelLong() {
		return privateFundCorrelLong;
	}

	public void setPrivateFundCorrelLong(double privateFundCorrelLong) {
		this.privateFundCorrelLong = privateFundCorrelLong;
	}

	public double getNationCorrelLong() {
		return nationCorrelLong;
	}

	public void setNationCorrelLong(double nationCorrelLong) {
		this.nationCorrelLong = nationCorrelLong;
	}

	public double getEtcForeignerCorrelLong() {
		return etcForeignerCorrelLong;
	}

	public void setEtcForeignerCorrelLong(double etcForeignerCorrelLong) {
		this.etcForeignerCorrelLong = etcForeignerCorrelLong;
	}

	public double getEtcCorpCorrelLong() {
		return etcCorpCorrelLong;
	}

	public void setEtcCorpCorrelLong(double etcCorpCorrelLong) {
		this.etcCorpCorrelLong = etcCorpCorrelLong;
	}

	public double getPersonalCorrelShort() {
		return personalCorrelShort;
	}

	public void setPersonalCorrelShort(double personalCorrelShort) {
		this.personalCorrelShort = personalCorrelShort;
	}

	public double getPowerCorrelShort() {
		return powerCorrelShort;
	}

	public void setPowerCorrelShort(double powerCorrelShort) {
		this.powerCorrelShort = powerCorrelShort;
	}

	public double getForeignerCorrelShort() {
		return foreignerCorrelShort;
	}

	public void setForeignerCorrelShort(double foreignerCorrelShort) {
		this.foreignerCorrelShort = foreignerCorrelShort;
	}

	public double getOrgSumCorrelShort() {
		return orgSumCorrelShort;
	}

	public void setOrgSumCorrelShort(double orgSumCorrelShort) {
		this.orgSumCorrelShort = orgSumCorrelShort;
	}

	public double getFinInvestCorrelShort() {
		return finInvestCorrelShort;
	}

	public void setFinInvestCorrelShort(double finInvestCorrelShort) {
		this.finInvestCorrelShort = finInvestCorrelShort;
	}

	public double getInsuranceCorrelShort() {
		return insuranceCorrelShort;
	}

	public void setInsuranceCorrelShort(double insuranceCorrelShort) {
		this.insuranceCorrelShort = insuranceCorrelShort;
	}

	public double getInvestTrustCorrelShort() {
		return investTrustCorrelShort;
	}

	public void setInvestTrustCorrelShort(double investTrustCorrelShort) {
		this.investTrustCorrelShort = investTrustCorrelShort;
	}

	public double getBankCorrelShort() {
		return bankCorrelShort;
	}

	public void setBankCorrelShort(double bankCorrelShort) {
		this.bankCorrelShort = bankCorrelShort;
	}

	public double getEtcFinCorrelShort() {
		return etcFinCorrelShort;
	}

	public void setEtcFinCorrelShort(double etcFinCorrelShort) {
		this.etcFinCorrelShort = etcFinCorrelShort;
	}

	public double getPensionCorrelShort() {
		return pensionCorrelShort;
	}

	public void setPensionCorrelShort(double pensionCorrelShort) {
		this.pensionCorrelShort = pensionCorrelShort;
	}

	public double getPrivateFundCorrelShort() {
		return privateFundCorrelShort;
	}

	public void setPrivateFundCorrelShort(double privateFundCorrelShort) {
		this.privateFundCorrelShort = privateFundCorrelShort;
	}

	public double getNationCorrelShort() {
		return nationCorrelShort;
	}

	public void setNationCorrelShort(double nationCorrelShort) {
		this.nationCorrelShort = nationCorrelShort;
	}

	public double getEtcForeignerCorrelShort() {
		return etcForeignerCorrelShort;
	}

	public void setEtcForeignerCorrelShort(double etcForeignerCorrelShort) {
		this.etcForeignerCorrelShort = etcForeignerCorrelShort;
	}

	public double getEtcCorpCorrelShort() {
		return etcCorpCorrelShort;
	}

	public void setEtcCorpCorrelShort(double etcCorpCorrelShort) {
		this.etcCorpCorrelShort = etcCorpCorrelShort;
	}

	public double getPersonalWL() {
		return personalWL;
	}

	public void setPersonalWL(double personalWL) {
		this.personalWL = personalWL;
	}

	public double getForeignerWL() {
		return foreignerWL;
	}

	public void setForeignerWL(double foreignerWL) {
		this.foreignerWL = foreignerWL;
	}

	public double getFinInvestWL() {
		return finInvestWL;
	}

	public void setFinInvestWL(double finInvestWL) {
		this.finInvestWL = finInvestWL;
	}

	public double getInsuranceWL() {
		return insuranceWL;
	}

	public void setInsuranceWL(double insuranceWL) {
		this.insuranceWL = insuranceWL;
	}

	public double getInvestTrustWL() {
		return investTrustWL;
	}

	public void setInvestTrustWL(double investTrustWL) {
		this.investTrustWL = investTrustWL;
	}

	public double getBankWL() {
		return bankWL;
	}

	public void setBankWL(double bankWL) {
		this.bankWL = bankWL;
	}

	public double getEtcFinWL() {
		return etcFinWL;
	}

	public void setEtcFinWL(double etcFinWL) {
		this.etcFinWL = etcFinWL;
	}

	public double getPensionWL() {
		return pensionWL;
	}

	public void setPensionWL(double pensionWL) {
		this.pensionWL = pensionWL;
	}

	public double getNationWL() {
		return nationWL;
	}

	public void setNationWL(double nationWL) {
		this.nationWL = nationWL;
	}

	public double getEtcForeignerWL() {
		return etcForeignerWL;
	}

	public void setEtcForeignerWL(double etcForeignerWL) {
		this.etcForeignerWL = etcForeignerWL;
	}

	public double getPrivateFundWL() {
		return privateFundWL;
	}

	public void setPrivateFundWL(double privateFundWL) {
		this.privateFundWL = privateFundWL;
	}

	public double getEtcCorpWL() {
		return etcCorpWL;
	}

	public void setEtcCorpWL(double etcCorpWL) {
		this.etcCorpWL = etcCorpWL;
	}

	public double getPersonalLds5() {
		return personalLds5;
	}

	public void setPersonalLds5(double personalLds5) {
		this.personalLds5 = personalLds5;
	}

	public double getPowerLds5() {
		return powerLds5;
	}

	public void setPowerLds5(double powerLds5) {
		this.powerLds5 = powerLds5;
	}

	public double getForeignerLds5() {
		return foreignerLds5;
	}

	public void setForeignerLds5(double foreignerLds5) {
		this.foreignerLds5 = foreignerLds5;
	}

	public double getOrgSumLds5() {
		return orgSumLds5;
	}

	public void setOrgSumLds5(double orgSumLds5) {
		this.orgSumLds5 = orgSumLds5;
	}

	public double getFinInvestLds5() {
		return finInvestLds5;
	}

	public void setFinInvestLds5(double finInvestLds5) {
		this.finInvestLds5 = finInvestLds5;
	}

	public double getInsuranceLds5() {
		return insuranceLds5;
	}

	public void setInsuranceLds5(double insuranceLds5) {
		this.insuranceLds5 = insuranceLds5;
	}

	public double getInvestTrustLds5() {
		return investTrustLds5;
	}

	public void setInvestTrustLds5(double investTrustLds5) {
		this.investTrustLds5 = investTrustLds5;
	}

	public double getBankLds5() {
		return bankLds5;
	}

	public void setBankLds5(double bankLds5) {
		this.bankLds5 = bankLds5;
	}

	public double getEtcFinLds5() {
		return etcFinLds5;
	}

	public void setEtcFinLds5(double etcFinLds5) {
		this.etcFinLds5 = etcFinLds5;
	}

	public double getPensionLds5() {
		return pensionLds5;
	}

	public void setPensionLds5(double pensionLds5) {
		this.pensionLds5 = pensionLds5;
	}

	public double getPrivateFundLds5() {
		return privateFundLds5;
	}

	public void setPrivateFundLds5(double privateFundLds5) {
		this.privateFundLds5 = privateFundLds5;
	}

	public double getNationLds5() {
		return nationLds5;
	}

	public void setNationLds5(double nationLds5) {
		this.nationLds5 = nationLds5;
	}

	public double getEtcForeignerLds5() {
		return etcForeignerLds5;
	}

	public void setEtcForeignerLds5(double etcForeignerLds5) {
		this.etcForeignerLds5 = etcForeignerLds5;
	}

	public double getEtcCorpLds5() {
		return etcCorpLds5;
	}

	public void setEtcCorpLds5(double etcCorpLds5) {
		this.etcCorpLds5 = etcCorpLds5;
	}

	public double getPersonalLds20() {
		return personalLds20;
	}

	public void setPersonalLds20(double personalLds20) {
		this.personalLds20 = personalLds20;
	}

	public double getPowerLds20() {
		return powerLds20;
	}

	public void setPowerLds20(double powerLds20) {
		this.powerLds20 = powerLds20;
	}

	public double getForeignerLds20() {
		return foreignerLds20;
	}

	public void setForeignerLds20(double foreignerLds20) {
		this.foreignerLds20 = foreignerLds20;
	}

	public double getOrgSumLds20() {
		return orgSumLds20;
	}

	public void setOrgSumLds20(double orgSumLds20) {
		this.orgSumLds20 = orgSumLds20;
	}

	public double getFinInvestLds20() {
		return finInvestLds20;
	}

	public void setFinInvestLds20(double finInvestLds20) {
		this.finInvestLds20 = finInvestLds20;
	}

	public double getInsuranceLds20() {
		return insuranceLds20;
	}

	public void setInsuranceLds20(double insuranceLds20) {
		this.insuranceLds20 = insuranceLds20;
	}

	public double getInvestTrustLds20() {
		return investTrustLds20;
	}

	public void setInvestTrustLds20(double investTrustLds20) {
		this.investTrustLds20 = investTrustLds20;
	}

	public double getBankLds20() {
		return bankLds20;
	}

	public void setBankLds20(double bankLds20) {
		this.bankLds20 = bankLds20;
	}

	public double getEtcFinLds20() {
		return etcFinLds20;
	}

	public void setEtcFinLds20(double etcFinLds20) {
		this.etcFinLds20 = etcFinLds20;
	}

	public double getPensionLds20() {
		return pensionLds20;
	}

	public void setPensionLds20(double pensionLds20) {
		this.pensionLds20 = pensionLds20;
	}

	public double getPrivateFundLds20() {
		return privateFundLds20;
	}

	public void setPrivateFundLds20(double privateFundLds20) {
		this.privateFundLds20 = privateFundLds20;
	}

	public double getNationLds20() {
		return nationLds20;
	}

	public void setNationLds20(double nationLds20) {
		this.nationLds20 = nationLds20;
	}

	public double getEtcForeignerLds20() {
		return etcForeignerLds20;
	}

	public void setEtcForeignerLds20(double etcForeignerLds20) {
		this.etcForeignerLds20 = etcForeignerLds20;
	}

	public double getEtcCorpLds20() {
		return etcCorpLds20;
	}

	public void setEtcCorpLds20(double etcCorpLds20) {
		this.etcCorpLds20 = etcCorpLds20;
	}

	public double getPersonalLds60() {
		return personalLds60;
	}

	public void setPersonalLds60(double personalLds60) {
		this.personalLds60 = personalLds60;
	}

	public double getPowerLds60() {
		return powerLds60;
	}

	public void setPowerLds60(double powerLds60) {
		this.powerLds60 = powerLds60;
	}

	public double getForeignerLds60() {
		return foreignerLds60;
	}

	public void setForeignerLds60(double foreignerLds60) {
		this.foreignerLds60 = foreignerLds60;
	}

	public double getOrgSumLds60() {
		return orgSumLds60;
	}

	public void setOrgSumLds60(double orgSumLds60) {
		this.orgSumLds60 = orgSumLds60;
	}

	public double getFinInvestLds60() {
		return finInvestLds60;
	}

	public void setFinInvestLds60(double finInvestLds60) {
		this.finInvestLds60 = finInvestLds60;
	}

	public double getInsuranceLds60() {
		return insuranceLds60;
	}

	public void setInsuranceLds60(double insuranceLds60) {
		this.insuranceLds60 = insuranceLds60;
	}

	public double getInvestTrustLds60() {
		return investTrustLds60;
	}

	public void setInvestTrustLds60(double investTrustLds60) {
		this.investTrustLds60 = investTrustLds60;
	}

	public double getBankLds60() {
		return bankLds60;
	}

	public void setBankLds60(double bankLds60) {
		this.bankLds60 = bankLds60;
	}

	public double getEtcFinLds60() {
		return etcFinLds60;
	}

	public void setEtcFinLds60(double etcFinLds60) {
		this.etcFinLds60 = etcFinLds60;
	}

	public double getPensionLds60() {
		return pensionLds60;
	}

	public void setPensionLds60(double pensionLds60) {
		this.pensionLds60 = pensionLds60;
	}

	public double getPrivateFundLds60() {
		return privateFundLds60;
	}

	public void setPrivateFundLds60(double privateFundLds60) {
		this.privateFundLds60 = privateFundLds60;
	}

	public double getNationLds60() {
		return nationLds60;
	}

	public void setNationLds60(double nationLds60) {
		this.nationLds60 = nationLds60;
	}

	public double getEtcForeignerLds60() {
		return etcForeignerLds60;
	}

	public void setEtcForeignerLds60(double etcForeignerLds60) {
		this.etcForeignerLds60 = etcForeignerLds60;
	}

	public double getEtcCorpLds60() {
		return etcCorpLds60;
	}

	public void setEtcCorpLds60(double etcCorpLds60) {
		this.etcCorpLds60 = etcCorpLds60;
	}

	public double getMa5() {
		return ma5;
	}

	public void setMa5(double ma5) {
		this.ma5 = ma5;
	}

	public double getMa20() {
		return ma20;
	}

	public void setMa20(double ma20) {
		this.ma20 = ma20;
	}

	public double getMa60() {
		return ma60;
	}

	public void setMa60(double ma60) {
		this.ma60 = ma60;
	}

	public double getMa240() {
		return ma240;
	}

	public void setMa240(double ma240) {
		this.ma240 = ma240;
	}


	public double getMacd() {
		return macd;
	}

	public void setMacd(double macd) {
		this.macd = macd;
	}

	public double getMacdSignal() {
		return macdSignal;
	}

	public void setMacdSignal(double macdSignal) {
		this.macdSignal = macdSignal;
	}

	public double getMacdHist() {
		return macdHist;
	}

	public void setMacdHist(double macdHist) {
		this.macdHist = macdHist;
	}

	public double getMacdRate() {
		return macdRate;
	}

	public void setMacdRate(double macdRate) {
		this.macdRate = macdRate;
	}

	public double getSlowK() {
		return slowK;
	}

	public void setSlowK(double slowK) {
		this.slowK = slowK;
	}

	public double getSlowD() {
		return slowD;
	}

	public void setSlowD(double slowD) {
		this.slowD = slowD;
	}

	public double getStochHist() {
		return stochHist;
	}

	public void setStochHist(double stochHist) {
		this.stochHist = stochHist;
	}

	public double getRsi() {
		return rsi;
	}

	public void setRsi(double rsi) {
		this.rsi = rsi;
	}

	public double getRsiSignal() {
		return rsiSignal;
	}

	public void setRsiSignal(double rsiSignal) {
		this.rsiSignal = rsiSignal;
	}

	public double getRsiHist() {
		return rsiHist;
	}

	public void setRsiHist(double rsiHist) {
		this.rsiHist = rsiHist;
	}

	public double getUpperBand() {
		return upperBand;
	}

	public void setUpperBand(double upperBand) {
		this.upperBand = upperBand;
	}

	public double getMiddleBand() {
		return middleBand;
	}

	public void setMiddleBand(double middleBand) {
		this.middleBand = middleBand;
	}

	public double getLowerBand() {
		return lowerBand;
	}

	public void setLowerBand(double lowerBand) {
		this.lowerBand = lowerBand;
	}

	public double getObv() {
		return obv;
	}

	public void setObv(double obv) {
		this.obv = obv;
	}

	public int getTradeSignal() {
		return tradeSignal;
	}

	public void setTradeSignal(int tradeSignal) {
		this.tradeSignal = tradeSignal;
	}

	public double getPersonalLds240() {
		return personalLds240;
	}

	public void setPersonalLds240(double personalLds240) {
		this.personalLds240 = personalLds240;
	}

	public double getPowerLds240() {
		return powerLds240;
	}

	public void setPowerLds240(double powerLds240) {
		this.powerLds240 = powerLds240;
	}

	public double getForeignerLds240() {
		return foreignerLds240;
	}

	public void setForeignerLds240(double foreignerLds240) {
		this.foreignerLds240 = foreignerLds240;
	}

	public double getOrgSumLds240() {
		return orgSumLds240;
	}

	public void setOrgSumLds240(double orgSumLds240) {
		this.orgSumLds240 = orgSumLds240;
	}

	public double getEtcSumLds240() {
		return etcSumLds240;
	}

	public void setEtcSumLds240(double etcSumLds240) {
		this.etcSumLds240 = etcSumLds240;
	}

	public double getFinInvestLds240() {
		return finInvestLds240;
	}

	public void setFinInvestLds240(double finInvestLds240) {
		this.finInvestLds240 = finInvestLds240;
	}

	public double getInsuranceLds240() {
		return insuranceLds240;
	}

	public void setInsuranceLds240(double insuranceLds240) {
		this.insuranceLds240 = insuranceLds240;
	}

	public double getInvestTrustLds240() {
		return investTrustLds240;
	}

	public void setInvestTrustLds240(double investTrustLds240) {
		this.investTrustLds240 = investTrustLds240;
	}

	public double getBankLds240() {
		return bankLds240;
	}

	public void setBankLds240(double bankLds240) {
		this.bankLds240 = bankLds240;
	}

	public double getEtcFinLds240() {
		return etcFinLds240;
	}

	public void setEtcFinLds240(double etcFinLds240) {
		this.etcFinLds240 = etcFinLds240;
	}

	public double getPensionLds240() {
		return pensionLds240;
	}

	public void setPensionLds240(double pensionLds240) {
		this.pensionLds240 = pensionLds240;
	}

	public double getPrivateFundLds240() {
		return privateFundLds240;
	}

	public void setPrivateFundLds240(double privateFundLds240) {
		this.privateFundLds240 = privateFundLds240;
	}

	public double getNationLds240() {
		return nationLds240;
	}

	public void setNationLds240(double nationLds240) {
		this.nationLds240 = nationLds240;
	}

	public double getEtcForeignerLds240() {
		return etcForeignerLds240;
	}

	public void setEtcForeignerLds240(double etcForeignerLds240) {
		this.etcForeignerLds240 = etcForeignerLds240;
	}

	public double getEtcCorpLds240() {
		return etcCorpLds240;
	}

	public void setEtcCorpLds240(double etcCorpLds240) {
		this.etcCorpLds240 = etcCorpLds240;
	}

	public double getClosePriceSum() {
		return closePriceSum;
	}

	public void setClosePriceSum(double closePriceSum) {
		this.closePriceSum = closePriceSum;
	}

	public double getPersonalLds720() {
		return personalLds720;
	}

	public void setPersonalLds720(double personalLds720) {
		this.personalLds720 = personalLds720;
	}

	public double getPowerLds720() {
		return powerLds720;
	}

	public void setPowerLds720(double powerLds720) {
		this.powerLds720 = powerLds720;
	}

	public double getForeignerLds720() {
		return foreignerLds720;
	}

	public void setForeignerLds720(double foreignerLds720) {
		this.foreignerLds720 = foreignerLds720;
	}

	public double getOrgSumLds720() {
		return orgSumLds720;
	}

	public void setOrgSumLds720(double orgSumLds720) {
		this.orgSumLds720 = orgSumLds720;
	}

	public double getEtcSumLds720() {
		return etcSumLds720;
	}

	public void setEtcSumLds720(double etcSumLds720) {
		this.etcSumLds720 = etcSumLds720;
	}

	public double getFinInvestLds720() {
		return finInvestLds720;
	}

	public void setFinInvestLds720(double finInvestLds720) {
		this.finInvestLds720 = finInvestLds720;
	}

	public double getInsuranceLds720() {
		return insuranceLds720;
	}

	public void setInsuranceLds720(double insuranceLds720) {
		this.insuranceLds720 = insuranceLds720;
	}

	public double getInvestTrustLds720() {
		return investTrustLds720;
	}

	public void setInvestTrustLds720(double investTrustLds720) {
		this.investTrustLds720 = investTrustLds720;
	}

	public double getBankLds720() {
		return bankLds720;
	}

	public void setBankLds720(double bankLds720) {
		this.bankLds720 = bankLds720;
	}

	public double getEtcFinLds720() {
		return etcFinLds720;
	}

	public void setEtcFinLds720(double etcFinLds720) {
		this.etcFinLds720 = etcFinLds720;
	}

	public double getPensionLds720() {
		return pensionLds720;
	}

	public void setPensionLds720(double pensionLds720) {
		this.pensionLds720 = pensionLds720;
	}

	public double getPrivateFundLds720() {
		return privateFundLds720;
	}

	public void setPrivateFundLds720(double privateFundLds720) {
		this.privateFundLds720 = privateFundLds720;
	}

	public double getNationLds720() {
		return nationLds720;
	}

	public void setNationLds720(double nationLds720) {
		this.nationLds720 = nationLds720;
	}

	public double getEtcForeignerLds720() {
		return etcForeignerLds720;
	}

	public void setEtcForeignerLds720(double etcForeignerLds720) {
		this.etcForeignerLds720 = etcForeignerLds720;
	}

	public double getEtcCorpLds720() {
		return etcCorpLds720;
	}

	public void setEtcCorpLds720(double etcCorpLds720) {
		this.etcCorpLds720 = etcCorpLds720;
	}

	public double getMa720() {
		return ma720;
	}

	public void setMa720(double ma720) {
		this.ma720 = ma720;
	}

	public double getPowerWL() {
		return powerWL;
	}

	public void setPowerWL(double powerWL) {
		this.powerWL = powerWL;
	}

	public double getOrgSumWL() {
		return orgSumWL;
	}

	public void setOrgSumWL(double orgSumWL) {
		this.orgSumWL = orgSumWL;
	}

	public double getVolume20() {
		return volume20;
	}

	public void setVolume20(double volume20) {
		this.volume20 = volume20;
	}

	public double getPersonalAccr() {
		return personalAccr;
	}

	public void setPersonalAccr(double personalAccr) {
		this.personalAccr = personalAccr;
	}

	public double getPowerAccr() {
		return powerAccr;
	}

	public void setPowerAccr(double powerAccr) {
		this.powerAccr = powerAccr;
	}

	public double getForeignerAccr() {
		return foreignerAccr;
	}

	public void setForeignerAccr(double foreignerAccr) {
		this.foreignerAccr = foreignerAccr;
	}

	public double getOrgSumAccr() {
		return orgSumAccr;
	}

	public void setOrgSumAccr(double orgSumAccr) {
		this.orgSumAccr = orgSumAccr;
	}

	public double getFinInvestAccr() {
		return finInvestAccr;
	}

	public void setFinInvestAccr(double finInvestAccr) {
		this.finInvestAccr = finInvestAccr;
	}

	public double getInsuranceAccr() {
		return insuranceAccr;
	}

	public void setInsuranceAccr(double insuranceAccr) {
		this.insuranceAccr = insuranceAccr;
	}

	public double getInvestTrustAccr() {
		return investTrustAccr;
	}

	public void setInvestTrustAccr(double investTrustAccr) {
		this.investTrustAccr = investTrustAccr;
	}

	public double getBankAccr() {
		return bankAccr;
	}

	public void setBankAccr(double bankAccr) {
		this.bankAccr = bankAccr;
	}

	public double getEtcFinAccr() {
		return etcFinAccr;
	}

	public void setEtcFinAccr(double etcFinAccr) {
		this.etcFinAccr = etcFinAccr;
	}

	public double getPensionAccr() {
		return pensionAccr;
	}

	public void setPensionAccr(double pensionAccr) {
		this.pensionAccr = pensionAccr;
	}

	public double getPrivateFundAccr() {
		return privateFundAccr;
	}

	public void setPrivateFundAccr(double privateFundAccr) {
		this.privateFundAccr = privateFundAccr;
	}

	public double getNationAccr() {
		return nationAccr;
	}

	public void setNationAccr(double nationAccr) {
		this.nationAccr = nationAccr;
	}

	public double getEtcForeignerAccr() {
		return etcForeignerAccr;
	}

	public void setEtcForeignerAccr(double etcForeignerAccr) {
		this.etcForeignerAccr = etcForeignerAccr;
	}

	public double getEtcCorpAccr() {
		return etcCorpAccr;
	}

	public void setEtcCorpAccr(double etcCorpAccr) {
		this.etcCorpAccr = etcCorpAccr;
	}

	public double getLeader() {
		return leader;
	}

	public void setLeader(double leader) {
		this.leader = leader;
	}

	public double getLeaderSum() {
		return leaderSum;
	}

	public void setLeaderSum(double leaderSum) {
		this.leaderSum = leaderSum;
	}

	public double getLeaderAccr() {
		return leaderAccr;
	}

	public void setLeaderAccr(double leaderAccr) {
		this.leaderAccr = leaderAccr;
	}

	public double getLeaderLeadingRatio() {
		return leaderLeadingRatio;
	}

	public void setLeaderLeadingRatio(double leaderLeadingRatio) {
		this.leaderLeadingRatio = leaderLeadingRatio;
	}

	public double getLeaderCorrelLong() {
		return leaderCorrelLong;
	}

	public void setLeaderCorrelLong(double leaderCorrelLong) {
		this.leaderCorrelLong = leaderCorrelLong;
	}

	public double getLeaderCorrelShort() {
		return leaderCorrelShort;
	}

	public void setLeaderCorrelShort(double leaderCorrelShort) {
		this.leaderCorrelShort = leaderCorrelShort;
	}

	public double getLeaderWL() {
		return leaderWL;
	}

	public void setLeaderWL(double leaderWL) {
		this.leaderWL = leaderWL;
	}

	public double getLeaderLds5() {
		return leaderLds5;
	}

	public void setLeaderLds5(double leaderLds5) {
		this.leaderLds5 = leaderLds5;
	}

	public double getLeaderLds20() {
		return leaderLds20;
	}

	public void setLeaderLds20(double leaderLds20) {
		this.leaderLds20 = leaderLds20;
	}

	public double getLeaderLds60() {
		return leaderLds60;
	}

	public void setLeaderLds60(double leaderLds60) {
		this.leaderLds60 = leaderLds60;
	}

	public double getLeaderLds240() {
		return leaderLds240;
	}

	public void setLeaderLds240(double leaderLds240) {
		this.leaderLds240 = leaderLds240;
	}

	public double getLeaderLds720() {
		return leaderLds720;
	}

	public void setLeaderLds720(double leaderLds720) {
		this.leaderLds720 = leaderLds720;
	}

	public int getTradeSignalPower() {
		return tradeSignalPower;
	}

	public void setTradeSignalPower(int tradeSignalPower) {
		this.tradeSignalPower = tradeSignalPower;
	}

	public int getTradeSignalLeader() {
		return tradeSignalLeader;
	}

	public void setTradeSignalLeader(int tradeSignalLeader) {
		this.tradeSignalLeader = tradeSignalLeader;
	}

	public int getTradeSignalForeigner() {
		return tradeSignalForeigner;
	}

	public void setTradeSignalForeigner(int tradeSignalForeigner) {
		this.tradeSignalForeigner = tradeSignalForeigner;
	}

	public int getTradeSignalOrgSum() {
		return tradeSignalOrgSum;
	}

	public void setTradeSignalOrgSum(int tradeSignalOrgSum) {
		this.tradeSignalOrgSum = tradeSignalOrgSum;
	}

}
