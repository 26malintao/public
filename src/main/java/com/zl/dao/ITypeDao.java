package com.zl.dao;

import java.util.List;

import com.zl.pojo.Type;

public interface ITypeDao {
	public Type findTypeById(Integer daikuantypeid);
	
	public List<Type> findAllType();
}
