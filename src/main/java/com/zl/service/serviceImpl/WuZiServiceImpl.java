/*package com.zl.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zl.dao.IWuZiDao;
import com.zl.pojo.FenYe;
import com.zl.pojo.Query;
import com.zl.pojo.WuZi;
import com.zl.service.IWuZiService;
@Service
public class WuZiServiceImpl implements IWuZiService {
	@Autowired
	private IWuZiDao wuziDaoImpl;

	@Override
	public WuZi findById(Integer wuziid) {
		// TODO Auto-generated method stub
		return wuziDaoImpl.findById(wuziid);
	}

	@Override
	public List<WuZi> findWuZiByFy(FenYe fy) {
		if(fy.getPage()==null) {
			fy.setPage(1);
		}		
		fy.setRowCount(wuziDaoImpl.findRowsByQuery(fy.getQuery()));		
		return wuziDaoImpl.findWuZiByFy(fy);
	}

	@Override
	public int findRowsByQuery(Query querys) {
		// TODO Auto-generated method stub
		return wuziDaoImpl.findRowsByQuery(querys);
	}

	@Override
	public boolean updatewuzi(WuZi wuzi) {
		// TODO Auto-generated method stub
		return wuziDaoImpl.updatewuzi(wuzi);
	}

	@Override
	public boolean deletewuzi(Integer wuziid) {
		// TODO Auto-generated method stub
		return wuziDaoImpl.deletewuzi(wuziid);
	}

	@Override
	public boolean deleteAll(int[] box) {
		// TODO Auto-generated method stub
		return wuziDaoImpl.deleteAll(box);
	}
	

}
*/