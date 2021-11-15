import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		launch(args);
		
	}


	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		
		//Accumulateur
		Accumulateur accumulateur = new Accumulateur();
		
		//Controleur
		Controleur controleur = new Controleur(accumulateur);
		
		//Initialisation des PropertyChangeListener
		accumulateur.addPropertyChangeListener("res", controleur);
		accumulateur.addPropertyChangeListener("Pile", controleur);
				
		//Boutons
		
			//Pave Numérique
		Button b0 = new Button("0");
		Button b1 = new Button("1");
		Button b2 = new Button("2");
		Button b3 = new Button("3");
		Button b4 = new Button("4");
		Button b5 = new Button("5");
		Button b6 = new Button("6");
		Button b7 = new Button("7");
		Button b8 = new Button("8");
		Button b9 = new Button("9");
		Button bVirgule = new Button(",");
		Button bSigne = new Button("+/-");
		
			//Opérations
		Button bPlus = new Button("+");
		Button bMoins = new Button("-");
		Button bProduit = new Button("x");
		Button bDivise = new Button("/");
		Button bPush = new Button("<>");
			
			//Autre
		Button bClear = new Button("AC");
		Button bReset = new Button("Drop");
		Button bSwap = new Button("<->");
		Button bSuppr = new Button("<-");
		
			//Action des boutons
		b0.setOnAction(controleur);
		b1.setOnAction(controleur);
		b2.setOnAction(controleur);
		b3.setOnAction(controleur);
		b4.setOnAction(controleur);
		b5.setOnAction(controleur);
		b6.setOnAction(controleur);
		b7.setOnAction(controleur);
		b8.setOnAction(controleur);
		b9.setOnAction(controleur);
		bVirgule.setOnAction(controleur);
		bSigne.setOnAction(controleur);
		
		bPlus.setOnAction(controleur);
		bMoins.setOnAction(controleur);
		bProduit.setOnAction(controleur);
		bDivise.setOnAction(controleur);
		bPush.setOnAction(controleur);
		
		bClear.setOnAction(controleur);
		bReset.setOnAction(controleur);
		bSwap.setOnAction(controleur);
		bSuppr.setOnAction(controleur);
		
		//Interface Graphique
		InterfaceGraphique interfaceGraphique = new InterfaceGraphique(stage, b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, bVirgule, bSigne,
																				bPlus, bMoins, bProduit, bDivise, bPush, bClear, bReset, bSwap, bSuppr);
		
		
		//Lien controleur/Interface
		controleur.setInterfaceGraphique(interfaceGraphique);
		
		//Ouverture de la fenetre
		interfaceGraphique.afficher();
		
		
	}

}
