package com.preag.wrapper.maincontainer.selectioncontainer.converttointerface;

import com.preag.core.ui.service.FXMLService;
import com.preag.wrapper.localization.Localization;

import javafx.collections.ObservableList;
import javafx.scene.layout.BorderPane;

public class ConvertToInterfaceView extends BorderPane {
	public ConvertToInterfaceView() {
		FXMLService.INSTANCE.loadView(this, Localization.getDefault());
	}

	public void setPojos(ObservableList<String> retrievePojoNames) {
		
	}
}
