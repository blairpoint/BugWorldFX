package application;

import javafx.scene.paint.Color;

public class Spider extends Bug {
	
	public Spider (String nm, char sym, int x, int y, String imagePath) {
			super ("Spider",nm, sym, x, y, 1500, imagePath);
	}
	public Spider() {
		super();
		this.setSpecies("Spider");
		this.setEnergy(1500);
//		this.setRadius(12);
//		this.setFill(Color.GREEN);
		
	}
		
}
