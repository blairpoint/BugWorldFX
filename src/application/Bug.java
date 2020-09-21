package application;

import com.sun.prism.paint.Color;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Bug extends ImageView{

	private String species;
	private String name;
	private char symbol;
	private int x;
	private int y;
	private int energy;
	private int radius;
	private int id;

	// private static int BUG_COUNT = 0;

	public Bug() {
		super();
		species = "species";
		name = "name";
		symbol = '%';
		x = 25;
		y = 25;
		energy = 10;
		Constants.BUG_COUNT++;
		id = Constants.BUG_COUNT;

	}

	public Bug(String sp, String nm, char sym, int x, int y, int nrg, String imagePath) {
		super();
		this.species = sp;
		this.name = nm;
		this.symbol = sym;
//		this.x = x;
//		this.y = y;
		this.energy = nrg;
		//this.radius = r;
		Constants.BUG_COUNT++;
		id = Constants.BUG_COUNT;
//		
//		this.setX(x);
//		this.setY(y);		
		setImage(new Image(imagePath));
        setFitWidth(50);
        setPreserveRatio(true);
        setSmooth(true);
        setCache(true);
        
        this.setTranslateX(x);
        this.setTranslateY(y);
		
		
		
//		this.setCenterX(x);
//		this.setCenterY(y);
//		this.setFill(javafx.scene.paint.Color.BLACK);
//		this.setRadius(17);
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
