package com.preag.pepexcel.data.pojo.project;

import java.time.LocalDate;

import panix.panic.Consts.Mapper;
import panix.panic.persistence.annotations.ForeignKey;
import panix.panic.persistence.annotations.Id;
import panix.panic.persistence.annotations.OneToOne;


public class PepExVwUniqueSearch {

	@Id
	private long id = -1;

	private String		parcelName	= null;
	private LocalDate	createdDate	= null;
	private String		street		= null;
	private String		city		= null;
	private String		abbrev		= null;

	@ForeignKey
	private long cityId = -1;

	private String branchName = null;

	@ForeignKey
	private long branchId = -1;

	private String districtName = null;

	@ForeignKey
	private long districtId = -1;

	@ForeignKey
	private long partOfTownId = -1;

	private String partOfTownName = null;

	@OneToOne(fk = "id", mappedBy = Mapper.MASTER, slave = Parcel.class)
	private Parcel parcel = null;


	public PepExVwUniqueSearch() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getParcelName() {
		return parcelName;
	}

	public void setParcelName(String parcelName) {
		this.parcelName = parcelName;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public long getCityId() {
		return cityId;
	}

	public void setCityId(long cityId) {
		this.cityId = cityId;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public long getBranchId() {
		return branchId;
	}

	public void setBranchId(long branchId) {
		this.branchId = branchId;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public long getDistrictId() {
		return districtId;
	}

	public void setDistrictId(long districtId) {
		this.districtId = districtId;
	}

	public long getPartOfTownId() {
		return partOfTownId;
	}

	public void setPartOfTownId(long partOfTownId) {
		this.partOfTownId = partOfTownId;
	}

	public String getPartOfTownName() {
		return partOfTownName;
	}

	public void setPartOfTownName(String partOfTownName) {
		this.partOfTownName = partOfTownName;
	}


	public Parcel getParcel() {
		return parcel;
	}


	public void setParcel(Parcel parcel) {
		this.parcel = parcel;
	}

	public String getAbbrev() {
		return abbrev;
	}


	public void setAbbrev(String abbrev) {
		this.abbrev = abbrev;
	}

	@Override
	public String toString() {
		return getBranchName() + " | " + getCity() + " | " + getStreet();
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((abbrev == null) ? 0 : abbrev.hashCode());
		result = prime * result + (int) (branchId ^ (branchId >>> 32));
		result = prime * result + ((branchName == null) ? 0 : branchName.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + (int) (cityId ^ (cityId >>> 32));
		result = prime * result + ((createdDate == null) ? 0 : createdDate.hashCode());
		result = prime * result + (int) (districtId ^ (districtId >>> 32));
		result = prime * result + ((districtName == null) ? 0 : districtName.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((parcel == null) ? 0 : parcel.hashCode());
		result = prime * result + ((parcelName == null) ? 0 : parcelName.hashCode());
		result = prime * result + (int) (partOfTownId ^ (partOfTownId >>> 32));
		result = prime * result + ((partOfTownName == null) ? 0 : partOfTownName.hashCode());
		result = prime * result + ((street == null) ? 0 : street.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PepExVwUniqueSearch other = (PepExVwUniqueSearch) obj;
		if (abbrev == null) {
			if (other.abbrev != null)
				return false;
		} else if (!abbrev.equals(other.abbrev))
			return false;
		if (branchId != other.branchId)
			return false;
		if (branchName == null) {
			if (other.branchName != null)
				return false;
		} else if (!branchName.equals(other.branchName))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (cityId != other.cityId)
			return false;
		if (createdDate == null) {
			if (other.createdDate != null)
				return false;
		} else if (!createdDate.equals(other.createdDate))
			return false;
		if (districtId != other.districtId)
			return false;
		if (districtName == null) {
			if (other.districtName != null)
				return false;
		} else if (!districtName.equals(other.districtName))
			return false;
		if (id != other.id)
			return false;
		if (parcel == null) {
			if (other.parcel != null)
				return false;
		} else if (!parcel.equals(other.parcel))
			return false;
		if (parcelName == null) {
			if (other.parcelName != null)
				return false;
		} else if (!parcelName.equals(other.parcelName))
			return false;
		if (partOfTownId != other.partOfTownId)
			return false;
		if (partOfTownName == null) {
			if (other.partOfTownName != null)
				return false;
		} else if (!partOfTownName.equals(other.partOfTownName))
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		return true;
	}


}
