package com.preag.wrapper.maincontainer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.preag.wrapper.event.WrapperEvent;
import com.preag.wrapper.maincontainer.selectioncontainer.converttointerface.ConvertToInterfaceView;
import com.preag.wrapper.maincontainer.selectioncontainer.converttominiobject.ConvertToMiniObjectView;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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
		mainContainerView.addEventHandler(WrapperEvent.CHOOSE_POJOS, evt -> choosePojos(evt));
		mainContainerView.setPlaceHolder(convertToMiniObjectView);
	}

	private void choosePojos(WrapperEvent evt) {
		convertToMiniObjectView.setPojos(retrievePojoNames(evt.getPojos()));
		convertToInterfaceView.setPojos(retrievePojoNames(evt.getPojos()));
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
