package com.zl.dao;

import java.util.List;


import com.zl.pojo.State;

public interface IStateDao {
	public State findStateById(Integer stateid);
	
	public List<State> findAllState();
}
