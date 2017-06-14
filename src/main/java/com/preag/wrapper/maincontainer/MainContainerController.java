package com.preag.wrapper.maincontainer;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.preag.wrapper.event.WrapperEvent;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;

public class MainContainerController implements Initializable{

	@FXML RadioButton rbChangeToInterface;
	@FXML RadioButton rbChangeToMiniObject;
	@FXML MainContainerView rootNode;
	@FXML HBox hbPlaceHolder;

	private final ToggleGroup group = new ToggleGroup();
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		registerListener();
		rootNode.placeHolderProperty().addListener((obs,oldVal,newVal)->replaceContaint(newVal));
		configureToggleGroup();
	}
	
	private void replaceContaint(Node newVal) {
		hbPlaceHolder.getChildren().clear();
		hbPlaceHolder.getChildren().add(newVal);
	}

	private void registerListener() {
		group.selectedToggleProperty().addListener((obs, old_toggle, new_toggle) -> toggle(new_toggle));
	}
	
	private void configureToggleGroup() {
		rbChangeToInterface.setToggleGroup(group);
		rbChangeToMiniObject.setToggleGroup(group);
		rbChangeToMiniObject.setSelected(true);
	}
	private void toggle(Toggle new_toggle) {
		if (new_toggle != null) {
		}
	}
	@FXML public void onChangeToInterface() {
		rootNode.fireEvent(new WrapperEvent(WrapperEvent.CHANGE_TO_INTERFACE));
	}

	@FXML public void onChangeToMiniObject() {
		rootNode.fireEvent(new WrapperEvent(WrapperEvent.CHANGE_TO_MINI_OBJECT));
	}

	@FXML public void onClose() {}

	@FXML public void onSave() {}

	@FXML public void onChoosePojos() {
		FileChooser fileChooser = new FileChooser();
		List<File> pojosFiles = fileChooser.showOpenMultipleDialog(rootNode.getScene().getWindow());
		rootNode.fireEvent(new WrapperEvent(WrapperEvent.CHOOSE_POJOS,pojosFiles));
	}

}
