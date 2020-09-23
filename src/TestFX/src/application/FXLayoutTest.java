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
import javafx.scene.control.TextArea;
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

	// ArrayList<MyCircle> circles = new ArrayList<>();
	ArrayList<Bug> bugs = new ArrayList<>(); // bugs arraylist
	ArrayList<Plant> plants = new ArrayList<>(); // plants arraylist
	private Text category1 = new Text("Bug Energy.");
	private Text category2 = new Text(" ");
	private Text category3 = new Text(" ");
	private Text category4 = new Text(" ");
	private Text category5 = new Text(" ");
	private Text category6 = new Text(" ");


	boolean flag = false;

	private void createCircles() {

		bugs.add(new Ant("Anty", 'A', 150, 250, "pacman1.gif"));
		bugs.add(new Ant("Anton", '#', 680, 400, "pacman5.gif"));
		bugs.add(new Worm("Wormy", 'W', 70, 310, "pacman2.gif"));
		bugs.add(new Spider("Spidey", 'S', 150, 50, "pacman4.gif"));
		bugs.add(new Spider("Spida", 's', 760, 15, "pacman3.gif")); // problematic bug effects the pane somehow
		bugs.add(new Worm("w0rm", 'w', 160, 103, "pacman6.gif"));
		

		for (Bug c : this.bugs) {
			grid.getChildren().add(c);
		}
	}

	private void createPlants() {
		System.out.println("In");

		plants.add(new Plant("planty", "plant", 'p', 150, 250, 1150, "plant1.gif"));
		plants.add(new Plant("MrPlant", "plant", 'P', 100, 25, 400, "plant2.gif"));
		plants.add(new Plant("planty", "plant", 'p', 400, 300, 500, "plant1.gif"));
		plants.add(new Plant("MrPlant", "plant", 'P', 300, 25, 400, "plant2.gif"));
		plants.add(new Plant("Cactus", "plant", 'c', 550, 50, 250, "plant4.gif"));
		plants.add(new Plant("planty", "plant", 'p', 40, 400, 1150, "plant1.gif"));
		plants.add(new Plant("MrPlant", "plant", 'P', 300, 225, 400, "plant2.gif"));
		plants.add(new Plant("Cactus", "plant", 'c', 750, 450, 1250, "plant4.gif"));

		for (Plant p : this.plants) {
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

		Scene scene = new Scene(border, 400, 400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();

		Bounds boundsInScene = grid.localToScene(grid.getBoundsInLocal());
		Bounds boundsInScreen = grid.localToScreen(grid.getBoundsInLocal());
		System.out.println(grid.getLayoutBounds());
		System.out.println(boundsInScene);
		System.out.println(boundsInScreen);

		// createCircles();
		animate();

	}

	private void animate() {
		try {

			Transition transition = new Transition() {
				{
					setCycleDuration(Duration.millis(50));
				}

				@Override
				protected void interpolate(double frac) {
					if (flag == false)
						return;
					grid.getChildren().clear();
					for (Bug c : bugs) {
						int random = (int) (1 + Math.random() * 2);
						Bounds boundsInScene = c.localToScene(c.getBoundsInLocal());
						if (boundsInScene.getMinY() <= 0 || boundsInScene.getMinY() >= grid.getHeight() - 50) {
							c.setDy(c.getDy() * -1);
						} else if (boundsInScene.getMinX() >= grid.getWidth() - 45 || boundsInScene.getMinX() < 0) {
							c.setDx(c.getDx() * -1);
						}
						
						c.setX(boundsInScene.getMinX());
						c.setY(boundsInScene.getMinY());
						// Decrement energy
						c.setEnergy(c.getEnergy() - 1);
						
						

						switch (c.getName()) {
						case "Anty":
							category1.setText(c.getName() + " : " + c.getEnergy());
							break;
						case "Anton":
							category2.setText(c.getName() + " : " + c.getEnergy());
							break;
						case "Wormy":
							category3.setText(c.getName() + " : " + c.getEnergy());
							break;
						case "Spidey":
							category4.setText(c.getName() + " : " + c.getEnergy());
							break;
						case "Spida":
							category5.setText(c.getName() + " : " + c.getEnergy());
							break;
						case "w0rm":
							category6.setText(c.getName() + " : " + c.getEnergy());
							break;
							

									
						}
						
						
						if (c.getEnergy() < 350) {
							c.setImage("pacmanDEAD.gif");
							
							//c.setImage("explosion2.gif");

		

						}
						if (c.getEnergy() < 150) {
							c.setFitWidth(40);
						}
						if (c.getEnergy() < 100) {
							c.setFitWidth(30);
						}	
						if (c.getEnergy() < 75) {
							c.setFitWidth(20);
						}	
						if (c.getEnergy() < 50) {
							c.setFitWidth(10);
						}	
						if (c.getEnergy() < 20) {
							c.setImage("explosion.gif");
							c.setFitWidth(70);
						}	
						if (c.getEnergy() > 350 ) {
							c.setFitWidth(50);
							// maybe do some instanceof things to restore the image
						}
						if (c.getEnergy() < 1) {
							//output3.setText("BUG DIED");
							bugs.remove(c);
							}

						c.setTranslateX(c.getTranslateX() + c.getDx() * -1);
						c.setTranslateY(c.getTranslateY() + c.getDy() * -1);

						grid.getChildren().add(c);
					}
					for (Plant a : plants) {
						// Bounds boundsInScene = p.localToScene(p.getBoundsInLocal());
						
						a.setTranslateX(a.getX());
						a.setTranslateY(a.getY());
						
						grid.getChildren().add(a);
						for (Bug o : bugs) {
						if ((o.getX() > a.getX()-5 && o.getX() < a.getX()+5) && (o.getY() > a.getY()-5 && o.getY() < a.getY()+5)) {
							System.out.println("EAT "+o.getName()+" x "+o.getX()+" y "+o.getY());
							o.setEnergy(o.getEnergy()+1000);
							a.setEnergy(-200);
						}
						}
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



	private void moveBugs(Button btn) {
		this.flag = !this.flag;
		if (flag)
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

		Button btnShow = new Button("Show Bugs");
		btnShow.setPrefSize(100, 20);
		btnShow.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> createCircles());

		Button plantShow = new Button("Show Plants");
		plantShow.setPrefSize(100, 20);
		plantShow.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> createPlants());

		hbox.getChildren().addAll(buttonCurrent, btnShow, plantShow);
		return hbox;
	}

	public VBox addVBox() {
		VBox vbox = new VBox();
		vbox.setPadding(new Insets(10));
		vbox.setSpacing(8);

		Text title = new Text("Kill Bug");
		title.setFont(Font.font("Arial", FontWeight.BOLD, 14));
		vbox.getChildren().add(title);

		Hyperlink options[] = new Hyperlink[] { new Hyperlink("Anty"), new Hyperlink("Anton"), new Hyperlink("Spidey"),
				new Hyperlink("Spida"), new Hyperlink("w0rm"), new Hyperlink("Wormy") };

		for (int i = 0; i < 6; i++) {
			VBox.setMargin(options[i], new Insets(0, 0, 0, 8));
			vbox.getChildren().add(options[i]);

			final Hyperlink hyperlink = options[i];
			hyperlink.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent t) {
					for (Bug b : bugs)
						if (hyperlink.getText() == b.getName()) {
							//bugs.remove(b);
							b.setEnergy(20);
						}
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

		category1.setFill(Color.WHITE);
		category1.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		hbox.getChildren().add(category1);
		category2.setFill(Color.WHITE);
		category2.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		hbox.getChildren().add(category2);
		category3.setFill(Color.WHITE);
		category3.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		hbox.getChildren().add(category3);
		category4.setFill(Color.WHITE);
		category4.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		hbox.getChildren().add(category4);
		category5.setFill(Color.WHITE);
		category5.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		hbox.getChildren().add(category5);
		category6.setFill(Color.WHITE);
		category6.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		hbox.getChildren().add(category6);

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
