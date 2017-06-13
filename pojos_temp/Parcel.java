package com.preag.pepexcel.data.pojo.project;

import java.time.LocalDate;

import panix.panic.Consts.Mapper;
import panix.panic.persistence.annotations.ForeignKey;
import panix.panic.persistence.annotations.Id;
import panix.panic.persistence.annotations.OneToOne;

public class Parcel {

	@Id
	private long					id								= -1;
	@ForeignKey
	private long					projectTypeId					= -1;
	@ForeignKey
	private long					projectStatusId					= -1;
	private LocalDate				createdDate						= null;
	private String					estateAgent						= null;
	private String					parcelReleasedBy				= null;
	private long					canvasserId						= -1;

	private LocalDate				parcelReleasedAt				= null;

	private String					projectConstructionLawComment	= null;
	private long					projectConstuctionLawId			= -1;

	@ForeignKey
	private long					rejectionReasonId				= -1;
	private String					rejectionReasonComment			= null;
	private LocalDate				firstContactedOwnerDate				= null;
	private LocalDate				lastContactedOwnerDate				= null;
	

	@OneToOne(mappedBy = Mapper.SLAVE, fk = "parcelId", slave = ParcelLocation.class)
	private ParcelLocation			parcelLocation					= null;

	@OneToOne(mappedBy = Mapper.SLAVE, fk = "parcelId", slave = ProjectData.class)
	private ProjectData				projectData						= null;

	@OneToOne(mappedBy = Mapper.SLAVE, fk = "parcelId", slave = ProjectAreaData.class)
	private ProjectAreaData			projectAreaData					= null;

	@OneToOne(mappedBy = Mapper.SLAVE, fk = "parcelId", slave = ProjectStageData.class)
	private ProjectStageData		projectStageData				= null;

	@OneToOne(mappedBy = Mapper.SLAVE, fk = "parcelId", slave = ProjectControlData.class)
	private ProjectControlData		projectControlData				= null;

	@OneToOne(mappedBy = Mapper.SLAVE, fk = "parcelId", slave = Project.class)
	private Project					project							= null;


	@OneToOne(mappedBy = Mapper.SLAVE, fk = "parcelId", slave = ProjectCompetitionData.class)
	private ProjectCompetitionData	competitionData					= null;

	@OneToOne(mappedBy = Mapper.SLAVE, fk = "parcelId", slave = ProjectParkingData.class)
	private ProjectParkingData		parkingData						= null;

	@OneToOne(mappedBy = Mapper.SLAVE, fk = "parcelId", slave = ProjectSalesData.class)
	private ProjectSalesData		salesData						= null;

	@OneToOne(mappedBy = Mapper.SLAVE, fk = "parcelId", slave = ProjectPurchaseData.class)
	private ProjectPurchaseData		purchaseData					= null;

	// @OneToOne(mappedBy = Mapper.SLAVE, fk = "parcelId", slave = ParcelRejection.class)
	// private ParcelRejection parcelRejection = null;


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


	public ParcelLocation getParcelLocation() {
		return parcelLocation;
	}


	public void setParcelLocation(ParcelLocation parcelLocation) {
		this.parcelLocation = parcelLocation;
	}


	public ProjectData getProjectData() {
		return projectData;
	}


	public void setProjectData(ProjectData projectData) {
		this.projectData = projectData;
	}


	public ProjectAreaData getProjectAreaData() {
		return projectAreaData;
	}


	public void setProjectAreaData(ProjectAreaData projectAreaData) {
		this.projectAreaData = projectAreaData;
	}


	public ProjectStageData getProjectStageData() {
		return projectStageData;
	}


	public void setProjectStageData(ProjectStageData projectStageData) {
		this.projectStageData = projectStageData;
	}


	public ProjectControlData getProjectControlData() {
		return projectControlData;
	}


	public void setProjectControlData(ProjectControlData projectControlData) {
		this.projectControlData = projectControlData;
	}


	public Project getProject() {
		return project;
	}


	public void setProject(Project project) {
		this.project = project;
	}


	public ProjectCompetitionData getCompetitionData() {
		return competitionData;
	}


	public void setCompetitionData(ProjectCompetitionData competitionData) {
		this.competitionData = competitionData;
	}


	public ProjectParkingData getParkingData() {
		return parkingData;
	}


	public void setParkingData(ProjectParkingData parkingData) {
		this.parkingData = parkingData;
	}


	public ProjectSalesData getSalesData() {
		return salesData;
	}


