package application;

import java.util.ArrayList;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

public class Main extends Application {


	// Circle circle1 = new Circle(20,200,7, Color.BLACK);
//	float x = 100, y = 100, dx = -1.5f, dy = -1.5f;
//	float d1y = -1.5f, d1x = +1.5f;
//	float d2y = +1.5f, d2x = +1.5f;
//	float d3y = -1.5f, d3x = -1.5f;
//	float d4y = +1.5f, d4x = +1.5f;

	ArrayList<Bug> bugs = new ArrayList<>(); //bugs arraylist
	ArrayList<Bug> deadbugs = new ArrayList<>(); //deadbugs arraylist if their energy goes below a certain value
	ArrayList<Plant> plants = new ArrayList<>(); //plants arraylist
	

	private void createSomeBugs() { //create bugs method
		// bugs.add(new Bug("NA", "General", 'B', 50, 50, 20));

		
		bugs.add(new Ant("Anty", 'A', 150, 250, "pacman1.gif"));
		bugs.add(new Ant("Anty", '#', 80, 80, "pacman5.gif"));
		bugs.add(new Worm("Wormy", 'W', 70, 310, "pacman2.gif"));
		bugs.add(new Spider("Spidey", 'S', 150, 50, "pacman4.gif")); 
		bugs.add(new Spider("Spida", 's', 60,15, "pacman3.gif")); //problematic bug effects the pane somehow
		bugs.add(new Worm("w0rm", 'w', 160,103, "pacman6.gif"));
		
		
		//bugs.add(new Plant("planty", 'o', 60,103, "plant1.gif"));

		plants.add(new Plant("planty", "plant",'p', 200,200,150,"plant1.gif"));
		plants.add(new Plant("MrPlant" , "plant", 'P' ,100,25,400,"plant2.gif"));
		plants.add(new Plant("Cactus", "plant", 'c', 350,50,250,"plant3.gif"));
	//	plants.add(new Plant("Cactus", "plant", 'C', 50,150,10,"plant4.gif"));
//		

	}


