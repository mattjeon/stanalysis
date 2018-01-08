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
public class FundamentalVo {  
    private String companyCode;  
    private String companyName; 
    private String regDate;  
    private String industryCode; 
    private String industryName;
    private String marketKind; 
    private String kospi200; 
    private String supervision;
    private String controlKind; 
    private String statusKind;
    
    private String closePrice; 
    private int totalStocks;   
    private long totalStockPrice;
    private int capital; 
    private int faceValue; 
    
    private float yPbr;  
    private float yPer;  
    private float yRoe; 
    private float yEps;  
    private float yBps; 
    
    // 연간 
    private float ySalesRiseRatio; 
    private float yBusinessProfitRiseRatio; 
    private float yNetProfitRiseRatio; 
    
    private float ySales; 
    private float yBusinessProfit; 
    private float yTermNetProfit; 
    
    private float yDebtRatio; 
    private float yRetentionRatio; 
    private String ySettingYyyymm; 
    
    //분기 
    private float qPbr;  
    private float qPer;  
    private float qRoe; 
    private float qEps;  
    private float qBps; 

    private float qSalesRiseRatio; 
    private float qBusinessProfitRiseRatio; 
    private float qNetProfitRiseRatio; 
    
    private float qSales; 
    private float qBusinessProfit; 
    private float qTermNetProfit; 
    
