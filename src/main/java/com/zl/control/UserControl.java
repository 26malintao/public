package com.zl.control;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zl.pojo.User;
import com.zl.service.IUsersService;


@Controller
@RequestMapping("/uc")
public class UserControl {
	@Autowired
	private IUsersService userServiceImpl;
	@RequestMapping(value="/ck")
	@ResponseBody
	public String  login(User user,HttpSession session) {
		user=userServiceImpl.IsLogin(user);
		if(user!=null) {
			session.setAttribute("loginUser", user);
			return "true";
		}else {
			return "false";
		}

	}
}
