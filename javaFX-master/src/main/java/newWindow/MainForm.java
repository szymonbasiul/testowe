package newWindow;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class MainForm extends Application {
    Button showAlertButton;
    Button example1;
    Button example2;
    public static int HEIGHT = 500;
    public static int WIDTH = 500;

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Główne okno");
        GridPane layout = new GridPane();
        layout.setPadding(new Insets(50,50,50,50));
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setGridLinesVisible(true);
        AlertForm alertForm = new AlertForm();
        showAlertButton = new Button("Wyświetl wiadomość");
        showAlertButton.setOnAction(event -> alertForm.display("Nowe Okno", "Nasza Wiadomość"));

        example1 = new Button("Example 1");
        example2 = new Button("Example 2");

        GridPane.setConstraints(showAlertButton, 1,0);
        GridPane.setConstraints(example1, 1,1);
        GridPane.setConstraints(example2, 0,1);

        layout.getChildren().addAll(showAlertButton, example1, example2);
        Scene scene = new Scene(layout, 500, 500);
        stage.setScene(scene);
        stage.show();
    }
}
