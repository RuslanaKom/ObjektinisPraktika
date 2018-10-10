package application;
	
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.io.FileInputStream;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;


public class Main extends Application {
    Boolean commaPressed=false;
    Boolean resultIsShouwn=false;
    Boolean mathSignIsPressed=false;
    
	@Override
	public void start(Stage primaryStage) {
		try {
		    Button button1 = new Button("1");
		    Button button2 = new Button("2");
		    Button button3 = new Button("3");
		    Button button4 = new Button("4");
            Button button5 = new Button("5");
            Button button6 = new Button("6");
            Button button7 = new Button("7");
            Button button8 = new Button("8");
            Button button9 = new Button("9");
            Button button0 = new Button("0");
            Button buttonPlus = new Button("+");
            Button buttonMinus = new Button("-");
            Button buttonMult= new Button("*");
            Button buttonDiv = new Button("/");
            Button buttonEq = new Button("=");
            Button buttonComma= new Button(",");
            Button buttonClear= new Button("CE");
            Button buttonSign=new Button("+/-");
            
            
            FileInputStream input1 = new FileInputStream("./images/root.png");
            Image image1 = new Image(input1);
            ImageView imageView1 = new ImageView(image1);          
            Button buttonRoot=new Button("",imageView1);
            
            FileInputStream input2 = new FileInputStream("./images/x2.png");
            Image image2 = new Image(input2);
            ImageView imageView2 = new ImageView(image2);  
            Button buttonSquare=new Button("",imageView2);
            
		    TextField textField1 = new TextField();
		    textField1.setAlignment(Pos.BASELINE_RIGHT);
		    textField1.setPrefHeight(30);
		    textField1.setFont(Font.font("Times",20));
		   
		    
			GridPane gridPane = new GridPane();
			gridPane.setVgap(5); 
		    gridPane.setHgap(5);
		    gridPane.setAlignment(Pos.TOP_CENTER); 
		    
		    gridPane.add(textField1, 1, 0, 5, 1);
		    gridPane.add(button1, 1, 2);
			gridPane.add(button2, 2, 2);
			gridPane.add(button3, 3, 2);
			gridPane.add(button4, 1, 3);
	        gridPane.add(button5, 2, 3);
	        gridPane.add(button6, 3, 3);
	        gridPane.add(button7, 1, 4);
	        gridPane.add(button8, 2, 4);
	        gridPane.add(button9, 3, 4);
	        gridPane.add(button0, 2, 5);
	        gridPane.add(buttonPlus, 1, 1);
	        gridPane.add(buttonMinus, 2, 1);
	        gridPane.add(buttonMult, 3, 1);
	        gridPane.add(buttonDiv, 4, 1);
	        gridPane.add(buttonEq, 3, 5);
	        gridPane.add(buttonComma, 1, 5); 
	        gridPane.add(buttonSquare, 4,2);
	        gridPane.add(buttonRoot, 4,3);
	        gridPane.add(buttonSign, 4, 4);
	        gridPane.add(buttonClear, 4, 5);

	        Calculator calc=new Calculator();
         
            EventHandler<ActionEvent> clearButtonsEventHandler = new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                 textField1.clear();
                 calc.erase();
                }
            };
	        
            EventHandler<ActionEvent> numberButtonsEventHandler = new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    if (resultIsShouwn || mathSignIsPressed) {
                        textField1.clear();
                        resultIsShouwn=false;
                        mathSignIsPressed=false;
                    }
                    Button eventObject = (Button) e.getSource();
                    textField1.appendText(eventObject.getText());
                }
            };

            EventHandler<ActionEvent> commaButtonsEventHandler = new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    if(!commaPressed) {
                    textField1.appendText(".");
                    commaPressed=true;
                    }
                }
            };
            
            EventHandler<ActionEvent> mathButtonsEventHandler = new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    if (!textField1.getText().equals("")) {
                        calc.inputValue(textField1.getText());
                        if (calc.setValues()) {
                            textField1.setText(String.valueOf(calc.calculate()));
                            resultIsShouwn = true;
                            calc.erase();
                            calc.inputValue(textField1.getText());
                        }
                        Button eventObject = (Button) e.getSource();
                        calc.inputSign(eventObject.getText());
                        commaPressed = false;
                        mathSignIsPressed = true;
                    }
                }
            };
            
            EventHandler<ActionEvent> equalsButtonsEventHandler = new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    calc.inputValue(textField1.getText());
                    calc.setValues();
                    textField1.setText(String.valueOf(calc.calculate()));
                    resultIsShouwn=true;
                    calc.erase();
                    commaPressed=false;
                    mathSignIsPressed=false;
                }
            };
            
            EventHandler<ActionEvent> squareButtonEventHandler = new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    calc.inputValue(textField1.getText());
                    textField1.setText(String.valueOf(calc.square()));
                    resultIsShouwn=true;
                    calc.erase();
                    commaPressed=false;
                }
            };
            
            EventHandler<ActionEvent> rootButtonEventHandler = new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    calc.inputValue(textField1.getText());
                    textField1.setText(String.valueOf(calc.root()));
                    resultIsShouwn=true;
                    calc.erase();
                    commaPressed=false;
                }
            };
            
            EventHandler<ActionEvent> signButtonsEventHandler = new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    if (!textField1.getText().contains("-")) {
                        textField1.setText("-"+textField1.getText());
                    }
                    else textField1.setText(textField1.getText().replace("-", ""));
                }
            };
            
            Set<Button> numberButtons = new HashSet<>();
            Collections.addAll(numberButtons, button1, button2, button3, button4, button5, button6, button7, button8,
                    button9, button0);

            for (Button button : numberButtons) {
                button.setOnAction(numberButtonsEventHandler);
                button.getStyleClass().add("buttonNum");
            }
            buttonComma.setOnAction(commaButtonsEventHandler);

            Set<Button> mathButtons = new HashSet<>();
            Collections.addAll(mathButtons, buttonPlus, buttonMinus, buttonMult, buttonDiv);

            for (Button button : mathButtons) {
                button.setOnAction(mathButtonsEventHandler);
            }

            buttonEq.setOnAction(equalsButtonsEventHandler);
            buttonClear.setOnAction(clearButtonsEventHandler);
            buttonSquare.setOnAction(squareButtonEventHandler);
            buttonRoot.setOnAction(rootButtonEventHandler);
            buttonSign.setOnAction(signButtonsEventHandler);
            
			Scene scene = new Scene(gridPane,280,350);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("CALCULATOR");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
