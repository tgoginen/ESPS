package com.stocks.esps;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.stocks.esps.models.CompanyInfoViewModel;
import com.stocks.esps.models.CompanyStockQuotesViewModel;


@Controller
//@RequestMapping("/")
public class ESPSController {
	@Inject BeanFactory beanFactory;

	
	@RequestMapping(value={"/test"},method = {RequestMethod.GET})
	public ModelAndView handleRequest(HttpServletRequest request,HttpServletResponse response){
		ModelAndView modelAndView = new ModelAndView("company");
		
		
		ESPSApplication app = beanFactory.getBean(ESPSApplication.class);
 		CompanyInfoViewModel model = app.getCompaniesInfo();
 		modelAndView.addObject("model",model);
 		
		return modelAndView;
	}
	
	@RequestMapping(value={"/company/{companySymbol}"} , method = RequestMethod.GET)
	public ModelAndView handleCompanyRequest(@PathVariable("companySymbol") String companySymbol){
		companySymbol = companySymbol.toUpperCase();
		ModelAndView modelAndView = new ModelAndView("companyinfo");
		ESPSApplication app = beanFactory.getBean(ESPSApplication.class);
		CompanyStockQuotesViewModel model = app.getCompanyHistory(companySymbol);
		modelAndView.addObject("model", model);
		return modelAndView;
	}

	@RequestMapping(value={"/companies"} , method = RequestMethod.GET)
	public ModelAndView handleCompanyList(){
		ModelAndView modelAndView = new ModelAndView("selectcompany");
		ESPSApplication app = beanFactory.getBean(ESPSApplication.class);
 		CompanyInfoViewModel model = app.getCompaniesInfo();
 		modelAndView.addObject("model",model);
		return modelAndView;
	}
	
	@RequestMapping(value="/companieslist", method = RequestMethod.GET)
	public String welcome(ModelMap model) {
 
	//	model.addAttribute("message", "Maven Web Project + Spring 3 MVC - welcome()");
 
		//Spring uses InternalResourceViewResolver and return back index.jsp
	/*	CompanyInfoDAO companyInfoDAO  = new CompanyInfoDAO();
		List<CompanyInfo> companiesList = companyInfoDAO.getAllCompaniesInfo();
		model.addAttribute("companyList", companiesList);*/
		return "company";
 
	}
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String homePage(ModelMap model) {
 
	//	model.addAttribute("message", "Maven Web Project + Spring 3 MVC - welcome()");
 
		//Spring uses InternalResourceViewResolver and return back index.jsp
		return "index";
 
	}
	}
