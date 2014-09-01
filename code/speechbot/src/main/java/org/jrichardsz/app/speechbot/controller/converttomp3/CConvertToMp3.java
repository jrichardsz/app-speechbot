package org.jrichardsz.app.speechbot.controller.converttomp3;

import java.awt.event.*;

import javax.swing.*;

import org.jrichardsz.swingapp.controller.core.*;
import org.jrichardsz.swingapp.view.core.*;

public class CConvertToMp3 extends Controler {

	public CConvertToMp3(View view){
		super(view);
	}

	@Override
	public void registerUIComponentsToActionListener(){
		addActionListenerComponent(rdbtnConvertWrite);
		addActionListenerComponent(textFieldConvertWriteText);
		addActionListenerComponent(rdbtnConvertFromFile);
		addActionListenerComponent(buttonConvertBrowseFile);
		addActionListenerComponent(textFieldConvertFilePath);
		
	}

	@Override
	public void assignInstancesOfView(){


	}

	@Override
	public void setup(){
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e){
		// TODO Auto-generated method stub
		
	}
	
	
	private JRadioButton rdbtnConvertWrite;
	private JTextField textFieldConvertWriteText;
	private JRadioButton rdbtnConvertFromFile;
	private JButton buttonConvertBrowseFile;
	private JTextField textFieldConvertFilePath;
}
