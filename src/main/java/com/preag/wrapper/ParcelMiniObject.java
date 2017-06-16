package com.preag.wrapper;

import java.time.LocalDate;

import javafx.beans.property.LongProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleObjectProperty;

public class ParcelMiniObject {
	private ObjectProperty<LocalDate> parcelReleasedAt = new SimpleObjectProperty<>();

	public final ObjectProperty<LocalDate> parcelReleasedAtProperty() {
		return this.parcelReleasedAt;
	}

	public final LocalDate getParcelReleasedAt() {
		return this.parcelReleasedAtProperty().get();
	}

	public final void setParcelReleasedAt(LocalDate parcelReleasedAt) {
		this.parcelReleasedAtProperty().set(parcelReleasedAt);
	}

	private ObjectProperty<String> projectConstructionLawComment = new SimpleObjectProperty<>();

	public final ObjectProperty<String> projectConstructionLawCommentProperty() {
		return this.projectConstructionLawComment;
	}

	public final String getProjectConstructionLawComment() {
		return this.projectConstructionLawCommentProperty().get();
	}

	public final void setProjectConstructionLawComment(String projectConstructionLawComment) {
		this.projectConstructionLawCommentProperty().set(projectConstructionLawComment);
	}

	private LongProperty projectTypeId = new SimpleLongProperty();

	public final LongProperty projectTypeIdProperty() {
		return this.projectTypeId;
	}

	public final long getProjectTypeId() {
		return this.projectTypeIdProperty().get();
	}

	public final void setProjectTypeId(long projectTypeId) {
		this.projectTypeIdProperty().set(projectTypeId);
	}

	private ObjectProperty<LocalDate> createdDate = new SimpleObjectProperty<>();

	public final ObjectProperty<LocalDate> createdDateProperty() {
		return this.createdDate;
	}

	public final LocalDate getCreatedDate() {
		return this.createdDateProperty().get();
	}

	public final void setCreatedDate(LocalDate createdDate) {
		this.createdDateProperty().set(createdDate);
	}

	private ObjectProperty<String> estateAgent = new SimpleObjectProperty<>();

	public final ObjectProperty<String> estateAgentProperty() {
		return this.estateAgent;
	}

	public final String getEstateAgent() {
		return this.estateAgentProperty().get();
	}

	public final void setEstateAgent(String estateAgent) {
		this.estateAgentProperty().set(estateAgent);
	}

	private ObjectProperty<String> parcelReleasedBy = new SimpleObjectProperty<>();

	public final ObjectProperty<String> parcelReleasedByProperty() {
		return this.parcelReleasedBy;
	}

	public final String getParcelReleasedBy() {
		return this.parcelReleasedByProperty().get();
	}

	public final void setParcelReleasedBy(String parcelReleasedBy) {
		this.parcelReleasedByProperty().set(parcelReleasedBy);
	}

	private LongProperty canvasserId = new SimpleLongProperty();

	public final LongProperty canvasserIdProperty() {
		return this.canvasserId;
	}

	public final long getCanvasserId() {
		return this.canvasserIdProperty().get();
	}

	public final void setCanvasserId(long canvasserId) {
		this.canvasserIdProperty().set(canvasserId);
	}

	private LongProperty projectConstuctionLawId = new SimpleLongProperty();

	public final LongProperty projectConstuctionLawIdProperty() {
		return this.projectConstuctionLawId;
	}

	public final long getProjectConstuctionLawId() {
		return this.projectConstuctionLawIdProperty().get();
	}

	public final void setProjectConstuctionLawId(long projectConstuctionLawId) {
		this.projectConstuctionLawIdProperty().set(projectConstuctionLawId);
	}

	private LongProperty id = new SimpleLongProperty();

	public final LongProperty idProperty() {
		return this.id;
	}

	public final long getId() {
		return this.idProperty().get();
	}

	public final void setId(long id) {
		this.idProperty().set(id);
	}

	private LongProperty projectStatusId = new SimpleLongProperty();

	public final LongProperty projectStatusIdProperty() {
		return this.projectStatusId;
	}

	public final long getProjectStatusId() {
		return this.projectStatusIdProperty().get();
	}

	public final void setProjectStatusId(long projectStatusId) {
		this.projectStatusIdProperty().set(projectStatusId);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getParcelReleasedAt() == null) ? 0 : getParcelReleasedAt().hashCode());
		result = prime * result
				+ ((getProjectConstructionLawComment() == null) ? 0 : getProjectConstructionLawComment().hashCode());
		result = prime * result + (int) (getProjectTypeId() ^ (getProjectTypeId() >>> 32));
		result = prime * result + ((getCreatedDate() == null) ? 0 : getCreatedDate().hashCode());
		result = prime * result + ((getEstateAgent() == null) ? 0 : getEstateAgent().hashCode());
		result = prime * result + ((getParcelReleasedBy() == null) ? 0 : getParcelReleasedBy().hashCode());
		result = prime * result + (int) (getCanvasserId() ^ (getCanvasserId() >>> 32));
		result = prime * result + (int) (getProjectConstuctionLawId() ^ (getProjectConstuctionLawId() >>> 32));
		result = prime * result + (int) (getId() ^ (getId() >>> 32));
		result = prime * result + (int) (getProjectStatusId() ^ (getProjectStatusId() >>> 32));
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
		ParcelMiniObject other = (ParcelMiniObject) obj;
		if (getParcelReleasedAt() == null) {
			if (other.getParcelReleasedAt() != null)
				return false;
		} else if (!getParcelReleasedAt().equals(other.getParcelReleasedAt()))
			return false;
		if (getProjectConstructionLawComment() == null) {
			if (other.getProjectConstructionLawComment() != null)
				return false;
		} else if (!getProjectConstructionLawComment().equals(other.getProjectConstructionLawComment()))
			return false;
		if (getProjectTypeId() != other.getProjectTypeId())
			return false;
		if (getCreatedDate() == null) {
			if (other.getCreatedDate() != null)
				return false;
		} else if (!getCreatedDate().equals(other.getCreatedDate()))
			return false;
		if (getEstateAgent() == null) {
			if (other.getEstateAgent() != null)
				return false;
		} else if (!getEstateAgent().equals(other.getEstateAgent()))
			return false;
		if (getParcelReleasedBy() == null) {
			if (other.getParcelReleasedBy() != null)
				return false;
		} else if (!getParcelReleasedBy().equals(other.getParcelReleasedBy()))
			return false;
		if (getCanvasserId() != other.getCanvasserId())
			return false;
		if (getProjectConstuctionLawId() != other.getProjectConstuctionLawId())
			return false;
		if (getId() != other.getId())
			return false;
		if (getProjectStatusId() != other.getProjectStatusId())
			return false;
		return true;
	}
}