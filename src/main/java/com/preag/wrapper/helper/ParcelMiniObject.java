package com.preag.wrapper.helper;

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

	private LongProperty projectTypeId = new SimpleLongProperty();

	public final LongProperty projectTypeIdProperty() {
		return this.projectTypeId;
	}

	public final Long getProjectTypeId() {
		return this.projectTypeIdProperty().get();
	}

	public final void setProjectTypeId(Long projectTypeId) {
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

	public final Long getCanvasserId() {
		return this.canvasserIdProperty().get();
	}

	public final void setCanvasserId(Long canvasserId) {
		this.canvasserIdProperty().set(canvasserId);
	}

	private LongProperty id = new SimpleLongProperty();

	public final LongProperty idProperty() {
		return this.id;
	}

	public final Long getId() {
		return this.idProperty().get();
	}

	public final void setId(Long id) {
		this.idProperty().set(id);
	}

	private LongProperty projectStatusId = new SimpleLongProperty();

	public final LongProperty projectStatusIdProperty() {
		return this.projectStatusId;
	}

	public final Long getProjectStatusId() {
		return this.projectStatusIdProperty().get();
	}

	public final void setProjectStatusId(Long projectStatusId) {
		this.projectStatusIdProperty().set(projectStatusId);
	}
}