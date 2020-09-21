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
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

public class Main extends Application {


	// Circle circle1 = new Circle(20,200,7, Color.BLACK);
	float x = 100, y = 100, dx = -1.5f, dy = -1.5f;
	float d1y = -1.5f, d1x = +1.5f;
	float d2y = +1.5f, d2x = +1.5f;
	float d3y = -1.5f, d3x = -1.5f;
	float d4y = +1.5f, d4x = +1.5f;

	ArrayList<Bug> bugs = new ArrayList<>();

	private void createSomeBugs() {
		// bugs.add(new Bug("NA", "General", 'B', 50, 50, 20));

		
		bugs.add(new Ant("Anty", 'A', 150, 250, "pacman3.gif"));
//		bugs.add(new Ant("Anty", '#', 80, 80, "pacman3.gif"));
//		bugs.add(new Worm("Wormy", 'W', 20, 210, "pacman3.gif"));
//		bugs.add(new Spider("Spidey", 'S', 50, 50, "pacman3.gif"));



	}

	@Override
	public void start(Stage primaryStage) {
		try {
			// BorderPane root = new BorderPane();

			createSomeBugs();

			HBox hBox = new HBox();
			VBox vBox = new VBox();
			hBox.setPrefSize(600, 600);
			vBox.setPrefWidth(100);
			Group root = new Group();
			root.prefHeight(600);
			root.prefWidth(500);
			
//			
//			Image ant = new Image("pacman1.gif");
//	        ImageView iv1 = new ImageView();
//	        iv1.setImage(ant);
//	        iv1.setFitWidth(50);
//	        iv1.setTranslateX(100);
//	        iv1.setTranslateY(150);
//	        iv1.setPreserveRatio(true);
//	        iv1.setSmooth(true);
//	        iv1.setCache(true);
//	        
//			Image spider = new Image("pacman2.gif");
//	        ImageView iv2 = new ImageView();
//	        iv2.setImage(spider);
//	        iv2.setFitWidth(50);
//	        iv2.setTranslateX(60);
//	        iv2.setTranslateY(222);
//	        iv2.setPreserveRatio(true);
//	        iv2.setSmooth(true);
//	        iv2.setCache(true);
//	        
//			Image worm = new Image("pacman4.gif");
//	        ImageView iv3 = new ImageView();
//	        iv3.setImage(worm);
//	        iv3.setFitWidth(50);
//	        iv3.setTranslateX(10);
//	        iv3.setTranslateY(44);
//	        iv3.setPreserveRatio(true);
//	        iv3.setSmooth(true);
//	        iv3.setCache(true);
//	        
//			Image bug = new Image("pacman3.gif");
//	        ImageView iv4 = new ImageView();
//	        iv4.setImage(bug);
//	        iv4.setFitWidth(50);
//	        iv4.setTranslateX(100);
//	        iv4.setTranslateY(95);
//	        iv4.setPreserveRatio(true);
//	        iv4.setSmooth(true);
//	        iv4.setCache(true);

			Button btn = new Button("Add ");
			Button btn2 = new Button("Remove");
			Text spacer = new Text(" ");
			vBox.getChildren().add(btn);
			vBox.getChildren().add(spacer);
			vBox.getChildren().add(btn2);

			root.getChildren().addAll(bugs);

			hBox.getChildren().add(vBox);
//			hBox.getChildren().add(iv1);
//			hBox.getChildren().add(iv2);
//			hBox.getChildren().add(iv3);
//			hBox.getChildren().add(iv4);


			hBox.getChildren().add(root);

			Scene scene = new Scene(hBox, 600, 600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			primaryStage.setScene(scene);
			
			

			btn.setOnAction(new EventHandler<ActionEvent>() {
				@Override // ADD BUG
				public void handle(ActionEvent arg0) {
				}

			});
			
			
			btn2.setOnAction(new EventHandler<ActionEvent>() {
				@Override //REMOVE BUG
				public void handle(ActionEvent arg0) {
					
				}

			});

			KeyFrame frame = new KeyFrame(Duration.millis(12), new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent t) {

					for (Bug circle : bugs) {
						
						
						//System.out.println(circle.getX()+", "+circle.getY()+", "+circle.getTranslateX()+", "+circle.getTranslateY()+", "+scene.getWidth()+", "+scene.getHeight());
						if (circle.getTranslateX() <=0  || circle.getTranslateX() + circle.getFitWidth() >= scene.getWidth()) {
							d1x = -d1x;
							// circle.setFill(Color.RED);
							System.out.println("In here");

						}
						if (circle.getTranslateY() <=0  || circle.getTranslateY() + circle.getFitHeight() >= scene.getHeight()) {
							d1y = -d1y;
							System.out.println("In there");
							// circle.setFill(Color.BLUE);
						}
//
//						circle.setX(circle.getX() + d1x);
//						circle.setY(circle.getY() + d1y);
						
						circle.setTranslateX(circle.getTranslateX() + d1x);
						circle.setTranslateY(circle.getTranslateY() + d1y);
						
//						
//						if (circle instanceof Ant) {
//							if (circle.getX() + circle.getTranslateX() < circle.getFitWidth() || circle.getX()
//									+ circle.getTranslateX() + circle.getFitWidth() > scene.getWidth()) {
//								d1x = -d1x;
//								// circle.setFill(Color.RED);
//
//							}
//							if (circle.getY() + circle.getTranslateY() < circle.getFitHeight() || circle.getY()
//									+ circle.getTranslateY() + circle.getFitHeight() > scene.getHeight()) {
//								d1y = -d1y;
//								// circle.setFill(Color.BLUE);
//							}
//
//							circle.setTranslateX(circle.getTranslateX() + d1x);
//							circle.setTranslateY(circle.getTranslateY() + d1y);
//
//						} else if (circle instanceof Spider) {
//							
//							if (circle.getCenterX() + circle.getTranslateX() < circle.getRadius() || circle.getCenterX()
//									+ circle.getTranslateX() + circle.getRadius() > scene.getWidth()) {
//								d2x = -d2x;
//							}
//							if (circle.getCenterY() + circle.getTranslateY() < circle.getRadius() || circle.getCenterY()
//									+ circle.getTranslateY() + circle.getRadius() > scene.getHeight()) {
//								d2y = -d2y;
//							}
//
//							circle.setTranslateX(circle.getTranslateX() + d2x);
//							circle.setTranslateY(circle.getTranslateY() + d2y);
//
//						} else if (circle instanceof Worm) {
//							circle.setFill(Color.BLUE);
//							if (circle.getCenterX() + circle.getTranslateX() < circle.getRadius() || circle.getCenterX()
//									+ circle.getTranslateX() + circle.getRadius() > scene.getWidth()) {
//								d3x = -d3x;
//							}
//							if (circle.getCenterY() + circle.getTranslateY() < circle.getRadius() || circle.getCenterY()
//									+ circle.getTranslateY() + circle.getRadius() > scene.getHeight()) {
//								d3y = -d3y;
//							}
//
//							circle.setTranslateX(circle.getTranslateX() + d3x);
//							circle.setTranslateY(circle.getTranslateY() + d3y);
//						}						
//						if(circle.getCenterX() + circle.getTranslateX() < circle.getRadius() || circle.getCenterX() + circle.getTranslateX() + circle.getRadius() > scene.getWidth()) {
//							d4x = -d4x;
//							}
//						if(circle.getCenterY() + circle.getTranslateY() < circle.getRadius()|| circle.getCenterY() + circle.getTranslateY() + circle.getRadius() > scene.getHeight()) {
//							d4y = -d4y;
//							}
//
//						circle.setTranslateX(circle.getTranslateX() + d4x );
//						circle.setTranslateY(circle.getTranslateY() + d4y );
					}

				}
			});

			Timeline t = new Timeline(frame);
			t.setCycleCount(javafx.animation.Animation.INDEFINITE);
			t.play();

			// Group root = new Group(circle);
//			VBox pane = new VBox();
//			pane.setAlignment(Pos.TOP_LEFT);
//			pane.setPadding(new Insets(25,25,25,25));
//			pane.getChildren().add(newgame);

//			primaryStage.setScene(new Scene(pane,350,400));
			vBox.setAlignment(Pos.CENTER);
			vBox.getStylesheets().add("controlStyle1.css");

			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
