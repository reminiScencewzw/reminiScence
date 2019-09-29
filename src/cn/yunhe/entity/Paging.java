package cn.yunhe.entity;

import java.util.List;

public class Paging {

	/**
	 * 数据总条数
	 */
	private int total;
	
	/**
	 * 页码数
	 */
	private int pageIndex;
	
	/**
	 * 每页显示的数据总条数
	 */
	private int pageCount;
	
	/**
	 *	 总页数
	 */
	private int pageTotal;
	/**
	 * 数据列表
	 */
	private List<?> list;
	
	public Paging() {}

	public Paging(int total, int pageIndex, int pageCount, List<?> list) {
		super();
		this.total = total;
		this.pageIndex = pageIndex;
		this.pageCount = pageCount;
		this.list = list;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
		int pageTotal = total%getPageCount()==0?total/pageCount:total/pageCount+1;
		setPageTotal(pageTotal);
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public List<?> getList() {
		return list;
	}

	public void setList(List<?> list) {
		this.list = list;
	}

	public int getPageTotal() {
		return pageTotal;
	}

	public void setPageTotal(int pageTotal) {
		this.pageTotal = pageTotal;
	}

	@Override
	public String toString() {
		return "Paging [total=" + total + ", pageIndex=" + pageIndex + ", pageCount=" + pageCount + ", list=" + list
				+ "]";
	}
}
