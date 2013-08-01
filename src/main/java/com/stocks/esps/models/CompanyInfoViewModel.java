package com.stocks.esps.models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component("CompanyInfoViewModel")
public class CompanyInfoViewModel {

	private List<CompanyInfo> companyInfoList = new ArrayList<CompanyInfo>();

	public List<CompanyInfo> getCompanyInfoList() {
		return companyInfoList;
	}

	public void setCompanyInfoList(List<CompanyInfo> companyInfoList) {
		this.companyInfoList = companyInfoList;
	}


	
}
