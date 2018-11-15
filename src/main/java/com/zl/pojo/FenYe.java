package com.zl.pojo;

import java.io.Serializable;
//∑÷“≥¿‡

public class FenYe implements Serializable {
		
		private Integer page;
		
		private Integer pageCount;
	
		private Integer rows=5;
		
		private Integer rowCount;
	
		private Integer rowStart;
		
		private Integer rowEnd;
		
		private Query query;

		public Query getQuery() {
			return query;
		}
		public void setQuery(Query query) {
			this.query = query;
		}
		public Integer getPage() {
			return page;
		}
		public void setPage(Integer page) {
			this.page = page;
		}
		public Integer getPageCount() {
			if(getRowCount()%getRows()==0) {
				pageCount=getRowCount()/getRows();
			}else {
				pageCount=getRowCount()/getRows()+1;
			}
			if(getRowCount()/getRows()==0) {
				pageCount=1;
			}
			return pageCount;
		}
		public void setPageCount(Integer pageCount) {
			this.pageCount = pageCount;
		}
		public Integer getRows() {
			return rows;
		}
		public void setRows(Integer rows) {
			this.rows = rows;
		}
		public Integer getRowCount() {
			return rowCount;
		}
		public void setRowCount(Integer rowCount) {
			this.rowCount = rowCount;
		}
		public Integer getRowStart() {
			rowStart=(getPage()-1)*getRows();
			return rowStart;
		}
		public void setRowStart(Integer rowStart) {
			this.rowStart = rowStart;
		}
		public Integer getRowEnd() {
			rowEnd=getPage()*getRows();
			return rowEnd;
		}
		public void setRowEnd(Integer rowEnd) {
			this.rowEnd = rowEnd;
		}
		
}
