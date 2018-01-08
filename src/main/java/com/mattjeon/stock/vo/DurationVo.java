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
public class DurationVo {
     
	// 기초 지표 
	private String companyCode; 
	private String companyName; 
	private String industryName; 
	private String industryCode; 
	private String regDate;
	
    // 가격 지표     
	private double openPrice; 
	private double highPrice; 
	private double lowPrice;
	private double closePrice;
	private double updownRatio;
	private double volume; 
	private double volumeRatio;
	
	private long    personal;
	private long    power;	
	private long    leader;	
	private long    foreigner;
	private long    orgSum;
	private long    finInvest;
	private long    insurance;
	private long    investTrust;
	private long    bank;
	private long    etcFin;
	private long    pension;
	private long    privateFund;
	private long    nation;
	private long    etcForeigner;
	private long    etcCorp;
	
	//현재 매집수량 (누적합계 - 매집 최고점)
	private long    closePriceSum;
	private long    personalSum;
	private long    powerSum;
	private long    leaderSum;
	private long    foreignerSum;
	private long    orgSumSum;
	private long    finInvestSum;
	private long    insuranceSum;
	private long    investTrustSum;
	private long    bankSum;
	private long    etcFinSum;
	private long    pensionSum;
	private long    privateFundSum;
	private long    nationSum; 
	private long    etcForeignerSum;
	private long    etcCorpSum;
	
	//평균매집단가
	private double    personalAvgBuyPrice;
	private double    powerAvgBuyPrice;
	private double    leaderAvgBuyPrice;
	private double    foreignerAvgBuyPrice;
	private double    orgSumAvgBuyPrice;
	private double    finInvestAvgBuyPrice;
	private double    insuranceAvgBuyPrice;
	private double    investTrustAvgBuyPrice;
	private double    bankAvgBuyPrice;
	private double    etcFinAvgBuyPrice;
	private double    pensionAvgBuyPrice;
	private double    privateFundAvgBuyPrice;
	private double    nationAvgBuyPrice; 
	private double    etcForeignerAvgBuyPrice;
	private double    etcCorpAvgBuyPrice;	
	
	private double    personalAvgIncomeRate;
	private double    powerAvgIncomeRate;
	private double    leaderAvgIncomeRate;
	private double    foreignerAvgIncomeRate;
	private double    orgSumAvgIncomeRate;
	private double    finInvestAvgIncomeRate;
	private double    insuranceAvgIncomeRate;
	private double    investTrustAvgIncomeRate;
	private double    bankAvgIncomeRate;
	private double    etcFinAvgIncomeRate;
	private double    pensionAvgIncomeRate;
	private double    privateFundAvgIncomeRate;
	private double    nationAvgIncomeRate; 
	private double    etcForeignerAvgIncomeRate;
	private double    etcCorpAvgIncomeRate;

	private double deviation;

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

	public String getIndustryCode() {
		return industryCode;
	}

