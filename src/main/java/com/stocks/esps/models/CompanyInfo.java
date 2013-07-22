package com.stocks.esps.models;

public class CompanyInfo {

	private String companySymbol;
	private String companyName;
	
	public CompanyInfo(String companySymbol){
		this.companySymbol = companySymbol;
	}

	public String getCompanySymbol() {
		return companySymbol;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	
}