	@Override
	public void start(Stage primaryStage) {
		try {
			// BorderPane root = new BorderPane();

			createSomeBugs(); //calls method
			
//			Image plant1 = new Image("plant1.gif");
//	        ImageView iv1 = new ImageView();
//	        iv1.setImage(plant1);
//	        iv1.setFitWidth(70);
//	        iv1.setTranslateX(100);
//	        iv1.setTranslateY(200);
//	        iv1.setPreserveRatio(true);
//	        iv1.setSmooth(true);
//	        iv1.setCache(true);
//	        
//			Image plant2 = new Image("plant2.gif");
//	        ImageView iv2 = new ImageView();
//	        iv2.setImage(plant2);
//	        iv2.setFitWidth(70);
//	        iv2.setTranslateX(100);
//	        iv2.setTranslateY(-200);
//	        iv2.setPreserveRatio(true);
//	        iv2.setSmooth(true);
//	        iv2.setCache(true);
//	        
//			Image plant3 = new Image("plant3.gif");
//	        ImageView iv3 = new ImageView();
//	        iv3.setImage(plant3);
//	        iv3.setFitWidth(70);
//	        iv3.setTranslateX(300);
//	        iv3.setTranslateY(-300);
//	        iv3.setPreserveRatio(true);
//	        iv3.setSmooth(true);
//	        iv3.setCache(true);

			HBox hBox = new HBox(); //creates hbox object			
			VBox vBox = new VBox(); //creates vbox object
//			hBox.getChildren().add(iv1);
//			hBox.getChildren().add(iv2);
//			hBox.getChildren().add(iv3);
			
			

			
			
			hBox.setPrefSize(600, 600); //sets the size of the hbox
			vBox.setPrefWidth(100); //sets width of the vbox
			vBox.setPrefHeight(600);
			Group root = new Group(); //creates new group 'root'
			root.prefHeight(600); //sets height of root group
			root.prefWidth(500); //same for width
			
			


			Button btn = new Button("Add ");
			Button btn2 = new Button("Remove");
			Text spacer = new Text(" "); //blank text object to create space between buttons
			Text output = new Text(" "); //output 1
			Text output2 = new Text(" "); //output2 currently displaying only w0rm information
			Text output3 = new Text(" ");
			Text eat = new Text(" "); //output flag if plant eaten
			
			vBox.getChildren().add(btn); //adding UI controls to vbox
			vBox.getChildren().add(spacer);
			vBox.getChildren().add(btn2);
			vBox.getChildren().add(output);
			vBox.getChildren().add(output3);
			vBox.getChildren().add(output2);
			vBox.getChildren().add(eat);
			
			//vBox.getChildren().add(iv1);
//			vBox.getChildren().add(iv2);
//			vBox.getChildren().add(iv3);



			root.getChildren().addAll(bugs); //adding bugs araylist to root
			root.getChildren().addAll(plants); //adding plants arraylist to root


			hBox.getChildren().add(vBox); //adds the vbox to the hbox


			hBox.getChildren().add(root); //adds root to the hbox

			Scene scene = new Scene(hBox, 600, 600); //adds the hbox (with root and vobx inside to main scene 
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	

			primaryStage.setScene(scene); //sets up the scene

			
			

			btn.setOnAction(new EventHandler<ActionEvent>() {
				@Override // ADD BUG
				public void handle(ActionEvent arg0) {
				}

			});
			
			
			btn2.setOnAction(new EventHandler<ActionEvent>() {
				@Override //REMOVE BUG
				public void handle(ActionEvent arg0) {
					
					for(Plant p : plants)
					{
						System.out.println(p);
					}
					
				}

			});

			KeyFrame frame = new KeyFrame(Duration.millis(9), new EventHandler<ActionEvent>() { 

				@Override
				public void handle(ActionEvent t) { //main method for moving bugs to run at runtime

//					for (Bug out : bugs) {
//						output2.setText(out.toString()+" "); 
//					}
					
					for (Bug circle : bugs) { //main for loop for moving
						//System.out.println(circle);
						output3.setText("test");
						
						//System.out.println(circle.getX()+", "+circle.getY()+", "+circle.getTranslateX()+", "+circle.getTranslateY()+", "+scene.getWidth()+", "+scene.getHeight());
						if (circle.getTranslateX() + circle.getFitWidth() <=0  || circle.getTranslateX() + circle.getFitWidth() >= scene.getWidth()) { //if statement to keep the  bugs within the borders
//							d1x = -d1x;
							circle.setDx(circle.getDx()*-1);
							// circle.setFill(Color.RED);
							if (circle.getEnergy() < 1) {
								output3.setText("BUG DIED");
								circle.setImage("pacmanDEAD.gif");
								deadbugs.add(circle);
								//bugs.remove(circle);

							}

						}
						if (circle.getTranslateY() <=0  || circle.getTranslateY() + circle.getFitHeight() >= scene.getHeight()) {
							circle.setDy(circle.getDy()*-1);

							// circle.setFill(Color.BLUE);
						}
////
						circle.setX(circle.getX() + circle.getDx());
						circle.setY(circle.getY() + circle.getDy());
						

						//for (Bug b : bugs) {

						
//						
//						circle.setTranslateX(circle.getTranslateX() + d2x);
//						circle.setTranslateY(circle.getTranslateY() + d2y);
//						
////						
						if (circle instanceof Ant) { //setting up the loop to respond to specific behaviour for an ant
							if (circle.getEnergy() < 1) {
								output3.setText("BUG DIED");
								deadbugs.add(circle);
								//bugs.remove(circle);


							}
							if (circle.getX() + circle.getTranslateX() < circle.getFitWidth() || circle.getX()
									+ circle.getTranslateX() + circle.getFitWidth() > scene.getWidth()) {
//								d2x = -d2x;
								circle.setDx(-circle.getDx());

								// circle.setFill(Color.RED);

							}
							if (circle.getY() + circle.getTranslateY() < circle.getFitHeight() || circle.getY()
									+ circle.getTranslateY() + circle.getFitHeight() > scene.getHeight()) {
//								d2y = -d2y;
								circle.setDy(-circle.getDy());

								// circle.setFill(Color.BLUE);

							}

//							circle.setTranslateX(circle.getTranslateX() + d2x);
//							circle.setTranslateY(circle.getTranslateY() + d2y);
							circle.setTranslateX(circle.getTranslateX() + circle.getDx());
							circle.setTranslateY(circle.getTranslateY() + circle.getDy());
							circle.setEnergy(circle.getEnergy()-1);
						



						} 
						else if (circle instanceof Spider) {//setting up the loop to respond to specific behaviour for an spider
							if (circle.getEnergy() < 1) {
								output3.setText("BUG DIED");
								deadbugs.add(circle);
								//bugs.remove(circle);


							}
							if (circle.getX() + circle.getTranslateX() < circle.getFitWidth() || circle.getX()
									+ circle.getTranslateX() + circle.getFitWidth() > scene.getWidth()) {
//								d3x = -d3x;
								circle.setDx(-circle.getDx());

								// circle.setFill(Color.RED);

							}
							if (circle.getY() + circle.getTranslateY() < circle.getFitHeight() || circle.getY()
									+ circle.getTranslateY() + circle.getFitHeight() > scene.getHeight()) {
//								d3y = -d3y;
								circle.setDy(-circle.getDy());

								// circle.setFill(Color.BLUE);

							}

//							circle.setTranslateX(circle.getTranslateX() + d3x);
//							circle.setTranslateY(circle.getTranslateY() + d3y);
							circle.setTranslateX(circle.getTranslateX() + circle.getDx());
							circle.setTranslateY(circle.getTranslateY() + circle.getDy());
							circle.setEnergy(circle.getEnergy()-1);
						


						} 
						else if (circle instanceof Worm) { //setting up the loop to respond to specific behaviour for an worm
							if (circle.getEnergy() < 1) {
								output3.setText("BUG DIED");
								deadbugs.add(circle);
								//bugs.remove(circle);

							}
							if (circle.getX() + circle.getTranslateX() < circle.getFitWidth() || circle.getX()
									+ circle.getTranslateX() + circle.getFitWidth() > scene.getWidth()) {
//								d4x = -d4x;
								circle.setDx(-circle.getDx());

								// circle.setFill(Color.RED);

							}
							if (circle.getY() + circle.getTranslateY() < circle.getFitHeight() || circle.getY()
									+ circle.getTranslateY() + circle.getFitHeight() > scene.getHeight()) {
//								d4y = -d4y;
								circle.setDy(-circle.getDy());

								// circle.setFill(Color.BLUE);
							}

//							circle.setTranslateX(circle.getTranslateX() + d4x);
//							circle.setTranslateY(circle.getTranslateY() + d4y);
							circle.setTranslateX(circle.getTranslateX() + circle.getDx());
							circle.setTranslateY(circle.getTranslateY() + circle.getDy());
							circle.setEnergy(circle.getEnergy()-1);


						}			


								// circle.setFill(Color.BLUE);
							

//							circle.setTranslateX(circle.getTranslateX() + d4x);
//							circle.setTranslateY(circle.getTranslateY() + d4y);

							

						
//						if (circle.getX() + circle.getTranslateX() < circle.getFitWidth() || circle.getX()
//								+ circle.getTranslateX() + circle.getFitWidth() > scene.getWidth()) {
//							d1x = -d1x;
//							// circle.setFill(Color.RED);
//
//						}
//						if (circle.getY() + circle.getTranslateY() < circle.getFitHeight() || circle.getY()
//								+ circle.getTranslateY() + circle.getFitHeight() > scene.getHeight()) {
//							d1y = -d1y;
//							// circle.setFill(Color.BLUE);
//						}
//
//						circle.setTranslateX(circle.getTranslateX() + d4x );
//						circle.setTranslateY(circle.getTranslateY() + d4y );
						output.setText("Bugs :" + (bugs.size())); //text output on left side
						int deadcount = 0;
						if (circle.getEnergy() < 1) {
							output3.setText("BUG DIED");
							circle.setImage("pacmanDEAD.gif");
							bugs.remove(circle);
							//hBox.getChildren().clear();
							deadbugs.add(circle);
							deadcount=deadcount+1;
								}
						for (Plant p : plants ) {
							int eatcount = 0;

							if ((circle.getX() > p.getX()-1 && circle.getX() < p.getX()+1) && (circle.getY() > p.getY()-1 && circle.getY() < p.getY()+1)) {
								System.out.println("EAT "+circle.getName()+" x "+circle.getX()+" y "+circle.getY());
								circle.setEnergy(circle.getEnergy()+1000);
								eatcount = eatcount+1;
								
							}
							eat.setText(String.valueOf(deadcount));

						}
						//System.out.println(iv1.getTranslateX()+" "+iv1.getX());
					}
				
				}
			});

			Timeline t = new Timeline(frame); //create timeline object t to correspond with KeyFrame
			t.setCycleCount(javafx.animation.Animation.INDEFINITE); //sets cycles as indefinate
			t.play();

			// Group root = new Group(circle);
//			VBox pane = new VBox();
//			pane.setAlignment(Pos.TOP_LEFT);
//			pane.setPadding(new Insets(25,25,25,25));
//			pane.getChildren().add(newgame);

//			primaryStage.setScene(new Scene(pane,350,400));
			vBox.setAlignment(Pos.CENTER); //sets alignment for the vbox
			vBox.getStylesheets().add("controlStyle1.css"); //sets the css schema to use in the vbox

			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
