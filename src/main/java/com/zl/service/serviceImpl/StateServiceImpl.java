package com.zl.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zl.dao.IStateDao;
import com.zl.pojo.State;
import com.zl.service.IStateService;
@Service
public class StateServiceImpl implements IStateService {
	@Autowired
	private IStateDao sd;
	@Override
	public State findStateById(Integer stateid) {
		// TODO Auto-generated method stub
		return sd.findStateById(stateid);
	}

	@Override
	public List<State> findAllState() {
		// TODO Auto-generated method stub
		return sd.findAllState();
	}

}
