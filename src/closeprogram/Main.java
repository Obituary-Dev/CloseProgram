/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package closeprogram;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Obituary
 */
public class Main extends Application {

    Stage window;
    Button button;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("JavaFX - the new boston");

        // users bypass the closeProgram() method if they don't click the button to close the window so
        window.setOnCloseRequest(e -> {
            // consume: hey Java we got it from here 
            e.consume();
            closeProgram();

        });

        button = new Button("Close Program");
        button.setOnAction(e -> closeProgram());

        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        Scene scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();

    }

    private void closeProgram() {
        Boolean answer = ConfirmBox.display("Title", "Are you sure you want to exit the window ?");
        if (answer) {
            window.close();
        }
    }
}
