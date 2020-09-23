package application;

import javafx.scene.paint.Color;

public class Ant extends Bug {
	
	public Ant (String nm, char sym, int x, int y, String imagePath) {
			super ("Ant",nm, sym, x, y, 2000, imagePath);
	}
	public Ant() {
		super();
		this.setSpecies("Ant");
		this.setEnergy(1000);
//		this.setRadius(15);
//		this.setFill(Color.BLUE);
	}

}
