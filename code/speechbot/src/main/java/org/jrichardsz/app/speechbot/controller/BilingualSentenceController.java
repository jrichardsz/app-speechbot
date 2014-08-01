package org.jrichardsz.app.speechbot.controller;

import java.io.*;
import java.util.*;

import javax.swing.*;

import org.jrichardsz.app.speechbot.common.*;
import org.jrichardsz.app.speechbot.core.*;

import com.linet.api.swing.filechooser.*;

public class BilingualSentenceController implements TTSController{
	
private HashMap<String,String> keyLanguajes = new HashMap<String,String>();
	
	@Override
	public void execute(){
		
		initializeLanguaje();
		
		try{
			
			String pathOfFirstFileSentences = FileChooserUtil.getFilePathToOpen("Enter path of first file whit sentences to convert..");
			String firstLanguajeValue = askLanguaje();
			String pathOfSecondFileSentences = FileChooserUtil.getFilePathToOpen("Enter path of second file whit sentences to convert..");
			String secondLanguajeValue = askLanguaje();			
			String pathToCreateFile = FileChooserUtil.getFolderPath("Enter path of folder to save converted files..");
			
			//TTSUtil.convertFileOfSentencesToSpeech(pathOfFileSentences,pathToCreateFile,keyLanguajes.get(languajeValue));
			
			JOptionPane.showMessageDialog(null, "Success Convertion", "SpeechBot", JOptionPane.INFORMATION_MESSAGE);
			
		}catch(Exception exception){
			exception.printStackTrace();
			StringWriter errors = new StringWriter();
			exception.printStackTrace(new PrintWriter(errors));
			JOptionPane.showMessageDialog(null, errors.toString(), "SpeechBot", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		
		
	}
	
	public void initializeLanguaje(){
		keyLanguajes = new HashMap<String,String>();
		keyLanguajes.put("Spanish","es");
		keyLanguajes.put("English","en");
	}
	
	public String askLanguaje() throws Exception{
		
		Object[] selectionValues = keyLanguajes.keySet().toArray();

	    String initialSelection = ""+selectionValues[0];
	    Object languaje = JOptionPane.showInputDialog(null, "Select languaje of sentences of selected file.","SpeechBot", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
		
	    if(languaje!=null){
	    	return ""+languaje;
	    }else {
	    	 throw new Exception("Error when try to get languaje.");
	    }
		
	}

}
