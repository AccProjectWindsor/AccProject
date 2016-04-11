package com.ims.action.search;

import com.ims.beans.CompanyInfoBean;
import com.ims.statics.OperationType;
import com.opensymphony.xwork2.ActionSupport;

public class SearchInternAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int operationFlag;

	private int targetID;

	private CompanyInfoBean companyInfoBean;

	// TODO: Dummy Login
	@Override
	public String execute() throws Exception {
		
		System.out.println(targetID);
		System.out.println(operationFlag);
		
		
		if (OperationType.UPDATE == operationFlag) {

			System.out.println("Update Company!");

			System.out.println(targetID);

			// TODO: DO UPDATE
			return SUCCESS;
		} else if (OperationType.CREATE == operationFlag) {

			System.out.println("Insert Company!");
			// TODO: DO INSERT
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	public int getOperationFlag() {
		return operationFlag;
	}

	public void setOperationFlag(int operationFlag) {
		this.operationFlag = operationFlag;
	}

	public CompanyInfoBean getCompanyInfoBean() {
		return companyInfoBean;
	}

	public void setCompanyInfoBean(CompanyInfoBean companyInfoBean) {
		this.companyInfoBean = companyInfoBean;
	}

	public int getTargetID() {
		return targetID;
	}

	public void setTargetID(int targetID) {
		this.targetID = targetID;
	}

}
