package com.ims.action;

import java.util.ArrayList;
import java.util.List;

import com.ims.beans.CompanyInfoBean;
import com.opensymphony.xwork2.ActionSupport;

public class CompanyEditAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String oper;
	private String code;
	private String name;
	private String country;
	private String city;
	private double creditLimit;

	@Override
	public String execute() {

		CompanyInfoBean company;
		
		if (oper.equalsIgnoreCase("add")) {
			System.out.println("ADD");
			company = new CompanyInfoBean();
			company.setName(name);

			// CustomerDAO.save(company);
		} else if (oper.equalsIgnoreCase("edit")) {

			System.out.println("edit");
			// company = CustomerDAO.findById(Integer.parseInt(id));
			//company.setName(name);

			// CustomerDAO.update(company);
		} else if (oper.equalsIgnoreCase("del")) {
			System.out.println("delete");
			System.out.println(code);
			System.out.println(name);
			// customer = CustomerDAO.findById(Integer.parseInt(id));
			// CustomerDAO.delete(customer);
		}

		return SUCCESS;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getOper() {
		return oper;
	}

	public void setOper(String oper) {
		this.oper = oper;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(double creditLimit) {
		this.creditLimit = creditLimit;
	}

}
