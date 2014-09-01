/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jrichardsz.swingapp.view.core;

import java.awt.*;
import java.util.*;

import javax.swing.*;

/**
 *
 * @author Richard Osmar Leon Ingaruca - RNASystems
 */
public abstract class View extends JFrame implements IView {

	/**
	 * 
	 */
	private static final long serialVersionUID=1L;
	protected HashMap<String,Component> contextComponents = new HashMap<String,Component>();
	
	public View(){
	}
	
	public void addComponents(){
		listAllComponentsIn(this);
	}
	
	
	public void listAllComponentsIn(Container parent)
	{
	    for (Component jComponent : parent.getComponents())
	    {
	    	
        	if(jComponent instanceof JButton){
        		if(jComponent.getName()!=null){
        			contextComponents.put(jComponent.getName(),jComponent);
        		}	        			        
        	}else if(jComponent instanceof JTextField){
        		if(jComponent.getName()!=null){
        			contextComponents.put(jComponent.getName(),jComponent);
        		}
        	}else if(jComponent instanceof JCheckBox){
        		if(jComponent.getName()!=null){
        			contextComponents.put(jComponent.getName(),jComponent);
        		}
        	}else if(jComponent instanceof JRadioButton){
        		if(jComponent.getName()!=null){
        			contextComponents.put(jComponent.getName(),jComponent);
        		}
        	}else  if (jComponent instanceof JComponent){
	        	listAllComponentsIn((Container)jComponent);
	        }
	            
	    }
	}

}
