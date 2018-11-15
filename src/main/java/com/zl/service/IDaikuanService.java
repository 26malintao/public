package com.zl.service;

import java.util.List;

import com.zl.pojo.Daikuan;
import com.zl.pojo.FenYe;
import com.zl.pojo.Query;

public interface IDaikuanService {
	public Daikuan findById(Integer sqid);
	
	public List<Daikuan> findSQByFy(FenYe fy);
	
	public int findRowsByQuery(Query query);
	
	public boolean updateSQ(Daikuan daikuan);	
	
	public boolean deleteDaikuan(Integer sqid);	
	
	public boolean deleteAll(int[] box);
}
