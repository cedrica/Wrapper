package com.preag.wrapper.maincontainer.selectioncontainer.converttominiobject;

import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ResourceBundle;

import com.preag.core.ui.utils.dialog.Dialogs;
import com.preag.wrapper.helper.Helper;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ConvertToMiniObjectController implements Initializable {

	@FXML
	ConvertToMiniObjectView rootNode;
	private final ToggleGroup group = new ToggleGroup();
	@FXML
	VBox vbPojos;
	@FXML
	HBox hbGridPaneContainer;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		rootNode.pojosProperty().addListener((obs, oldVal, newVal) -> insertIntoGrid(newVal));
	}

	private void insertIntoGrid(ObservableList<String> pojosNames) {
		boolean first = true;
		String jarFilePath = "file:///" + rootNode.getJarFilePath().replace("\\", "/");
		for (String className : pojosNames) {
			try {
				URLClassLoader classLoader = URLClassLoader.newInstance(new URL[] { new URL(jarFilePath) });
				Class<?> clazz = classLoader
						.loadClass(rootNode.getPackageName() + "." + Helper.removeFileExtension(className));
				RadioButton rbPojo = new RadioButton(className);
				if (first) {
					first = false;
					rbPojo.setSelected(true);
					initFieldsAndPreviewForClass(clazz);
					rootNode.setCurrentSelectedPojo(Helper.removeFileExtension(className));
				}
				rbPojo.setToggleGroup(group);
				HBox hbField = new HBox(rbPojo);
				hbField.setFillHeight(true);
				vbPojos.getChildren().add(hbField);
				rbPojo.selectedProperty().addListener(
						(obs, oldVal, newVal) -> initFieldAndSwitchBackgroundForSelectedPojo(clazz, hbField, newVal,className));
			} catch (ClassNotFoundException | MalformedURLException e) {
				Dialog<ButtonType> error = Dialogs.error(
						"Das PoJo " + className + " enthält Abhängigkeiten die auch mitimportiert werden sollen",
						rootNode.getScene().getWindow());
				error.showAndWait();
				e.printStackTrace();
			}
		}
	}

	private void initFieldAndSwitchBackgroundForSelectedPojo(Class<?> clazz, HBox hbField, Boolean newVal,String className) {
		if (newVal) {
			rootNode.setCurrentSelectedPojo(Helper.removeFileExtension(className));
			hbField.setStyle("-fx-background-color:#fff");
			initFieldsAndPreviewForClass(clazz);
		} else {
			hbField.setStyle("-fx-background-color:gray");
		}
	}

	private void initFieldsAndPreviewForClass(Class<?> clazz) {
		Field[] declaredFields = clazz.getDeclaredFields();
		int columnIndex = 0;
		int rowIndex = 0;
		GridPane gridPane = new GridPane();
		for (Field field : declaredFields) {
			Class<?> type = field.getType();
			Label label = new Label("--");
			CheckBox cbField = new CheckBox(field.getName() + " (" + type.getSimpleName() + ")");
			HBox preview = new HBox(label);
			cbField.selectedProperty()
					.addListener((obs, oldVal, newVal) -> showPropertyForSelectedField(field, type, label, newVal));
			gridPane.add(cbField, columnIndex, rowIndex);
			gridPane.add(preview, columnIndex + 1, rowIndex);
			rowIndex++;
		}
		hbGridPaneContainer.getChildren().clear();
		hbGridPaneContainer.getChildren().add(gridPane);
	}

	private void showPropertyForSelectedField(Field field, Class<?> type, Label label, Boolean newVal) {
		if (newVal) {
			if (type.getSimpleName().toLowerCase().equals("long")) {
				label.setText("LongProperty " + field.getName() + " = new SimpleLongProperty()");
				rootNode.getHashFieldAndProperties().put(field.getName(), "LongProperty " + field.getName() + " = new SimpleLongProperty()");
			} else if (type.getSimpleName().toLowerCase().equals("int")) {
				label.setText("IntegerProperty " + field.getName() + " = new SimpleIntegerProperty()");
				rootNode.getHashFieldAndProperties().put(field.getName(), "IntegerProperty " + field.getName() + " = new SimpleIntegerProperty()");
			} else if (type.getSimpleName().toLowerCase().equals("string")
					|| type.getSimpleName().toLowerCase().equals("textfield")
					|| type.getSimpleName().toLowerCase().equals("textarea")) {
				label.setText("StringProperty " + field.getName() + " = new SimpleStringProperty()");
				rootNode.getHashFieldAndProperties().put(field.getName(), "StringProperty " + field.getName() + " = new SimpleStringProperty()");
			} else if (type.getSimpleName().toLowerCase().equals("double")) {
				label.setText("DoubleProperty " + field.getName() + " = new SimpleDoubleProperty()");
				rootNode.getHashFieldAndProperties().put(field.getName(), "DoubleProperty " + field.getName() + " = new SimpleDoubleProperty()");
			} else if (type.getSimpleName().toLowerCase().equals("float")) {
				label.setText("FloatProperty " + field.getName() + " = new SimpleFloatProperty()");
				rootNode.getHashFieldAndProperties().put(field.getName(),"FloatProperty " + field.getName() + " = new SimpleFloatProperty()");
			} else if (type.getSimpleName().toLowerCase().equals("boolean")
					|| type.getSimpleName().toLowerCase().equals("checkbox")
					|| type.getSimpleName().toLowerCase().equals("radiobutton")) {
				label.setText("BooleanProperty " + field.getName() + " = new SimpleBooleanProperty()");
				rootNode.getHashFieldAndProperties().put(field.getName(), "BooleanProperty " + field.getName() + " = new SimpleBooleanProperty()");
			} else {
				label.setText("ObjectProperty<" + Helper.retrieveType(field.getGenericType()) + "> " + field.getName()
						+ " = new SimpleObjectProperty<>()");
				rootNode.getHashFieldAndProperties().put(field.getName(), "ObjectProperty<" + Helper.retrieveType(field.getGenericType()) + "> " + field.getName()
				+ " = new SimpleObjectProperty<>()");
			}
		} else {
			label.setText("--");
			rootNode.getHashFieldAndProperties().remove(field.getName());
		}
	}

}
