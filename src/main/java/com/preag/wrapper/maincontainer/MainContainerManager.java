package com.preag.wrapper.maincontainer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.preag.core.ui.utils.dialog.Dialogs;
import com.preag.wrapper.event.WrapperEvent;
import com.preag.wrapper.maincontainer.selectioncontainer.converttointerface.ConvertToInterfaceView;
import com.preag.wrapper.maincontainer.selectioncontainer.converttominiobject.ConvertToMiniObjectView;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.stage.FileChooser;

@Singleton
public class MainContainerManager {

	@Inject
	private ConvertToInterfaceView convertToInterfaceView;
	@Inject
	private ConvertToMiniObjectView convertToMiniObjectView;

	public void initialize(MainContainerView mainContainerView) {
		mainContainerView.addEventHandler(WrapperEvent.CHANGE_TO_INTERFACE,
				evt -> changeToInterface(evt, mainContainerView));
		mainContainerView.addEventHandler(WrapperEvent.CHANGE_TO_MINI_OBJECT,
				evt -> changeToMiniObject(evt, mainContainerView));
		mainContainerView.addEventHandler(WrapperEvent.CHOOSE_POJOS, evt -> choosePojos(evt, mainContainerView));
		mainContainerView.setPlaceHolder(convertToMiniObjectView);
	}

	private void choosePojos(WrapperEvent evt, MainContainerView mainContainerView) {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Wählen sie die .JAR Datei ihres Projekts");
		File jarFile = fileChooser.showOpenDialog(mainContainerView.getScene().getWindow());
		if (!jarFile.getName().endsWith(".jar")) {
			Dialog<ButtonType> error = Dialogs.error("Die Datei ist keine JAR",
					mainContainerView.getScene().getWindow());
			error.showAndWait();
			return;
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if(evt.getPojos() != null){
			convertToMiniObjectView.setPackageName(builtPackageName(evt.getPojos().get(0)));
			convertToMiniObjectView.setJarFilePath(jarFile.getAbsolutePath());
			convertToMiniObjectView.setPojos(retrievePojoNames(evt.getPojos()));
			convertToInterfaceView.setPojos(retrievePojoNames(evt.getPojos()));
		}
	}

	private String builtPackageName(File file) {
		Pattern pattern = Pattern.compile("com(.*)");
		Matcher matcher = pattern.matcher(file.getAbsolutePath());
		if (matcher.find()) {
			String split = matcher.group().replace("\\", ".");
			split = split.replace("."+file.getName(), "");
			return split;
		}
		return "";
	}

	private void changeToMiniObject(WrapperEvent evt, MainContainerView mainContainerView) {
		evt.consume();
		mainContainerView.setPlaceHolder(convertToMiniObjectView);
	}

	private void changeToInterface(WrapperEvent evt, MainContainerView mainContainerView) {
		evt.consume();
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
