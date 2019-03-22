package viko_encription.rsa;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Hello world!
 *
 */
public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            RsaEncripter aesEncrypter = new RsaEncripter();

            GridPane gridPane = new GridPane();
            gridPane.setVgap(5);
            gridPane.setHgap(5);
            gridPane.setAlignment(Pos.TOP_CENTER);

            TextField textInput = new TextField();
            TextField textOutput = new TextField();
            Button buttonEncrypt = new Button("Encrypt");
            Button buttonDecrypt = new Button("Decrypt");

            gridPane.add(textInput, 1, 1, 5, 1);
            gridPane.add(buttonEncrypt, 2, 2);
            gridPane.add(textOutput, 1, 3, 5, 1);
            gridPane.add(buttonDecrypt, 2, 4);

//            
//            EventHandler<ActionEvent> encryptButtonsEventHandler = new EventHandler<ActionEvent>() {
//                @Override
//                public void handle(ActionEvent e) {
//                    String text = textInput.getText();
//                    aesEncrypter.encryptAndSave(text, "./newFile");
//                    textInput.clear();
//                    textOutput.clear();
//                }
//            };
//            
//            EventHandler<ActionEvent> decryptButtonsEventHandler = new EventHandler<ActionEvent>() {
//                @Override
//                public void handle(ActionEvent e) {
//                    String text = aesEncrypter.readAndDecrypt("./newFile");
//                    textOutput.setText(text);
//                }
//            };
//            
//            buttonEncrypt.setOnAction(encryptButtonsEventHandler);
//            buttonDecrypt.setOnAction(decryptButtonsEventHandler);

            Scene scene = new Scene(gridPane, 280, 350);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Encryprer");
            primaryStage.show();

        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}
