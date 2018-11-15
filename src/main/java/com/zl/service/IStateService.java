package com.zl.service;

import java.util.List;

import com.zl.pojo.State;

public interface IStateService {
	public State findStateById(Integer stateid);
	
	public List<State> findAllState();
}
