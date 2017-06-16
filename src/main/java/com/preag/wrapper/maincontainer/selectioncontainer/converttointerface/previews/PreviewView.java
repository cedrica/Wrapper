package com.preag.wrapper.maincontainer.selectioncontainer.converttointerface.previews;

import java.util.HashMap;

import javax.inject.Singleton;

import com.preag.core.ui.service.FXMLService;
import com.preag.wrapper.localization.Localization;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.layout.VBox;
import javafx.util.Pair;

@Singleton
public class PreviewView extends VBox {

	private ObjectProperty<HashMap<String, HashMap<String, Pair<String, String>>>> hashClassFieldAndFunctions = new SimpleObjectProperty<>(
			new HashMap<>());
	private BooleanProperty trigger = new SimpleBooleanProperty(false);

	public PreviewView() {
		FXMLService.INSTANCE.loadView(this, Localization.getDefault());
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

	public final BooleanProperty triggerProperty() {
		return this.trigger;
	}

	public final boolean isTrigger() {
		return this.triggerProperty().get();
	}

	public final void setTrigger(final boolean trigger) {
		this.triggerProperty().set(trigger);
	}

}
