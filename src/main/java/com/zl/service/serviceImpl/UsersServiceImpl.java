package com.zl.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zl.dao.IUsersDao;
import com.zl.pojo.User;
import com.zl.service.IUsersService;
@Service
public class UsersServiceImpl implements IUsersService {
	@Autowired
	private IUsersDao usersDaoImpl;
	@Override
	public User IsLogin(User user) {
		User u=usersDaoImpl.IsLogin(user);
		if(u==null|user.getLoginname()==null||user.getLoginpwd()==null||user.getLoginname().equals("")||user.getLoginpwd().equals("")) {
			return null;
		}
		return usersDaoImpl.IsLogin(user);
	}

}
