package org.jrichardsz.app.speechbot.view;

import java.awt.*;

import javax.swing.*;

public class MainView{

	private JFrame frmSpeechbot;
	private final ButtonGroup buttonGroupLanguajeMode = new ButtonGroup();
	private final ButtonGroup buttonGroupInputMode = new ButtonGroup();
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				try{
					MainView window=new MainView();
					window.frmSpeechbot.setVisible(true);
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainView(){
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(){
		frmSpeechbot=new JFrame();
		frmSpeechbot.setTitle("SpeechBot");
		frmSpeechbot.setBounds(100,100,450,300);
		frmSpeechbot.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSpeechbot.getContentPane().setLayout(null);
		
		JLabel lblSelectLanguajeMode = new JLabel("Select languaje mode");
		lblSelectLanguajeMode.setBounds(10, 11, 120, 14);
		frmSpeechbot.getContentPane().add(lblSelectLanguajeMode);
		
		JCheckBox chckbxOneLanguaje = new JCheckBox("One Languaje");
		buttonGroupLanguajeMode.add(chckbxOneLanguaje);
		chckbxOneLanguaje.setBounds(10, 32, 97, 23);
		frmSpeechbot.getContentPane().add(chckbxOneLanguaje);
		
		JCheckBox chckbxBillingual = new JCheckBox("Billingual");
		buttonGroupLanguajeMode.add(chckbxBillingual);
		chckbxBillingual.setBounds(179, 32, 97, 23);
		frmSpeechbot.getContentPane().add(chckbxBillingual);
		
		JLabel lblSelectInputMode = new JLabel("Select Input Mode");
		lblSelectInputMode.setBounds(10, 73, 120, 14);
		frmSpeechbot.getContentPane().add(lblSelectInputMode);
		
		JCheckBox chckbxFromFile = new JCheckBox("From File with sentences");
		buttonGroupInputMode.add(chckbxFromFile);
		chckbxFromFile.setBounds(10, 106, 148, 23);
		frmSpeechbot.getContentPane().add(chckbxFromFile);
		
		JCheckBox chckbxAddManually = new JCheckBox("Manually add sentences");
		buttonGroupInputMode.add(chckbxAddManually);
		chckbxAddManually.setBounds(179, 106, 163, 23);
		frmSpeechbot.getContentPane().add(chckbxAddManually);
		
		JButton btnConfigureInputMode = new JButton("Configure input mode");
		btnConfigureInputMode.setBounds(10, 136, 148, 23);
		frmSpeechbot.getContentPane().add(btnConfigureInputMode);
		
		JLabel lblSelectPathFor = new JLabel("Output Directory");
		lblSelectPathFor.setBounds(10, 170, 300, 14);
		frmSpeechbot.getContentPane().add(lblSelectPathFor);
		
		textField = new JTextField();
		textField.setBounds(10, 193, 351, 20);
		frmSpeechbot.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnBrowse = new JButton("Browse");
		btnBrowse.setBounds(363, 192, 69, 23);
		frmSpeechbot.getContentPane().add(btnBrowse);
	}
}
