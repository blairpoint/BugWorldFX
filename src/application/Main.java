package application;
	
import java.util.ArrayList;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public class Main extends Application {
	
	
	
	
	//Circle circle1 = new Circle(20,200,7, Color.BLACK);
	float x = 100, y = 100, dx = -1.5f, dy = -1.5f;
	
	ArrayList<Bug> bugs = new ArrayList<>();
	
	
	
	private void createSomeBugs() {
		bugs.add(new Bug("NA", "General", 'B', 50, 50, 20));

		bugs.add(new Ant("Anty", 'A', 100, 100));
		bugs.add(new Ant("Anty", '#', 80, 80));
	}
	
	@Override	
	public void start(Stage primaryStage) {
		try {
			//BorderPane root = new BorderPane();
			
			createSomeBugs();
			
			Group root = new Group();
			
			root.getChildren().addAll(bugs);
			
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			
			
			
			
			KeyFrame frame = new KeyFrame(Duration.millis(4), new EventHandler<ActionEvent>() {

				
				@Override
				public void handle(ActionEvent t) {
					
					for(Bug circle  : bugs)
					{
//						//System.out.println("In");
//						Circle circle = new Circle(b.getX(), b.getY(), 7, Color.BLACK);
//						
						if(circle  instanceof Ant)
							circle.setFill(Color.RED);
					
						//Circle circle = bugs.get(0);
//						
						if(circle.getCenterX() + circle.getTranslateX() < circle.getRadius() || circle.getCenterX() + circle.getTranslateX() + circle.getRadius() > scene.getWidth()) {
							dx = -dx;
							//circle.setFill(Color.RED);
							
							
							}
						if(circle.getCenterY() + circle.getTranslateY() < circle.getRadius()|| circle.getCenterY() + circle.getTranslateY() + circle.getRadius() > scene.getHeight()) {
							dy = -dy;
							//circle.setFill(Color.BLUE);
							}

						circle.setTranslateX(circle.getTranslateX() + dx );
						circle.setTranslateY(circle.getTranslateY() + dy );

						
					}				
										
				}
			});
			
			Timeline t = new Timeline(frame);
			t.setCycleCount(javafx.animation.Animation.INDEFINITE);
			t.play();
			
			//Group root = new Group(circle);

			
			
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
