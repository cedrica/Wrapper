package com.preag.wrapper.event;

import java.io.File;
import java.util.List;

import com.preag.core.ui.event.ApplicationEvent;

import javafx.event.EventType;

public class WrapperEvent extends ApplicationEvent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final EventType<WrapperEvent> CHANGE_TO_INTERFACE = new EventType<>(ANY, "CHANGE_TO_INTERFACE");
	public static final EventType<WrapperEvent> CHANGE_TO_MINI_OBJECT = new EventType<>(ANY, "CHANGE_TO_MINI_OBJECT");
	public static final EventType<WrapperEvent> CHOOSE_POJOS =  new EventType<>(ANY, "CHOOSE_POJOS");
	private List<File> pojos;
	

	public WrapperEvent(EventType<WrapperEvent> arg0) {
		super(arg0);
	}

	public WrapperEvent(EventType<WrapperEvent> arg0,List<File> pojos) {
		super(arg0);
		this.pojos = pojos;
	}
	public List<File> getPojos() {
		return this.pojos;
	}

}
