package TestFX.src.application;

import java.util.ArrayList;

import application.Ant;
import application.Bug;
import application.Plant;
import application.Spider;
import application.Worm;
import javafx.animation.Animation;
import javafx.animation.Transition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class FXLayoutTest extends Application {
	
	GridPane grid;
	
	//ArrayList<MyCircle> circles = new ArrayList<>();
	ArrayList<Bug> bugs = new ArrayList<>(); //bugs arraylist
	ArrayList<Plant> plants = new ArrayList<>(); //plants arraylist

	
	boolean flag = false;
	
	private void createCircles()
	{

		bugs.add(new Ant("Anty", 'A', 150, 250, "pacman1.gif"));
		bugs.add(new Ant("Anton", '#', 680, 400, "pacman5.gif"));
		bugs.add(new Worm("Wormy", 'W', 70, 310, "pacman2.gif"));
		bugs.add(new Spider("Spidey", 'S', 150, 50, "pacman4.gif")); 
		bugs.add(new Spider("Spida", 's', 760,15, "pacman3.gif")); //problematic bug effects the pane somehow
		bugs.add(new Worm("w0rm", 'w', 160,103, "pacman6.gif"));
		
		
		
		
		
		for(Bug c : this.bugs)
		{
			grid.getChildren().add(c);			
		}		
	}
	private void createPlants() {
		System.out.println("In");

		plants.add(new Plant("planty", "plant",'p', 150,250,150,"plant1.gif"));
		plants.add(new Plant("MrPlant" , "plant", 'P' ,100,25,400,"plant2.gif"));
		plants.add(new Plant("planty", "plant",'p', 400,300,50,"plant1.gif"));
		plants.add(new Plant("MrPlant" , "plant", 'P' ,300,25,400,"plant2.gif"));
		plants.add(new Plant("Cactus", "plant", 'c', 550,50,250,"plant4.gif"));
		plants.add(new Plant("planty", "plant",'p', 40,400,150,"plant1.gif"));
		plants.add(new Plant("MrPlant" , "plant", 'P' ,300,225,400,"plant2.gif"));
		plants.add(new Plant("Cactus", "plant", 'c', 750,450,250,"plant4.gif"));
		
		for(Plant p : this.plants)
		{
			grid.getChildren().add(p);			
		}		
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		BorderPane border = new BorderPane();
		
		HBox hbox = addHBox();
		border.setTop(hbox);
		border.setLeft(addVBox());
		this.grid = addGridPane();
		border.setCenter(grid);	
		border.setBottom(addBottomPane());	
		
		Scene scene = new Scene(border,400,400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
		
		Bounds boundsInScene = grid.localToScene(grid.getBoundsInLocal());
		Bounds boundsInScreen = grid.localToScreen(grid.getBoundsInLocal());
		System.out.println(grid.getLayoutBounds());
		System.out.println(boundsInScene);
		System.out.println(boundsInScreen);
		
		//createCircles();
		animate();
		

	}
	
	private void animate()
	{
		try {
			

			Transition transition = new Transition() {
	            {
	                setCycleDuration(Duration.millis(50));
	            }

	            @Override
	            protected void interpolate(double frac) {
	            	if(flag == false)
	    				return;
	            	grid.getChildren().clear();
	            	for (Bug c: bugs) 
	            	{	    
	            		int random = (int) ( 1 + Math.random()*2);
	            		Bounds boundsInScene = c.localToScene(c.getBoundsInLocal());
	            		if(boundsInScene.getMinY() <= 0 || boundsInScene.getMinY() >= grid.getHeight()-50) 
	            		{
	                        c.setDy(c.getDy()*-1);
	                    } 
	            		else if(boundsInScene.getMinX() >= grid.getWidth() -45|| boundsInScene.getMinX() < 0) 
	            		{
	            			c.setDx(c.getDx()*-1);
	            		}
	            		c.setX(boundsInScene.getMinX());
	                    c.setY(boundsInScene.getMinY());
	                    
	                    c.setTranslateX(c.getTranslateX() + c.getDx()*-1);
	         			c.setTranslateY(c.getTranslateY() + c.getDy()*-1);            		
	        		
	            		grid.getChildren().add(c);	            		
	    			}  
	            	for (Plant p : plants) {
	            		//Bounds boundsInScene = p.localToScene(p.getBoundsInLocal());
	            		
	                    p.setTranslateX(p.getX());
	         			p.setTranslateY(p.getY());
	         			grid.getChildren().add(p);
	            	}
	            }
	        };
	        transition.setCycleCount(Animation.INDEFINITE);
	        transition.setAutoReverse(true);	        
	        transition.play();
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void worldLogic(Button btn) {
		// TODO Auto-generated constructor stub
		System.out.println("worldlogic");
		
		
		for (Bug circle : bugs) {
			if (circle.getTranslateX() + circle.getFitWidth() <=0  || circle.getTranslateX() + circle.getFitWidth() >= grid.getWidth()) { //if statement to keep the  bugs within the borders
//				d1x = -d1x;
				circle.setDx(circle.getDx()*-1);
				// circle.setFill(Color.RED);
				if (circle.getEnergy() < 1) {
					//output3.setText("BUG DIED");
					circle.setImage("pacmanDEAD.gif");
					//deadbugs.add(circle);
					//bugs.remove(circle);

				}

			}
			if (circle.getTranslateY() <=0  || circle.getTranslateY() + circle.getFitHeight() >= grid.getHeight()) {
				circle.setDy(circle.getDy()*-1);

				// circle.setFill(Color.BLUE);
			}
////
			circle.setX(circle.getX() + circle.getDx());
			circle.setY(circle.getY() + circle.getDy());
			
		int deadcount = 0;
		
		if (circle.getEnergy() < 1) {
			circle.setImage("pacmanDEAD.gif");
			bugs.remove(circle);
			deadcount=deadcount+1;
		}
		}
		
	}
	
	private void moveBugs(Button btn)
	{
		this.flag = !this.flag;
		if(flag)
			btn.setText("Stop Moving");
		
		else
			btn.setText("Start Moving");
	}
	
	public HBox addHBox() {
	    HBox hbox = new HBox();
	    hbox.setPadding(new Insets(15, 12, 15, 12));
	    hbox.setSpacing(10);
	    hbox.setStyle("-fx-background-color: #31a517;");

	    

	    Button buttonCurrent = new Button("Start Moving");
	    buttonCurrent.setPrefSize(100, 20);
	    buttonCurrent.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> moveBugs(buttonCurrent));
	    buttonCurrent.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> worldLogic(buttonCurrent));


	    Button btnShow = new Button("Show Bugs");
	    btnShow.setPrefSize(100, 20);	    
	    btnShow.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> createCircles());

	    Button plantShow = new Button("Show Plants");
	    plantShow.setPrefSize(100, 20);
	    plantShow.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> createPlants());
	    
	    hbox.getChildren().addAll(buttonCurrent, btnShow, plantShow);
	    return hbox;
	}
	
	public VBox addVBox(){
	    VBox vbox = new VBox();
	    vbox.setPadding(new Insets(10));
	    vbox.setSpacing(8);

	    Text title = new Text("What to add?");
	    title.setFont(Font.font("Arial", FontWeight.BOLD, 14));
	    vbox.getChildren().add(title);

	    Hyperlink options[] = new Hyperlink[] {
	        new Hyperlink("Ant"),
	        new Hyperlink("Spider"),
	        new Hyperlink("Worm"),
	        new Hyperlink("Plant")};

	    for (int i=0; i<4; i++) {
	        VBox.setMargin(options[i], new Insets(0, 0, 0, 8));
	        vbox.getChildren().add(options[i]);
	        
	        final Hyperlink hyperlink = options[i];
	        hyperlink.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent t) {
                    System.out.println("Hello: " + hyperlink.getText());
                }
            });
	    }

	    return vbox;
	}

	public HBox addBottomPane()
	
	{
		HBox hbox = new HBox();
	    hbox.setPadding(new Insets(15, 12, 15, 12));
	    hbox.setSpacing(10);
	    hbox.setStyle("-fx-background-color: #31a517;");
	    Text category = new Text("Log..");
	    category.setFill(Color.WHITE);
	    category.setFont(Font.font("Arial", FontWeight.BOLD, 20));
	    hbox.getChildren().add(category); 

	    
	    
	    return hbox;		
	}
	
	public GridPane addGridPane() {
	    GridPane grid = new GridPane();
	    grid.setStyle("-fx-background-color: #000000;");
	    grid.setHgap(10);
	    grid.setVgap(10);
	    grid.setPadding(new Insets(0, 10, 0, 10));

	    return grid;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
