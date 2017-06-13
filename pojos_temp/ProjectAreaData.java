package com.preag.pepexcel.data.pojo.project;

import panix.panic.persistence.annotations.ForeignKey;
import panix.panic.persistence.annotations.Id;

public class ProjectAreaData {

	@Id
	private long id = -1;

	@ForeignKey
	private long parcelId = -1;

	private float landArea = 0;
	private float baseArea = 0;
	private float totalLivingArea = 0;
	private float commercialArea = 0;
	private float smallestArea = 0;
	private float largestArea = 0;

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

	public float getLandArea() {
		return landArea;
	}

	public void setLandArea(float landArea) {
		this.landArea = landArea;
	}

	public float getBaseArea() {
		return baseArea;
	}

	public void setBaseArea(float baseArea) {
		this.baseArea = baseArea;
	}

	public float getTotalLivingArea() {
		return totalLivingArea;
	}

	public void setTotalLivingArea(float totalLivingArea) {
		this.totalLivingArea = totalLivingArea;
	}

	public float getCommercialArea() {
		return commercialArea;
	}

	public void setCommercialArea(float commercialArea) {
		this.commercialArea = commercialArea;
	}

	public float getSmallestArea() {
		return smallestArea;
	}

	public void setSmallestArea(float smallestArea) {
		this.smallestArea = smallestArea;
	}

	public float getLargestArea() {
		return largestArea;
	}

	public void setLargestArea(float largestArea) {
		this.largestArea = largestArea;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(baseArea);
		result = prime * result + Float.floatToIntBits(commercialArea);
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + Float.floatToIntBits(landArea);
		result = prime * result + Float.floatToIntBits(largestArea);
		result = prime * result + (int) (parcelId ^ (parcelId >>> 32));
		result = prime * result + Float.floatToIntBits(smallestArea);
		result = prime * result + Float.floatToIntBits(totalLivingArea);
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
		ProjectAreaData other = (ProjectAreaData) obj;
		if (Float.floatToIntBits(baseArea) != Float.floatToIntBits(other.baseArea))
			return false;
		if (Float.floatToIntBits(commercialArea) != Float.floatToIntBits(other.commercialArea))
			return false;
		if (id != other.id)
			return false;
		if (Float.floatToIntBits(landArea) != Float.floatToIntBits(other.landArea))
			return false;
		if (Float.floatToIntBits(largestArea) != Float.floatToIntBits(other.largestArea))
			return false;
		if (parcelId != other.parcelId)
			return false;
		if (Float.floatToIntBits(smallestArea) != Float.floatToIntBits(other.smallestArea))
			return false;
		if (Float.floatToIntBits(totalLivingArea) != Float.floatToIntBits(other.totalLivingArea))
			return false;
		return true;
	}





}
