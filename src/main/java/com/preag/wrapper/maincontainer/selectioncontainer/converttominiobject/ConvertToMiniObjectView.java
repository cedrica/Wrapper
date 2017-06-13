package com.preag.wrapper.maincontainer.selectioncontainer.converttominiobject;

import java.io.IOException;
import java.io.InputStream;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import com.preag.core.ui.service.FXMLService;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ObservableList;
import javafx.scene.layout.HBox;

public class ConvertToMiniObjectView extends HBox {
	private ObjectProperty<ObservableList<String>> pojos = new SimpleObjectProperty<>();

	public ConvertToMiniObjectView() {
		InputStream is;
		try {
			is = getClass().getResourceAsStream("ConvertToMiniObjectView_DE.properties");
			ResourceBundle resource = new PropertyResourceBundle(is);
			FXMLService.INSTANCE.loadView(this, resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
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

}
