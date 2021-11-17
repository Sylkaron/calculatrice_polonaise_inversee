/**
 * Implementation de la classe Pile et de ses differentes méthodes depuis la superclasse Stack
 */


import java.util.Stack;

/**
 * @author pablo
 *
 */
public class Pile extends Stack<Double> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
