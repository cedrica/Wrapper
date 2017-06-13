package com.preag.wrapper.maincontainer.selectioncontainer;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.preag.wrapper.maincontainer.MainContainerView;
import com.preag.wrapper.maincontainer.selectioncontainer.converttominiobject.ConvertToMiniObjectView;

@Singleton
public class SelectionContainerManager {

	@Inject
	private ConvertToMiniObjectView convertToMiniObjectView;
	
	public void initialize(MainContainerView mainContainerView) {
	}
	

}
