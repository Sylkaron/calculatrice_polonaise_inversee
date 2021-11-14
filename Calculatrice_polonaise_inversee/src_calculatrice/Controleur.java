

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Controleur implements PropertyChangeListener, EventHandler<ActionEvent> {
	
	private Accumulateur model;

	public Controleur(Accumulateur accum) {
		// TODO Auto-generated constructor stub
		model = accum;
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub
		String name = evt.getPropertyName();
		

	}

	@Override
	public void handle(ActionEvent evt) {
		// TODO Auto-generated method stub
		
		evt.getSource().toString()
	}

}
