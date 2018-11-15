/*package com.zl.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zl.dao.IChangshangDao;
import com.zl.pojo.Changshang;
import com.zl.service.IChangshangService;
@Service
public class ChangshangServiceImpl implements IChangshangService {
	@Autowired
	private IChangshangDao cd;
	@Override
	public Changshang findChangshangById(Integer changshangid) {
		return cd.findChangshangById(changshangid);
	}

	@Override
	public List<Changshang> findAllChangshang() {
		return cd.findAllChangshang();
	}

}
*/