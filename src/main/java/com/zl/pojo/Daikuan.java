package com.zl.pojo;

import java.io.Serializable;
import java.util.Date;

public class Daikuan implements Serializable {
	private Integer sqid;
	private String hostname;
	private double price;
	private Integer daikuantypeid;
	private Type type;
	private Date sqdate;
	private Integer stateid;
	private State state;
	
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	public Integer getSqid() {
		return sqid;
	}
	public void setSqid(Integer sqid) {
		this.sqid = sqid;
	}
	public String getHostname() {
		return hostname;
	}
	public void setHostname(String hostname) {
		this.hostname = hostname;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	public Integer getDaikuantypeid() {
		return daikuantypeid;
	}
	public void setDaikuantypeid(Integer daikuantypeid) {
		this.daikuantypeid = daikuantypeid;
	}
	public Date getSqdate() {
		return sqdate;
	}
	public void setSqdate(Date sqdate) {
		this.sqdate = sqdate;
	}
	public Integer getStateid() {
		return stateid;
	}
	public void setStateid(Integer stateid) {
		this.stateid = stateid;
	}
	
}
