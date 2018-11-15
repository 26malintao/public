package com.zl.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zl.dao.IDaikuanDao;
import com.zl.pojo.Daikuan;
import com.zl.pojo.FenYe;
import com.zl.pojo.Query;
import com.zl.service.IDaikuanService;
@Service
public class DaikuanServiceImpl implements IDaikuanService {
	@Autowired
	private IDaikuanDao dd;
	@Override
	public Daikuan findById(Integer sqid) {
		// TODO Auto-generated method stub
		return dd.findById(sqid);
	}

	@Override
	public List<Daikuan> findSQByFy(FenYe fy) {
		if(fy.getPage()==null) {
			fy.setPage(1);
		}		
		fy.setRowCount(dd.findRowsByQuery(fy.getQuery()));		
		return dd.findSQByFy(fy);
	}

	@Override
	public int findRowsByQuery(Query query) {
		// TODO Auto-generated method stub
		return dd.findRowsByQuery(query);
	}

	@Override
	public boolean updateSQ(Daikuan daikuan) {
		// TODO Auto-generated method stub
		return dd.updateSQ(daikuan);
	}

	@Override
	public boolean deleteDaikuan(Integer sqid) {
		// TODO Auto-generated method stub
		return dd.deleteDaikuan(sqid);
	}

	@Override
	public boolean deleteAll(int[] box) {
		if(box==null) {
			return false;
		}else {
			return dd.deleteAll(box);
		}
		
	}

}
