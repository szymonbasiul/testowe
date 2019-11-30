package progressBar;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class MainForm extends Application {

    File file;
    FileChooser fileChooser;
    ProgressBar progressBar;
    Button findFileButton;
    Button button2;

    @Override
    public void start(Stage primaryStage) throws Exception {
        fileChooser = new FileChooser();
        progressBar = new ProgressBar(0);

        findFileButton = new Button("Wybierz Plik");
        findFileButton.setOnAction(event -> {
            file = fileChooser.showOpenDialog(primaryStage);
            if(file == null){
                System.out.println("Nie wybrano żadnego pliku");
            }
            else {
                System.out.println(file.getAbsolutePath());
                Thread thread = new Thread(new ReaderRunnable(file, progressBar));
                thread.start();
            }
        });

        VBox layout = new VBox();
        layout.getChildren().addAll(findFileButton, progressBar);
        Scene scene = new Scene(layout, 300,300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
