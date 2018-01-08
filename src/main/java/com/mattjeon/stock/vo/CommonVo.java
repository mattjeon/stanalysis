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
public class CommonVo {
    private String companyCode; 
	private String companyName; 
    private String marketKind;   
    private String kospi200;
     
    private String industryCode; 
    private String industryName; 
    private String industryKind;  
     
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
	public String getMarketKind() {
		return marketKind;
	}
	public void setMarketKind(String marketKind) {
		this.marketKind = marketKind;
	}
	public String getIndustryCode() {
		return industryCode;
	}
	public void setIndustryCode(String industryCode) {
		this.industryCode = industryCode;
	}
	public String getKospi200() {
		return kospi200;
	}
	public void setKospi200(String kospi200) {
		this.kospi200 = kospi200;
	}

	public String getIndustryName() {
		return industryName;
	}
	public void setIndustryName(String industryName) {
		this.industryName = industryName;
	}
	public String getIndustryKind() {
		return industryKind;
	}
	public void setIndustryKind(String industryKind) {
		this.industryKind = industryKind;
	}

}
