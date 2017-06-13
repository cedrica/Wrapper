package com.preag.pepexcel.data.pojo.project;

import panix.panic.persistence.annotations.ForeignKey;
import panix.panic.persistence.annotations.Id;

public class ParcelLocation {

	@Id
	private long	id				= -1;

	@ForeignKey
	private long	parcelId		= -1;
	private String	street			= null;

	@ForeignKey
	private long	districtId		= -1;
	@ForeignKey
	private long	partOfTownId	= -1;
	@ForeignKey
	private long	planingAreaId	= -1;
	@ForeignKey
	private long	cityId			= -1;


	public ParcelLocation() {
		super();
		// TODO Auto-generated constructor stub
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public long getParcelId() {
		return parcelId;
	}


	public void setParcelId(long parcelId) {
		this.parcelId = parcelId;
	}

	//
	// public long getBranchId() {
	// return branchId;
	// }
	//
	//
	// public void setBranchId(long branchId) {
	// this.branchId = branchId;
	// }


	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
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


	public long getPlaningAreaId() {
		return planingAreaId;
	}


	public void setPlaningAreaId(long planingAreaId) {
		this.planingAreaId = planingAreaId;
	}


	public long getCityId() {
		return cityId;
	}


	public void setCityId(long cityId) {
		this.cityId = cityId;
	}


	// public String getZipCode() {
	// return zipCode;
	// }
	//
	//
	// public void setZipCode(String zipCode) {
	// this.zipCode = zipCode;
	// }


	@Override
	public String toString() {
		return getStreet();
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (cityId ^ (cityId >>> 32));
		result = prime * result + (int) (districtId ^ (districtId >>> 32));
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + (int) (parcelId ^ (parcelId >>> 32));
		result = prime * result + (int) (partOfTownId ^ (partOfTownId >>> 32));
		result = prime * result + (int) (planingAreaId ^ (planingAreaId >>> 32));
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
		ParcelLocation other = (ParcelLocation) obj;
		if (cityId != other.cityId)
			return false;
		if (districtId != other.districtId)
			return false;
		if (id != other.id)
			return false;
		if (parcelId != other.parcelId)
			return false;
		if (partOfTownId != other.partOfTownId)
			return false;
		if (planingAreaId != other.planingAreaId)
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		return true;
	}

}
