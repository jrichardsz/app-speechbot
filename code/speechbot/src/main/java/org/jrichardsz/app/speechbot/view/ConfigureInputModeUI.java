package org.jrichardsz.app.speechbot.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import org.jrichardsz.app.speechbot.common.*;
import com.linet.api.swing.filechooser.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConfigureInputModeUI extends JDialog implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID=1L;
	private final JPanel contentPanel=new JPanel();
	private JTextField textFieldFirstFileSentences;
	private JTextField textFieldSecondFileSentences;
	private JPanel panelFirstLanguaje ;
	private JPanel panelSecondLanguaje ;
	private JComboBox comboBoxFirstLanguaje ;
	private JComboBox comboBoxSecondLanguaje ;
	private JButton btnBrowseFirstFile;
	private JButton btnBrowseSecondFile;
	private JButton btnAccept;
	private JLabel labelSelectSecondLanguaje;
	private JLabel labelSelectSecondFile;
	
	public ConfigureInputModeUI(JFrame frame){
		super(frame);
		initComponents();
		
		textFieldFirstFileSentences.setSize(textFieldFirstFileSentences.getWidth(),textFieldFirstFileSentences.getHeight()+5);
		textFieldFirstFileSentences.setFont(new Font("Serif", Font.PLAIN, 12));
		textFieldSecondFileSentences.setSize(textFieldSecondFileSentences.getWidth(),textFieldSecondFileSentences.getHeight()+5);
		textFieldSecondFileSentences.setFont(new Font("Serif", Font.PLAIN, 12));
		
	}

	/**
	 * Create the dialog.
	 */
	public void initComponents(){
		setBounds(100,100,450,397);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5,5,5,5));
		getContentPane().add(contentPanel,BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		panelFirstLanguaje = new JPanel();
		panelFirstLanguaje.setBorder(new TitledBorder(null, "Configure First Languaje", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelFirstLanguaje.setBounds(10, 11, 422, 145);
		contentPanel.add(panelFirstLanguaje);
		panelFirstLanguaje.setLayout(null);
		{
			JLabel lblConfigureLanguaje = new JLabel("Select file with sentences...");
			lblConfigureLanguaje.setBounds(10, 29, 402, 14);
			panelFirstLanguaje.add(lblConfigureLanguaje);
		}
		
		textFieldFirstFileSentences = new JTextField();
		textFieldFirstFileSentences.setBounds(10, 54, 329, 20);
		panelFirstLanguaje.add(textFieldFirstFileSentences);
		textFieldFirstFileSentences.setColumns(10);
		
		btnBrowseFirstFile = new JButton("...");
		btnBrowseFirstFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String pathOfFileSentences  = FileChooserUtil.getFilePathToOpen("Select file with sentences.","txt");
					textFieldFirstFileSentences.setText(pathOfFileSentences);
				}
				catch(Exception e1){
					ErrorEngine.traceErrorOnUI(e1,false,true);
				}
			}
		});
		btnBrowseFirstFile.setBounds(350, 53, 62, 23);
		panelFirstLanguaje.add(btnBrowseFirstFile);
		
		comboBoxFirstLanguaje = new JComboBox();
		comboBoxFirstLanguaje.setModel(new DefaultComboBoxModel(new String[] {"Spanish", "English"}));
		comboBoxFirstLanguaje.setBounds(10, 112, 110, 22);
		panelFirstLanguaje.add(comboBoxFirstLanguaje);
		
		JLabel lblSelectLanguaje = new JLabel("Select Languaje");
		lblSelectLanguaje.setBounds(10, 85, 402, 14);
		panelFirstLanguaje.add(lblSelectLanguaje);
		
		panelSecondLanguaje = new JPanel();
		panelSecondLanguaje.setLayout(null);
		panelSecondLanguaje.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Configure Second Languaje", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelSecondLanguaje.setBounds(10, 167, 422, 145);
		contentPanel.add(panelSecondLanguaje);
		
		labelSelectSecondFile = new JLabel("Select file with sentences...");
		labelSelectSecondFile.setBounds(10, 29, 402, 14);
		panelSecondLanguaje.add(labelSelectSecondFile);
		
		textFieldSecondFileSentences = new JTextField();
		textFieldSecondFileSentences.setColumns(10);
		textFieldSecondFileSentences.setBounds(10, 54, 329, 20);
		panelSecondLanguaje.add(textFieldSecondFileSentences);
		
		btnBrowseSecondFile = new JButton("...");
		btnBrowseSecondFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String pathOfFileSentences  = FileChooserUtil.getFilePathToOpen("Select file with sentences.","txt");
					textFieldSecondFileSentences.setText(pathOfFileSentences);
				}
				catch(Exception e1){
					ErrorEngine.traceErrorOnUI(e1,false,true);
				}
			}
		});
		btnBrowseSecondFile.setBounds(350, 53, 62, 23);
		panelSecondLanguaje.add(btnBrowseSecondFile);
		
		comboBoxSecondLanguaje = new JComboBox();
		comboBoxSecondLanguaje.setModel(new DefaultComboBoxModel(new String[] {"English", "Spanish"}));
		comboBoxSecondLanguaje.setBounds(10, 112, 110, 22);
		panelSecondLanguaje.add(comboBoxSecondLanguaje);
		
		labelSelectSecondLanguaje = new JLabel("Select Languaje");
		labelSelectSecondLanguaje.setBounds(10, 85, 402, 14);
		panelSecondLanguaje.add(labelSelectSecondLanguaje);
		{
			JPanel buttonPane=new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane,BorderLayout.SOUTH);
			
			btnAccept = new JButton("Ok");
			btnAccept.addActionListener(this);
			buttonPane.add(btnAccept);
		}
	}
	

	@Override
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == btnAccept){
			this.setVisible(false);
		}
	}

	public JTextField getTextFieldFirstFileSentences(){
		return textFieldFirstFileSentences;
	}

	public void setTextFieldFirstFileSentences(JTextField textFieldFirstFileSentences){
		this.textFieldFirstFileSentences=textFieldFirstFileSentences;
	}

	public JTextField getTextFieldSecondFileSentences(){
		return textFieldSecondFileSentences;
	}

	public void setTextFieldSecondFileSentences(JTextField textFieldSecondFileSentences){
		this.textFieldSecondFileSentences=textFieldSecondFileSentences;
	}

	public JPanel getPanelFirstLanguaje(){
		return panelFirstLanguaje;
	}

	public void setPanelFirstLanguaje(JPanel panelFirstLanguaje){
		this.panelFirstLanguaje=panelFirstLanguaje;
	}

	public JPanel getPanelSecondLanguaje(){
		return panelSecondLanguaje;
	}

	public void setPanelSecondLanguaje(JPanel panelSecondLanguaje){
		this.panelSecondLanguaje=panelSecondLanguaje;
	}

	public JComboBox getComboBoxFirstLanguaje(){
		return comboBoxFirstLanguaje;
	}

	public void setComboBoxFirstLanguaje(JComboBox comboBoxFirstLanguaje){
		this.comboBoxFirstLanguaje=comboBoxFirstLanguaje;
	}

	public JComboBox getComboBoxSecondLanguaje(){
		return comboBoxSecondLanguaje;
	}

	public void setComboBoxSecondLanguaje(JComboBox comboBoxSecondLanguaje){
		this.comboBoxSecondLanguaje=comboBoxSecondLanguaje;
	}

	public JButton getBtnBrowseFirstFile(){
		return btnBrowseFirstFile;
	}

	public void setBtnBrowseFirstFile(JButton btnBrowseFirstFile){
		this.btnBrowseFirstFile=btnBrowseFirstFile;
	}

	public JButton getBtnBrowseSecondFile(){
		return btnBrowseSecondFile;
	}

	public void setBtnBrowseSecondFile(JButton btnBrowseSecondFile){
		this.btnBrowseSecondFile=btnBrowseSecondFile;
	}

	public JLabel getLabelSelectSecondLanguaje(){
		return labelSelectSecondLanguaje;
	}

	public void setLabelSelectSecondLanguaje(JLabel labelSelectSecondLanguaje){
		this.labelSelectSecondLanguaje=labelSelectSecondLanguaje;
	}

	public JLabel getLabelSelectSecondFile(){
		return labelSelectSecondFile;
	}

	public void setLabelSelectSecondFile(JLabel labelSelectSecondFile){
		this.labelSelectSecondFile=labelSelectSecondFile;
	}



}
