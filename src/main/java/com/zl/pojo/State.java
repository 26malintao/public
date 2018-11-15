package com.zl.pojo;

import java.io.Serializable;

public class State implements Serializable {
	private Integer stateid;
	private String statename;
	public Integer getStateid() {
		return stateid;
	}
	public void setStateid(Integer stateid) {
		this.stateid = stateid;
	}
	public String getStatename() {
		return statename;
	}
	public void setStatename(String statename) {
		this.statename = statename;
	}
	
}
