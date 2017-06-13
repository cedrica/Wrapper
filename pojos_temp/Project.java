
package com.preag.pepexcel.data.pojo.project;

import java.time.LocalDate;

import panix.panic.persistence.annotations.ForeignKey;
import panix.panic.persistence.annotations.Id;

public class Project {

	@Id
	private long		id			= -1;

	private String		name;
	private String		marketingName;

	@ForeignKey
	private long		branchId;

	@ForeignKey
	private long		parcelId;

	private String		corporation;
	private String		abbrev;
	private boolean		active;
	private float		area;
	private boolean		divided;
	private String			zipCode;
	private String		location;
	private String		comment;
	private LocalDate	saleStart;
	private int			projectStep	= 0;


	private boolean		release		= false;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMarketingName() {
		return marketingName;
	}

	public void setMarketingName(String marketingName) {
		this.marketingName = marketingName;
	}

	public long getBranchId() {
		return branchId;
	}

	public void setBranchId(long branchId) {
		this.branchId = branchId;
	}

	public String getCorporation() {
		return corporation;
	}

	public void setCorporation(String corporation) {
		this.corporation = corporation;
	}

	public String getAbbrev() {
		return abbrev;
	}

	public void setAbbrev(String abbrev) {
		this.abbrev = abbrev;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public float getArea() {
		return area;
	}

	public void setArea(float area) {
		this.area = area;
	}

	public boolean isDivided() {
		return divided;
	}

	public void setDivided(boolean divided) {
		this.divided = divided;
	}

	public String getZipCode() {
		return zipCode;
	}


	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public LocalDate getSaleStart() {
		return saleStart;
	}

	public void setSaleStart(LocalDate saleStart) {
		this.saleStart = saleStart;
	}


	public long getParcelId() {
		return parcelId;
	}


	public void setParcelId(long parcelId) {
		this.parcelId = parcelId;
	}


	public boolean isRelease() {
		return release;
	}


	public void setRelease(boolean release) {
		this.release = release;
	}


	public int getProjectStep() {
		return projectStep;
	}


	public void setProjectStep(int projectStep) {
		this.projectStep = projectStep;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((abbrev == null) ? 0 : abbrev.hashCode());
		result = prime * result + (active ? 1231 : 1237);
		result = prime * result + Float.floatToIntBits(area);
		result = prime * result + (int) (branchId ^ (branchId >>> 32));
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + ((corporation == null) ? 0 : corporation.hashCode());
		result = prime * result + (divided ? 1231 : 1237);
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((marketingName == null) ? 0 : marketingName.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (int) (parcelId ^ (parcelId >>> 32));
		result = prime * result + projectStep;
		result = prime * result + (release ? 1231 : 1237);
		result = prime * result + ((saleStart == null) ? 0 : saleStart.hashCode());
		result = prime * result + ((zipCode == null) ? 0 : zipCode.hashCode());
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
		Project other = (Project) obj;
		if (abbrev == null) {
			if (other.abbrev != null)
				return false;
		} else if (!abbrev.equals(other.abbrev))
			return false;
		if (active != other.active)
			return false;
		if (Float.floatToIntBits(area) != Float.floatToIntBits(other.area))
			return false;
		if (branchId != other.branchId)
			return false;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		if (corporation == null) {
			if (other.corporation != null)
				return false;
		} else if (!corporation.equals(other.corporation))
			return false;
		if (divided != other.divided)
			return false;
		if (id != other.id)
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (marketingName == null) {
			if (other.marketingName != null)
				return false;
		} else if (!marketingName.equals(other.marketingName))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (parcelId != other.parcelId)
			return false;
		if (projectStep != other.projectStep)
			return false;
		if (release != other.release)
			return false;
		if (saleStart == null) {
			if (other.saleStart != null)
				return false;
		} else if (!saleStart.equals(other.saleStart))
			return false;
		if (zipCode == null) {
			if (other.zipCode != null)
				return false;
		} else if (!zipCode.equals(other.zipCode))
			return false;
		return true;
	}

}
