package com.preag.wrapper.maincontainer;

import java.io.IOException;
import java.io.InputStream;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import com.preag.core.ui.service.FXMLService;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;

public class MainContainerView extends BorderPane {
	private ObjectProperty<Node> placeHolder = new SimpleObjectProperty<>();

	public MainContainerView() {
		InputStream is;
		try {
			is = getClass().getResourceAsStream("MainContainerView_EN.properties");
			ResourceBundle resource = new PropertyResourceBundle(is);
			FXMLService.INSTANCE.loadView(this, resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
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
