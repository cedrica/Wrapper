package com.preag.pepexcel.data.pojo.project;


public class PEP_VwResumeByBranche {

	private long branchId = -1;
	private String branchName;
	private long statusId = -1;
	private long countryId = -1;
	private String statusValue;
	private String countryAbbrev;
	private float sumTotalLivingArea;
	private int sumUnit;
	private double sumPurchasePrice;
	private double sumTotalProjectSalesPrice;
	private int countStatus;
	
	public long getBranchId() {
		return branchId;
	}
	
	public void setBranchId(long branchId) {
		this.branchId = branchId;
	}
	
	public String getBranchName() {
		return branchName;
	}
	
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	
	public long getStatusId() {
		return statusId;
	}
	
	public void setStatusId(long statusId) {
		this.statusId = statusId;
	}
	
	public String getStatusValue() {
		return statusValue;
	}
	
	public void setStatusValue(String statusValue) {
		this.statusValue = statusValue;
	}
	
	public float getSumTotalLivingArea() {
		return sumTotalLivingArea;
	}
	
	public void setSumTotalLivingArea(float sumTotalLivingArea) {
		this.sumTotalLivingArea = sumTotalLivingArea;
	}
	
	public int getSumUnit() {
		return sumUnit;
	}
	
	public void setSumUnit(int sumUnit) {
		this.sumUnit = sumUnit;
	}

	public double getSumPurchasePrice() {
		return sumPurchasePrice;
	}
	
	public void setSumPurchasePrice(double sumPurchasePrice) {
		this.sumPurchasePrice = sumPurchasePrice;
	}

	
	public double getSumTotalProjectSalesPrice() {
		return sumTotalProjectSalesPrice;
	}

	
	public void setSumTotalProjectSalesPrice(double sumTotalProjectSalesPrice) {
		this.sumTotalProjectSalesPrice = sumTotalProjectSalesPrice;
	}

	public int getCountStatus() {
		return countStatus;
	}
	
	public void setCountStatus(int countStatus) {
		this.countStatus = countStatus;
	}

	
	public long getCountryId() {
		return countryId;
	}

	
	public void setCountryId(long countryId) {
		this.countryId = countryId;
	}

	
	public String getCountryAbbrev() {
		return countryAbbrev;
	}

	
	public void setCountryAbbrev(String countryAbbrev) {
		this.countryAbbrev = countryAbbrev;
	}
	
	
	
}
