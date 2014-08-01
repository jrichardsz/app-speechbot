package org.jrichardsz.app.speechbot.controller;

import java.io.*;
import java.util.*;

import javax.swing.*;

import org.jrichardsz.app.speechbot.common.*;
import org.jrichardsz.app.speechbot.core.*;

import com.linet.api.swing.filechooser.*;

public class SingleSentenceController implements TTSController{

	private HashMap<String,String> keyLanguajes = new HashMap<String,String>();
	private HashMap<String,String> keyModes = new HashMap<String,String>();
	
	@Override
	public void execute(){
		
		initializeSelectedValues();
		
		try{
			
			String pathOfFileSentences = FileChooserUtil.getFilePathToOpen("Enter path of file whit sentences to convert..");
			String languajeValue = askLanguaje();
			String pathToCreateFile = FileChooserUtil.getFolderPath("Enter path of folder to save converted files..");
			
			String modeValue = askMode();
			
			if(keyModes.get(modeValue).equals("single")){
				TTSUtil.convertFileOfSentencesToSeveralSpeechs(pathOfFileSentences,pathToCreateFile,keyLanguajes.get(languajeValue));
			}else {
				TTSUtil.convertFileOfSentencesToUniqueSpeechs(pathOfFileSentences,pathToCreateFile,keyLanguajes.get(languajeValue));
			}
			
			JOptionPane.showMessageDialog(null, "Success Convertion", "SpeechBot", JOptionPane.INFORMATION_MESSAGE);
			
		}catch(Exception exception){
			exception.printStackTrace();
			StringWriter errors = new StringWriter();
			exception.printStackTrace(new PrintWriter(errors));
			JOptionPane.showMessageDialog(null, errors.toString(), "SpeechBot", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		
	}
	
	public void initializeSelectedValues(){
		keyLanguajes = new HashMap<String,String>();
		keyLanguajes.put("Spanish","es");
		keyLanguajes.put("English","en");
		
		keyModes = new HashMap<String,String>();
		keyModes.put("Single mp3 file by each sentence.","single");
		keyModes.put("A unique mp3 file containing all sentences.","en");
	}
	
	public String askLanguaje() throws Exception{
		
		Object[] selectionValues = keyLanguajes.keySet().toArray();

	    String initialSelection = ""+selectionValues[0];
	    Object languaje = JOptionPane.showInputDialog(null, "Select languaje of sentences to convert..","SpeechBot", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
		
	    if(languaje!=null){
	    	return ""+languaje;
	    }else {
	    	 throw new Exception("Error when try to get languaje.");
	    }
		
	}
	
	public String askMode() throws Exception{
		
		Object[] selectionValues = keyModes.keySet().toArray();

	    String initialSelection = ""+selectionValues[0];
	    Object languaje = JOptionPane.showInputDialog(null, "Select mode of mp3 creation..","SpeechBot", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
		
	    if(languaje!=null){
	    	return ""+languaje;
	    }else {
	    	 throw new Exception("Error when try to get mp3 creation.");
	    }
		
	}
		
	

}
