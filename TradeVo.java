/*
 * Copyright (c) 2014. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.mattjeon.stock.vo; 
 
/** 
 * Created by jeon-yeongsu on 2014. 6. 17.. 
 */
public class TradeVo {
	 
	private String companyCode;
	private String companyName;
	
	private String regDate;  
	private double closePrice;
	private double tradePrice;
	private double targetPrice;
	private double cutPrice;
	private double raisePercent;
	private String comments;
	
	// �씠�븯 嫄곕옒醫낅ぉ�쓽 �쁽 �긽�깭瑜� �몴�떆�븯湲� �쐞�븳 �빆紐⑸뱾
	private double updownRatio;
	private String tradeSignalMsg;
	private String powerCharacterMsg;
	private String winnerList;
	
	private String priceTrendMsg;
	private String powerAdTrendMsg;
	private String foreignerAdTrendMsg;
	private String orgSumAdTrendMsg;
	private String etcSumAdTrendMsg;
	private String winnerAdTrendMsg;
	
	private double powerCorrel;
	private double powerLds5;
	private double powerLds20;
	private double powerLds60;
	
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

	public double getRaisePercent() {
		return raisePercent;
	}
	public void setRaisePercent(double raisePercent) {
		this.raisePercent = raisePercent;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getPriceTrendMsg() {
		return priceTrendMsg;
	}
	public void setPriceTrendMsg(String priceTrendMsg) {
		this.priceTrendMsg = priceTrendMsg;
	}
	public String getTradeSignalMsg() {
		return tradeSignalMsg;
	}
	public void setTradeSignalMsg(String tradeSignalMsg) {
		this.tradeSignalMsg = tradeSignalMsg;
	}
	public double getClosePrice() {
		return closePrice;
	}
	public void setClosePrice(double closePrice) {
		this.closePrice = closePrice;
	}
	public double getTradePrice() {
		return tradePrice;
	}
	public void setTradePrice(double tradePrice) {
		this.tradePrice = tradePrice;
	}
	public double getTargetPrice() {
		return targetPrice;
	}
	public void setTargetPrice(double targetPrice) {
		this.targetPrice = targetPrice;
	}
	public double getCutPrice() {
		return cutPrice;
	}
	public void setCutPrice(double cutPrice) {
		this.cutPrice = cutPrice;
	}
	public String getPowerCharacterMsg() {
		return powerCharacterMsg;
	}
	public void setPowerCharacterMsg(String powerCharacterMsg) {
		this.powerCharacterMsg = powerCharacterMsg;
	}
	public String getPowerAdTrendMsg() {
		return powerAdTrendMsg;
	}
	public void setPowerAdTrendMsg(String powerAdTrendMsg) {
		this.powerAdTrendMsg = powerAdTrendMsg;
	}
	public String getForeignerAdTrendMsg() {
		return foreignerAdTrendMsg;
	}
	public void setForeignerAdTrendMsg(String foreignerAdTrendMsg) {
		this.foreignerAdTrendMsg = foreignerAdTrendMsg;
	}
	public String getOrgSumAdTrendMsg() {
		return orgSumAdTrendMsg;
	}
	public void setOrgSumAdTrendMsg(String orgSumAdTrendMsg) {
		this.orgSumAdTrendMsg = orgSumAdTrendMsg;
	}
	public String getWinnerAdTrendMsg() {
		return winnerAdTrendMsg;
	}
	public void setWinnerAdTrendMsg(String winnerAdTrendMsg) {
		this.winnerAdTrendMsg = winnerAdTrendMsg;
	}
	public String getEtcSumAdTrendMsg() {
		return etcSumAdTrendMsg;
	}
	public void setEtcSumAdTrendMsg(String etcSumAdTrendMsg) {
		this.etcSumAdTrendMsg = etcSumAdTrendMsg;
	}
	public String getWinnerList() {
		return winnerList;
	}
	public void setWinnerList(String winnerList) {
		this.winnerList = winnerList;
	}
	public double getPowerLds5() {
		return powerLds5;
	}
	public void setPowerLds5(double powerLds5) {
		this.powerLds5 = powerLds5;
	}
	public double getPowerLds20() {
		return powerLds20;
	}
	public void setPowerLds20(double powerLds20) {
		this.powerLds20 = powerLds20;
	}
	public double getPowerLds60() {
		return powerLds60;
	}
	public void setPowerLds60(double powerLds60) {
		this.powerLds60 = powerLds60;
	}
	public double getUpdownRatio() {
		return updownRatio;
	}
	public void setUpdownRatio(double updownRatio) {
		this.updownRatio = updownRatio;
	}
	public double getPowerCorrel() {
		return powerCorrel;
	}
	public void setPowerCorrel(double powerCorrel) {
		this.powerCorrel = powerCorrel;
	}
}
