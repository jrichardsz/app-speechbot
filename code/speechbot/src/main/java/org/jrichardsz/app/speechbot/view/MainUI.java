package org.jrichardsz.app.speechbot.view;

import java.awt.*;
import java.awt.event.*;
import java.util.Map.Entry;

import javax.swing.*;
import javax.swing.border.*;

import org.jrichardsz.swingapp.view.core.*;

public class MainUI extends View implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID=1L;
	private JPanel contentPane;

	private final ButtonGroup buttonGroupConvertInputMode = new ButtonGroup();
	private JTextField textFieldConvertOutputFolder;
	private JTextField textFieldTranslateOutputFolder;
	private JTextField textFieldTranslateFilePath;
	private JTextField textFieldTranslateWriteText;
	private JTextField textFieldJoinFirstFilePath;
	private JTextField textFieldJoinSecondFilePath;
	private JTextField textFieldJoinOutoutFolder;
	private final ButtonGroup buttonGroupConvertOutputMode = new ButtonGroup();
	private final ButtonGroup buttonGroupTranslateInputMode = new ButtonGroup();
	private final ButtonGroup buttonGroupTranslateOutputMode = new ButtonGroup();
	private final ButtonGroup buttonGroupJoinOutputMode = new ButtonGroup();
	
	//first tab
	private JRadioButton rdbtnConvertWrite;
	private JTextField textFieldConvertWriteText;
	private JRadioButton rdbtnConvertFromFile;
	private JButton buttonConvertBrowseFile;
	private JTextField textFieldConvertFilePath;

	@Override
	public void initComponents(){
	}

	@Override
	public void setup(){
	}
	
	/**
	 * Create the frame.
	 */
	public MainUI(){
		
		setResizable(false);
		setTitle("Speech Bot");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,451,438);
		contentPane=new JPanel();
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane);
		
		JPanel panelConvertToMp3 = new JPanel();
		tabbedPane.addTab("Convert to mp3", null, panelConvertToMp3, null);
		panelConvertToMp3.setLayout(null);
		
		rdbtnConvertFromFile = new JRadioButton("From File");
		rdbtnConvertFromFile.addActionListener(this);
		buttonGroupConvertInputMode.add(rdbtnConvertFromFile);
		rdbtnConvertFromFile.setBounds(6, 7, 415, 23);
		panelConvertToMp3.add(rdbtnConvertFromFile);
		
		JPanel panel = new JPanel();
		panel.setBounds(6, 37, 415, 43);
		panelConvertToMp3.add(panel);
		panel.setLayout(null);
		
		textFieldConvertFilePath = new JTextField();
		textFieldConvertFilePath.setName("textFieldConvertFilePath");
		textFieldConvertFilePath.setFont(new Font("Serif", Font.PLAIN, 12));
		textFieldConvertFilePath.setColumns(10);
		textFieldConvertFilePath.setBounds(10, 12, 329, 25);
		panel.add(textFieldConvertFilePath);
		
		buttonConvertBrowseFile = new JButton("...");
		buttonConvertBrowseFile.setBounds(350, 11, 62, 23);
		panel.add(buttonConvertBrowseFile);
		
		rdbtnConvertWrite = new JRadioButton("Write Words");
		rdbtnConvertWrite.addActionListener(this);
		buttonGroupConvertInputMode.add(rdbtnConvertWrite);
		rdbtnConvertWrite.setBounds(6, 94, 415, 23);
		panelConvertToMp3.add(rdbtnConvertWrite);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(6, 117, 415, 43);
		panelConvertToMp3.add(panel_1);
		
		textFieldConvertWriteText = new JTextField();
		textFieldConvertWriteText.setName("textFieldConvertWriteText");
		textFieldConvertWriteText.setFont(new Font("Serif", Font.PLAIN, 12));
		textFieldConvertWriteText.setColumns(10);
		textFieldConvertWriteText.setBounds(10, 12, 395, 25);
		panel_1.add(textFieldConvertWriteText);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(6, 171, 415, 2);
		panelConvertToMp3.add(separator);
		
		JRadioButton radioButtonConvertSingleFile = new JRadioButton("Single File with all sentences");
		buttonGroupConvertOutputMode.add(radioButtonConvertSingleFile);
		radioButtonConvertSingleFile.setSelected(true);
		radioButtonConvertSingleFile.setBounds(6, 180, 209, 23);
		panelConvertToMp3.add(radioButtonConvertSingleFile);
		
		JRadioButton radioButtonConvertSeveralFiles = new JRadioButton("Several files ( each sentence )");
		buttonGroupConvertOutputMode.add(radioButtonConvertSeveralFiles);
		radioButtonConvertSeveralFiles.setBounds(217, 180, 211, 23);
		panelConvertToMp3.add(radioButtonConvertSeveralFiles);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(6, 210, 415, 2);
		panelConvertToMp3.add(separator_1);
		
		JLabel lblNewLabel = new JLabel("Output Folder");
		lblNewLabel.setBounds(10, 223, 412, 14);
		panelConvertToMp3.add(lblNewLabel);
		
		textFieldConvertOutputFolder = new JTextField();
		textFieldConvertOutputFolder.setFont(new Font("Serif", Font.PLAIN, 12));
		textFieldConvertOutputFolder.setColumns(10);
		textFieldConvertOutputFolder.setBounds(19, 252, 329, 25);
		panelConvertToMp3.add(textFieldConvertOutputFolder);
		
		JButton buttonConvertBrowseOutputFolder = new JButton("...");
		buttonConvertBrowseOutputFolder.setBounds(359, 251, 62, 23);
		panelConvertToMp3.add(buttonConvertBrowseOutputFolder);
		
		JPanel panelTranslateToMp3 = new JPanel();
		tabbedPane.addTab("Translate to mp3", null, panelTranslateToMp3, null);
		panelTranslateToMp3.setLayout(null);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(6, 223, 412, 2);
		panelTranslateToMp3.add(separator_2);
		
		JRadioButton radioButtonTranslateSingleFile = new JRadioButton("Single File with all sentences");
		buttonGroupTranslateOutputMode.add(radioButtonTranslateSingleFile);
		radioButtonTranslateSingleFile.setSelected(true);
		radioButtonTranslateSingleFile.setBounds(6, 232, 171, 23);
		panelTranslateToMp3.add(radioButtonTranslateSingleFile);
		
		JRadioButton radioButtonTranslateSeveralFiles = new JRadioButton("Several files ( each sentence )");
		buttonGroupTranslateOutputMode.add(radioButtonTranslateSeveralFiles);
		radioButtonTranslateSeveralFiles.setBounds(198, 232, 201, 23);
		panelTranslateToMp3.add(radioButtonTranslateSeveralFiles);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(-4, 262, 415, 2);
		panelTranslateToMp3.add(separator_3);
		
		JLabel label = new JLabel("Output Folder");
		label.setBounds(10, 275, 412, 14);
		panelTranslateToMp3.add(label);
		
		textFieldTranslateOutputFolder = new JTextField();
		textFieldTranslateOutputFolder.setFont(new Font("Serif", Font.PLAIN, 12));
		textFieldTranslateOutputFolder.setColumns(10);
		textFieldTranslateOutputFolder.setBounds(19, 304, 330, 25);
		panelTranslateToMp3.add(textFieldTranslateOutputFolder);
		
		JButton buttonTranslateBrowseOutputFolder = new JButton("...");
		buttonTranslateBrowseOutputFolder.setBounds(359, 306, 59, 23);
		panelTranslateToMp3.add(buttonTranslateBrowseOutputFolder);
		
		JComboBox comboBoxTranslateToLanguaje = new JComboBox();
		comboBoxTranslateToLanguaje.setModel(new DefaultComboBoxModel(new String[] {"Spanish", "English"}));
		comboBoxTranslateToLanguaje.setBounds(202, 179, 216, 22);
		panelTranslateToMp3.add(comboBoxTranslateToLanguaje);
		
		JLabel lblLanguaje = new JLabel("To Languaje:");
		lblLanguaje.setBounds(10, 183, 182, 14);
		panelTranslateToMp3.add(lblLanguaje);
		
		JRadioButton radioButtonTranslateFromFile = new JRadioButton("From File");
		buttonGroupTranslateInputMode.add(radioButtonTranslateFromFile);
		radioButtonTranslateFromFile.setBounds(6, 7, 415, 23);
		panelTranslateToMp3.add(radioButtonTranslateFromFile);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(6, 37, 415, 43);
		panelTranslateToMp3.add(panel_2);
		
		textFieldTranslateFilePath = new JTextField();
		textFieldTranslateFilePath.setFont(new Font("Serif", Font.PLAIN, 12));
		textFieldTranslateFilePath.setColumns(10);
		textFieldTranslateFilePath.setBounds(10, 12, 329, 25);
		panel_2.add(textFieldTranslateFilePath);
		
		JButton buttonTranslateBrowseFile = new JButton("...");
		buttonTranslateBrowseFile.setBounds(350, 11, 62, 23);
		panel_2.add(buttonTranslateBrowseFile);
		
		JRadioButton radioButtonTranslateWrite = new JRadioButton("Write Words");
		buttonGroupTranslateInputMode.add(radioButtonTranslateWrite);
		radioButtonTranslateWrite.setBounds(6, 94, 415, 23);
		panelTranslateToMp3.add(radioButtonTranslateWrite);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBounds(6, 117, 415, 43);
		panelTranslateToMp3.add(panel_3);
		
		textFieldTranslateWriteText = new JTextField();
		textFieldTranslateWriteText.setFont(new Font("Serif", Font.PLAIN, 12));
		textFieldTranslateWriteText.setColumns(10);
		textFieldTranslateWriteText.setBounds(10, 12, 395, 25);
		panel_3.add(textFieldTranslateWriteText);
		
		JPanel panelJoinLanguajes = new JPanel();
		tabbedPane.addTab("Joing Languajes to mp3", null, panelJoinLanguajes, null);
		panelJoinLanguajes.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_4.setBounds(6, 11, 415, 101);
		panel_4.setLayout(null);
		panelJoinLanguajes.add(panel_4);
		
		textFieldJoinFirstFilePath = new JTextField();
		textFieldJoinFirstFilePath.setFont(new Font("Serif", Font.PLAIN, 12));
		textFieldJoinFirstFilePath.setColumns(10);
		textFieldJoinFirstFilePath.setBounds(10, 33, 329, 25);
		panel_4.add(textFieldJoinFirstFilePath);
		
		JButton buttonJoinBrowseButton = new JButton("...");
		buttonJoinBrowseButton.setBounds(350, 32, 62, 23);
		panel_4.add(buttonJoinBrowseButton);
		
		JLabel lblNewLabel_1 = new JLabel("First File");
		lblNewLabel_1.setBounds(10, 11, 402, 14);
		panel_4.add(lblNewLabel_1);
		
		JComboBox comboBoxFirstLanguaje = new JComboBox();
		comboBoxFirstLanguaje.setModel(new DefaultComboBoxModel(new String[] {"English", "Spanish"}));
		comboBoxFirstLanguaje.setBounds(196, 69, 216, 22);
		panel_4.add(comboBoxFirstLanguaje);
		
		JLabel lblLanguaje_1 = new JLabel("Languaje");
		lblLanguaje_1.setBounds(10, 73, 168, 14);
		panel_4.add(lblLanguaje_1);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_5.setLayout(null);
		panel_5.setBounds(6, 123, 415, 101);
		panelJoinLanguajes.add(panel_5);
		
		textFieldJoinSecondFilePath = new JTextField();
		textFieldJoinSecondFilePath.setFont(new Font("Serif", Font.PLAIN, 12));
		textFieldJoinSecondFilePath.setColumns(10);
		textFieldJoinSecondFilePath.setBounds(10, 33, 329, 25);
		panel_5.add(textFieldJoinSecondFilePath);
		
		JButton buttonJoinBrowseButton_1 = new JButton("...");
		buttonJoinBrowseButton_1.setBounds(350, 32, 62, 23);
		panel_5.add(buttonJoinBrowseButton_1);
		
		JLabel lblSecondFile = new JLabel("Second File");
		lblSecondFile.setBounds(10, 11, 402, 14);
		panel_5.add(lblSecondFile);
		
		JComboBox comboBoxSecondLanguaje = new JComboBox();
		comboBoxSecondLanguaje.setModel(new DefaultComboBoxModel(new String[] {"Spanish", "English"}));
		comboBoxSecondLanguaje.setBounds(196, 69, 216, 22);
		panel_5.add(comboBoxSecondLanguaje);
		
		JLabel label_2 = new JLabel("Languaje");
		label_2.setBounds(10, 73, 168, 14);
		panel_5.add(label_2);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(6, 235, 415, 2);
		panelJoinLanguajes.add(separator_4);
		
		JRadioButton radioButtonJoinSingleFile = new JRadioButton("Single File with all sentences");
		buttonGroupJoinOutputMode.add(radioButtonJoinSingleFile);
		radioButtonJoinSingleFile.setSelected(true);
		radioButtonJoinSingleFile.setBounds(-1, 244, 209, 23);
		panelJoinLanguajes.add(radioButtonJoinSingleFile);
		
		JRadioButton radioButtonJoinSeveralFiles = new JRadioButton("Several files ( each sentence )");
		buttonGroupJoinOutputMode.add(radioButtonJoinSeveralFiles);
		radioButtonJoinSeveralFiles.setBounds(210, 244, 211, 23);
		panelJoinLanguajes.add(radioButtonJoinSeveralFiles);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(6, 274, 415, 2);
		panelJoinLanguajes.add(separator_5);
		
		JLabel label_1 = new JLabel("Output Folder");
		label_1.setBounds(10, 287, 412, 14);
		panelJoinLanguajes.add(label_1);
		
		textFieldJoinOutoutFolder = new JTextField();
		textFieldJoinOutoutFolder.setFont(new Font("Serif", Font.PLAIN, 12));
		textFieldJoinOutoutFolder.setColumns(10);
		textFieldJoinOutoutFolder.setBounds(15, 316, 329, 25);
		panelJoinLanguajes.add(textFieldJoinOutoutFolder);
		
		JButton buttonJoinBrowseOutputFolder = new JButton("...");
		buttonJoinBrowseOutputFolder.setBounds(355, 315, 62, 23);
		panelJoinLanguajes.add(buttonJoinBrowseOutputFolder);
		
		this.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		        
		    	JPanel panel=new JPanel();
				JTextField jTextField = new JTextField("https://github.com/jrichardsz/app-speechbot");
				panel.add(jTextField);
		    	
				JOptionPane.showMessageDialog(null,panel,"By : JRichardsz",JOptionPane.INFORMATION_MESSAGE);
		    	System.exit(0);
		    }
		});
		
		addComponents();
		
		for(Entry<String,Component> entry : contextComponents.entrySet()){
			System.out.println(entry.getKey()+":"+entry.getValue().getClass());
		}
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == rdbtnConvertFromFile){
			if(rdbtnConvertFromFile.isSelected()){
				textFieldConvertWriteText.setEnabled(false);
				textFieldConvertFilePath.setEnabled(true);
				buttonConvertBrowseFile.setEnabled(true);
			}
		}else if(e.getSource() == rdbtnConvertWrite){
			if(rdbtnConvertWrite.isSelected()){
				textFieldConvertFilePath.setEnabled(false);
				buttonConvertBrowseFile.setEnabled(false);
				textFieldConvertWriteText.setEnabled(true);
			}
			
		}
		
	}
	
	
	
}
