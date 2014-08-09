
package org.jrichardsz.swingapp.controller.core;

import java.awt.event.*;
import java.util.*;

import javax.swing.*;

import org.jrichardsz.swingapp.view.core.*;

/**
 *
 * @author Richard Osmar Leon Ingaruca - RNASystems
 */
public abstract class Controler implements IControler,ActionListener{
	
    public Controler(View translatorUI) {
        this.view = translatorUI;
        assignInstancesOfView();
        initializeFunctionalityActionListener();
        setup();
    }

	public void addActionListenerComponent(JComponent actionListenerComponent) {      
		
		if(actionListenerComponentes==null){
			actionListenerComponentes = new ArrayList<JComponent>();
		}
		
		actionListenerComponentes.add(actionListenerComponent);
    }
    
    public void initializeFunctionalityActionListener() {
    	
    	registerUIComponentsToActionListener();
    	
        for(JComponent jComponent : actionListenerComponentes){
        	if(jComponent instanceof JButton){
        		 ((JButton)jComponent).addActionListener(this); 
        	}else if(jComponent instanceof JTextField){
        		((JTextField)jComponent).addActionListener(this);
        	}else if(jComponent instanceof JCheckBox){
        		((JCheckBox)jComponent).addActionListener(this);
        	}else if(jComponent instanceof JRadioButton){
        		((JRadioButton)jComponent).addActionListener(this);
        	}
        }
    }   
        
    public View view;
	private ArrayList<JComponent> actionListenerComponentes; 
    
}
