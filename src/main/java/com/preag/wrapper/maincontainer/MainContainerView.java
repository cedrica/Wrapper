package com.preag.wrapper.maincontainer;

import javax.inject.Singleton;

import com.preag.core.ui.service.FXMLService;
import com.preag.wrapper.localization.Localization;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;

@Singleton
public class MainContainerView extends BorderPane {
	private ObjectProperty<Node> placeHolder = new SimpleObjectProperty<>();

	public MainContainerView() {
		FXMLService.INSTANCE.loadView(this, Localization.getDefault());
	}

	public final ObjectProperty<Node> placeHolderProperty() {
		return this.placeHolder;
	}

	public final Node getPlaceHolder() {
		return this.placeHolderProperty().get();
	}

	public final void setPlaceHolder(final Node placeHolder) {
		this.placeHolderProperty().set(placeHolder);
	}

}
