package com.stocks.esps.models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component("CompanyStockQuotesViewModel")
public class CompanyStockQuotesViewModel {
	
	private String companySymbol;
	private List<CompanyStockPrice> historicalQuotes = new ArrayList<CompanyStockPrice>();
	

	public String getCompanySymbol() {
		return companySymbol;
	}

	public void setCompanySymbol(String companySymbol) {
		this.companySymbol = companySymbol;
	}

	public List<CompanyStockPrice> getHistoricalQuotes() {
		return historicalQuotes;
	}

	public void setHistoricalQuotes(List<CompanyStockPrice> historicalQuotes) {
		this.historicalQuotes = historicalQuotes;
	}
	
	

}
