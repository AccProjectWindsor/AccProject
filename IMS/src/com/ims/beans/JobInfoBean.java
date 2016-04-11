package com.ims.beans;

import java.math.BigDecimal;

public class JobInfoBean {
	private int JobCode;
	private String JobTitle;
	private String JobRespon;
	private int NoPosition;
	private BigDecimal JobSalary;
	private int JobGroupCode;

	public int getJobCode() {
		return JobCode;
	}

	public void setJobCode(int JobCode) {
		this.JobCode = JobCode;
	}

	public String getJobTitle() {
		return JobTitle;
	}

	public void setJobTitle(String JobTitle) {
		this.JobTitle = JobTitle;
	}

	public String getJobRespon() {
		return JobRespon;
	}

	public void setIJobRespon(String JobRespon) {
		this.JobRespon = JobRespon;
	}
	public int getNoPosition() {
		return NoPosition;
	}

	public void setNoPosition(int NoPosition) {
		this.NoPosition = NoPosition;
	}
	public BigDecimal getJobSalary() {
		return JobSalary;
	}

	public void setJobSalary(BigDecimal JobSalary) {
		this.JobSalary = JobSalary;
	}
	public int getJobGroupCode() {
		return JobGroupCode;
	}

	public void setJobGroupCode(int JobGroupCode) {
		this.JobGroupCode = JobGroupCode;
	}
}
