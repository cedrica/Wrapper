package com.preag.wrapper;

import org.apache.deltaspike.core.api.provider.BeanProvider;

import com.preag.core.ui.app.DesktopApp;
import com.preag.wrapper.maincontainer.MainContainerManager;
import com.preag.wrapper.maincontainer.MainContainerView;

import javafx.scene.image.Image;

public class Main extends DesktopApp{

	public static void main(String[] args){
		enablePreloader();
		launch(args);
	}
	
	@Override
	public void initialize() {
		MainContainerView mainContainerView = BeanProvider.getContextualReference(MainContainerView.class, true);
		MainContainerManager mainContainerManager = BeanProvider.getContextualReference(MainContainerManager.class, true);
		mainContainerManager.initialize(mainContainerView);
		getPrimaryStage().getIcons().add(new Image("/images/wrapper-icon.png"));
		closePreloader();
		showPrimaryStage(mainContainerView);

	}

}