    private float qRetentionRatio; 
    private float qDebtRatio; 
    private String qSettingYyyymm;
    
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
	public String getIndustryCode() {
		return industryCode;
	}
	public void setIndustryCode(String industryCode) {
		this.industryCode = industryCode;
	}
	public String getIndustryName() {
		return industryName;
	}
	public void setIndustryName(String industryName) {
		this.industryName = industryName;
	}
	public String getMarketKind() {
		return marketKind;
	}
	public void setMarketKind(String marketKind) {
		this.marketKind = marketKind;
	}
	public String getKospi200() {
		return kospi200;
	}
	public void setKospi200(String kospi200) {
		this.kospi200 = kospi200;
	}
	public String getSupervision() {
		return supervision;
	}
	public void setSupervision(String supervision) {
		this.supervision = supervision;
	}
	public String getControlKind() {
		return controlKind;
	}
	public void setControlKind(String controlKind) {
		this.controlKind = controlKind;
	}
	public String getStatusKind() {
		return statusKind;
	}
	public void setStatusKind(String statusKind) {
		this.statusKind = statusKind;
	}
	public String getClosePrice() {
		return closePrice;
	}
	public void setClosePrice(String closePrice) {
		this.closePrice = closePrice;
	}
	public int getTotalStocks() {
		return totalStocks;
	}
	public void setTotalStocks(int totalStocks) {
		this.totalStocks = totalStocks;
	}
	public int getCapital() {
		return capital;
	}
	public void setCapital(int capital) {
		this.capital = capital;
	}
	public int getFaceValue() {
		return faceValue;
	}
	public void setFaceValue(int faceValue) {
		this.faceValue = faceValue;
	}
	public float getyPbr() {
		return yPbr;
	}
	public void setyPbr(float yPbr) {
		this.yPbr = yPbr;
	}
	public float getyPer() {
		return yPer;
	}
	public void setyPer(float yPer) {
		this.yPer = yPer;
	}
	public float getyRoe() {
		return yRoe;
	}
	public void setyRoe(float yRoe) {
		this.yRoe = yRoe;
	}
	public float getyEps() {
		return yEps;
	}
	public void setyEps(float yEps) {
		this.yEps = yEps;
	}
	public float getyBps() {
		return yBps;
	}
	public void setyBps(float yBps) {
		this.yBps = yBps;
	}
	public float getySalesRiseRatio() {
		return ySalesRiseRatio;
	}
	public void setySalesRiseRatio(float ySalesRiseRatio) {
		this.ySalesRiseRatio = ySalesRiseRatio;
	}
	public float getyBusinessProfitRiseRatio() {
		return yBusinessProfitRiseRatio;
	}
	public void setyBusinessProfitRiseRatio(float yBusinessProfitRiseRatio) {
		this.yBusinessProfitRiseRatio = yBusinessProfitRiseRatio;
	}
	public float getyNetProfitRiseRatio() {
		return yNetProfitRiseRatio;
	}
	public void setyNetProfitRiseRatio(float yNetProfitRiseRatio) {
		this.yNetProfitRiseRatio = yNetProfitRiseRatio;
	}
	public float getySales() {
		return ySales;
	}
	public void setySales(float ySales) {
		this.ySales = ySales;
	}
	public float getyBusinessProfit() {
		return yBusinessProfit;
	}
	public void setyBusinessProfit(float yBusinessProfit) {
		this.yBusinessProfit = yBusinessProfit;
	}
	public float getyTermNetProfit() {
		return yTermNetProfit;
	}
	public void setyTermNetProfit(float yTermNetProfit) {
		this.yTermNetProfit = yTermNetProfit;
	}
	public float getyDebtRatio() {
		return yDebtRatio;
	}
	public void setyDebtRatio(float yDebtRatio) {
		this.yDebtRatio = yDebtRatio;
	}
	public float getyRetentionRatio() {
		return yRetentionRatio;
	}
	public void setyRetentionRatio(float yRetentionRatio) {
		this.yRetentionRatio = yRetentionRatio;
	}
	public String getySettingYyyymm() {
		return ySettingYyyymm;
	}
	public void setySettingYyyymm(String ySettingYyyymm) {
		this.ySettingYyyymm = ySettingYyyymm;
	}
	public float getqPbr() {
		return qPbr;
	}
	public void setqPbr(float qPbr) {
		this.qPbr = qPbr;
	}
	public float getqPer() {
		return qPer;
	}
	public void setqPer(float qPer) {
		this.qPer = qPer;
	}
	public float getqRoe() {
		return qRoe;
	}
	public void setqRoe(float qRoe) {
		this.qRoe = qRoe;
	}
	public float getqEps() {
		return qEps;
	}
	public void setqEps(float qEps) {
		this.qEps = qEps;
	}
	public float getqBps() {
		return qBps;
	}
	public void setqBps(float qBps) {
		this.qBps = qBps;
	}
	public float getqSalesRiseRatio() {
		return qSalesRiseRatio;
	}
	public void setqSalesRiseRatio(float qSalesRiseRatio) {
		this.qSalesRiseRatio = qSalesRiseRatio;
	}
	public float getqBusinessProfitRiseRatio() {
		return qBusinessProfitRiseRatio;
	}
	public void setqBusinessProfitRiseRatio(float qBusinessProfitRiseRatio) {
		this.qBusinessProfitRiseRatio = qBusinessProfitRiseRatio;
	}
	public float getqNetProfitRiseRatio() {
		return qNetProfitRiseRatio;
	}
	public void setqNetProfitRiseRatio(float qNetProfitRiseRatio) {
		this.qNetProfitRiseRatio = qNetProfitRiseRatio;
	}
	public float getqSales() {
		return qSales;
	}
	public void setqSales(float qSales) {
		this.qSales = qSales;
	}
	public float getqBusinessProfit() {
		return qBusinessProfit;
	}
	public void setqBusinessProfit(float qBusinessProfit) {
		this.qBusinessProfit = qBusinessProfit;
	}
	public float getqTermNetProfit() {
		return qTermNetProfit;
	}
	public void setqTermNetProfit(float qTermNetProfit) {
		this.qTermNetProfit = qTermNetProfit;
	}
	public float getqRetentionRatio() {
		return qRetentionRatio;
	}
	public void setqRetentionRatio(float qRetentionRatio) {
		this.qRetentionRatio = qRetentionRatio;
	}
	public float getqDebtRatio() {
		return qDebtRatio;
	}
	public void setqDebtRatio(float qDebtRatio) {
		this.qDebtRatio = qDebtRatio;
	}
	public String getqSettingYyyymm() {
		return qSettingYyyymm;
	}
	public void setqSettingYyyymm(String qSettingYyyymm) {
		this.qSettingYyyymm = qSettingYyyymm;
	}
	public long getTotalStockPrice() {
		return totalStockPrice;
	}
	public void setTotalStockPrice(long totalStockPrice) {
		this.totalStockPrice = totalStockPrice;
	} 
 
}
