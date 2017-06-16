package com.preag.wrapper.maincontainer.selectioncontainer.converttointerface;

import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.ResourceBundle;

import com.preag.core.ui.utils.dialog.Dialogs;
import com.preag.wrapper.event.WrapperEvent;
import com.preag.wrapper.helper.Helper;
import com.preag.wrapper.maincontainer.selectioncontainer.converttointerface.previews.PreviewView;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.util.Pair;

public class ConvertToInterfaceController implements Initializable {

	@FXML
	ConvertToInterfaceView rootNode;
	@FXML
	GridPane gridPane;
	@FXML PreviewView previewView;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		rootNode.setPreviewView(previewView);
		rootNode.pojosProperty().addListener((obs, oldVal, newVal) -> insertIntoGrid(newVal));
	}

	private void insertIntoGrid(ObservableList<String> pojosNames) {
		String jarFilePath = "file:///" + rootNode.getJarFilePath().replace("\\", "/");
		int columnIndex = 0;
		int rowIndex = 0;
		for (String className : pojosNames) {
			try {
				URLClassLoader classLoader = URLClassLoader.newInstance(new URL[] { new URL(jarFilePath) });
				Class<?> clazz = classLoader
						.loadClass(rootNode.getPackageName() + "." + Helper.removeFileExtension(className));
				CheckBox cbPojo = new CheckBox(className);
				gridPane.add(cbPojo, columnIndex, rowIndex);
				gridPane.add(new Label("I" + className), columnIndex + 1, rowIndex);
				Button btnPreview = new Button("Vorschau");
				btnPreview.disableProperty().bind(cbPojo.selectedProperty().not());
				btnPreview.setOnAction(this::onShowPreview);
				gridPane.add(btnPreview, columnIndex + 2, rowIndex);
				cbPojo.selectedProperty().addListener((obs, oldVal,
						newVal) -> initFieldAndSwitchBackgroundForSelectedPojo(clazz, newVal, className));
				rowIndex++;
			} catch (ClassNotFoundException | MalformedURLException e) {
				Dialog<ButtonType> error = Dialogs.error(
						"Das PoJo " + className + " enthält Abhängigkeiten die auch mitimportiert werden sollen",
						rootNode.getScene().getWindow());
				error.showAndWait();
				e.printStackTrace();
			}
		}
	}

	private void onShowPreview(ActionEvent evt) {
		rootNode.fireEvent(new WrapperEvent(WrapperEvent.SHOW_PREVIEW));
	}

	private void initFieldAndSwitchBackgroundForSelectedPojo(Class<?> clazz, Boolean newVal, String className) {
		if (newVal) {
			HashMap<String, Pair<String, String>> value = new HashMap<>();

			Field[] declaredFields = clazz.getDeclaredFields();
			for (Field field : declaredFields) {
				Class<?> type = field.getType();
				String setter = "public void set" + Helper.capitalizeFirstLetter(field.getName()) + "(" + type + " "
						+ field.getName() + ");";
				String getter = "public " + type + " get" + Helper.capitalizeFirstLetter(field.getName()) + "();";
				Pair<String, String> pair = new Pair<String, String>(setter, getter);
				value.put(field.getName(), pair);
			}
			rootNode.getHashClassFieldAndFunctions().put(className, value);
		} else {
			rootNode.getHashClassFieldAndFunctions().remove(className);
		}
	}

}
