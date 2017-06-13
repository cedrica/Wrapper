package com.preag.wrapper.maincontainer.selectioncontainer.converttointerface;

import java.io.IOException;
import java.io.InputStream;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import com.preag.core.ui.service.FXMLService;

import javafx.collections.ObservableList;
import javafx.scene.layout.BorderPane;

public class ConvertToInterfaceView extends BorderPane {
	public ConvertToInterfaceView() {
		InputStream is;
		try {
			is = getClass().getResourceAsStream("ConvertToInterfaceView_EN.properties");
			ResourceBundle resource = new PropertyResourceBundle(is);
			FXMLService.INSTANCE.loadView(this, resource );
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setPojos(ObservableList<String> retrievePojoNames) {
		
	}
}
