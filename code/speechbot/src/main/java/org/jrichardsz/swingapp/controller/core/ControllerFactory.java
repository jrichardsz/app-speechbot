package org.jrichardsz.swingapp.controller.core;

import org.jrichardsz.app.speechbot.controller.*;
import org.jrichardsz.app.speechbot.view.*;

public class ControllerFactory{
	
	public ControllerFactory(MainUI mainUI ){
		gui = mainUI;
	}
	
	public void init() {
//		 guiController = new GuiController(gui);
	}

	public MainUI getGui(){
		return gui;
	}

	public void setGui(MainUI gui){
		this.gui=gui;
	}

	public GuiController getGuiController(){
		return guiController;
	}

	public void setGuiController(GuiController guiController){
		this.guiController=guiController;
	}

	private MainUI gui;
	private GuiController guiController;
	
}
