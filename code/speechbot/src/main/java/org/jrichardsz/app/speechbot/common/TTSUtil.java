package org.jrichardsz.app.speechbot.common;

import java.io.*;
import java.util.*;

import org.apache.commons.io.*;

import com.gtranslate.*;
import com.linet.util.file.*;

public class TTSUtil{
	
	public static void joinMp3(String firstFile,String secondFile, String finalFile) throws Exception {
		
		FileInputStream firstStream = null;
		FileOutputStream finalStream = null;
		FileInputStream secondStream = null;
		try {
            firstStream = new FileInputStream(firstFile);
            File f = new File(finalFile);
            if(!f.exists())
            {
                f.createNewFile();
            }
            
            finalStream = new FileOutputStream(finalFile);
            int temp;
            temp = firstStream.read();
            while( temp != -1)
            {
                finalStream.write(temp);
                temp = firstStream.read();
            };
            firstStream.close();
            
            secondStream = new FileInputStream(secondFile);
            secondStream.read(new byte[32],0,32);
            temp = secondStream.read();
            while( temp != -1)
            {
                finalStream.write(temp);
                temp = secondStream.read();
            };
            secondStream.close();
            finalStream.close();
        } catch (IOException e) {
           throw new Exception("Error when try to join mp3 files.",e);
        } finally{
        	
        	if(firstStream!=null){finalStream.close();}
        	if(secondStream!=null){secondStream.close();}
        	if(finalStream!=null){finalStream.close();}
        	
        }
		
		
	}
	
	public static void appendMp3Files(FileOutputStream finalMp3Stream,InputStream streamToAppend) throws Exception {
				
		try {

            int temp;
            
            streamToAppend.read(new byte[32],0,32);
            temp = streamToAppend.read();
            while( temp != -1)
            {
                finalMp3Stream.write(temp);
                temp = streamToAppend.read();
            };

        } catch (IOException e) {
           throw new Exception("Error when try to join mp3 files.",e);
        } finally{
        	
        	if(streamToAppend!=null){
        		streamToAppend.close();
        	}        	
        }
		
		
	}
	
	public static void convertSentenceToSpeech(String sentence ,String pathToCreateFile, String languaje, String nameMp3) throws Exception {
		
		OutputStream out = null;
		InputStream sound = null;
		
	    try {
	        
	    	Audio audio = Audio.getInstance();
    		sound = audio.getAudio(sentence,languaje);
            
    		out =  new FileOutputStream(new File(pathToCreateFile+File.separator+nameMp3+".mp3"));
    		IOUtils.copy(sound,out);
    		
    		if(sound!=null){
    			sound.close();
    		}
    		
    		if(out!=null){
    			out.close();
    		}	    		
	        
	    } catch(Exception exception) {
	        throw new Exception("Error when try to convert string to mp3.",exception);
	    } finally{

    		if(sound!=null){
    			sound.close();
    		}
    		
    		if(out!=null){
    			out.close();
    		}
	    	
	    }
		
	}
	
	
	public static void convertFileOfSentencesToSeveralSpeechs(String pathOfFileSentences ,String pathToCreateFile, String languaje) throws Exception {
		
		ArrayList<String> fileOfSentences = (ArrayList<String>) FileUtil.readFileAsStringCollection(pathOfFileSentences);
		
		try{
			
			for(int a=0; a< fileOfSentences.size() ;a++){
				
				String sentence = fileOfSentences.get(a);
				sentence = StringUtil.cleanSentence(sentence);
				
				String nameMp3 = StringUtil.convertNumberToStringWhitZeros(a+1, 5);
				convertSentenceToSpeech(sentence,pathToCreateFile,languaje,nameMp3);
				
			}
			
		} 
		catch(Exception exception) {
		        throw new Exception("Error when try to convert file of sentences to mp3.",exception);
		} 
		
	}
	
	public static void convertFileOfSentencesToUniqueSpeechs(String pathOfFileSentences ,String pathToCreateFile, String languaje) throws Exception {
		
		ArrayList<String> fileOfSentences = (ArrayList<String>) FileUtil.readFileAsStringCollection(pathOfFileSentences);
		
		InputStream streamToAppend = null;
		FileOutputStream finalMp3Stream = null;
		String pathMp3FinalFile = pathToCreateFile+File.separator+"mp3_created.mp3";
		
		try{
			
			Audio audio = Audio.getInstance();
			
			for(int a=0; a< fileOfSentences.size() ;a++){
				
				String sentence = fileOfSentences.get(a);
				
				sentence = StringUtil.cleanSentence(sentence);
				
				streamToAppend = audio.getAudio(sentence,languaje);
				
				if(a==0){
					finalMp3Stream = initializeFinalFile(pathMp3FinalFile,streamToAppend);
				}else {
					appendMp3Files(finalMp3Stream,streamToAppend);
				}
				
			}
			
		}
		catch(Exception exception) {
		        throw new Exception("Error when try to convert file of join sentences to unique mp3.",exception);
		}finally{
        	
        	if(streamToAppend!=null){
        		streamToAppend.close();
        	}        	
        	if(finalMp3Stream!=null){
        		finalMp3Stream.close();
        	}        	
        }
		
	}	
	
	private static FileOutputStream initializeFinalFile(String finalFile, InputStream firstStream) throws Exception{
		File f = new File(finalFile);
        if(!f.exists())
        {
            try{
				f.createNewFile();
			}
			catch(IOException e){
				throw new Exception("Error when try to create mp3 file.",e);
			}
        }
        
        FileOutputStream finalStream = new FileOutputStream(finalFile);
        int temp;
        temp = firstStream.read();
        while( temp != -1)
        {
            finalStream.write(temp);
            temp = firstStream.read();
        };
        
        return finalStream;
	}


}
