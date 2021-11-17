/**
 * 
 */


import java.beans.PropertyChangeSupport;

/**
 * @author pablo
 *
 */
public class Accumulateur implements IAccumulateur {
	
	//Attributes
	
	private String res;
	private Pile P;
	private final PropertyChangeSupport evt = new PropertyChangeSupport(this);

	/**
	 * 
	 */
	public Accumulateur() {
		this.P = new Pile();
		res = "";
	}

	@Override
	public void push() { //Ajouter l'entrée
		P.push(Double.parseDouble(res));
		String save = res;
		res = "";
		evt.firePropertyChange("res",save, res);
		evt.firePropertyChange("Pile", "", P);
	}

	@Override
	public void drop() { //Supprimer la dernière entrée
		if(P.size() != 0) {
			P.drop();
			evt.firePropertyChange("Pile", "", P);
		}
	}

	@Override
	public void swap() { //Changer l'entrée avec la dernière entrée
		if(P.size() < 1) {
			Double a = P.pop();
			P.push(Double.parseDouble(res));
			String save = res;
			res =  a.toString();
			evt.firePropertyChange("Pile", "", P);
			evt.firePropertyChange("res", save, res);
		}
		
	}

	@Override
	public void add() { //Somme
		if(res == "") {
			Double somme = P.pop()+P.pop();
			res = somme.toString();
			evt.firePropertyChange("res", "", res);
		}
		else {
			String save = res;
			Double somme = Double.parseDouble(res) + P.pop();
			res = somme.toString() ;
			evt.firePropertyChange("res", save, res);
		}
		evt.firePropertyChange("Pile", "", P);
	}

	@Override
	public void sub() { //Soustraction
		if(res == "") {
			Double diff = P.pop()-P.pop();
			res = diff.toString();
			evt.firePropertyChange("res", "", res);
		}
		else {
			String save = res;
			Double diff = Double.parseDouble(save)-P.pop();
			res = diff.toString();
			evt.firePropertyChange("res", save, res);
		}
		evt.firePropertyChange("Pile", "", P);
	}

	@Override
	public void mult() { //Multiplication
		if(res == "") {
			Double produit = P.pop()*P.pop();
			res = produit.toString();
			evt.firePropertyChange("res", "", res);
		}
		else {
			String save = res;
			Double produit = Double.parseDouble(res)*P.pop();
			res = produit.toString();
			evt.firePropertyChange("res", save, res);
		}
		evt.firePropertyChange("Pile", "", P);
	}

	@Override
	public void div() { //Division
		if(res == "") {
			Double a = P.pop();
			Double b = P.pop();
			if(b == 0) {
				System.err.println("Division par 0");
			}
			else {
				Double division = a/b;
				res = division.toString();
				evt.firePropertyChange("res", "", res);
			}
		}
		else {
			Double a = P.pop();
			if(a==0) {
				System.err.println("Division par 0");
			}
			else {
				String save = res;
				Double division = Double.parseDouble(res)/a;
				res = division.toString();
				evt.firePropertyChange("res", save, res);
			}
		}
		evt.firePropertyChange("Pile", "", P);
	}

	@Override
	public void neg() { //changer le signe de l'entrée
		String save = res;
		Double oppose = -1 * Double.parseDouble(res);
		res = oppose.toString();
		evt.firePropertyChange("res", save, res);
	}

	@Override
	public void backspace() { //retour supprimer un character
		if(res != "") {
			String save = res;
			res = res.substring(0, res.length() - 1);
			if(res == "-") res = "";
			evt.firePropertyChange("res", save, res);
		}

	}

	@Override
	public void accumuler(char caractere) { // 1 - 5 - 0 → 150
		String save = res;
		//On limite l'affichage a 10 chiffres, point  et - non inclus
		int limiteChar = 10;
		if(res.contains("-")) limiteChar+=1;
		if(res.contains(".")) limiteChar+=1;
		if(res.length() < limiteChar ) {
			if(!Character.toString(caractere).equals(".")) {
				res += Character.toString(caractere);
				evt.firePropertyChange("res", save, res);
			}
			else{
				if(!res.contains(".") ){
					res += ".";
					evt.firePropertyChange("res", save, res);
				}
			}
		}

	}

	@Override
	public void reset() {
		String save = res;
		res = "";
		evt.firePropertyChange("res", save, res);
	}
	
	public void clear() {
		P.clear();
		String save = res;
		res = "";
		evt.firePropertyChange("res", save, res);
		evt.firePropertyChange("Pile", "", P);
	}
	
	public void addPropertyChangeListener(String str, Controleur ctrl) {
		this.evt.addPropertyChangeListener(str, ctrl);
	}

}
