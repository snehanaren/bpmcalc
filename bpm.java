import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.util.Timer;
import javafx.geometry.*;
import java.lang.Object.*;
import javafx.scene.shape.Shape.*;
import javafx.scene.text.*;

public class bpm extends Application implements EventHandler<ActionEvent>{

	Button button;
	int numClicks;
	boolean clickedFirst = false;
	//create instance of timer
	timer myTimer = new timer();


	@Override 
	public void start (Stage primaryStage) throws Exception {
		primaryStage.setTitle ("BPM Tapper");
		button = new Button ();
	
		//text.setPadding(new Insets( 0,0,0,500));

		button.setOnAction(this);
		button.setText("BPM" + "\n" + myTimer.difference);
		button.setStyle("-fx-background-color: #B4ABAE; ");
		button.setStyle("-fx-text-fill: black");
		//set text style
		button.setFont(new Font (40));
		button.setTextAlignment(TextAlignment.CENTER);

		button.setPrefSize (500.0, 500.0);
		
		StackPane layout = new StackPane();
		layout.getChildren().add(button);
		Text myText  = new Text ("click anywhere on the screen, or use the spacebar to tap to the beat of your song!");
		myText.setFont (new Font(20));
		myText.setTextAlignment(TextAlignment.CENTER);
		//set margin of text
		StackPane.setMargin(myText, new Insets (10, 5, 0, 5));
		myText.setWrappingWidth(495);

		layout.getChildren().add(myText);
		StackPane.setAlignment (myText, Pos.TOP_LEFT);
		//set margin of text

		Scene scene = new Scene(layout, 500, 500);
		primaryStage.setScene(scene);
		primaryStage.show();


	}


	@Override 
	public void handle (ActionEvent e) {
		//if clickedFirst is false, start thread
		if (!clickedFirst) {
			//start boolean flag again
			myTimer.endless = true;
			Thread myThread = new Thread (myTimer);
			myThread.start();
			clickedFirst = true;
		}
		else {
			myTimer.displayTime();
			button.setText("BPM" + "\n" + myTimer.difference);
			//stop thread
			clickedFirst = false;
		}
	}

	public static void main (String[] args) {
		launch (args);
	}
}