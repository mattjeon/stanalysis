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
public class RecommendVo {
	 
	private String companyCode;
	private String companyName;
	
	private String regDate;  
	private int tradeSignal;
	private String tradeSignalMsg;
	
	// 이하 거래종목의 현 상태를 표시하기 위한 항목들
	private double updownRatio;
	private double maxUpdownRatio;

	private int cnt;

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

	public int getTradeSignal() {
		return tradeSignal;
	}

	public void setTradeSignal(int tradeSignal) {
		this.tradeSignal = tradeSignal;
	}

	public String getTradeSignalMsg() {
		return tradeSignalMsg;
	}

	public void setTradeSignalMsg(String tradeSignalMsg) {
		this.tradeSignalMsg = tradeSignalMsg;
	}

	public double getUpdownRatio() {
		return updownRatio;
	}

	public void setUpdownRatio(double updownRatio) {
		this.updownRatio = updownRatio;
	}

	public double getMaxUpdownRatio() {
		return maxUpdownRatio;
	}

	public void setMaxUpdownRatio(double maxUpdownRatio) {
		this.maxUpdownRatio = maxUpdownRatio;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

}
