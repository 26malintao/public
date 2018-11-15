package com.zl.pojo;

import java.io.Serializable;

public class Query implements Serializable {
	private String qhostname;
	private Integer qdaikuantypeid;
	private Integer lowprice;
	private Integer highprice;
	public String getQhostname() {
		return qhostname;
	}
	public void setQhostname(String qhostname) {
		this.qhostname = qhostname;
	}
	public Integer getQdaikuantypeid() {
		return qdaikuantypeid;
	}
	public void setQdaikuantypeid(Integer qdaikuantypeid) {
		this.qdaikuantypeid = qdaikuantypeid;
	}
	public Integer getLowprice() {
		return lowprice;
	}
	public void setLowprice(Integer lowprice) {
		this.lowprice = lowprice;
	}
	public Integer getHighprice() {
		return highprice;
	}
	public void setHighprice(Integer highprice) {
		this.highprice = highprice;
	}

	
}
