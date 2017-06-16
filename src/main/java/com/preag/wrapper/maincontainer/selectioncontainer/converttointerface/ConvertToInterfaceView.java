package com.preag.wrapper.maincontainer.selectioncontainer.converttointerface;

import java.util.HashMap;

import javax.inject.Singleton;

import com.preag.core.ui.service.FXMLService;
import com.preag.wrapper.localization.Localization;
import com.preag.wrapper.maincontainer.selectioncontainer.converttointerface.previews.PreviewView;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.scene.layout.HBox;
import javafx.util.Pair;
@Singleton
public class ConvertToInterfaceView extends HBox {
	private ObjectProperty<ObservableList<String>> pojos = new SimpleObjectProperty<>();
	private StringProperty jarFilePath = new SimpleStringProperty();
	private StringProperty packageName = new SimpleStringProperty();
	private ObjectProperty<HashMap<String, HashMap<String, Pair<String, String>>>> hashClassFieldAndFunctions = new SimpleObjectProperty<>(
			new HashMap<>());
	private ObjectProperty<PreviewView> previewView = new SimpleObjectProperty<>();
	public ConvertToInterfaceView() {
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

	public final ObjectProperty<HashMap<String, HashMap<String, Pair<String, String>>>> hashClassFieldAndFunctionsProperty() {
		return this.hashClassFieldAndFunctions;
	}

	public final HashMap<String, HashMap<String, Pair<String, String>>> getHashClassFieldAndFunctions() {
		return this.hashClassFieldAndFunctionsProperty().get();
	}

	public final void setHashClassFieldAndFunctions(
			final HashMap<String, HashMap<String, Pair<String, String>>> hashClassFieldAndFunctions) {
		this.hashClassFieldAndFunctionsProperty().set(hashClassFieldAndFunctions);
	}

	public final ObjectProperty<PreviewView> previewViewProperty() {
		return this.previewView;
	}
	

	public final PreviewView getPreviewView() {
		return this.previewViewProperty().get();
	}
	

	public final void setPreviewView(final PreviewView previewView) {
		this.previewViewProperty().set(previewView);
	}
	
	
	

}
