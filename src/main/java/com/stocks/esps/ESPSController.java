package com.stocks.esps;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/")
public class ESPSController {
	
/*	@RequestMapping(value="/test",method = RequestMethod.GET)
	public ModelAndView handleRequest(HttpServerErrorException request){
		ModelAndView modelAndView = new ModelAndView("company");
		CompanyInfoDAO companyInfoDAO  = new CompanyInfoDAO();
		List<CompanyInfo> companiesList = companyInfoDAO.getAllCompaniesInfo();
		CompanyInfoViewModel viewModel = new CompanyInfoViewModel();
		viewModel.setCompanyInfoList(companiesList);
		modelAndView.addObject("model", viewModel);
		return modelAndView;
	}*/

	@RequestMapping(value="/companies", method = RequestMethod.GET)
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
