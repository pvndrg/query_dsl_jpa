package com.example.demo.response;

public class PaginationDetails
{

	private long totalItems;
	private int totalPages;
	private int currentPageItem;
	private int currentPage;
	private int pageSize;
	private Boolean isMyPortfolioActive;
	private Boolean isFirstPage;
	private Boolean isLastPage;
	private Boolean prev;
	private Boolean next;
	
	public PaginationDetails(int size, int offset, 
			double total,
			double limit,
			int pageNumber, int pageSize, boolean isMyPortfolioActive) {
		if((int) total/(int) limit < total/limit) {
			this.totalPages = (int) (total/limit);
			++this.totalPages;
		}else {
			this.totalPages = (int) (total/limit);
		}
		if (pageNumber == 0) {
			this.isFirstPage = true;
			this.prev = false;
			}
		else {				
			this.isFirstPage = false;
			this.prev = true;
		}
		if(offset >= this.totalPages) {
			this.isLastPage = true;
			this.next = false;
		}else {
			this.isLastPage = false;
			this.next = true;
		}
		
		this.totalItems = (int) total;
		this.currentPageItem = size;
		this.currentPage = pageNumber;
		this.pageSize = (int) limit;
		this.isMyPortfolioActive = isMyPortfolioActive;
	}

	public PaginationDetails() {
		// TODO Auto-generated constructor stub
	}

	public Boolean getIsMyPortfolioActive()
	{
		return isMyPortfolioActive;
	}

	public void setIsMyPortfolioActive(Boolean isMyPortfolioActive)
	{
		this.isMyPortfolioActive = isMyPortfolioActive;
	}

	public int getCurrentPageItem()
	{
		return currentPageItem;
	}

	public void setCurrentPageItem(int currentPageItem)
	{
		this.currentPageItem = currentPageItem;
	}

	public int getPageSize()
	{
		return pageSize;
	}

	public void setPageSize(int pageSize)
	{
		this.pageSize = pageSize;
	}

	public long getTotalItems()
	{
		return totalItems;
	}

	public void setTotalItems(long totalItems)
	{
		this.totalItems = totalItems;
	}

	public int getTotalPages()
	{
		return totalPages;
	}

	public void setTotalPages(int totalPages)
	{
		this.totalPages = totalPages;
	}

	public int getCurrentPage()
	{
		return currentPage;
	}

	public void setCurrentPage(int currentPage)
	{
		this.currentPage = currentPage;
	}

	public Boolean getIsFirstPage()
	{
		return isFirstPage;
	}

	public void setIsFirstPage(Boolean isFirstPage)
	{
		this.isFirstPage = isFirstPage;
	}

	public Boolean getIsLastPage()
	{
		return isLastPage;
	}

	public void setIsLastPage(Boolean isLastPage)
	{
		this.isLastPage = isLastPage;
	}

	public Boolean getPrev()
	{
		return prev;
	}

	public void setPrev(Boolean prev)
	{
		this.prev = prev;
	}

	public Boolean getNext()
	{
		return next;
	}

	public void setNext(Boolean next)
	{
		this.next = next;
	}

}
