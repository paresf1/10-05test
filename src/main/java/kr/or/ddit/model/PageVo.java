package kr.or.ddit.model;


public class PageVo {
	private int page ;
	private int pageSize ;
	

	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}	
	@Override
	public String toString() {
		return "Paging [page=" + page + ", pageSize=" + pageSize + "]";
	}


}
