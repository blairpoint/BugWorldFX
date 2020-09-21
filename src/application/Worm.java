package application;

import javafx.scene.paint.Color;

public class Worm extends Bug {
	
	public Worm (String nm, char sym, int x, int y, String imagePath) {
			super ("Worm",nm, sym, x, y, 15, imagePath);
	}
	public Worm() {
		super();
		this.setSpecies("Worm");
		this.setEnergy(3);
//		this.setRadius(12);
//		this.setFill(Color.ORANGE);
	}
	public void move(int direction) {
		//System.out.println("Moving the Spider,"+getName());	
		if (direction==Constants.NORTH) {
			if (this.getY() > 1) {
			this.setY(this.getY() -1);
			}
		} else if (direction==Constants.SOUTH) {
			if (this.getY() < Constants.WORLD_HEIGHT-2) {
			this.setY(this.getY() +1);	
			}
		} else if (direction==Constants.WEST) {
			if (this.getX() > 1) {
			this.setX(this.getX() -1);	
			}	
		} else if (direction==Constants.EAST) {
			if (this.getX() < Constants.WORLD_WIDTH-2) {
			this.setX(this.getX() +1);
			}
		} else if (direction==Constants.RANDOM) {
			System.out.println("Randomising position");
			
			
		} else if (direction==Constants.quit){
			System.err.println("End Move");
			System.exit(1);
		}
//		System.out.println(getName() + " | " + getX() + " | " + getY());
		
	}		
}