	public void setIndustryCode(String industryCode) {
		this.industryCode = industryCode;
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

	public double getVolumeRatio() {
		return volumeRatio;
	}

	public void setVolumeRatio(double volumeRatio) {
		this.volumeRatio = volumeRatio;
	}

	public long getPersonal() {
		return personal;
	}

	public void setPersonal(long personal) {
		this.personal = personal;
	}

	public long getPower() {
		return power;
	}

	public void setPower(long power) {
		this.power = power;
	}

	public long getForeigner() {
		return foreigner;
	}

	public void setForeigner(long foreigner) {
		this.foreigner = foreigner;
	}

	public long getOrgSum() {
		return orgSum;
	}

	public void setOrgSum(long orgSum) {
		this.orgSum = orgSum;
	}

	public long getFinInvest() {
		return finInvest;
	}

	public void setFinInvest(long finInvest) {
		this.finInvest = finInvest;
	}

	public long getInsurance() {
		return insurance;
	}

	public void setInsurance(long insurance) {
		this.insurance = insurance;
	}

	public long getInvestTrust() {
		return investTrust;
	}

	public void setInvestTrust(long investTrust) {
		this.investTrust = investTrust;
	}

	public long getBank() {
		return bank;
	}

	public void setBank(long bank) {
		this.bank = bank;
	}

	public long getEtcFin() {
		return etcFin;
	}

	public void setEtcFin(long etcFin) {
		this.etcFin = etcFin;
	}

	public long getPension() {
		return pension;
	}

	public void setPension(long pension) {
		this.pension = pension;
	}

	public long getPrivateFund() {
		return privateFund;
	}

	public void setPrivateFund(long privateFund) {
		this.privateFund = privateFund;
	}

	public long getNation() {
		return nation;
	}

	public void setNation(long nation) {
		this.nation = nation;
	}

	public long getEtcForeigner() {
		return etcForeigner;
	}

	public void setEtcForeigner(long etcForeigner) {
		this.etcForeigner = etcForeigner;
	}

	public long getEtcCorp() {
		return etcCorp;
	}

	public void setEtcCorp(long etcCorp) {
		this.etcCorp = etcCorp;
	}

	public long getClosePriceSum() {
		return closePriceSum;
	}

	public void setClosePriceSum(long closePriceSum) {
		this.closePriceSum = closePriceSum;
	}

	public long getPersonalSum() {
		return personalSum;
	}

	public void setPersonalSum(long personalSum) {
		this.personalSum = personalSum;
	}

	public long getPowerSum() {
		return powerSum;
	}

	public void setPowerSum(long powerSum) {
		this.powerSum = powerSum;
	}

	public long getForeignerSum() {
		return foreignerSum;
	}

	public void setForeignerSum(long foreignerSum) {
		this.foreignerSum = foreignerSum;
	}

	public long getOrgSumSum() {
		return orgSumSum;
	}

	public void setOrgSumSum(long orgSumSum) {
		this.orgSumSum = orgSumSum;
	}

	public long getFinInvestSum() {
		return finInvestSum;
	}

	public void setFinInvestSum(long finInvestSum) {
		this.finInvestSum = finInvestSum;
	}

	public long getInsuranceSum() {
		return insuranceSum;
	}

	public void setInsuranceSum(long insuranceSum) {
		this.insuranceSum = insuranceSum;
	}

	public long getInvestTrustSum() {
		return investTrustSum;
	}

	public void setInvestTrustSum(long investTrustSum) {
		this.investTrustSum = investTrustSum;
	}

	public long getBankSum() {
		return bankSum;
	}

	public void setBankSum(long bankSum) {
		this.bankSum = bankSum;
	}

	public long getEtcFinSum() {
		return etcFinSum;
	}

	public void setEtcFinSum(long etcFinSum) {
		this.etcFinSum = etcFinSum;
	}

	public long getPensionSum() {
		return pensionSum;
	}

	public void setPensionSum(long pensionSum) {
		this.pensionSum = pensionSum;
	}

	public long getPrivateFundSum() {
		return privateFundSum;
	}

	public void setPrivateFundSum(long privateFundSum) {
		this.privateFundSum = privateFundSum;
	}

	public long getNationSum() {
		return nationSum;
	}

	public void setNationSum(long nationSum) {
		this.nationSum = nationSum;
	}

	public long getEtcForeignerSum() {
		return etcForeignerSum;
	}

	public void setEtcForeignerSum(long etcForeignerSum) {
		this.etcForeignerSum = etcForeignerSum;
	}

	public long getEtcCorpSum() {
		return etcCorpSum;
	}

	public void setEtcCorpSum(long etcCorpSum) {
		this.etcCorpSum = etcCorpSum;
	}

	public double getPersonalAvgBuyPrice() {
		return personalAvgBuyPrice;
	}

	public void setPersonalAvgBuyPrice(double personalAvgBuyPrice) {
		this.personalAvgBuyPrice = personalAvgBuyPrice;
	}

	public double getPowerAvgBuyPrice() {
		return powerAvgBuyPrice;
	}

	public void setPowerAvgBuyPrice(double powerAvgBuyPrice) {
		this.powerAvgBuyPrice = powerAvgBuyPrice;
	}

	public double getForeignerAvgBuyPrice() {
		return foreignerAvgBuyPrice;
	}

	public void setForeignerAvgBuyPrice(double foreignerAvgBuyPrice) {
		this.foreignerAvgBuyPrice = foreignerAvgBuyPrice;
	}

	public double getOrgSumAvgBuyPrice() {
		return orgSumAvgBuyPrice;
	}

	public void setOrgSumAvgBuyPrice(double orgSumAvgBuyPrice) {
		this.orgSumAvgBuyPrice = orgSumAvgBuyPrice;
	}

	public double getFinInvestAvgBuyPrice() {
		return finInvestAvgBuyPrice;
	}

	public void setFinInvestAvgBuyPrice(double finInvestAvgBuyPrice) {
		this.finInvestAvgBuyPrice = finInvestAvgBuyPrice;
	}

	public double getInsuranceAvgBuyPrice() {
		return insuranceAvgBuyPrice;
	}

	public void setInsuranceAvgBuyPrice(double insuranceAvgBuyPrice) {
		this.insuranceAvgBuyPrice = insuranceAvgBuyPrice;
	}

	public double getInvestTrustAvgBuyPrice() {
		return investTrustAvgBuyPrice;
	}

	public void setInvestTrustAvgBuyPrice(double investTrustAvgBuyPrice) {
		this.investTrustAvgBuyPrice = investTrustAvgBuyPrice;
	}

	public double getBankAvgBuyPrice() {
		return bankAvgBuyPrice;
	}

	public void setBankAvgBuyPrice(double bankAvgBuyPrice) {
		this.bankAvgBuyPrice = bankAvgBuyPrice;
	}

	public double getEtcFinAvgBuyPrice() {
		return etcFinAvgBuyPrice;
	}

	public void setEtcFinAvgBuyPrice(double etcFinAvgBuyPrice) {
		this.etcFinAvgBuyPrice = etcFinAvgBuyPrice;
	}

	public double getPensionAvgBuyPrice() {
		return pensionAvgBuyPrice;
	}

	public void setPensionAvgBuyPrice(double pensionAvgBuyPrice) {
		this.pensionAvgBuyPrice = pensionAvgBuyPrice;
	}

	public double getPrivateFundAvgBuyPrice() {
		return privateFundAvgBuyPrice;
	}

	public void setPrivateFundAvgBuyPrice(double privateFundAvgBuyPrice) {
		this.privateFundAvgBuyPrice = privateFundAvgBuyPrice;
	}

	public double getNationAvgBuyPrice() {
		return nationAvgBuyPrice;
	}

	public void setNationAvgBuyPrice(double nationAvgBuyPrice) {
		this.nationAvgBuyPrice = nationAvgBuyPrice;
	}

	public double getEtcForeignerAvgBuyPrice() {
		return etcForeignerAvgBuyPrice;
	}

	public void setEtcForeignerAvgBuyPrice(double etcForeignerAvgBuyPrice) {
		this.etcForeignerAvgBuyPrice = etcForeignerAvgBuyPrice;
	}

	public double getEtcCorpAvgBuyPrice() {
		return etcCorpAvgBuyPrice;
	}

	public void setEtcCorpAvgBuyPrice(double etcCorpAvgBuyPrice) {
		this.etcCorpAvgBuyPrice = etcCorpAvgBuyPrice;
	}

	public double getPersonalAvgIncomeRate() {
		return personalAvgIncomeRate;
	}

	public void setPersonalAvgIncomeRate(double personalAvgIncomeRate) {
		this.personalAvgIncomeRate = personalAvgIncomeRate;
	}

	public double getPowerAvgIncomeRate() {
		return powerAvgIncomeRate;
	}

	public void setPowerAvgIncomeRate(double powerAvgIncomeRate) {
		this.powerAvgIncomeRate = powerAvgIncomeRate;
	}

	public double getForeignerAvgIncomeRate() {
		return foreignerAvgIncomeRate;
	}

	public void setForeignerAvgIncomeRate(double foreignerAvgIncomeRate) {
		this.foreignerAvgIncomeRate = foreignerAvgIncomeRate;
	}

	public double getOrgSumAvgIncomeRate() {
		return orgSumAvgIncomeRate;
	}

	public void setOrgSumAvgIncomeRate(double orgSumAvgIncomeRate) {
		this.orgSumAvgIncomeRate = orgSumAvgIncomeRate;
	}

	public double getFinInvestAvgIncomeRate() {
		return finInvestAvgIncomeRate;
	}

	public void setFinInvestAvgIncomeRate(double finInvestAvgIncomeRate) {
		this.finInvestAvgIncomeRate = finInvestAvgIncomeRate;
	}

	public double getInsuranceAvgIncomeRate() {
		return insuranceAvgIncomeRate;
	}

	public void setInsuranceAvgIncomeRate(double insuranceAvgIncomeRate) {
		this.insuranceAvgIncomeRate = insuranceAvgIncomeRate;
	}

	public double getInvestTrustAvgIncomeRate() {
		return investTrustAvgIncomeRate;
	}

	public void setInvestTrustAvgIncomeRate(double investTrustAvgIncomeRate) {
		this.investTrustAvgIncomeRate = investTrustAvgIncomeRate;
	}

	public double getBankAvgIncomeRate() {
		return bankAvgIncomeRate;
	}

	public void setBankAvgIncomeRate(double bankAvgIncomeRate) {
		this.bankAvgIncomeRate = bankAvgIncomeRate;
	}

	public double getEtcFinAvgIncomeRate() {
		return etcFinAvgIncomeRate;
	}

	public void setEtcFinAvgIncomeRate(double etcFinAvgIncomeRate) {
		this.etcFinAvgIncomeRate = etcFinAvgIncomeRate;
	}

	public double getPensionAvgIncomeRate() {
		return pensionAvgIncomeRate;
	}

	public void setPensionAvgIncomeRate(double pensionAvgIncomeRate) {
		this.pensionAvgIncomeRate = pensionAvgIncomeRate;
	}

	public double getPrivateFundAvgIncomeRate() {
		return privateFundAvgIncomeRate;
	}

	public void setPrivateFundAvgIncomeRate(double privateFundAvgIncomeRate) {
		this.privateFundAvgIncomeRate = privateFundAvgIncomeRate;
	}

	public double getNationAvgIncomeRate() {
		return nationAvgIncomeRate;
	}

	public void setNationAvgIncomeRate(double nationAvgIncomeRate) {
		this.nationAvgIncomeRate = nationAvgIncomeRate;
	}

	public double getEtcForeignerAvgIncomeRate() {
		return etcForeignerAvgIncomeRate;
	}

	public void setEtcForeignerAvgIncomeRate(double etcForeignerAvgIncomeRate) {
		this.etcForeignerAvgIncomeRate = etcForeignerAvgIncomeRate;
	}

	public double getEtcCorpAvgIncomeRate() {
		return etcCorpAvgIncomeRate;
	}

	public void setEtcCorpAvgIncomeRate(double etcCorpAvgIncomeRate) {
		this.etcCorpAvgIncomeRate = etcCorpAvgIncomeRate;
	}

	public double getDeviation() {
		return deviation;
	}

	public void setDeviation(double deviation) {
		this.deviation = deviation;
	}

	public long getLeader() {
		return leader;
	}

	public void setLeader(long leader) {
		this.leader = leader;
	}

	public long getLeaderSum() {
		return leaderSum;
	}

	public void setLeaderSum(long leaderSum) {
		this.leaderSum = leaderSum;
	}

	public double getLeaderAvgBuyPrice() {
		return leaderAvgBuyPrice;
	}

	public void setLeaderAvgBuyPrice(double leaderAvgBuyPrice) {
		this.leaderAvgBuyPrice = leaderAvgBuyPrice;
	}

	public double getLeaderAvgIncomeRate() {
		return leaderAvgIncomeRate;
	}

	public void setLeaderAvgIncomeRate(double leaderAvgIncomeRate) {
		this.leaderAvgIncomeRate = leaderAvgIncomeRate;
	}

	public String getIndustryName() {
		return industryName;
	}

	public void setIndustryName(String industryName) {
		this.industryName = industryName;
	}

}
