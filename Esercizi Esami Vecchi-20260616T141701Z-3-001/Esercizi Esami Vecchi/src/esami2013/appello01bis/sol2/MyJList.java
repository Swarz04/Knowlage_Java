package esami2013.appello01bis.sol2;

import javax.swing.*;
import java.util.*;

/*
 * A Swing component: a list showing elements E, and a vertical scrollbar
 */

public class MyJList<E> extends JScrollPane{
	
	private static final long serialVersionUID = 7587653394587068943L;
	
	private DefaultListModel<E> model = new DefaultListModel<>();
	
	// Creates an empty list
	public MyJList(){
		super();
		this.setViewportView(new JList<E>(model));
		this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	}

	// Adds an element at the end of the list
	public void addElement(E elem){
		this.model.addElement(elem);
	}
	
	// Returns a java.util.List of all elements in the list
	public List<E> getAll(){
		List<E> al = new ArrayList<>();
		for (int index = 0; index<this.model.getSize();index++){
			al.add(this.model.getElementAt(index));
		}
		return al;
	}
	
}
