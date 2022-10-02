package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Main extends Application {
	
	public static int Score(int score) {
		return score++;
	}
	
	public static String AIGame(int num) { //How Ai will pick their choice
		if(num == 0) {
			return "Rock";
		}
		else if(num == 1) {
			return "Paper";
		}
		else if (num == 2) {
			return "Scissor";
		}
		else {
			return "Error";
		}
	}
	
	public static String GameResult(String AIChoice, String UserChoice) { //Results of game done here
		if(UserChoice.equals(AIChoice)) { //if a tie happens
			return "Draw";
		}
		else if (UserChoice.equals("Scissor")) { //if user chooses scissors
			if(AIChoice.equals("Paper")) { //and Ai chooses paper
				return "Win";
			}
			else { //Ai chooses rock here
				return "Lose";
			}
		}
		else if (UserChoice.equals("Rock")) { //if user chooses rock
			if(AIChoice.equals("Scissor")) { //and Ai chooses scissors
				return "Win";
			}
			else { //Ai chooses paper here
				return "Lose";
			}
		}
		else if (UserChoice.equals("Paper")) { //if user chooses paper
			if(AIChoice.equals("Rock")) { //and Ai chooses rock
				return "Win";
			}
			else { //Ai chooses scissors here
				return "Lose";
			}
		}
		return "Error";
	}
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Pane root = new Pane();
			
			//Picture Setup
			Image rock = new Image("Rock-removebg-preview.png"); //image set up
			ImageView rockView = new ImageView(rock);
			ImageView AIrockView = new ImageView(rock);
			Image scissor = new Image("Scissor-removebg-preview.png");
			ImageView scissorView = new ImageView(scissor);
			ImageView AIscissorView = new ImageView(scissor);
			Image paper = new Image("Paper.jpg");
			ImageView paperView = new ImageView(paper);
			ImageView AIpaperView = new ImageView(paper);
			Image PlayNow = new Image("Let's Play.png");
			ImageView PlayNowPic = new ImageView(PlayNow);
			Image PartyBlower = new Image("PartyBlower-removebg-preview.png");
			ImageView PartyBlowerPic = new ImageView(PartyBlower);
			Image PartyBlowerLeft = new Image("PartyBlowerLeft-removebg-preview.png");
			ImageView PartyBlowerLeftPic = new ImageView(PartyBlowerLeft);
			Image Winner = new Image("Winner_-removebg-preview.png");
			ImageView WinnerPic = new ImageView(Winner);
			Image Rain = new Image("Rain_Emoji.png");
			ImageView RainPic = new ImageView(Rain);
			ImageView RainLeftPic = new ImageView(Rain);
			Image Loser = new Image("Loser.png");
			ImageView LoserPic = new ImageView(Loser);
			Image Draw = new Image("Draw.png");
			ImageView DrawPic = new ImageView(Draw);
			Image StraightFace = new Image("StraightFace.png");
			ImageView StraightFacePic = new ImageView(StraightFace);
			ImageView StraightFaceLeftPic = new ImageView(StraightFace);
			StraightFacePic.setFitHeight(60); StraightFacePic.setFitWidth(60);
			StraightFaceLeftPic.setFitHeight(60); StraightFaceLeftPic.setFitWidth(60);
			RainPic.setFitHeight(60); RainPic.setFitWidth(60);
			RainLeftPic.setFitHeight(60); RainLeftPic.setFitWidth(60);
			PartyBlowerPic.setFitWidth(60); PartyBlowerPic.setFitHeight(60);
			PartyBlowerLeftPic.setFitWidth(60); PartyBlowerLeftPic.setFitHeight(60);
			rockView.setLayoutX(75); rockView.setLayoutY(450); rockView.setFitWidth(60); rockView.setFitHeight(60);
			scissorView.setLayoutX(450); scissorView.setLayoutY(450); scissorView.setFitWidth(60); scissorView.setFitHeight(60);
			paperView.setLayoutX(250); paperView.setLayoutY(450); paperView.setFitWidth(40); paperView.setFitHeight(40);
			AIrockView.setLayoutX(75); AIrockView.setLayoutY(450); AIrockView.setFitWidth(70); AIrockView.setFitHeight(70);
			AIscissorView.setLayoutX(450); AIscissorView.setLayoutY(450); AIscissorView.setFitWidth(70); AIscissorView.setFitHeight(70);
			AIpaperView.setLayoutX(250); AIpaperView.setLayoutY(450); AIpaperView.setFitWidth(50); AIpaperView.setFitHeight(50);
			
			//Text set up
			Text rockText = new Text("Rock");
			rockText.setX(60); rockText.setY(550); rockText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 30));
			Text scissorText = new Text("Scissor");
			scissorText.setX(410); scissorText.setY(550); scissorText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 30));
			Text paperText = new Text("Paper");
			paperText.setX(230); paperText.setY(550); paperText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 30));
			Label Center = new Label();
			Center.setTranslateX(200); Center.setTranslateY(250); Center.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 30));
			Center.setPrefSize(70, 70); Center.setGraphic(PlayNowPic);
			Label CenterRight = new Label();
			CenterRight.setTranslateX(380); CenterRight.setTranslateY(250);
			CenterRight.setPrefSize(70, 70);
			Label CenterLeft = new Label();
			CenterLeft.setTranslateX(150); CenterLeft.setTranslateY(250);
			CenterLeft.setPrefSize(70, 70);
			
			//Rock Paper Scissors Button Set up
			Button Rock = new Button();
			Rock.setTranslateX(70); Rock.setTranslateY(450); Rock.setStyle("-fx-background-color: #404095; ");
			Rock.setPrefSize(25, 25); Rock.setGraphic(rockView); Rock.setShape(new Circle(1.5));
			Button Paper = new Button();
			Paper.setTranslateX(250); Paper.setTranslateY(450); Paper.setStyle("-fx-background-color: #404095; ");
			Paper.setPrefSize(70, 70); Paper.setGraphic(paperView); Paper.setShape(new Circle(1.5));
			Button Scissor = new Button();
			Scissor.setTranslateX(430); Scissor.setTranslateY(450); Scissor.setStyle("-fx-background-color: #404095; ");
			Scissor.setPrefSize(70, 70); Scissor.setGraphic(scissorView); Scissor.setShape(new Circle(1.5));
			
			//User and AI choice set up
			Text PlayerInput = new Text(); //user choice
			Text AIInput = new Text(); //AI choice
			Button AIInputPic = new Button(); //AI picture
			AIInputPic.setTranslateX(240); AIInputPic.setTranslateY(100); AIInputPic.setStyle("-fx-background-color: #404095; ");
			AIInputPic.setPrefSize(80, 80); AIInputPic.setShape(new Circle(4.5));
			
			//Scoreboard setup
			Text Score = new Text("Score");
			Score.setX(480); Score.setY(50); Score.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
			Text Player = new Text("Player:");
			Player.setX(480); Player.setY(80); Player.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
			Text Computer = new Text("Computer:");
			Computer.setX(480); Computer.setY(110); Computer.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
			Text PlayerScore = new Text("0");
			Text ComputerScore = new Text("0");
			ComputerScore.setX(575); ComputerScore.setY(110);
			PlayerScore.setX(550); PlayerScore.setY(80);

			//Button Events for Player Input
			Rock.setOnMouseClicked(new EventHandler<MouseEvent>() {
	            @Override
	            public void handle(MouseEvent event) {
	                PlayerInput.setText("Rock"); //player choice
	                String PlayerChoice = "Rock";
	                //Set player text area
	                PlayerInput.setX(245); PlayerInput.setY(425); PlayerInput.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 30));
	                int randomNum = (int)(Math.random()*10)%3; //Random num for ai choice
	                String AIChoice = AIGame(randomNum); //creates ai choice
	                AIInput.setText(AIChoice);
	                //Sets up GUI for AI choice
	                if(AIChoice.equals("Rock")) {
	                	AIInputPic.setGraphic(AIrockView);
	                }
	                else if (AIChoice.equals("Scissor")) {
	                	AIInputPic.setGraphic(AIscissorView);
	                }
	                else if (AIChoice.equals("Paper")) {
	                	AIInputPic.setGraphic(AIpaperView);
	                }
	                AIInput.setX(235); AIInput.setY(55); AIInput.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 30));
	                String GameResult = GameResult(AIChoice, PlayerChoice); //result of game done here
	                if(GameResult.equals("Win")) {
	                	Center.setGraphic(WinnerPic); Center.setTranslateX(230); //set winner pics
	                	CenterRight.setGraphic(PartyBlowerPic);
	                	CenterLeft.setGraphic(PartyBlowerLeftPic);
	                	int savedCount = Integer.parseInt(PlayerScore.getText()) + 1;
	                	String stringCount = "" + savedCount; //set winner score 191-193
	                	PlayerScore.setText(stringCount);
	                }
	                else if(GameResult.equals("Lose")) {
	                	Center.setGraphic(LoserPic); Center.setTranslateX(230); //set loser pics
	                	CenterRight.setGraphic(RainPic);
	                	CenterLeft.setGraphic(RainLeftPic);
	                	int savedCount = Integer.parseInt(ComputerScore.getText()) + 1; 
	                	String stringCount = "" + savedCount; //set computer score line 197-199
	                	ComputerScore.setText(stringCount);
	                }
	                else if(GameResult.equals("Draw")) {
	                	Center.setGraphic(DrawPic); Center.setTranslateX(230); //set pics for draw
	                	CenterRight.setGraphic(StraightFacePic);
	                	CenterLeft.setGraphic(StraightFaceLeftPic);
	                }
	                
	            }
	        });
			Paper.setOnMouseClicked(new EventHandler<MouseEvent>() { //repeat for paper
	            @Override
	            public void handle(MouseEvent event) {
	            	PlayerInput.setText("Paper");
	            	String PlayerChoice = "Paper";
	            	PlayerInput.setX(235); PlayerInput.setY(425); PlayerInput.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 30));
	            	int randomNum = (int)(Math.random()*10)%3;
	                String AIChoice = AIGame(randomNum);
	                AIInput.setText(AIChoice);
	                if(AIChoice.equals("Rock")) {
	                	AIInputPic.setGraphic(AIrockView);
	                }
	                else if (AIChoice.equals("Scissor")) {
	                	AIInputPic.setGraphic(AIscissorView);
	                }
	                else if (AIChoice.equals("Paper")) {
	                	AIInputPic.setGraphic(AIpaperView);
	                }
	                AIInput.setX(235); AIInput.setY(55); AIInput.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 30));
	                String GameResult = GameResult(AIChoice, PlayerChoice);
	                if(GameResult.equals("Win")) {
	                	Center.setGraphic(WinnerPic); Center.setTranslateX(230);
	                	CenterRight.setGraphic(PartyBlowerPic);
	                	CenterLeft.setGraphic(PartyBlowerLeftPic);
	                	int savedCount = Integer.parseInt(PlayerScore.getText()) + 1;
	                	String stringCount = "" + savedCount;
	                	PlayerScore.setText(stringCount);
	                }
	                else if(GameResult.equals("Lose")) {
	                	Center.setGraphic(LoserPic); Center.setTranslateX(230);
	                	CenterRight.setGraphic(RainPic);
	                	CenterLeft.setGraphic(RainLeftPic);
	                	int savedCount = Integer.parseInt(ComputerScore.getText()) + 1;
	                	String stringCount = "" + savedCount;
	                	ComputerScore.setText(stringCount);
	                }
	                else if(GameResult.equals("Draw")) {
	                	Center.setGraphic(DrawPic); Center.setTranslateX(230);
	                	CenterRight.setGraphic(StraightFacePic);
	                	CenterLeft.setGraphic(StraightFaceLeftPic);
	                }
	            }
	        });
			Scissor.setOnMouseClicked(new EventHandler<MouseEvent>() { //repeat for scissor
	            @Override
	            public void handle(MouseEvent event) {
	            	PlayerInput.setText("Scissor");
	            	String PlayerChoice = "Scissor";
	            	PlayerInput.setX(225); PlayerInput.setY(425); PlayerInput.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 30));
	            	int randomNum = (int)(Math.random()*10)%3;
	                String AIChoice = AIGame(randomNum);
	                AIInput.setText(AIChoice);
	                if(AIChoice.equals("Rock")) {
	                	AIInputPic.setGraphic(AIrockView);
	                }
	                else if (AIChoice.equals("Scissor")) {
	                	AIInputPic.setGraphic(AIscissorView);
	                }
	                else if (AIChoice.equals("Paper")) {
	                	AIInputPic.setGraphic(AIpaperView);
	                }
	                AIInput.setX(235); AIInput.setY(55); AIInput.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 30));
	                String GameResult = GameResult(AIChoice, PlayerChoice);
	                if(GameResult.equals("Win")) {
	                	Center.setGraphic(WinnerPic); Center.setTranslateX(230);
	                	CenterRight.setGraphic(PartyBlowerPic);
	                	CenterLeft.setGraphic(PartyBlowerLeftPic);
	                	int savedCount = Integer.parseInt(PlayerScore.getText()) + 1;
	                	String stringCount = "" + savedCount;
	                	PlayerScore.setText(stringCount);
	                }
	                else if(GameResult.equals("Lose")) {
	                	Center.setGraphic(LoserPic); Center.setTranslateX(230);
	                	CenterRight.setGraphic(RainPic);
	                	CenterLeft.setGraphic(RainLeftPic);
	                	int savedCount = Integer.parseInt(ComputerScore.getText()) + 1;
	                	String stringCount = "" + savedCount;
	                	ComputerScore.setText(stringCount);
	                }
	                else if(GameResult.equals("Draw")) {
	                	Center.setGraphic(DrawPic); Center.setTranslateX(230);
	                	CenterRight.setGraphic(StraightFacePic);
	                	CenterLeft.setGraphic(StraightFaceLeftPic);
	                }
	                
	            }
	        });
			
			
			
			//add components to pane
			root.getChildren().add(PlayerScore);
			root.getChildren().add(ComputerScore);
			root.getChildren().add(CenterLeft);
			root.getChildren().add(CenterRight);
			root.getChildren().add(Center);
			root.getChildren().add(Score);
			root.getChildren().add(Player);
			root.getChildren().add(Computer);
			root.getChildren().add(AIInputPic);
			root.getChildren().add(PlayerInput);
			root.getChildren().add(AIInput);
			root.getChildren().add(rockText);
			root.getChildren().add(scissorText);
			root.getChildren().add(paperText);
			root.getChildren().add(Rock);
			root.getChildren().add(Paper);
			root.getChildren().add(Scissor);
			
			Scene scene = new Scene(root,600,600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm()); //any css 
			
			primaryStage.setTitle("Rock Paper Scissors");//title
			root.setStyle("-fx-background-color: #BCBFE6;");//background color
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.sizeToScene();
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
