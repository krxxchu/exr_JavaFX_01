package com.example.demo2;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
public class Kontrolki extends Application {

    public static void main(String[] args) {
        launch();
    }
    @Override
    public void start(Stage stage) {
//DEFINIOWANIE CZCIONKI
        Font font = Font.font("Cambria", FontWeight.BOLD, 56);
        System.out.println(Font.getFamilies());
//DEFINIOWANIE KOLORU
        Color color = Color.rgb(76, 145 ,97);
//TWORZENIE Labelki
        Label label = new Label("JAKAŚ PIERWSZA LABELKA");
        label.setLayoutX(250);
        label.setLayoutY(100);
//PRZYPISANIE CZCIONKI
        // label.setFont(new Font(20));
        label.setFont(font);
//KOLOR CZCIONKI
        // label.setTextFill(Color.RED);
        label.setTextFill(color);
//ImageView - dodawanie obrazków
        Image mario = new Image("Mario.ico");
        ImageView imageView = new ImageView(mario);
        imageView.setX(30);
        imageView.setY(30);
        imageView.setScaleX(0.5);
        imageView.setScaleY(0.5);
//TextField
        TextField poleTekstowe = new TextField();
        poleTekstowe.setPromptText("TextField - wpisz tajne dane");
        poleTekstowe.setPrefWidth(200);
        poleTekstowe.setLayoutX(440);
        poleTekstowe.setLayoutY(230);
//TextArea - pole tekstowe na wiele linii
        TextArea textArea = new TextArea();
        textArea.setPromptText("TextArea - wpisz co chcesz");
        textArea.setLayoutX(150);
        textArea.setLayoutY(300);
        textArea.setPrefHeight(60);
        textArea.setPrefWidth(600);

//PasswordField
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("PasswordField - wpisz hasło bq");
        passwordField.setPrefWidth(200);
        passwordField.setLayoutX(440);
        passwordField.setLayoutY(260);

//BUTTON - dodawanie przycisku
        Button button = new Button("Button");
        button.setLayoutX(460);
        button.setLayoutY(200);
        button.setPrefWidth(150);
        button.setPrefHeight(30);
        button.setTextFill(Color.PURPLE);
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("przechwycono tekst z pola: " + poleTekstowe.getText());
                System.out.println("przechwycono hasło: " + passwordField.getText());
                button.setText("przesłano informacje");
            }
        });
  //CheckBox
        CheckBox checkBox = new CheckBox("CheckBox");
        checkBox.setLayoutX(500);
        checkBox.setLayoutY(180);
        checkBox.setSelected(true);
//RadioButton
        RadioButton radioButton1 = new RadioButton("RadioButton - opcja 1");
        radioButton1.setLayoutX(450);
        radioButton1.setLayoutY(60);

        RadioButton radioButton2 = new RadioButton("RadioButton - opcja 2");
        radioButton2.setLayoutX(450);
        radioButton2.setLayoutY(80);

        ToggleGroup toggleGroup = new ToggleGroup();
        radioButton1.setToggleGroup(toggleGroup);
        radioButton2.setToggleGroup(toggleGroup);
        toggleGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                RadioButton wybrany = (RadioButton) newValue;
                System.out.println("Wybrano na RadioButtonie: " + wybrany.getText());
            }
        });

//ChoiceBox
        String [] listaWyborow = {"pierwszy", "drugi", "trzeci","czwarty"};
        ChoiceBox<String> choiceBox = new ChoiceBox<>();
        choiceBox.getItems().addAll(listaWyborow);

        choiceBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                String wybranaOpcja =listaWyborow[newValue.intValue()];
                System.out.println("wybrano opcję: " + wybranaOpcja + " z ChoiceBoxa");
            }
        });
//ListView
        ListView <String> listView = new ListView<>();
        listView.getItems().addAll(listaWyborow);
        listView.setLayoutX(100);
        listView.setPrefHeight(80);
        listView.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                String wybranyZListy = listaWyborow[newValue.intValue()];
                System.out.println("wybrano opcję: " + wybranyZListy + " z ListView");
            }
        });
//ProgressBar
        ProgressBar progressBar = new ProgressBar();
        progressBar.setLayoutX(480);
        progressBar.setLayoutY(20);
        //progressBar.setProgress(0.77);
//ProgressIndicator
        ProgressIndicator progressIndicator = new ProgressIndicator();
        progressIndicator.setLayoutX(600);
        progressIndicator.setLayoutY(10);
//Slider
        Slider slider = new Slider(0, 100, 0);
        slider.setLayoutX(660);
        slider.setLayoutY(30);
        slider.setPrefWidth(200);
        slider.setShowTickMarks(true);
        slider.setShowTickLabels(true);
        slider.setMajorTickUnit(20);
        slider.setMinorTickCount(1);
        slider.setSnapToTicks(true);
        slider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                double wybranaWartosc = newValue.doubleValue();
                System.out.println("Warotsc wybrana na sliderze to: " + wybranaWartosc);
                progressBar.setProgress(wybranaWartosc/100);
                progressIndicator.setProgress(wybranaWartosc/100);
            }
        });


//Dodawanie elementów do grupy (które następnie lądują na scenie)
        Group group = new Group();
        group.getChildren().add(label);
        group.getChildren().add(imageView);
        group.getChildren().add(button);
        group.getChildren().add(poleTekstowe);
        group.getChildren().add(passwordField);
        group.getChildren().add(textArea);
        group.getChildren().add(checkBox);
        group.getChildren().add(radioButton1);
        group.getChildren().add(radioButton2);
        group.getChildren().add(choiceBox);
        group.getChildren().add(listView);
        group.getChildren().add(progressBar);
        group.getChildren().add(progressIndicator);
        group.getChildren().add(slider);



        //scene
        Scene scene = new Scene(group, 1000, 400, Color.LIGHTGRAY);

        //stage
        stage.setScene(scene);
        stage.setTitle("APKA KONTROLKI");
        stage.show();


    }

}
