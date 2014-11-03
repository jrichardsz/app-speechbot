package org.jrichardsz.app.speechbot.main;

import org.jrichardsz.app.speechbot.controller.*;

import com.gtranslate.context.*;

public class MainSingleSentenceController{


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

		SingleSentenceController controller = new SingleSentenceController();
		controller.execute();

	}

}
