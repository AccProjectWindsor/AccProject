package com.ims.action.list;

import java.util.ArrayList;
import java.util.List;

import com.ims.beans.CompanyInfoBean;
import com.ims.beans.LoginBean;
import com.opensymphony.xwork2.ActionSupport;

public class ListSkillAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private LoginBean loginBean;

	private List<CompanyInfoBean> companyList = new ArrayList<CompanyInfoBean>();

	// TODO: Dummy Login
	@Override
	public String execute() throws Exception {

		for (int i = 0; i < 20; i++) {
			CompanyInfoBean company = new CompanyInfoBean();
			company.setCode(i);
			company.setName("C_" + i);
			company.setAddress("C_" + i + " Address");
			company.setCity("Windsor");
			company.setCountry("Canada");
			company.setPostcode("X0X 0X0");
			company.setWebsite("www.xxxx" + i + ".com");
			companyList.add(company);
		}

		System.out.println("LIST");

		return SUCCESS;
	}

	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

	public List<CompanyInfoBean> getCompanyList() {
		return companyList;
	}

	public void setCompanyList(List<CompanyInfoBean> companyList) {
		this.companyList = companyList;
	}

}
