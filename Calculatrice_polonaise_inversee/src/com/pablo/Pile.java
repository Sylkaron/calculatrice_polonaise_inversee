/**
 * 
 */
package com.pablo;

import java.util.Stack;

/**
 * @author pablo
 *
 */
public class Pile extends Stack<Object> {

	/**
	 * 
	 */
	public Pile() {
		super();
	}
	
	//Methods
	
	public void push(double nombre) {
		this.push(nombre);
	};
	
	public Double pop() {
		return this.pop();
	};

	public void drop( ) {
		this.pop();
	};
	
	public void clear() {
		this.clear();
	}
	
}
