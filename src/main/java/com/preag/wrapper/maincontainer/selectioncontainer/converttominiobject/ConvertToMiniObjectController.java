package com.preag.wrapper.maincontainer.selectioncontainer.converttominiobject;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;

import com.preag.core.ui.utils.dialog.Dialogs;

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
	private String jarFilePath;
	private String packageName;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		rootNode.packageNameProperty().addListener((obs, oldVal, newVal) -> setPackageName(newVal));
		rootNode.pojosProperty().addListener((obs, oldVal, newVal) -> insertIntoGrid(newVal));
		rootNode.jarFilePathProperty().addListener((obs, oldVal, newVal) -> setJarFilePath(newVal));
	}

	private void setPackageName(String newVal) {
		packageName = newVal;
	}

	private void setJarFilePath(String newVal) {
		jarFilePath = newVal;
	}

	private void insertIntoGrid(ObservableList<String> pojosNames) {
		boolean first = true;
		jarFilePath = "file:///" + jarFilePath.replace("\\", "/");
		for (String className : pojosNames) {
			try {
				URLClassLoader classLoader = URLClassLoader.newInstance(new URL[] { new URL(jarFilePath) });
				Class<?> clazz = classLoader
						.loadClass(packageName+"." + retrieveName(className));
				RadioButton rbPojo = new RadioButton(className);
				if (first) {
					first = false;
					rbPojo.setSelected(true);
					initFieldsAndPreviewForClass(clazz);
				}
				rbPojo.setToggleGroup(group);
				vbPojos.getChildren().add(rbPojo);
				rbPojo.selectedProperty().addListener((obs, oldVal, newVal) -> {
					initFieldsAndPreviewForClass(clazz);
				});
			} catch (ClassNotFoundException | MalformedURLException e) {
				Dialog<ButtonType> error = Dialogs.error(
						"Das PoJo " + className + " enthält Abhängigkeiten die auch mitimportiert werden sollen",
						rootNode.getScene().getWindow());
				error.showAndWait();
				e.printStackTrace();
			}
		}
	}

	private String retrieveName(String className) {
		if (className.trim().isEmpty())
			return "";
		else {
			String[] split = className.split("\\.");
			return split[0];
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
			CheckBox cbField = new CheckBox(field.getName() + " (" + type.getName() + ")");
			HBox preview = new HBox(label);
			cbField.selectedProperty().addListener((obs, oldVal, newVal) -> {
				if (newVal) {
					if (type.getName().toLowerCase().equals("long")) {
						label.setText("LongProperty " + field.getName() + " = new SimpleLongProperty()");
					} else if (type.getName().toLowerCase().equals("int")) {
						label.setText("IntegerProperty " + field.getName() + " = new SimpleIntegerProperty()");
					} else if (type.getName().toLowerCase().equals("string")
							|| type.getName().toLowerCase().equals("textfield")
							|| type.getName().toLowerCase().equals("textarea")) {
						label.setText("StringProperty " + field.getName() + " = new SimpleStringProperty()");
					} else if (type.getName().toLowerCase().equals("double")) {
						label.setText("DoubleProperty " + field.getName() + " = new SimpleDoubleProperty()");
					} else if (type.getName().toLowerCase().equals("float")) {
						label.setText("FloatProperty " + field.getName() + " = new SimpleFloatProperty()");
					} else if (type.getName().toLowerCase().equals("boolean")
							|| type.getName().toLowerCase().equals("checkbox")
							|| type.getName().toLowerCase().equals("radiobutton")) {
						label.setText("BooleanProperty " + field.getName() + " = new SimpleBooleanProperty()");
					} else {
						label.setText("ObjectProperty<" + retrieveType(field.getGenericType()) + "> " + field.getName()
								+ " = new SimpleObjectProperty<>()");
					}
				} else {
					label.setText("--");
				}
			});

			gridPane.add(cbField, columnIndex, rowIndex);
			gridPane.add(preview, columnIndex + 1, rowIndex);
			rowIndex++;
			hbGridPaneContainer.getChildren().clear();
			hbGridPaneContainer.getChildren().add(gridPane);
		}
	}

	private String retrieveType(Type genericType) {
		Pattern pattern = Pattern.compile("<(.*?)>");
		Matcher matcher = pattern.matcher(genericType.getTypeName());
		if (matcher.find()) {
			String[] split = matcher.group(1).split("\\.");
			return (split != null && split.length > 0) ? split[split.length - 1] : matcher.group(1);
		} else {
			String[] split = genericType.getTypeName().split("\\.");
			return (split != null && split.length > 0) ? split[split.length - 1] : null;
		}
	}

}
