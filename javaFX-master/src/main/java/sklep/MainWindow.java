package sklep;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import sklep.model.Smartfon;


public class MainWindow extends Application {
    private GridPane layout;
    private Stage stage;
    private TableView<Smartfon> tabelaSmartfonow;
    private TextField modelText, markaText, cenaText, procesorText, ramText, romText;
    private Button addButton;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        setWindowParameters();

        //Tworzymy kolumny
        TableColumn<Smartfon, String> kolumnaMarek = new TableColumn<>("Marka");
        TableColumn<Smartfon, String> kolumnaModeli = new TableColumn<>("Model");
        TableColumn<Smartfon, String> kolumnaCen = new TableColumn<>("Cena");
        TableColumn<Smartfon, String> kolumnaProcesora = new TableColumn<>("Model Procesora");
        TableColumn<Smartfon, String> kolumnaRam = new TableColumn<>("Pamięć RAM");
        TableColumn<Smartfon, String> kolumnaRom = new TableColumn<>("Pamięć ROM");

        //Ustawiamy szerokość kolumn
        kolumnaMarek.setMinWidth(150);
        kolumnaModeli.setMinWidth(150);
        kolumnaCen.setMinWidth(150);
        kolumnaProcesora.setMinWidth(150);
        kolumnaRam.setMinWidth(150);
        kolumnaRom.setMinWidth(150);

        //przypisujemy kolumny do pól
        kolumnaMarek.setCellValueFactory(new PropertyValueFactory("marka"));
        kolumnaModeli.setCellValueFactory(new PropertyValueFactory("model"));
        kolumnaCen.setCellValueFactory(new PropertyValueFactory("cena"));
        kolumnaProcesora.setCellValueFactory(new PropertyValueFactory("modelProcesora"));
        kolumnaRam.setCellValueFactory(new PropertyValueFactory("pamiecRam"));
        kolumnaRom.setCellValueFactory(new PropertyValueFactory("pamiecRom"));

        tabelaSmartfonow = new TableView<>();
        tabelaSmartfonow.setItems(getSmartfony());
        tabelaSmartfonow.getColumns().addAll(kolumnaMarek, kolumnaModeli, kolumnaCen, kolumnaProcesora, kolumnaRam, kolumnaRom);
        tabelaSmartfonow.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        setTextFields();
        addButton = new Button("Dodaj Smartfon");
        addButton.setOnAction(event -> addSmartfon());
        GridPane.setConstraints(addButton,5,3);

        GridPane.setColumnSpan(tabelaSmartfonow, 6);
        GridPane.setValignment(tabelaSmartfonow, VPos.CENTER);

        layout.getChildren().addAll(tabelaSmartfonow, cenaText, modelText, markaText,ramText,romText,procesorText, addButton);
        Scene scene = new Scene(layout, 920,600);
        stage.setScene(scene);
        stage.show();
    }

    public void setWindowParameters(){
        layout = new GridPane();
        layout.setPadding(new Insets(10,10,10,10));
        layout.setHgap(10);
        layout.setVgap(10);
        stage.setTitle("Sklep z rzeczami");
    }

    public ObservableList<Smartfon> getSmartfony(){
        ObservableList<Smartfon> smartfony = FXCollections.observableArrayList();

        smartfony.add(new Smartfon("Apple", "Srajfon", 5500, "A12", 4, 128));
        smartfony.add(new Smartfon("Samsung", "Note11", 5000, "Exynos", 8, 256));
        smartfony.add(new Smartfon("Nokia", "3310", 10000, "Cudo", 128, 1024));

        return smartfony;
    }

    public void setTextFields(){
        markaText = new TextField();
        markaText.setPromptText("Marka");
        GridPane.setConstraints(markaText, 0, 2);

        modelText = new TextField();
        modelText.setPromptText("Model");
        GridPane.setConstraints(modelText, 1, 2);

        cenaText = new TextField();
        cenaText.setPromptText("Cena");
        GridPane.setConstraints(cenaText, 2, 2);

        procesorText = new TextField();
        procesorText.setPromptText("Procesor");
        GridPane.setConstraints(procesorText, 3, 2);

        ramText = new TextField();
        ramText.setPromptText("RAM");
        GridPane.setConstraints(ramText, 4, 2);

        romText = new TextField();
        romText.setPromptText("ROM");
        GridPane.setConstraints(romText, 5, 2);
    }

    public void addSmartfon(){
        //Sprawdzanie czy pola nie są puste - w domu
        tabelaSmartfonow.getItems().add(new Smartfon(
                markaText.getText(),
                modelText.getText(),
                Integer.parseInt(cenaText.getText()),
                procesorText.getText(),
                Integer.parseInt(ramText.getText()),
                Integer.parseInt(romText.getText())));
    }




}
