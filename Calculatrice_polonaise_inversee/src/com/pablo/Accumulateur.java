/**
 * 
 */
package com.pablo;

/**
 * @author pablo
 *
 */
public class Accumulateur implements IAccumulateur {
	
	//Attributes
	
	Double res = null;
	Pile P;

	/**
	 * 
	 */
	public Accumulateur() {
		this.P = new Pile();
	}

	@Override
	public void push() {
		P.push(res);

	}

	@Override
	public void drop() {
	

	}

	@Override
	public void swap() {
		// TODO Auto-generated method stub

	}

	@Override
	public void add() {
		if(res == null) {
			res = P.pop()+P.pop();
		}
		else {
			res = res + P.pop()
		}

	}

	@Override
	public void sub() {
		if(res == null) {
			res = P.pop()-P.pop();
		}
		else {
			res = res-P.pop();
		}

	}

	@Override
	public void mult() {
		if(res == null) {
			res = P.pop()*P.pop();
		}
		else {
			res = res*P.pop();
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
			}
		}
		else {
			Double a = P.pop();
			if(a==0) {
				System.err.println("Division par 0");
			}
			else {
				res = res/a;
			}
		}

	}

	@Override
	public void neg() {
		// TODO Auto-generated method stub

	}

	@Override
	public void backspace() {
		// TODO Auto-generated method stub

	}

	@Override
	public void accumuler(char caractere) {
		// TODO Auto-generated method stub

	}

	@Override
	public void reset() {
		res = null;

	}
	
	public void clear() {
		res = 0.0;
	}

}
