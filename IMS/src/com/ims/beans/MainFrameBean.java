package com.ims.beans;

import java.util.List;
import java.util.Map;

public class MainFrameBean {

	private LoginBean loginBean;

	private Map<String, List<LinkPair>> itemList;

	private Map<String, List<LinkPair>> contentList;

	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

	public Map<String, List<LinkPair>> getItemList() {
		return itemList;
	}

	public void setItemList(Map<String, List<LinkPair>> itemList) {
		this.itemList = itemList;
	}

	public Map<String, List<LinkPair>> getContentList() {
		return contentList;
	}

	public void setContentList(Map<String, List<LinkPair>> contentList) {
		this.contentList = contentList;
	}

}
