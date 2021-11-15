/**
 * 
 */


import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeSupport;

/**
 * @author pablo
 *
 */
public class Accumulateur implements IAccumulateur {
	
	//Attributes
	
	private Double res;
	private Pile P;
	private final PropertyChangeSupport evt = new PropertyChangeSupport(this);

	/**
	 * 
	 */
	public Accumulateur() {
		this.P = new Pile();
		res = null;
	}

	@Override
	public void push() {
		P.push(res);
		Double save = res;
		res = null;
		evt.firePropertyChange("push",save, res);
		evt.firePropertyChange("Pile", "", P);
	}

	@Override
	public void drop() {
		if(P.size() != 0) {
			P.drop();
			evt.firePropertyChange("Pile", "", P);
		}
	}

	@Override
	public void swap() {
		if(P.size() < 1) {
			Double a = P.pop();
			P.push(res);
			res =  a;
			evt.firePropertyChange("Pile", "", P);
		}
		
	}

	@Override
	public void add() {
		if(res == null) {
			res = P.pop()+P.pop();
			evt.firePropertyChange("res", res, null);
		}
		else {
			Double save = res;
			res = res + P.pop();
			evt.firePropertyChange("res", save, res);
		}
		evt.firePropertyChange("Pile", "", P);
	}

	@Override
	public void sub() {
		if(res == null) {
			res = P.pop()-P.pop();
			evt.firePropertyChange("res", null, res);
		}
		else {
			Double save = res;
			res = res-P.pop();
			evt.firePropertyChange("res", save, res);
		}
		evt.firePropertyChange("Pile", "", P);
	}

	@Override
	public void mult() {
		if(res == null) {
			res = P.pop()*P.pop();
			evt.firePropertyChange("res", null, res);
		}
		else {
			Double save = res;
			res = res*P.pop();
			evt.firePropertyChange("res", save, res);
		}
		evt.firePropertyChange("Pile", "", P);
	}

	@Override
	public void div() {
		if(res == null) {
			Double a = P.pop();
			Double b = P.pop();
			if(b == 0) {
				System.err.println("Division par 0");
			}
			else {
				res = a/b;
				evt.firePropertyChange("res", null, res);
			}
		}
		else {
			Double a = P.pop();
			if(a==0) {
				System.err.println("Division par 0");
			}
			else {
				Double save = res;
				res = res/a;
				evt.firePropertyChange("res", save, res);
			}
		}
		evt.firePropertyChange("Pile", "", P);
	}

	@Override
	public void neg() {
		res = -res;
		evt.firePropertyChange("res", -res, res);
	}

	@Override
	public void backspace() { //retour suupr un char
		if(res <= 0 && res != null) {
			Double save = res;
			String resStr = res.toString();
			resStr = resStr.substring(0, resStr.length() - 1);
			if(resStr == "-" || resStr == "") res = 0.0;
			else res = Double.parseDouble(resStr);
			evt.firePropertyChange("res", save, res);
		}

	}

	@Override
	public void accumuler(char caractere) { // 1 - 5 - 0 → 150
		Double save = res;
		String resStr = res.toString();
		//On limite l'affichage a 10 chiffres, point  et - non inclus
		int limiteChar = 10;
		if(resStr.contains("-")) limiteChar+=1;
		if(resStr.contains(".")) limiteChar+=1;
		if(resStr.length() < limiteChar ) {
			if(!Character.toString(caractere).equals(".")) {
				resStr += Character.toString(caractere);
				res = Double.parseDouble(resStr);
				evt.firePropertyChange("res", save, res);
			}
			else{
				if(!resStr.contains(".") ){
					resStr += ".";
					res = Double.parseDouble(resStr);
					evt.firePropertyChange("res", save, res);
				}
			}
		}

	}

	@Override
	public void reset() {
		res = null;
		evt.firePropertyChange("res", "", res);
	}
	
	public void clear() {
		P.clear();
		res = null;
		evt.firePropertyChange("res", "", res);
		evt.firePropertyChange("Pile", "", P);
	}
	
	public void addPropertyChangeListener(String str, Controleur ctrl) {
		this.evt.addPropertyChangeListener(str, ctrl);
	}

}
