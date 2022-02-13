package com.manhpv.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "work")
public class WorkEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY	)
	@Column
	private long id;
	@Column()
	private String name;
	@Column(name = "startdate")
	private Date startDate;
	@Column(name = "enddate")
	private Date endDate;
	@Column()
	private int status;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getStratDate() {
		return startDate;
	}
	public void setStratDate(Date stratDate) {
		this.startDate = stratDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date andDate) {
		this.endDate = andDate;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public WorkEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
