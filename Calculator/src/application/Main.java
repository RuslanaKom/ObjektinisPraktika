package application;
	
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.awt.DisplayMode;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;


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
            
            FileInputStream input1 = new FileInputStream("./images/root.png");
            Image image1 = new Image(input1);
            ImageView imageView1 = new ImageView(image1);          
            Button buttonRoot=new Button("",imageView1);
            
            FileInputStream input2 = new FileInputStream("./images/x2.png");
            Image image2 = new Image(input2);
            ImageView imageView2 = new ImageView(image2);  
            Button buttonSquare=new Button("",imageView2);
            
		    TextField textField1 = new TextField();
		    
			GridPane gridPane = new GridPane();
			gridPane.setVgap(5); 
		    gridPane.setHgap(5);
		    gridPane.setAlignment(Pos.TOP_CENTER); 
		    
		    gridPane.add(textField1, 1, 0, 5, 1);
		    gridPane.add(button1, 1, 1);
			gridPane.add(button2, 2, 1);
			gridPane.add(button3, 3, 1);
			gridPane.add(button4, 1, 2);
	        gridPane.add(button5, 2, 2);
	        gridPane.add(button6, 3, 2);
	        gridPane.add(button7, 1, 3);
	        gridPane.add(button8, 2, 3);
	        gridPane.add(button9, 3, 3);
	        gridPane.add(button0, 1, 4);
	        gridPane.add(buttonPlus, 4, 1);
	        gridPane.add(buttonMinus, 4, 2);
	        gridPane.add(buttonMult, 4, 3);
	        gridPane.add(buttonDiv, 4, 4);
	        gridPane.add(buttonEq, 3, 4);
	        gridPane.add(buttonComma, 2, 4);
	        gridPane.add(buttonClear, 5, 3);
	        gridPane.add(buttonSquare, 5,1);
	        gridPane.add(buttonRoot, 5,2);
	        
	       
	        List <KeyCode> numberKeys=Arrays.asList(new KeyCode [] {KeyCode.NUMPAD0, KeyCode.NUMPAD1, KeyCode.NUMPAD2, KeyCode.NUMPAD3,
	                KeyCode.NUMPAD4, KeyCode.NUMPAD5, KeyCode.NUMPAD6, KeyCode.NUMPAD7,KeyCode.NUMPAD8, KeyCode.NUMPAD9});
      
	        Calculator calc=new Calculator();
            EventHandler<KeyEvent> numberButtonKeyEventHandler = new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent key) {
                    if (numberKeys.contains(key.getCode())) {
                        if (resultIsShouwn || mathSignIsPressed) {
                            textField1.clear();
                            resultIsShouwn = false;
                            mathSignIsPressed = false;
                        }
                        textField1.appendText(key.getCharacter());    
                    }
                }
            };
	        
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
                    calc.inputValue(textField1.getText());
                   // textField1.clear();
                    if (calc.setValues()) {
                        textField1.setText(String.valueOf(calc.calculate()));
                        resultIsShouwn=true;
                        calc.erase();
                        calc.inputValue(textField1.getText());
                    }
                    Button eventObject = (Button) e.getSource();
                    calc.inputSign(eventObject.getText());
                    commaPressed=false;
                    mathSignIsPressed=true;
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
                    //Calculator.inputValue(textField1.getText());
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
                    //Calculator.inputValue(textField1.getText());
                    commaPressed=false;
                }
            };
            
            Set<Button> numberButtons = new HashSet<>();
            Collections.addAll(numberButtons, button1, button2, button3, button4, button5, button6, button7, button8,
                    button9, button0);

            for (Button button : numberButtons) {
                button.setOnAction(numberButtonsEventHandler);
            }
            buttonComma.setOnAction(commaButtonsEventHandler);

            Set<Button> mathButtons = new HashSet<>();
            Collections.addAll(mathButtons, buttonPlus, buttonMinus, buttonMult, buttonDiv);

            for (Button button : mathButtons) {
                button.setOnAction(mathButtonsEventHandler);
            }
            
            textField1.setOnKeyPressed(numberButtonKeyEventHandler);

            buttonEq.setOnAction(equalsButtonsEventHandler);
            buttonClear.setOnAction(clearButtonsEventHandler);
            buttonSquare.setOnAction(squareButtonEventHandler);
            buttonRoot.setOnAction(rootButtonEventHandler);
            
			Scene scene = new Scene(gridPane,300,270);
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
