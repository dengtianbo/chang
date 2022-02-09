package com.situ.utils;

public class PaginateInfo {
	private static final Integer DEFAULT_PAGENO = 1;
	private static final Integer DEFAULT_PAGESIZE = 15;

	private Integer pageNo;// 第几页
	private Integer pageSize;// 每页显示多少条记录

	private Integer count;// 总记录数
	private Integer pages;// 总页数
	private Integer navItemCount = 5;// 导航页个数

	public PaginateInfo(Integer pageNo, Integer pageSize) {
		super();
		// 当前页
		setPageNo(pageNo);
		// 每页显示多少条记录
		setPageSize(pageSize);
	}

	public void setPageNo(Integer pageNo) {
		if (pageNo == null) {
			this.pageNo = DEFAULT_PAGENO;
		} else {
			this.pageNo = pageNo < 1 ? 1 : pageNo;
		}
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize == null ? DEFAULT_PAGESIZE : pageSize;
	}


	public Integer getPageNo() {
		return pageNo;
	}

	public Integer getCount() {
		return count;
	}

	/**
	 * 设置总记录数
	 * @param count
	 */
	public void setCount(Integer count) {
		this.count = count;
		// 计算总页数
		this.pages = count / getPageSize();// 总页数
		if (count % getPageSize() > 0) {
			this.pages += 1;
		}
		// 重新修正当前页码
		if (this.pages>0&&this.pageNo > pages) {
			this.pageNo = pages;
		}
		if (this.pageNo < 1) {
			this.pageNo = 1;
		}
	}

	public Integer getPageSize() {
		return pageSize;
	}

	/**
	 * 获取总页数
	 * @return
	 */
	public Integer getPages() {
		return pages;
	}

	// 从第几个位置开始查
	public Integer getOffset() {
		return (this.pageNo - 1) * this.pageSize;
	}

	// 查询多少条
	public Integer getLimit() {
		return getPageSize();
	}

	public Integer getNavItemCount() {
		return navItemCount;
	}

	public void setNavItemCount(Integer navItemCount) {
		this.navItemCount = navItemCount;
	}

	/**
	 * 导航页起始值
	 * @return
	 */
	public int getNavItemStart() {
		int cnt = this.navItemCount / 2;
		int start = this.pageNo - cnt;
		if (start < 1) {
			start = 1;
		}
		return start;
	}

	/**
	 * 导航页结束值
	 * @return
	 */
	public int getNavItemEnd() {
		int end = getNavItemStart() + navItemCount - 1;
		if (end > this.pages) {
			end = this.pages;
		}
		return end;
	}

}
