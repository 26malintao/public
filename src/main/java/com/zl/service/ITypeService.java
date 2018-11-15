package com.zl.service;

import java.util.List;

import com.zl.pojo.Type;

public interface ITypeService {
public Type findTypeById(Integer daikuantypeid);
	
	public List<Type> findAllType();
}
