package com.zl.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zl.dao.ITypeDao;
import com.zl.pojo.Type;
import com.zl.service.ITypeService;
@Service

public class TypeServiceImpl implements ITypeService {
	@Autowired
	private ITypeDao td;
	@Override
	public Type findTypeById(Integer daikuantypeid) {
		// TODO Auto-generated method stub
		return td.findTypeById(daikuantypeid);
	}

	@Override
	public List<Type> findAllType() {
		// TODO Auto-generated method stub
		return td.findAllType();
	}

}
