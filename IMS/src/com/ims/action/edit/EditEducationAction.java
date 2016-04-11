package com.ims.action.edit;

import com.ims.beans.MainFrameBean;
import com.opensymphony.xwork2.ActionSupport;

public class EditEducationAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private MainFrameBean mainFrameBean;

	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}

	public MainFrameBean getMainFrameBean() {
		return mainFrameBean;
	}

	public void setMainFrameBean(MainFrameBean mainFrameBean) {
		this.mainFrameBean = mainFrameBean;
	}

}
