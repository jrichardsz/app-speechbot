package org.jrichardsz.swingapp.controller.core;

import org.jrichardsz.app.speechbot.controller.*;
import org.jrichardsz.app.speechbot.view.*;

public class ControllerFactory{
	
	public ControllerFactory(SpeechBotUI speechBotUI ){
		gui = speechBotUI;
	}
	
	public void init() {
		 guiController = new GuiController(gui);
	}

	public SpeechBotUI getGui(){
		return gui;
	}

	public void setGui(SpeechBotUI gui){
		this.gui=gui;
	}

	public GuiController getGuiController(){
		return guiController;
	}

	public void setGuiController(GuiController guiController){
		this.guiController=guiController;
	}





	private SpeechBotUI gui;
	 private GuiController guiController;
	
}
