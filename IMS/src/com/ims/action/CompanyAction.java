package com.ims.action;

import java.util.ArrayList;
import java.util.List;

import com.ims.beans.CompanyInfoBean;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

public class CompanyAction extends ActionSupport {

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

	private List<CompanyInfoBean> gridModel;

	@Override
	public String execute() {
		String type = "";
		List<CompanyInfoBean> companyList = new ArrayList<CompanyInfoBean>();
		try {

			if (filters == null || "".equals(filters)) {
				companyList.clear();
				for (int i = 0; i < 50; i++) {
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
				companyList.clear();
				for (int i = 7; i < 30; i++) {

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
			}

			if (sidx != null && !sidx.equals("")) {
				System.out.println("sort by " + sidx);
				companyList.clear();
				if (sord.equals("desc")) {
					for (int i = 130; i > 99; i--) {
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
				} else {
					companyList.clear();
					for (int i = 99; i < 130; i++) {
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
				}
			}

			int to = (rows * page);
			int from = to - rows;

			// Count Rows (select count(*) from custumer)
			records = companyList.size();

			// calculate the total pages for the query
			total = (int) Math.ceil((double) records / (double) rows);

			if (to > records) {
				setGridModel(companyList.subList(from, records));
			} else {
				setGridModel(companyList.subList(from, to));
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

	public List<CompanyInfoBean> getGridModel() {
		return gridModel;
	}

	public void setGridModel(List<CompanyInfoBean> gridModel) {
		this.gridModel = gridModel;
	}

	public void setFilters(String filters) {
		this.filters = filters;
	}

	public String getFilters() {
		return filters;
	}

}
