package com.preag.wrapper.temp;

import java.time.LocalDate;


public class Parcel {

	private long					id								= -1;
	private long					projectTypeId					= -1;
	private long					projectStatusId					= -1;
	private LocalDate				createdDate						= null;
	private String					estateAgent						= null;
	private String					parcelReleasedBy				= null;
	private long					canvasserId						= -1;

	private LocalDate				parcelReleasedAt				= null;

	private String					projectConstructionLawComment	= null;
	private long					projectConstuctionLawId			= -1;

	private long					rejectionReasonId				= -1;
	private String					rejectionReasonComment			= null;
	private LocalDate				firstContactedOwnerDate				= null;
	private LocalDate				lastContactedOwnerDate				= null;
	




	public Parcel() {
		super();
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public long getProjectTypeId() {
		return projectTypeId;
	}


	public void setProjectTypeId(long projectTypeId) {
		this.projectTypeId = projectTypeId;
	}


	public long getProjectStatusId() {
		return projectStatusId;
	}


	public void setProjectStatusId(long projectStatusId) {
		this.projectStatusId = projectStatusId;
	}


	public LocalDate getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}


	// public String getName() {
	// return name;
	// }
	//
	//
	// public void setName(String name) {
	// this.name = name;
	// }


	public String getEstateAgent() {
		return estateAgent;
	}


	public void setEstateAgent(String estateAgent) {
		this.estateAgent = estateAgent;
	}


	public String getParcelReleasedBy() {
		return parcelReleasedBy;
	}


	public void setParcelReleasedBy(String parcelReleasedBy) {
		this.parcelReleasedBy = parcelReleasedBy;
	}


	public LocalDate getParcelReleasedAt() {
		return parcelReleasedAt;
	}


	public void setParcelReleasedAt(LocalDate parcelReleasedAt) {
		this.parcelReleasedAt = parcelReleasedAt;
	}


	public long getProjectConstuctionLawId() {
		return projectConstuctionLawId;
	}


	public void setProjectConstuctionLawId(long projectConstuctionLawId) {
		this.projectConstuctionLawId = projectConstuctionLawId;
	}



	// public ParcelRejection getParcelRejection() {
	// return parcelRejection;
	// }
	//
	//
	// public void setParcelRejection(ParcelRejection parcelRejection) {
	// this.parcelRejection = parcelRejection;
	// }


	public long getCanvasserId() {
		return canvasserId;
	}


	public void setCanvasserId(long canvasserId) {
		this.canvasserId = canvasserId;
	}


	public String getProjectConstructionLawComment() {
		return projectConstructionLawComment;
	}


	public void setProjectConstructionLawComment(String projectConstructionLawComment) {
		this.projectConstructionLawComment = projectConstructionLawComment;
	}


	public long getRejectionReasonId() {
		return rejectionReasonId;
	}


	public void setRejectionReasonId(long rejectionReasonId) {
		this.rejectionReasonId = rejectionReasonId;
	}


//	public boolean isContactedOwner() {
//		return contactedOwner;
//	}
//
//
//	public void setContactedOwner(boolean contactedOwner) {
//		this.contactedOwner = contactedOwner;
//	}




	public String getRejectionReasonComment() {
		return rejectionReasonComment;
	}

	public void setRejectionReasonComment(String rejectionReasonComment) {
		this.rejectionReasonComment = rejectionReasonComment;
	}


	
	public LocalDate getFirstContactedOwnerDate() {
		return firstContactedOwnerDate;
	}


	
	public void setFirstContactedOwnerDate(LocalDate firstContactedOwnerDate) {
		this.firstContactedOwnerDate = firstContactedOwnerDate;
	}


	
	public LocalDate getLastContactedOwnerDate() {
		return lastContactedOwnerDate;
	}


	
	public void setLastContactedOwnerDate(LocalDate lastContactedOwnerDate) {
		this.lastContactedOwnerDate = lastContactedOwnerDate;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (canvasserId ^ (canvasserId >>> 32));
		result = prime * result + ((createdDate == null) ? 0 : createdDate.hashCode());
		result = prime * result + ((estateAgent == null) ? 0 : estateAgent.hashCode());
		result = prime * result + ((firstContactedOwnerDate == null) ? 0 : firstContactedOwnerDate.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((lastContactedOwnerDate == null) ? 0 : lastContactedOwnerDate.hashCode());
		result = prime * result + ((parcelReleasedAt == null) ? 0 : parcelReleasedAt.hashCode());
		result = prime * result + ((parcelReleasedBy == null) ? 0 : parcelReleasedBy.hashCode());
		result = prime * result
				+ ((projectConstructionLawComment == null) ? 0 : projectConstructionLawComment.hashCode());
		result = prime * result + (int) (projectConstuctionLawId ^ (projectConstuctionLawId >>> 32));
		result = prime * result + (int) (projectStatusId ^ (projectStatusId >>> 32));
		result = prime * result + (int) (projectTypeId ^ (projectTypeId >>> 32));
		result = prime * result + ((rejectionReasonComment == null) ? 0 : rejectionReasonComment.hashCode());
		result = prime * result + (int) (rejectionReasonId ^ (rejectionReasonId >>> 32));
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
		Parcel other = (Parcel) obj;
		if (canvasserId != other.canvasserId)
			return false;
		if (createdDate == null) {
			if (other.createdDate != null)
				return false;
		} else if (!createdDate.equals(other.createdDate))
			return false;
		if (estateAgent == null) {
			if (other.estateAgent != null)
				return false;
		} else if (!estateAgent.equals(other.estateAgent))
			return false;
		if (firstContactedOwnerDate == null) {
			if (other.firstContactedOwnerDate != null)
				return false;
		} else if (!firstContactedOwnerDate.equals(other.firstContactedOwnerDate))
			return false;
		if (id != other.id)
			return false;
		if (lastContactedOwnerDate == null) {
			if (other.lastContactedOwnerDate != null)
				return false;
		} else if (!lastContactedOwnerDate.equals(other.lastContactedOwnerDate))
			return false;
		if (parcelReleasedAt == null) {
			if (other.parcelReleasedAt != null)
				return false;
		} else if (!parcelReleasedAt.equals(other.parcelReleasedAt))
			return false;
		if (parcelReleasedBy == null) {
			if (other.parcelReleasedBy != null)
				return false;
		} else if (!parcelReleasedBy.equals(other.parcelReleasedBy))
			return false;
		if (projectConstructionLawComment == null) {
			if (other.projectConstructionLawComment != null)
				return false;
		} else if (!projectConstructionLawComment.equals(other.projectConstructionLawComment))
			return false;
		if (projectConstuctionLawId != other.projectConstuctionLawId)
			return false;
		if (projectStatusId != other.projectStatusId)
			return false;
		if (projectTypeId != other.projectTypeId)
			return false;
		if (rejectionReasonComment == null) {
			if (other.rejectionReasonComment != null)
				return false;
		} else if (!rejectionReasonComment.equals(other.rejectionReasonComment))
			return false;
		if (rejectionReasonId != other.rejectionReasonId)
			return false;
		return true;
	}
}
