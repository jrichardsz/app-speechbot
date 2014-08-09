package org.jrichardsz.app.speechbot.controller;

import java.awt.event.*;
import java.util.*;

import javax.swing.*;
import org.jrichardsz.app.speechbot.common.*;
import org.jrichardsz.app.speechbot.view.*;
import org.jrichardsz.swingapp.controller.core.*;
import org.jrichardsz.swingapp.view.core.*;
import com.linet.api.swing.filechooser.*;

public class GuiController extends Controler {

	public GuiController(View gui){
		super(gui);
	}

	@Override
	public void assignInstancesOfView(){
		buttonGroupInputMode = ((SpeechBotUI) view).getButtonGroupInputMode();
		buttonGroupLanguajeMode = ((SpeechBotUI) view).getButtonGroupLanguajeMode();
		buttonGroupOutputMode = ((SpeechBotUI) view).getButtonGroupOutputMode();
		btnStart = ((SpeechBotUI) view).getBtnStart();
		btnBrowseOutputDirectory = ((SpeechBotUI) view).getBtnBrowseOutputDirectory();
		btnConfigureInputMode = ((SpeechBotUI) view).getBtnConfigureInputMode();
		textFieldOutputDirectory = ((SpeechBotUI) view).getTextFieldOutputDirectory();
		rdbtnConvertToMp3 = ((SpeechBotUI) view).getRdbtnConvertToMp3();
		rdbtnTranslateToMp3 = ((SpeechBotUI) view).getRdbtnConvertToMp3();
		rdbtnFromFileWith = ((SpeechBotUI) view).getRdbtnFromFileWith();
		rdbtnManuallyAddSentences = ((SpeechBotUI) view).getRdbtnManuallyAddSentences();
		rdbtnSingleFileWith = ((SpeechBotUI) view).getRdbtnSingleFileWith();
		rdbtnSeveralFiles = ((SpeechBotUI) view).getRdbtnSeveralFiles();
		configureInputModeDialog = ((SpeechBotUI) view).getConfigureInputModeDialog();
		
	}
	
	@Override
	public void registerUIComponentsToActionListener(){
		
		Enumeration<AbstractButton> it = buttonGroupInputMode.getElements();
		
		while(it.hasMoreElements()){
			addActionListenerComponent(it.nextElement());
		}

		Enumeration<AbstractButton> it2 = buttonGroupLanguajeMode.getElements();
		
		while(it2.hasMoreElements()){
			addActionListenerComponent(it2.nextElement());
		}
		
		Enumeration<AbstractButton> it3 = buttonGroupOutputMode.getElements();
		
		while(it3.hasMoreElements()){
			addActionListenerComponent(it3.nextElement());
		}
		
		addActionListenerComponent(btnConfigureInputMode);
		addActionListenerComponent(btnStart);
		addActionListenerComponent(btnBrowseOutputDirectory);
		addActionListenerComponent(textFieldOutputDirectory);
		
	}

	@Override
	public void setup(){
		initializeLanguajes();
	}

	@Override
	public void actionPerformed(ActionEvent e){
		
		if(e.getSource() == btnStart){
			
			start();
			
		}else if(e.getSource() == btnBrowseOutputDirectory){
			
			getOutputDirectoryPath();
			
		}else if(e.getSource() == btnConfigureInputMode){
			configureInputMode();
		}else if(e.getSource() == rdbtnConvertToMp3){
			
			if(((JRadioButton)e.getSource()).isSelected()){
				selectedConvertToMp3 = true;
			}else {
				selectedConvertToMp3 = false;
			}
			
		}else if(e.getSource() == rdbtnTranslateToMp3){
			
			if(((JRadioButton)e.getSource()).isSelected()){
				selectedTranslateToMp3 = true;
				selectedConvertToMp3 = false;
			}else {
				selectedTranslateToMp3 = false;
				selectedConvertToMp3 = true;
			}
		}else if(e.getSource() == rdbtnFromFileWith){

			if(((JRadioButton)e.getSource()).isSelected()){
				selectedFromFile = true;
				selectedManually = false;
			}else {
				selectedFromFile = false;
				selectedManually = true;
			}
		}else if(e.getSource() == rdbtnManuallyAddSentences){
			
			if(((JRadioButton)e.getSource()).isSelected()){
				selectedManually = true;
				selectedFromFile = false;
			}else {
				selectedManually = false;
				selectedFromFile = true;
			}
		}else if(e.getSource() == rdbtnSingleFileWith){
			
			if(((JRadioButton)e.getSource()).isSelected()){
				selectedSingleFile = true;
				selectedSeverealFiles = false;
			}else {
				selectedSingleFile = false;
				selectedSeverealFiles = true;
			}
		}else if(e.getSource() == rdbtnSeveralFiles){
			
			if(((JRadioButton)e.getSource()).isSelected()){
				selectedSeverealFiles = true;
				selectedSingleFile = false;
			}else {
				selectedSeverealFiles = false;
				selectedSingleFile = true;
			}
		}
		
	}
	
