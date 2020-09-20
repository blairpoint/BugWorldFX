package application;

import com.sun.prism.paint.Color;

public class Bug extends javafx.scene.shape.Circle{

	private String species;
	private String name;
	private char symbol;
	private int x;
	private int y;
	private int energy;
	private int id;

	// private static int BUG_COUNT = 0;

	public Bug() {
		super();
		species = "species";
		name = "name";
		symbol = '%';
		x = 5;
		y = 5;
		energy = 10;
		Constants.BUG_COUNT++;
		id = Constants.BUG_COUNT;

	}

	public Bug(String sp, String nm, char sym, int x, int y, int nrg) {
		super();
		this.species = sp;
		this.name = nm;
		this.symbol = sym;
		this.x = x;
		this.y = y;
		this.energy = nrg;
		Constants.BUG_COUNT++;
		id = Constants.BUG_COUNT;
		
		this.setTranslateX(x);
		this.setTranslateX(y);
		this.setFill(javafx.scene.paint.Color.BLACK);
		this.setRadius(7);
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getSymbol() {
		return symbol;
	}

	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}

	public int getThisId() {
		return id;
	}

	public String toString() {
		return "Bug = " + species + " name = " + name + " symbol = " + symbol + " x position = " + x + " y position = "
				+ y + " energy = " + energy + " ID = " + id;
	}

	public String toText() {
		return species + name + symbol + x + y + energy + id;

	}

	public void move(int direction) {
		// System.out.println("Moving the Bug, don't know how");
		if (direction == Constants.NORTH) {
			if (this.y > 1) {
				this.setY(this.getY() - 1);
			}

		} else if (direction == Constants.SOUTH) {
			if (this.y < Constants.WORLD_HEIGHT-2) {
				this.setY(this.getY() + 1);
			}

		} else if (direction == Constants.WEST) {
			if (this.x > 1) {
				this.setX(this.getX() - 1);
			}

		} else if (direction == Constants.EAST) {
			if (this.x < Constants.WORLD_WIDTH-2) {
				this.setX(this.getX() + 1);
			}

		} else {
			System.out.println("Direction is not recognised");
		}

	}

//	public void move(int direction, int position) {
//		if (direction == '1') {
//			this.y += position;
//		}else if (direction == '3') {
//			this.y += position;
//		}else if (direction == '5') {
//			this.x += position;
//		}else if (direction == '7' ) {
//			this.x += position;
//			
//		
//				
//			}
}
