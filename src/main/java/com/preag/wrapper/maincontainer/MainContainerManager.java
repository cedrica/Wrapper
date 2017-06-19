package com.preag.wrapper.maincontainer;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.preag.core.ui.utils.dialog.Dialogs;
import com.preag.wrapper.enums.Category;
import com.preag.wrapper.event.WrapperEvent;
import com.preag.wrapper.helper.Helper;
import com.preag.wrapper.maincontainer.selectioncontainer.converttointerface.ConvertToInterfaceView;
import com.preag.wrapper.maincontainer.selectioncontainer.converttominiobject.ConvertToMiniObjectView;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextInputDialog;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.util.Pair;

@Singleton
public class MainContainerManager {
	private final static Logger LOG = LoggerFactory.getLogger(MainContainerManager.class);
	@Inject
	private ConvertToInterfaceView convertToInterfaceView;
	@Inject
	private ConvertToMiniObjectView convertToMiniObjectView;
	private Category category;

	public void initialize(MainContainerView mainContainerView) {
		mainContainerView.addEventHandler(WrapperEvent.CHANGE_TO_INTERFACE,
				evt -> changeToInterface(evt, mainContainerView));
		mainContainerView.addEventHandler(WrapperEvent.CHANGE_TO_MINI_OBJECT,
				evt -> changeToMiniObject(evt, mainContainerView));
		mainContainerView.addEventHandler(WrapperEvent.CHOOSE_POJOS, evt -> choosePojos(evt, mainContainerView));
		mainContainerView.addEventHandler(WrapperEvent.SAVE, evt -> save(evt, mainContainerView));
		mainContainerView.setPlaceHolder(convertToMiniObjectView);
		convertToInterfaceView.addEventFilter(WrapperEvent.SHOW_PREVIEW, evt -> {
			HashMap<String, HashMap<String, Pair<String, String>>> hashClassFieldAndFunctions = convertToInterfaceView
					.getHashClassFieldAndFunctions();
			convertToInterfaceView.getPreviewView().setHashClassFieldAndFunctions(hashClassFieldAndFunctions);
			convertToInterfaceView.getPreviewView().setTrigger(true);

		});
	}

