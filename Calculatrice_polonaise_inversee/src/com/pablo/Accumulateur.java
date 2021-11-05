/**
 * 
 */
package com.pablo;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeSupport;

/**
 * @author pablo
 *
 */
public class Accumulateur implements IAccumulateur {
	
	//Attributes
	
	private Double res = null;
	private Pile P;
	private  private PropertyChangeSupport evt = new PropertyChangeSupport(this);

	/**
	 * 
	 */
	public Accumulateur() {
		this.P = new Pile();
	}

	@Override
	public void push() {
		P.push(res);
		evt.firePropertyChange("push",
				res, null);
	}
	
	public void push(Double a) {
		P.push(a);
		evt.firePropertyChange("push",a, res
				);
	}

	@Override
	public void drop() {
	

	}

	@Override
	public void swap() {
		Double a = P.pop();
		P.push(res);
		res = a;

	}

	@Override
	public void add() {
		if(res == null) {
			
			res = P.pop()+P.pop();
			evt.firePropertyChange("add",res,null);
		}
		else {
			Double save = res;
			res = res + P.pop();
			evt.firePropertyChange("add",save,res);
		}

	}

	@Override
	public void sub() {
		if(res == null) {
			res = P.pop()-P.pop();
			evt.firePropertyChange("sub",res,null);
		}
		else {
			Double save = res;
			res = res-P.pop();
			evt.firePropertyChange("sub",res,save);
		}

	}

	@Override
	public void mult() {
		if(res == null) {
			res = P.pop()*P.pop();
			evt.firePropertyChange("mult",res,null);
		}
		else {
			Double save = res;
			res = res*P.pop();
			evt.firePropertyChange("mult",res,save);
		}

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
				evt.firePropertyChange("div",res,null);
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
				evt.firePropertyChange("div",res,save);
			}
		}

	}

	@Override
	public void neg() {
		// TODO Auto-generated method stub
		res = -res;

	}

	@Override
	public void backspace() { //retour suupr un char
		// TODO Auto-generated method stub

	}

	@Override
	public void accumuler(char caractere) { // 1 - 5 - 0 → 150
		// TODO Auto-generated method stub

	}

	@Override
	public void reset() {
		res = 0.;

	}
	
	public void clear() {
		P.clear();;
	}

}