	public void setSalesData(ProjectSalesData salesData) {
		this.salesData = salesData;
	}


	public ProjectPurchaseData getPurchaseData() {
		return purchaseData;
	}


	public void setPurchaseData(ProjectPurchaseData purchaseData) {
		this.purchaseData = purchaseData;
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
		result = prime * result + ((competitionData == null) ? 0 : competitionData.hashCode());
		result = prime * result + ((createdDate == null) ? 0 : createdDate.hashCode());
		result = prime * result + ((estateAgent == null) ? 0 : estateAgent.hashCode());
		result = prime * result + ((firstContactedOwnerDate == null) ? 0 : firstContactedOwnerDate.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((lastContactedOwnerDate == null) ? 0 : lastContactedOwnerDate.hashCode());
		result = prime * result + ((parcelLocation == null) ? 0 : parcelLocation.hashCode());
		result = prime * result + ((parcelReleasedAt == null) ? 0 : parcelReleasedAt.hashCode());
		result = prime * result + ((parcelReleasedBy == null) ? 0 : parcelReleasedBy.hashCode());
		result = prime * result + ((parkingData == null) ? 0 : parkingData.hashCode());
		result = prime * result + ((project == null) ? 0 : project.hashCode());
		result = prime * result + ((projectAreaData == null) ? 0 : projectAreaData.hashCode());
		result = prime * result + ((projectConstructionLawComment == null) ? 0 : projectConstructionLawComment.hashCode());
		result = prime * result + (int) (projectConstuctionLawId ^ (projectConstuctionLawId >>> 32));
		result = prime * result + ((projectControlData == null) ? 0 : projectControlData.hashCode());
		result = prime * result + ((projectData == null) ? 0 : projectData.hashCode());
		result = prime * result + ((projectStageData == null) ? 0 : projectStageData.hashCode());
		result = prime * result + (int) (projectStatusId ^ (projectStatusId >>> 32));
		result = prime * result + (int) (projectTypeId ^ (projectTypeId >>> 32));
		result = prime * result + ((purchaseData == null) ? 0 : purchaseData.hashCode());
		result = prime * result + ((rejectionReasonComment == null) ? 0 : rejectionReasonComment.hashCode());
		result = prime * result + (int) (rejectionReasonId ^ (rejectionReasonId >>> 32));
		result = prime * result + ((salesData == null) ? 0 : salesData.hashCode());
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
		if (competitionData == null) {
			if (other.competitionData != null)
				return false;
		} else if (!competitionData.equals(other.competitionData))
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
		if (parcelLocation == null) {
			if (other.parcelLocation != null)
				return false;
		} else if (!parcelLocation.equals(other.parcelLocation))
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
		if (parkingData == null) {
			if (other.parkingData != null)
				return false;
		} else if (!parkingData.equals(other.parkingData))
			return false;
		if (project == null) {
			if (other.project != null)
				return false;
		} else if (!project.equals(other.project))
			return false;
		if (projectAreaData == null) {
			if (other.projectAreaData != null)
				return false;
		} else if (!projectAreaData.equals(other.projectAreaData))
			return false;
		if (projectConstructionLawComment == null) {
			if (other.projectConstructionLawComment != null)
				return false;
		} else if (!projectConstructionLawComment.equals(other.projectConstructionLawComment))
			return false;
		if (projectConstuctionLawId != other.projectConstuctionLawId)
			return false;
		if (projectControlData == null) {
			if (other.projectControlData != null)
				return false;
		} else if (!projectControlData.equals(other.projectControlData))
			return false;
		if (projectData == null) {
			if (other.projectData != null)
				return false;
		} else if (!projectData.equals(other.projectData))
			return false;
		if (projectStageData == null) {
			if (other.projectStageData != null)
				return false;
		} else if (!projectStageData.equals(other.projectStageData))
			return false;
		if (projectStatusId != other.projectStatusId)
			return false;
		if (projectTypeId != other.projectTypeId)
			return false;
		if (purchaseData == null) {
			if (other.purchaseData != null)
				return false;
		} else if (!purchaseData.equals(other.purchaseData))
			return false;
		if (rejectionReasonComment == null) {
			if (other.rejectionReasonComment != null)
				return false;
		} else if (!rejectionReasonComment.equals(other.rejectionReasonComment))
			return false;
		if (rejectionReasonId != other.rejectionReasonId)
			return false;
		if (salesData == null) {
			if (other.salesData != null)
				return false;
		} else if (!salesData.equals(other.salesData))
			return false;
		return true;
	}


}
