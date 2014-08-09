package org.jrichardsz.app.speechbot.view;

import java.awt.*;

import javax.swing.*;

import org.jrichardsz.swingapp.view.core.*;

import com.linet.api.swing.jframe.*;

public class SpeechBotUI extends View{

	/**
	 * 
	 */
	private static final long serialVersionUID=1L;
	private ButtonGroup buttonGroupLanguajeMode;
	private ButtonGroup buttonGroupInputMode;
	private ButtonGroup buttonGroupOutputMode ;	
	private JButton btnBrowseOutputDirectory;
	private JButton btnStart;
	private JButton btnConfigureInputMode;
	private JTextField textFieldOutputDirectory;
	private JRadioButton rdbtnConvertToMp3;
	private JRadioButton rdbtnTranslateToMp3;
	private JRadioButton rdbtnFromFileWith;
	private JRadioButton rdbtnManuallyAddSentences;
	private JRadioButton rdbtnSingleFileWith;
	private JRadioButton rdbtnSeveralFiles;
	private ConfigureInputModeUI configureInputModeDialog;

	 
	public void setup() {
		configureInputModeDialog = new ConfigureInputModeUI(this);
		configureInputModeDialog.setModal(true);
		configureInputModeDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		textFieldOutputDirectory.setSize(textFieldOutputDirectory.getWidth(),textFieldOutputDirectory.getHeight()+5);
		textFieldOutputDirectory.setFont(new Font("Serif", Font.PLAIN, 12));
		
		setResizable(false);
		JFrameUtil.centerJFrame(this);
		
	}
	/**
	 * Create the application.
	 */
	public SpeechBotUI(){
		super();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@Override
	public void initComponents(){
		
		setTitle("SpeechBot");
		setBounds(100,100,450,346);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblSelectLanguajeMode = new JLabel("Select Convertion mode");
		lblSelectLanguajeMode.setBounds(10, 11, 120, 14);
		getContentPane().add(lblSelectLanguajeMode);
		
		JLabel lblSelectInputMode = new JLabel("Select Input Mode");
		lblSelectInputMode.setBounds(10, 73, 120, 14);
		getContentPane().add(lblSelectInputMode);
		
		btnConfigureInputMode = new JButton("Configure input mode");
		btnConfigureInputMode.setBounds(10, 136, 148, 23);
		getContentPane().add(btnConfigureInputMode);
		
		JLabel lblSelectPathFor = new JLabel("Select Output Directory");
		lblSelectPathFor.setBounds(10, 236, 300, 14);
		getContentPane().add(lblSelectPathFor);
		
		textFieldOutputDirectory = new JTextField();
		textFieldOutputDirectory.setBounds(10, 259, 333, 20);
		getContentPane().add(textFieldOutputDirectory);
		textFieldOutputDirectory.setColumns(10);
		
		btnBrowseOutputDirectory = new JButton("Browse");
		btnBrowseOutputDirectory.setBounds(353, 258, 79, 23);
		getContentPane().add(btnBrowseOutputDirectory);
		
		btnStart = new JButton("start");
		btnStart.setBounds(10, 289, 91, 23);
		getContentPane().add(btnStart);
		
		buttonGroupLanguajeMode = new ButtonGroup();
		rdbtnConvertToMp3 = new JRadioButton("Convert to mp3");
		rdbtnConvertToMp3.setSelected(true);
		buttonGroupLanguajeMode.add(rdbtnConvertToMp3);
		rdbtnConvertToMp3.setBounds(10, 32, 148, 23);
		getContentPane().add(rdbtnConvertToMp3);
		
		rdbtnTranslateToMp3 = new JRadioButton("Translate to mp3");
		buttonGroupLanguajeMode.add(rdbtnTranslateToMp3);
		rdbtnTranslateToMp3.setBounds(221, 32, 183, 23);
		getContentPane().add(rdbtnTranslateToMp3);
		
		buttonGroupInputMode = new ButtonGroup();
		rdbtnFromFileWith = new JRadioButton("From File with sentences");
		rdbtnFromFileWith.setSelected(true);
		buttonGroupInputMode.add(rdbtnFromFileWith);
		rdbtnFromFileWith.setBounds(10, 106, 209, 23);
		getContentPane().add(rdbtnFromFileWith);
		
		rdbtnManuallyAddSentences = new JRadioButton("Manually add sentences");
		buttonGroupInputMode.add(rdbtnManuallyAddSentences);
		rdbtnManuallyAddSentences.setBounds(221, 106, 211, 23);
		getContentPane().add(rdbtnManuallyAddSentences);
		
		JLabel lblSelectOutputMode = new JLabel("Select Output Mode");
		lblSelectOutputMode.setBounds(14, 177, 153, 14);
		getContentPane().add(lblSelectOutputMode);
		
		buttonGroupOutputMode = new ButtonGroup();
		
		rdbtnSingleFileWith = new JRadioButton("Single File with all sentences");
		rdbtnSingleFileWith.setSelected(true);
		buttonGroupOutputMode.add(rdbtnSingleFileWith);
		rdbtnSingleFileWith.setBounds(10, 198, 209, 23);
		getContentPane().add(rdbtnSingleFileWith);
		
		rdbtnSeveralFiles = new JRadioButton("Several files ( each sentence )");
		buttonGroupOutputMode.add(rdbtnSeveralFiles);
		rdbtnSeveralFiles.setBounds(221, 198, 211, 23);
		getContentPane().add(rdbtnSeveralFiles);
	}
	
	
	public JTextField getTextFieldOutputDirectory(){
		return textFieldOutputDirectory;
	}
	public void setTextFieldOutputDirectory(JTextField textFieldOutputDirectory){
		this.textFieldOutputDirectory=textFieldOutputDirectory;
	}
	public ButtonGroup getButtonGroupLanguajeMode(){
		return buttonGroupLanguajeMode;
	}
	public ButtonGroup getButtonGroupInputMode(){
		return buttonGroupInputMode;
	}
	public JButton getBtnBrowseOutputDirectory(){
		return btnBrowseOutputDirectory;
	}
	public void setBtnBrowseOutputDirectory(JButton btnBrowseOutputDirectory){
		this.btnBrowseOutputDirectory=btnBrowseOutputDirectory;
	}
	public JButton getBtnStart(){
		return btnStart;
	}
	public void setBtnStart(JButton btnStart){
		this.btnStart=btnStart;
	}
	public void setButtonGroupLanguajeMode(ButtonGroup buttonGroupLanguajeMode){
		this.buttonGroupLanguajeMode=buttonGroupLanguajeMode;
	}
	public void setButtonGroupInputMode(ButtonGroup buttonGroupInputMode){
		this.buttonGroupInputMode=buttonGroupInputMode;
	}
	public JButton getBtnConfigureInputMode(){
		return btnConfigureInputMode;
	}
	public void setBtnConfigureInputMode(JButton btnConfigureInputMode){
		this.btnConfigureInputMode=btnConfigureInputMode;
	}

	public JRadioButton getRdbtnConvertToMp3(){
		return rdbtnConvertToMp3;
	}
	public void setRdbtnConvertToMp3(JRadioButton rdbtnConvertToMp3){
		this.rdbtnConvertToMp3=rdbtnConvertToMp3;
	}
	public JRadioButton getRdbtnTranslateToMp3(){
		return rdbtnTranslateToMp3;
	}
	public void setRdbtnTranslateToMp3(JRadioButton rdbtnTranslateToMp3){
		this.rdbtnTranslateToMp3=rdbtnTranslateToMp3;
	}
	public JRadioButton getRdbtnFromFileWith(){
		return rdbtnFromFileWith;
	}
	public void setRdbtnFromFileWith(JRadioButton rdbtnFromFileWith){
		this.rdbtnFromFileWith=rdbtnFromFileWith;
	}
	public JRadioButton getRdbtnManuallyAddSentences(){
		return rdbtnManuallyAddSentences;
	}
	public void setRdbtnManuallyAddSentences(JRadioButton rdbtnManuallyAddSentences){
		this.rdbtnManuallyAddSentences=rdbtnManuallyAddSentences;
	}
	public JRadioButton getRdbtnSingleFileWith(){
		return rdbtnSingleFileWith;
	}
	public void setRdbtnSingleFileWith(JRadioButton rdbtnSingleFileWith){
		this.rdbtnSingleFileWith=rdbtnSingleFileWith;
	}
	public JRadioButton getRdbtnSeveralFiles(){
		return rdbtnSeveralFiles;
	}
	public void setRdbtnSeveralFiles(JRadioButton rdbtnSeveralFiles){
		this.rdbtnSeveralFiles=rdbtnSeveralFiles;
	}
	public ButtonGroup getButtonGroupOutputMode(){
		return buttonGroupOutputMode;
	}
	public void setButtonGroupOutputMode(ButtonGroup buttonGroupOutputMode){
		this.buttonGroupOutputMode=buttonGroupOutputMode;
	}
	public ConfigureInputModeUI getConfigureInputModeDialog(){
		return configureInputModeDialog;
	}
	public void setConfigureInputModeDialog(ConfigureInputModeUI configureInputModeDialog){
		this.configureInputModeDialog=configureInputModeDialog;
	}
}
