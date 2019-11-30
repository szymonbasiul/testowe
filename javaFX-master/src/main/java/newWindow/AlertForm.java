package newWindow;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;



public class AlertForm {

    public void display(String tytul, String wiadomosc){
        Stage stage = new Stage();

        stage.setTitle(tytul);
        stage.setMinWidth(300);
        stage.setMinHeight(300);
        stage.initModality(Modality.APPLICATION_MODAL);

        Label label = new Label(wiadomosc);
        Button closeButton = new Button("Zamknij");
        closeButton.setOnAction(event -> stage.close());

        VBox layout = new VBox();
        layout.setAlignment(Pos.BASELINE_CENTER);
        layout.getChildren().addAll(label, closeButton);

        Scene scene = new Scene(layout);
        stage.setScene(scene);
        stage.show();
    }
}
