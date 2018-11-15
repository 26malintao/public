package com.zl.control;



import javax.servlet.http.HttpServletRequest;


import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class FirstPageControl {

	@RequestMapping(value="/")
	public String Fenye(HttpServletRequest request){
		System.out.println("111111111");
		return "forward:/uc/ck";				
	}
	
	
	
	
}
