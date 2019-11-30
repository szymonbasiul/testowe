package przyklad1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;



public class MainForm extends Application {
    public void start(Stage primaryStage) throws Exception {
        StackPane layout1 = new StackPane();
        StackPane layout2 = new StackPane();

        Scene scene = new Scene(layout1, 300, 250);
        Scene scene2 = new Scene(layout2, 200,200);

        Button button = new Button("Kliknij Tutaj");
        button.setOnAction(event -> primaryStage.setScene(scene2));
        layout1.getChildren().add(button);

        Button button2 = new Button("Wróc do okna 1");
        button2.setOnAction(event -> primaryStage.setScene(scene));
        layout2.getChildren().add(button2);

        primaryStage.setTitle("Nasze Okno");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
