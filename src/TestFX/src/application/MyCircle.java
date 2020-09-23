package TestFX.src.application;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class MyCircle extends Circle {
	
	private float dx = -1.5f;
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

	private float dy =  -1.5f;

	public MyCircle() {
		// TODO Auto-generated constructor stub
	}

	public MyCircle(double radius) {
		super(radius);
		// TODO Auto-generated constructor stub
	}

	public MyCircle(double radius, Paint fill) {
		super(radius, fill);
		// TODO Auto-generated constructor stub
	}

	public MyCircle(double centerX, double centerY, double radius) {
		super(centerX, centerY, radius);
		// TODO Auto-generated constructor stub
	}

	public MyCircle(double centerX, double centerY, double radius, Paint fill) {
		super(centerX, centerY, radius, fill);
		// TODO Auto-generated constructor stub
	}

}
