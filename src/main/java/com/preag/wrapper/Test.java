package com.preag.wrapper;

import java.time.LocalDate;

import javafx.beans.property.LongProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleObjectProperty;

public class Test {
	private int					id								= -1;
	private long					projectTypeId					= -1;
	private boolean					projectStatusId					;
	private LocalDate				createdDate						= null;
	private String					estateAgent						= null;
	private ObjectProperty<Integer>					parcelReleasedBy				= new SimpleObjectProperty<>();
	private LongProperty					canvasserId						= new SimpleLongProperty();
	private String					projectConstructionLawComment	= null;
	private long					projectConstuctionLawId			= -1;
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((canvasserId == null) ? 0 : canvasserId.hashCode());
		result = prime * result + ((createdDate == null) ? 0 : createdDate.hashCode());
		result = prime * result + ((estateAgent == null) ? 0 : estateAgent.hashCode());
		result = prime * result + id;
		result = prime * result + ((parcelReleasedBy == null) ? 0 : parcelReleasedBy.hashCode());
		result = prime * result
				+ ((projectConstructionLawComment == null) ? 0 : projectConstructionLawComment.hashCode());
		result = prime * result + (int) (projectConstuctionLawId ^ (projectConstuctionLawId >>> 32));
		result = prime * result + (projectStatusId ? 1231 : 1237);
		result = prime * result + (int) (projectTypeId ^ (projectTypeId >>> 32));
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
		Test other = (Test) obj;
		if (canvasserId == null) {
			if (other.canvasserId != null)
				return false;
		} else if (!canvasserId.equals(other.canvasserId))
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
		if (id != other.id)
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
		return true;
	}
	public final LongProperty canvasserIdProperty() {
		return this.canvasserId;
	}
	
	public final long getCanvasserId() {
		return this.canvasserIdProperty().get();
	}
	
	public final void setCanvasserId(final long canvasserId) {
		this.canvasserIdProperty().set(canvasserId);
	}
	public final ObjectProperty<Integer> parcelReleasedByProperty() {
		return this.parcelReleasedBy;
	}
	
	public final Integer getParcelReleasedBy() {
		return this.parcelReleasedByProperty().get();
	}
	
	public final void setParcelReleasedBy(final Integer parcelReleasedBy) {
		this.parcelReleasedByProperty().set(parcelReleasedBy);
	}
	
	

}