	private void save(WrapperEvent evt, MainContainerView mainContainerView) {
		String fileContaint = "";
		if (category == Category.MINI_OBJECT) {
			HashMap<String, String> hashFieldAndProperties = convertToMiniObjectView.getHashFieldAndProperties();
			String fileName = retrieveFilename(mainContainerView);
			fileContaint = MainContainerService.builtMiniObjectFileHeader(fileName) + "\n";
			String hashCode = MainContainerService.builtHashCodeFunctionHeader();
			String equalsCode = MainContainerService.builtEqualsCodeHeader(fileName);
			for (Entry<String, String> entry : hashFieldAndProperties.entrySet()) {
				fileContaint += "private " + entry.getValue() + ";\n";
				fileContaint += MainContainerService.builtPropertyFunction(entry.getKey(), entry.getValue()) + "\n";
				fileContaint += MainContainerService.builtGetterFunction(entry.getKey(), entry.getValue()) + "\n";
				fileContaint += MainContainerService.builtSetterFunction(entry.getKey(), entry.getValue()) + "\n";
				if (MainContainerService.isLongProperty(entry.getValue())) {
					hashCode += "result = prime * result + (int) (get" + Helper.capitalizeFirstLetter(entry.getKey())
							+ "() ^ (get" + Helper.capitalizeFirstLetter(entry.getKey()) + "() >>> 32));\n";
					equalsCode += "if (get" + Helper.capitalizeFirstLetter(entry.getKey()) + "() != other.get"
							+ Helper.capitalizeFirstLetter(entry.getKey()) + "())return false;";
				} else if (MainContainerService.isIntegerProperty(entry.getValue())) {
					hashCode += "result = prime * result + " + entry.getKey() + ";\n";
					equalsCode += "if (get" + Helper.capitalizeFirstLetter(entry.getKey()) + "() != other.get"
							+ Helper.capitalizeFirstLetter(entry.getKey()) + "())return false;";
				} else if (MainContainerService.isFloatProperty(entry.getValue())) {
					hashCode += "result = prime * result + Float.floatToIntBits(get"
							+ Helper.capitalizeFirstLetter(entry.getKey()) + "());\n";
					equalsCode += "if (get" + Helper.capitalizeFirstLetter(entry.getKey()) + "() != other.get"
							+ Helper.capitalizeFirstLetter(entry.getKey()) + "())return false;";
				} else if (MainContainerService.isDoubleProperty(entry.getValue())) {
					hashCode += "long temp;\n" + "temp = Double.doubleToLongBits(get"
							+ Helper.capitalizeFirstLetter(entry.getKey()) + "());\n"
							+ "result = prime * result + (int) (temp ^ (temp >>> 32));";
					equalsCode += "if (get" + Helper.capitalizeFirstLetter(entry.getKey()) + "() != other.get"
							+ Helper.capitalizeFirstLetter(entry.getKey()) + "())return false;";
				} else if (MainContainerService.isBooleanProperty(entry.getValue())) {
					hashCode += "result = prime * result + (get" + Helper.capitalizeFirstLetter(entry.getKey())
							+ "() ? 1231 : 1237);\n";
					equalsCode += "if (get" + Helper.capitalizeFirstLetter(entry.getKey()) + "() != other.get"
							+ Helper.capitalizeFirstLetter(entry.getKey()) + "())return false;";
				} else {
					hashCode += "result = prime * result + ((get" + Helper.capitalizeFirstLetter(entry.getKey())
							+ "() == null) ? 0 : get" + Helper.capitalizeFirstLetter(entry.getKey())
							+ "().hashCode());\n";
					equalsCode += "if (get" + Helper.capitalizeFirstLetter(entry.getKey()) + "() == null) {"
							+ "if (other.get" + Helper.capitalizeFirstLetter(entry.getKey())
							+ "() != null)return false;}" + " else if (!get"
							+ Helper.capitalizeFirstLetter(entry.getKey()) + "().equals(other.get"
							+ Helper.capitalizeFirstLetter(entry.getKey()) + "()))return false;";

				}

			}
			hashCode += "return result;}";
			equalsCode += "return true;}";
			fileContaint += hashCode + equalsCode + "}";

			saveUnderDirectory(mainContainerView, fileContaint, fileName);
		} else if (category == Category.INTERFACE) {
			HashMap<String, HashMap<String, Pair<String, String>>> hashClassFieldAndFunctions = convertToInterfaceView
					.getHashClassFieldAndFunctions();
			if (hashClassFieldAndFunctions == null)
				return;
			DirectoryChooser directoryChooser = new DirectoryChooser();
			directoryChooser.setTitle("Wählen Sie den Speicherort");
			File directory = directoryChooser.showDialog(mainContainerView.getScene().getWindow());
			if (directory == null)
				return;
			for (Entry<String, HashMap<String, Pair<String, String>>> interfaceName : hashClassFieldAndFunctions
					.entrySet()) {
				fileContaint = "package "+convertToInterfaceView.getPackageName()+"\n";
				fileContaint += "public interface I" + Helper.removeFileExtension(interfaceName.getKey()) + "{\n";
				for (Entry<String, Pair<String, String>> pairGetterSetter : interfaceName.getValue().entrySet()) {
					fileContaint += pairGetterSetter.getValue().getKey() + "\n";
					fileContaint += pairGetterSetter.getValue().getValue() + "\n";
					fileContaint += "//=======================================\n";
				}
				fileContaint += "}";
				boolean saveSuccessfull = Helper.writeContaintToFileAndSave(fileContaint, directory.getAbsolutePath()+"\\I"+interfaceName.getKey());
				if (saveSuccessfull) {
					Dialogs.info(
							"Die Spericherung der Interface I"+interfaceName.getKey()+ " wurde erfolgreich. Sie sollen aber ein paar Anpassungen an die Datei einbringen:\n"
									+ "z.B. Import oganisieren und Packageeinbindung per autovervollständigung",
							mainContainerView.getScene().getWindow()).showAndWait();
					LOG.info("Saving successful");
				}else{
					Dialogs.error(
							"Die Spericherung der Interface I"+interfaceName.getKey()+ " wurde nicht erfolgreich",
							mainContainerView.getScene().getWindow()).showAndWait();
				}
			}
		}
	}

