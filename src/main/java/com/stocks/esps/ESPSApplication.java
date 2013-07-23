package com.stocks.esps;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import com.stocks.esps.dao.CompanyInfoDAO;
import com.stocks.esps.models.CompanyInfo;
import com.stocks.esps.models.CompanyInfoViewModel;

@Component("ESPSApplication")
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ESPSApplication {

	@Inject
	private BeanFactory beanFactory;
	
	public CompanyInfoViewModel process(){
		
		
		
		CompanyInfoViewModel viewModel = beanFactory.getBean(CompanyInfoViewModel.class);
		CompanyInfoDAO companyInfoDAO  = new CompanyInfoDAO();
		List<CompanyInfo> companiesList = companyInfoDAO.getAllCompaniesInfo();
		viewModel.setCompanyInfoList(companiesList);
		viewModel.setHello("bhaaai");
		
		return viewModel;

	}
}
