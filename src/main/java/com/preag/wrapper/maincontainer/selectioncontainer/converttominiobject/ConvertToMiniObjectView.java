package com.preag.wrapper.maincontainer.selectioncontainer.converttominiobject;

import com.preag.core.ui.service.FXMLService;
import com.preag.wrapper.localization.Localization;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.scene.layout.HBox;

public class ConvertToMiniObjectView extends HBox {
	private ObjectProperty<ObservableList<String>> pojos = new SimpleObjectProperty<>();
	private StringProperty jarFilePath = new SimpleStringProperty();
	private StringProperty packageName = new SimpleStringProperty();

	public ConvertToMiniObjectView() {
		FXMLService.INSTANCE.loadView(this, Localization.getDefault());
	}

	public final ObjectProperty<ObservableList<String>> pojosProperty() {
		return this.pojos;
	}

	public final ObservableList<String> getPojos() {
		return this.pojosProperty().get();
	}

	public final void setPojos(final ObservableList<String> pojos) {
		this.pojosProperty().set(pojos);
	}

	public final StringProperty jarFilePathProperty() {
		return this.jarFilePath;
	}

	public final String getJarFilePath() {
		return this.jarFilePathProperty().get();
	}

	public final void setJarFilePath(final String jarFilePath) {
		this.jarFilePathProperty().set(jarFilePath);
	}

	public final StringProperty packageNameProperty() {
		return this.packageName;
	}

	public final String getPackageName() {
		return this.packageNameProperty().get();
	}

	public final void setPackageName(final String packageName) {
		this.packageNameProperty().set(packageName);
	}

}