	public void configureInputMode() {

		if(selectedFromFile){
			
			if(selectedConvertToMp3){
				setVisiblePanelSecondLanguaje(false);
				configureInputModeDialog.setVisible(true);
				
			}else if(selectedTranslateToMp3){
				setVisiblePanelSecondLanguaje(true);
				configureInputModeDialog.setVisible(true);				
			}
			
		}else if(selectedManually){
			
			JOptionPane.showMessageDialog(null,"comming soon");
			
		}
		
	}
	
	public void start() {

		if(selectedFromFile){
			
			if(selectedConvertToMp3){

				if(selectedSingleFile){
					
					String pathOfFileSentences = configureInputModeDialog.getTextFieldFirstFileSentences().getText();
					String languaje = keyLanguajes.get(configureInputModeDialog.getComboBoxFirstLanguaje().getSelectedItem().toString());
					
					try{
						TTSUtil.convertFileOfSentencesToUniqueSpeechs(pathOfFileSentences,outputDirectoryPath,languaje);
						JOptionPane.showMessageDialog(null, "Success Convertion", "SpeechBot", JOptionPane.INFORMATION_MESSAGE);
					}
					catch(Exception e){
						ErrorEngine.traceErrorOnUI(e,false,true);
					}
					
				}else if(selectedSeverealFiles){
					
					String pathOfFileSentences = configureInputModeDialog.getTextFieldFirstFileSentences().getText();
					String languaje = keyLanguajes.get(configureInputModeDialog.getComboBoxFirstLanguaje().getSelectedItem().toString());					
					
					try{
						TTSUtil.convertFileOfSentencesToSeveralSpeechs(pathOfFileSentences,outputDirectoryPath,languaje);
					}
					catch(Exception e){
						ErrorEngine.traceErrorOnUI(e,false,true);
					}
					
				}
				
			}else if(selectedTranslateToMp3){
		
			}
			
		}else if(selectedManually){
			
			JOptionPane.showMessageDialog(null,"comming soon");
			
		}
		
	}
	
	public void setVisiblePanelSecondLanguaje(boolean visible){
		
		configureInputModeDialog.getPanelSecondLanguaje().setVisible(visible);
		
	}
	
	public void getOutputDirectoryPath() {
		try{
			outputDirectoryPath  = FileChooserUtil.getFolderPath("Enter path of folder to save converted files..");
			textFieldOutputDirectory.setText(outputDirectoryPath);
		}
		catch(Exception e){
			ErrorEngine.traceErrorOnUI(e,false,true);
		}
	}
	
	public String getSentencesFilePath() {
		
		String pathOfFileSentences = null;
		
		try{
			pathOfFileSentences  = FileChooserUtil.getFolderPath("Select file with sentences.");
		}
		catch(Exception e){
			ErrorEngine.traceErrorOnUI(e,false,true);
		}
		
		return pathOfFileSentences;
	}
	
	public void initializeLanguajes(){
		keyLanguajes = new HashMap<String,String>();
		keyLanguajes.put("Spanish","es");
		keyLanguajes.put("English","en");
	}
	
	
	private String outputDirectoryPath;
	private ButtonGroup buttonGroupLanguajeMode;
	private ButtonGroup buttonGroupInputMode;
	private ButtonGroup buttonGroupOutputMode;
	private JButton btnBrowseOutputDirectory;
	private JButton btnStart;
	private JTextField textFieldOutputDirectory;
	private JButton btnConfigureInputMode;
	private JRadioButton rdbtnConvertToMp3;
	private JRadioButton rdbtnTranslateToMp3;
	private JRadioButton rdbtnFromFileWith;
	private JRadioButton rdbtnManuallyAddSentences;
	private JRadioButton rdbtnSingleFileWith;
	private JRadioButton rdbtnSeveralFiles;	
	private ConfigureInputModeUI configureInputModeDialog;
	private boolean selectedConvertToMp3 = true;
	private boolean selectedTranslateToMp3 = false;
	private boolean selectedFromFile = true;
	private boolean selectedManually = false;
	private boolean selectedSingleFile = true;
	private boolean selectedSeverealFiles = false;
	private HashMap<String,String> keyLanguajes;
}
