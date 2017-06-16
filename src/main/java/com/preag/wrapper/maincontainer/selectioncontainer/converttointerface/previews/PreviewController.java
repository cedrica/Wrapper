package com.preag.wrapper.maincontainer.selectioncontainer.converttointerface.previews;

import java.net.URL;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.util.Pair;

public class PreviewController implements Initializable {

	@FXML PreviewView rootNode;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		rootNode.triggerProperty().addListener((obs,oldVal,newVal)->{
			if(newVal){
				rootNode.getChildren().clear();
				HashMap<String,HashMap<String,Pair<String,String>>> hashClassFieldAndFunctions = rootNode.getHashClassFieldAndFunctions();
				if(hashClassFieldAndFunctions == null) return;
				for (Entry<String,HashMap<String,Pair<String,String>>> entry1: hashClassFieldAndFunctions.entrySet()) {
					for (Entry<String,Pair<String,String>> entry2: entry1.getValue().entrySet()) {
						Label label = new Label(entry2.getValue().getKey());
						rootNode.getChildren().add(label);
						rootNode.getChildren().add(new Label(entry2.getValue().getValue()));
					}
				}
			}
		
			rootNode.setTrigger(false);
		});
	}

}
