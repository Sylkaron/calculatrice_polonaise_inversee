

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Controleur implements PropertyChangeListener, EventHandler<ActionEvent> {
	
	private Accumulateur model;
	private InterfaceGraphique interfaceGraphique;

	public Controleur(Accumulateur accum) {
		model = accum;
		interfaceGraphique = null;
	}
	
	public void setInterfaceGraphique(InterfaceGraphique graphisme) {
		interfaceGraphique = graphisme;
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		String name = evt.getPropertyName();
		
		if(name.equals("res")) {
			Object val = evt.getNewValue();
			String res = val.toString();
			if(res.length()>0) {
				
				char caractere = res.charAt(res.length()-1);
				String h = Character.toString(caractere);
				
				if(h.equals("z")) {
					model.backspace();
					System.err.println("   ! Division by zero !");
				}
				else if(h.equals("l")) {
					model.backspace();
					System.err.println("  ! Too large number !");
				}
				else{
					interfaceGraphique.change(res);
				}
			}
		}
		else if(name.equals("Pile")){
			Object P = evt.getNewValue();
			String strP = P.toString();
			
			String o = "0123456789.-E";
			
			String[] liste = new String[4];
			
			int index = 0;
			
			int i = strP.length()-2;
			while(index<4&&i>0) {
				
				String s = "";
				
				int j = i;
				String change = Character.toString(strP.charAt(j));
				while(o.contains(change)&&j>0) {
					s = change+s;
					j--;
					change = Character.toString(strP.charAt(j));
				}
				
				liste[index] = s;
				
				index++;
				
				i = j-2;
				
			}
			
			interfaceGraphique.change(liste);
			
		}

	}

	@Override
	public void handle(ActionEvent evt) {		
		String nomEvt = evt.getSource().toString();
		
		char caractere = nomEvt.charAt(nomEvt.length()-2);
		String bouton = Character.toString(caractere);
		
		String o = "0123456789.";
		
		if(o.contains(bouton)) { //Chiffre ou point
			model.accumuler(caractere);
		}
		else if(bouton.equals("+/-")) {
			model.neg();
		}
		else if(bouton.equals("+")) {
			model.add();
		}
		else if(bouton.equals("-")) {
			model.sub();
		}
		else if(bouton.equals("*")) {
			model.mult();
		}
		else if(bouton.equals("/")) {
			model.div();
		}
		else if(bouton.equals("<>")) {
			model.push();
		}
		else if(bouton.equals("Reset")) {
			model.reset();
		}
		else if(bouton.equals("<->")) {
			model.swap();
		}
		else if(bouton.equals("<-")) {
			model.backspace();
		}
		else { //Clear
			model.clear();
			interfaceGraphique.change(" ");
		}
		
	}

}
