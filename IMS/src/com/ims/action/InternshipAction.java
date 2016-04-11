package com.ims.action;

import java.util.ArrayList;
import java.util.List;

import com.ims.beans.InternshipInfoBean;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

public class InternshipAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// get how many rows we want to have into the grid - rowNum attribute in the
	// grid
	private Integer rows = 0;

	// Get the requested page. By default grid sets this to 1.
	private Integer page = 0;

	// sorting order - asc or desc
	private String sord;

	// get index row - i.e. user click to sort.
	private String sidx;

	// Search Field
	private String searchField;

	// The Search String
	private String searchString;

	// Limit the result when using local data, value form attribute rowTotal
	private Integer totalrows;

	// he Search Operation
	// ['eq','ne','lt','le','gt','ge','bw','bn','in','ni','ew','en','cn','nc']
	private String searchOper;

	// Your Total Pages
	private Integer total = 0;

	// All Records
	private Integer records = 0;

	private String filters;

	private boolean loadonce = false;

	private List<InternshipInfoBean> gridModel;

	@Override
	public String execute() {
		String type = "";
		List<InternshipInfoBean> internshipList = new ArrayList<InternshipInfoBean>();
		try {

			if (filters == null || "".equals(filters)) {
				internshipList.clear();
				for (int i = 0; i < 50; i++) {
					InternshipInfoBean internship = new InternshipInfoBean();
					internship.setInternCode(i);
					internship.setCompanyCode(i);
					internship.setCompanyName("C_" + i + " Name");
					internship.setCompanyAdress("C_" + i + " Address");
					internship.setInterShipTitle("Intern_" + i + " Title");
					internship.setJobType(i);
					internship.setInternTypeCode(i);
					internship.setCntctPsnFName("Contact_" + i + " Fname");
					internship.setCntctPsnLName("Contact_" + i + " Lname");
					internship.setCntctPsnPosition("Contact_" + i + " Position");
					internship.setTelephone("X0X-X0X-X0X0");
					internship.setEmail(i + "XXmail.com");
					internship.setNotes("Intern" + i + " Notes");
					internshipList.add(internship);
				}
			} else {

				JSONObject jsonFilter = (JSONObject) JSONSerializer.toJSON(filters);
				String groupOp = jsonFilter.getString("groupOp");
				System.out.println(groupOp);
				JSONArray rules = jsonFilter.getJSONArray("rules");
				int rulesCount = JSONArray.getDimensions(rules)[0];
				for (int i = 0; i < rulesCount; i++) {
					JSONObject rule = rules.getJSONObject(i);
					System.out.println("field :" + rule.getString("field"));
					System.out.println("op :" + rule.getString("op"));
					System.out.println("data :" + rule.getString("data"));
				}
				internshipList.clear();
				for (int i = 7; i < 30; i++) {

					InternshipInfoBean internship = new InternshipInfoBean();
					internship.setInternCode(i);
					internship.setCompanyCode(i);
					internship.setCompanyName("C_" + i + " Name");
					internship.setCompanyAdress("C_" + i + " Address");
					internship.setInterShipTitle("Intern_" + i + " Title");
					internship.setJobType(i);
					internship.setInternTypeCode(i);
					internship.setCntctPsnFName("Contact_" + i + " Fname");
					internship.setCntctPsnLName("Contact_" + i + " Lname");
					internship.setCntctPsnPosition("Contact_" + i + " Position");
					internship.setTelephone("X0X-X0X-X0X0");
					internship.setEmail(i + "XXmail.com");
					internship.setNotes("Intern" + i + " Notes");
					internshipList.add(internship);
				}
			}

			if (sidx != null && !sidx.equals("")) {
				System.out.println("sort by " + sidx);
				internshipList.clear();
				if (sord.equals("desc")) {
					for (int i = 130; i > 99; i--) {
						InternshipInfoBean internship = new InternshipInfoBean();
						internship.setInternCode(i);
						internship.setCompanyCode(i);
						internship.setCompanyName("C_" + i + " Name");
						internship.setCompanyAdress("C_" + i + " Address");
						internship.setInterShipTitle("Intern_" + i + " Title");
						internship.setJobType(i);
						internship.setInternTypeCode(i);
						internship.setCntctPsnFName("Contact_" + i + " Fname");
						internship.setCntctPsnLName("Contact_" + i + " Lname");
						internship.setCntctPsnPosition("Contact_" + i + " Position");
						internship.setTelephone("X0X-X0X-X0X0");
						internship.setEmail(i + "XXmail.com");
						internship.setNotes("Intern" + i + " Notes");
						internshipList.add(internship);
					}
				} else {
					internshipList.clear();
					for (int i = 99; i < 130; i++) {
						InternshipInfoBean internship = new InternshipInfoBean();
						internship.setInternCode(i);
						internship.setCompanyCode(i);
						internship.setCompanyName("C_" + i + " Name");
						internship.setCompanyAdress("C_" + i + " Address");
						internship.setInterShipTitle("Intern_" + i + " Title");
						internship.setJobType(i);
						internship.setInternTypeCode(i);
						internship.setCntctPsnFName("Contact_" + i + " Fname");
						internship.setCntctPsnLName("Contact_" + i + " Lname");
						internship.setCntctPsnPosition("Contact_" + i + " Position");
						internship.setTelephone("X0X-X0X-X0X0");
						internship.setEmail(i + "XXmail.com");
						internship.setNotes("Intern" + i + " Notes");
						internshipList.add(internship);
					}
				}
			}

			int to = (rows * page);
			int from = to - rows;

			// Count Rows (select count(*) from custumer)
			records = internshipList.size();

			// calculate the total pages for the query
			total = (int) Math.ceil((double) records / (double) rows);

			if (to > records) {
				setGridModel(internshipList.subList(from, records));
			} else {
				setGridModel(internshipList.subList(from, to));
			}

			System.out.println("execute");

			type = SUCCESS;
		} catch (Exception e) {
			type = ERROR;
		}
		return type;
	}

	public String getJSON() {
		return execute();
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public String getSord() {
		return sord;
	}

	public void setSord(String sord) {
		this.sord = sord;
	}

	public String getSidx() {
		return sidx;
	}

	public void setSidx(String sidx) {
		this.sidx = sidx;
	}

	public String getSearchField() {
		return searchField;
	}

	public void setSearchField(String searchField) {
		this.searchField = searchField;
	}

	public String getSearchString() {
		return searchString;
	}

	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}

	public Integer getTotalrows() {
		return totalrows;
	}

	public void setTotalrows(Integer totalrows) {
		this.totalrows = totalrows;
	}

	public String getSearchOper() {
		return searchOper;
	}

	public void setSearchOper(String searchOper) {
		this.searchOper = searchOper;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getRecords() {
		return records;
	}

	public void setRecords(Integer records) {
		this.records = records;
	}

	public boolean isLoadonce() {
		return loadonce;
	}

	public void setLoadonce(boolean loadonce) {
		this.loadonce = loadonce;
	}

	public List<InternshipInfoBean> getGridModel() {
		return gridModel;
	}

	public void setGridModel(List<InternshipInfoBean> gridModel) {
		this.gridModel = gridModel;
	}

	public void setFilters(String filters) {
		this.filters = filters;
	}

	public String getFilters() {
		return filters;
	}

}
