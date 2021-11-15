/**
 * Implémentation de l'interface IView suivant le diagramme UML de l'énoncé
 */


import java.util.List;

/**
 * @author pablo
 *
 */
public interface IView {
	
	public void afficher();
	
	public void change(String[] data);
	
	public void change(String accu);
	
	}

