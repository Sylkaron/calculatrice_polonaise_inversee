import java.awt.Dimension;
import java.util.List;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class InterfaceGraphique implements IView {
	
	private Stage stage;
	public Label [] historique;
	public Label res;
	

	public InterfaceGraphique(Stage stage, Button b0, Button b1, Button b2, Button b3, Button b4, Button b5, Button b6, Button b7, 
			Button b8, Button b9, Button bVirgule, Button bSigne, Button bPlus, Button bMoins, Button bProduit, Button bDivise, 
			Button bPush, Button bClear, Button bReset, Button bSuppr) {
		
		//Taille fenetre
		Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int hauteur = (int)dimension.getHeight();
		int largeur  = (int)dimension.getWidth();
		
		//Fenetre
		
		VBox base = new VBox();
		
		//Zone affichage résultats
		VBox affichage = new VBox();
		
		historique = new Label[4];
		for(int i = 0; i < historique.length; i++) {
			historique[i] = new Label(" ");
			historique[i].setOpacity(0.5);
			affichage.getChildren().add(historique[i]);
		}
		
		res = new Label(" ");
		res.setOpacity(1);
		affichage.getChildren().add(res);
		
		//Zone bouton
		HBox calcul = new HBox();
		
			//Pavé numérique
		VBox paveNumerique = new VBox();
		
		HBox l1 = new HBox();
		l1.getChildren().addAll(b7, b8, b9);
		HBox l2 = new HBox();
		l2.getChildren().addAll(b4, b5, b6);
		HBox l3 = new HBox();
		l3.getChildren().addAll(b1, b2, b3);
		HBox l4 = new HBox();
		l4.getChildren().addAll(b0, bVirgule, bSigne);
		HBox l5 = new HBox();
		l5.getChildren().addAll(bClear, bReset, bSuppr);
		
		paveNumerique.getChildren().addAll(l1, l2, l3, l4, l5);
		
			//Pavé Opérations
		VBox paveOperation = new VBox();
		paveOperation.getChildren().addAll(bPlus, bMoins, bProduit, bDivise, bPush);
		
		calcul.getChildren().addAll(paveNumerique, paveOperation);
		
		base.getChildren().addAll(affichage, calcul);
		
		//Scene
		Scene sc = new Scene(base, largeur/4, hauteur/2);
		
		//Stage
		this.stage = stage;
		this.stage.setTitle("Calculatrice Polonaise Inversée");
		stage.setScene(sc);
		

	}

	@Override
	public void afficher() {
		this.stage.show();

	}

	@Override
	public void change( List<String> data) {
		for(int i = 0; i < historique.length; i++) {
			if(data.get(i) == null) historique[i].setText(" ");
			else historique[i].setText(data.get(i));
		};

	}

	@Override
	public void change(String accu) {
		res.setText(accu);

	}

}
