package com.ims.action.list;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.ims.beans.LoginBean;
import com.ims.beans.StudentInfoBean;
import com.opensymphony.xwork2.ActionSupport;

public class ListStudentAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private LoginBean loginBean;

	private List<StudentInfoBean> studentList = new ArrayList<StudentInfoBean>();

	// TODO: Dummy Login
	@Override
	public String execute() throws Exception {

		Calendar cal = Calendar.getInstance();
		cal.set(1990, 1, 1);
		for (int i = 0; i < 20; i++) {
			cal.add(Calendar.DATE, 1);
			SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
			StudentInfoBean student = new StudentInfoBean();
			student.setStuId(i);
			student.setFirstName("S_FN" + i);
			student.setLastName("S_FN" + i);
			student.setAddress("S_" + i + " Address");
			student.setStatus(i % 4);
			student.setCountry("Canada");
			student.setPostcode("X0X 0X0");
			student.setDateOfBirth(format1.format(cal.getTime()));
			student.setGender(i % 2);
			student.setEmail("email_" + i + "@XXXXX.com");
			student.setTelephone(String.valueOf(5000000000L + i));
			studentList.add(student);
		}

		return SUCCESS;
	}

	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

	public List<StudentInfoBean> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<StudentInfoBean> studentList) {
		this.studentList = studentList;
	}

}
