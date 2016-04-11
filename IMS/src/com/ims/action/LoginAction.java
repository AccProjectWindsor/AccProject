package com.ims.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.ims.beans.LinkPair;
import com.ims.beans.LoginBean;
import com.ims.beans.MainFrameBean;
import com.ims.statics.LoginStatus;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private LoginBean loginBean;

	private MainFrameBean mainFrameBean = new MainFrameBean();

	// TODO: Dummy Login
	@Override
	public String execute() throws Exception {
		if ("123".equals(loginBean.getUserName()) && "123456".equals(loginBean.getPassword())) {
			loginBean.setLoginStatus(LoginStatus.ADMIN);
			InitAdminData();
			return SUCCESS;
		} else if ("123".equals(loginBean.getUserName()) && "123".equals(loginBean.getPassword())) {
			loginBean.setLoginStatus(LoginStatus.STUDENT);
			InitStudentData();

			return SUCCESS;
		} else {
			loginBean.setLoginStatus(LoginStatus.FAIL);
			return ERROR;
		}
	}

	// TODO: Dummy Data
	void InitAdminData() {

		this.mainFrameBean.setLoginBean(this.loginBean);

		Map<String, List<LinkPair>> itemList = new TreeMap<String, List<LinkPair>>();
		List<LinkPair> itemList_1 = new ArrayList<LinkPair>();
		List<LinkPair> itemList_2 = new ArrayList<LinkPair>();

		LinkPair link_1 = new LinkPair();
		link_1.setUrl("showCompany");
		link_1.setText("Add Company");
		LinkPair link_2 = new LinkPair();
		link_2.setUrl("showCompany");
		link_2.setText("Company List");
		LinkPair link_3 = new LinkPair();
		link_3.setUrl("editStudent");
		link_3.setText("Add Student");
		LinkPair link_4 = new LinkPair();
		link_4.setUrl("listStudent");
		link_4.setText("Student List");

		itemList_1.add(link_1);
		itemList_1.add(link_2);
		itemList_2.add(link_3);
		itemList_2.add(link_4);

		itemList.put("Company", itemList_1);
		itemList.put("Student", itemList_2);

		mainFrameBean.setItemList(itemList);

		Map<String, List<LinkPair>> contentMap = new TreeMap<String, List<LinkPair>>();
		List<LinkPair> contentList_1 = new ArrayList<LinkPair>();
		List<LinkPair> contentList_2 = new ArrayList<LinkPair>();

		LinkPair link_11 = new LinkPair();
		link_11.setUrl("");
		link_11.setText("News 1 - 1 aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		LinkPair link_12 = new LinkPair();
		link_12.setUrl("");
		link_12.setText("News 1 - 2 aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		LinkPair link_21 = new LinkPair();
		link_21.setUrl("");
		link_21.setText("News 2 - 1 aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		LinkPair link_22 = new LinkPair();
		link_22.setUrl("");
		link_22.setText("News 2 - 2 aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

		contentList_1.add(link_11);
		contentList_1.add(link_12);

		contentList_2.add(link_21);
		contentList_2.add(link_22);

		contentMap.put("Block 1", contentList_1);
		contentMap.put("Block 2", contentList_2);

		mainFrameBean.setContentList(contentMap);

		System.out.println(mainFrameBean.getItemList());
		System.out.println(mainFrameBean.getItemList());

	}

	// TODO: Dummy Data
	void InitStudentData() {

		this.mainFrameBean = new MainFrameBean();
		this.mainFrameBean.setLoginBean(this.loginBean);

		Map<String, List<LinkPair>> itemList = new TreeMap<String, List<LinkPair>>();
		List<LinkPair> itemList_1 = new ArrayList<LinkPair>();
		List<LinkPair> itemList_2 = new ArrayList<LinkPair>();

		LinkPair link_1 = new LinkPair();
		link_1.setUrl("<s:url action='addCompany'/>");
		link_1.setText("Find Company");
		LinkPair link_2 = new LinkPair();
		link_2.setUrl("<s:url action='addStudent'/>");
		link_2.setText("Find Internship");
		LinkPair link_3 = new LinkPair();
		link_3.setUrl("<s:url action='changeCompany'/>");
		link_3.setText("Change My Info");
		LinkPair link_4 = new LinkPair();
		link_4.setUrl("<s:url action='changeStudent'/>");
		link_4.setText("Change Internship");

		itemList_1.add(link_1);
		itemList_1.add(link_2);
		itemList_2.add(link_3);
		itemList_2.add(link_4);

		itemList.put("Catalog 1", itemList_1);
		itemList.put("Catalog 2", itemList_2);

		mainFrameBean.setItemList(itemList);

		Map<String, List<LinkPair>> contentMap = new TreeMap<String, List<LinkPair>>();
		List<LinkPair> contentList_1 = new ArrayList<LinkPair>();
		List<LinkPair> contentList_2 = new ArrayList<LinkPair>();

		LinkPair link_11 = new LinkPair();
		link_11.setUrl("");
		link_11.setText("News 1 - 1 eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
		LinkPair link_12 = new LinkPair();
		link_12.setUrl("");
		link_12.setText("News 1 - 2 eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
		LinkPair link_21 = new LinkPair();
		link_21.setUrl("");
		link_21.setText("News 2 - 1 eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
		LinkPair link_22 = new LinkPair();
		link_22.setUrl("");
		link_22.setText("News 2 - 2 eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");

		contentList_1.add(link_11);
		contentList_1.add(link_12);

		contentList_2.add(link_21);
		contentList_2.add(link_22);

		contentMap.put("Block 1", contentList_1);
		contentMap.put("Block 2", contentList_2);

		mainFrameBean.setContentList(contentMap);
	}

	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

	public MainFrameBean getMainFrameBean() {
		return mainFrameBean;
	}

	public void setMainFrameBean(MainFrameBean mainFrameBean) {
		this.mainFrameBean = mainFrameBean;
	}

}
