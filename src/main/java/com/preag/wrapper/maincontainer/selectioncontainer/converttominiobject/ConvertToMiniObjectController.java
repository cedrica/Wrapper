package com.preag.wrapper.maincontainer.selectioncontainer.converttominiobject;

import java.lang.reflect.Field;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class ConvertToMiniObjectController implements Initializable {

	@FXML
	ConvertToMiniObjectView rootNode;
	@FXML
	VBox vbPojos;
	@FXML
	VBox vbFieldsAndPreview;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		rootNode.pojosProperty().addListener((obs, oldVal, newVal) -> insertIntoGrid(newVal));

	}

	private void insertIntoGrid(ObservableList<String> newVal) {
		try {
			for (String className : newVal) {

				Class<?> clazz = Class.forName("com.preag.wrapper.temp.Parcel");
				vbPojos.getChildren().add(new RadioButton(className));
				initFieldsAndPreviewForClass(clazz);

			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void initFieldsAndPreviewForClass(Class<?> clazz) {
		Field[] declaredFields = clazz.getDeclaredFields();
		for (Field field : declaredFields) {
			HBox preview = new HBox(new Label("ca marche"));
			HBox row = new HBox(new CheckBox(field.getName()),preview);
			HBox.setHgrow(preview, Priority.ALWAYS);
			preview.setAlignment(Pos.CENTER_RIGHT);
			vbFieldsAndPreview.getChildren().add(row);
		}
	}

}
