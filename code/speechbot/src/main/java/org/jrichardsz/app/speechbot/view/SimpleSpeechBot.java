package org.jrichardsz.app.speechbot.view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.swing.JOptionPane;

import org.apache.commons.io.IOUtils;

import com.gtranslate.Audio;
import com.gtranslate.context.TranslateEnvironment;
import com.linet.api.swing.filechooser.FileChooserUtil;


public class SimpleSpeechBot{


	public static String enableProxy = "false";
	public static String proxy = "my.proxy.com";
	public static String port= "8080";
	public static String googleTranslateText = "http://translate.google.com.{locale}/translate_a/t?";
	public static String googleTranslateAudio = "http://translate.google.com/translate_tts?";
	public static String googleTranslateDetect = "http://www.google.com/uds/GlangDetect?";
	public static String locale = "pe";	
	
	
	static{
		
		TranslateEnvironment.init(enableProxy, proxy, port, googleTranslateText, googleTranslateAudio, googleTranslateDetect, locale);
	}
		

	
	public static void convertFile(String pathFileInput,String pathOutputFolder) throws Exception {
			
	    BufferedReader br = new BufferedReader(new FileReader(pathFileInput));
	    try {
	        
	        String line = br.readLine();
	        
	        int cont=1;
	        
	        while (line != null) {
	            
	        	String[] sentences = line.split("[|]");
	    		
	    		Audio audio = Audio.getInstance();
	    		String sentence1 = cleanSentence(sentences[0]);
	    		InputStream sound = audio.getAudio(sentence1,"es");
	            
	    		OutputStream out =  new FileOutputStream(new File(pathOutputFolder+File.separator+convertNumberToStringWhitZeros(cont, 5)+".mp3"));
	    		IOUtils.copy(sound,out);
	    		
	    		if(sound!=null){
	    			sound.close();
	    		}
	    		
	    		if(out!=null){
	    			out.close();
	    		}
	    		
	    		Thread.sleep(5000);
	    		
	    		cont++;
	    		
	    		String sentence2 = cleanSentence(sentences[1]);
	    		InputStream sound2 = audio.getAudio(sentence2,"en");
	            
	    		OutputStream out2 =  new FileOutputStream(new File(pathOutputFolder+File.separator+convertNumberToStringWhitZeros(cont, 5)+".mp3"));
	    		IOUtils.copy(sound2,out2);
	    		
	    		if(sound2!=null){
	    			sound2.close();
	    		}
	    		
	    		if(out2!=null){
	    			out2.close();
	    		}
	        	
	            line = br.readLine();
	            cont++;
	        }
	        
	    } catch(Exception exception) {
	        throw new Exception("Error when try to convert stringd to mp3.",exception);
	    } finally{
	    	if(br!=null){
	    		br.close();
	    	}
	    }
		
	}
	
    public static String convertNumberToStringWhitZeros(int codigo, int length) {
        String cadena_numero_ini = "" + codigo;// representa el codigo pasado a cadena
        String cadena_con_ceros = "";
        if (cadena_numero_ini.length() > length) {//si el codigo pasado a cadena es mayor al limite establecido
            //lanzar alerta
        } else {
            int numero_ceros = length - cadena_numero_ini.length();
            for (int a = 0; a < numero_ceros; a++) {
                cadena_con_ceros += "0";//crea un acadena con tantos ceros como se necesita
            } //ahora lo concatenamos con el numero
            cadena_con_ceros += cadena_numero_ini;
        }
        return cadena_con_ceros;
    }	
    
	public static String cleanSentence(String sentenceInitial){
		return sentenceInitial.replaceAll("\t", "").replaceAll("\\s\\s", "");
	}
    
	public static void main(String[] args) {
		
		try{
			
			String pathFileInput = FileChooserUtil.getFilePathToOpen("Enter path of file to convert..");
			String pathOutputFolder = FileChooserUtil.getFolderPath("Enter path of folder to save converted files..");
			convertFile(pathFileInput, pathOutputFolder);
			JOptionPane.showMessageDialog(null, "Success Convertion", "SpeechBot", JOptionPane.ERROR_MESSAGE);
			
		}catch(Exception exception){
			exception.printStackTrace();
			StringWriter errors = new StringWriter();
			exception.printStackTrace(new PrintWriter(errors));
			JOptionPane.showMessageDialog(null, errors.toString(), "SpeechBot", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		
		
	}

}
