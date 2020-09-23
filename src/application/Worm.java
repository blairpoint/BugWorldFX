package application;

import javafx.scene.paint.Color;

public class Worm extends Bug {
	
	public Worm (String nm, char sym, int x, int y, String imagePath) {
			super ("Worm",nm, sym, x, y, 1000, imagePath);
	}
	public Worm() {
		super();
		this.setSpecies("Worm");
		this.setEnergy(1000);
//		this.setRadius(12);
//		this.setFill(Color.ORANGE);
	}

}

