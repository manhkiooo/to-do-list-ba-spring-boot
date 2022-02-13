package com.manhpv.api.output;

import java.util.ArrayList;
import java.util.List;

import com.manhpv.dto.WorkDto;

public class WorkOutput {
	private int page;
	private int totalPage;
	private List<WorkDto> list =  new ArrayList<WorkDto>();
	private String sort;
	private int error;
	private String message;
	
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public int getError() {
		return error;
	}
	public void setError(int error) {
		this.error = error;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<WorkDto> getList() {
		return list;
	}
	public void setList(List<WorkDto> list) {
		this.list = list;
	}
}
