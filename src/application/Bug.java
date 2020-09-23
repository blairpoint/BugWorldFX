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
	private float dx;
	private float dy;

	// private static int BUG_COUNT = 0;

	public Bug() {
		super();
		species = "species";
		name = "name";
		symbol = '%';
		x = 25;
		y = 25;
		energy = 1000;
		dx = -1.5f;
		dy = -1.5f;
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
		this.dx = -1.5f;
		this.dy = -1.5f;
		setImage(new Image(imagePath));
        setFitWidth(50);
        //setFitHeight(2000);
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

	public float getDx() {
		return dx;
	}

	public void setDx(float dx) {
		this.dx = dx;
	}

	public float getDy() {
		return dy;
	}

	public void setDy(float dy) {
		this.dy = dy;
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
//		return "Bug = " + species + " name = " + name + " symbol = " + symbol + " x position = " + x + " y position = "
//				+ y + " energy = " + energy + " ID = " + id;
		return name + " " + energy+"\n";

	}

	public String toText() {
		return name +  " "+energy+"\n";

	}

	public void setImage(String imagePath) {
		// TODO Auto-generated method stub
		setImage(new Image(imagePath));

		
	}

}
