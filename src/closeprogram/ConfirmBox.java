package closeprogram;

/**
 *
 * @author Obituary
 */
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmBox {

    // bollean variable to store the user's answers
    static boolean answer;
    
    // returns the answer: boolean 
    public static boolean display(String title, String message) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);
        Label label = new Label();
        label.setText(message);

        // create 2 buttons 
        Button yesButton = new Button("Yes");
        Button noButton = new Button("No");
        
        // functionalities
        yesButton.setOnAction(e -> {
            answer = true; 
            window.close();
        });
        noButton.setOnAction(e -> {
            answer = false; 
            window.close();
        });
        
        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, yesButton, noButton);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout, 200, 250);
        window.setScene(scene);
        window.showAndWait();
        
        return answer; 
    }
}

