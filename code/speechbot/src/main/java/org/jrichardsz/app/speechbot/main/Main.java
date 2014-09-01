package org.jrichardsz.app.speechbot.main;

import java.awt.*;

import javax.swing.*;

import org.jrichardsz.app.speechbot.common.*;
import org.jrichardsz.app.speechbot.view.*;
import org.jrichardsz.swingapp.controller.core.*;

import com.gtranslate.context.*;

public class Main{

	public static String enableProxy = "false";
	public static String proxy = "my.proxy.com";
	public static String port= "8080";
	public static String googleTranslateText = "http://translate.google.com.{locale}/translate_a/t?";
	public static String googleTranslateAudio = "http://translate.google.com/translate_tts?";
	public static String googleTranslateDetect = "	";
	public static String locale = "pe";	
	
	
	static{
		
		TranslateEnvironment.init(enableProxy, proxy, port, googleTranslateText, googleTranslateAudio, googleTranslateDetect, locale);
	}

	public static void main(String[] args){
		
		
		
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				try{
					
					UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
					MainUI gui = new MainUI();
					gui.setVisible(true);
					
					ControllerFactory controllerFactory = new ControllerFactory(gui);
	                controllerFactory.init();
				}
				catch(Exception ex){				
					ErrorEngine.traceErrorOnUI(ex,true,true);
				}
			}
		});
	}

}