	private String retrieveFilename(MainContainerView mainContainerView) {
		TextInputDialog textInputDialog = new TextInputDialog(
				convertToMiniObjectView.getCurrentSelectedPojo() + "MiniObject");
		textInputDialog.initOwner(mainContainerView.getScene().getWindow());
		textInputDialog.setHeaderText(
				"Geben einen gewünschten Dateiname ein wenn sie nicht mit dem Defaultname zufrieden sind.");
		textInputDialog.setContentText(null);
		Optional<String> result = textInputDialog.showAndWait();
		String fileName = "";
		if (result.isPresent()) {
			fileName = result.get();
		} else {
			Dialogs.info("Kein Name wurde eingegeben. Der Default Name wird genommen werden.",
					mainContainerView.getScene().getWindow()).showAndWait();
			fileName = convertToMiniObjectView.getCurrentSelectedPojo() + "MiniObject";
		}
		return fileName;
	}

	private void saveUnderDirectory(MainContainerView mainContainerView, String fileContaint, String fileName) {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Wählen Sie den Speicherort");
		fileChooser.setSelectedExtensionFilter(new ExtensionFilter("JAVA Files (*.java)","*.java"));
		if (fileName != null)
			fileChooser.setInitialFileName(fileName);
		File directory = fileChooser.showSaveDialog(mainContainerView.getScene().getWindow());
		if (directory == null)
			return;
		boolean saveSuccessfull = Helper.writeContaintToFileAndSave(fileContaint, directory.getAbsolutePath());
		if (saveSuccessfull) {
			Dialogs.info(
					"Die Spericherung wurde erfolgreich. Sie sollen aber ein paar Anpassungen an die Datei einbringen:\n"
							+ "z.B. Import oganisieren und Packageeinbindung per autovervollständigung",
					mainContainerView.getScene().getWindow()).showAndWait();
			LOG.info("Saving successful");
		}
	}

	private void choosePojos(WrapperEvent evt, MainContainerView mainContainerView) {
		String targetPath = MainContainerService.retrieveJAR(evt.getPojos().get(0).getAbsolutePath());
		File[] fileList = Helper.findFilesEndingWith(targetPath, ".jar");
		if (fileList.length == 0) {
			Dialog<ButtonType> error = Dialogs.error(
					"Das Projekt wo die PoJos liegen muss gebaut werden.\nFühren Sie ein mvn clean install aus und wiederholen den Vorgang.",
					mainContainerView.getScene().getWindow());
			error.showAndWait();
			return;
		}

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (evt.getPojos() != null) {
			convertToMiniObjectView.setPackageName(MainContainerService.builtPackageName(evt.getPojos().get(0)));
			convertToMiniObjectView.setJarFilePath(fileList[0].getAbsolutePath());
			convertToMiniObjectView.setPojos(retrievePojoNames(evt.getPojos()));

			convertToInterfaceView.setPackageName(MainContainerService.builtPackageName(evt.getPojos().get(0)));
			convertToInterfaceView.setJarFilePath(fileList[0].getAbsolutePath());
			convertToInterfaceView.setPojos(retrievePojoNames(evt.getPojos()));
		}
	}

	private void changeToMiniObject(WrapperEvent evt, MainContainerView mainContainerView) {
		evt.consume();
		category = evt.getCategory();
		mainContainerView.setPlaceHolder(convertToMiniObjectView);
	}

	private void changeToInterface(WrapperEvent evt, MainContainerView mainContainerView) {
		evt.consume();
		category = evt.getCategory();
		mainContainerView.setPlaceHolder(convertToInterfaceView);
	}

	private ObservableList<String> retrievePojoNames(List<File> pojos) {
		List<String> resultList = new ArrayList<>();
		if (pojos == null)
			return null;
		for (File file : pojos) {
			resultList.add(file.getName());
		}
		return FXCollections.observableList(resultList);
	}
}
