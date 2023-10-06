package com.example.demo2;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Timer;


public class ZadanieKontrolki extends Application {


    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) {

        Text text = new Text("Pasek postępu");
        text.setLayoutX(70);
        text.setLayoutY(10);

        Text text2 = new Text("Zakończono");
        text2.setLayoutX(70);
        text2.setLayoutY(50);
        text2.setVisible(false);

        Label label = new Label();
        label.setLayoutX(230);
        label.setLayoutY(20);



        ProgressBar progressBar = new ProgressBar(0);
        progressBar.setLayoutY(20);
        progressBar.setLayoutX(10);
        progressBar.setPrefWidth(200);

        System.out.println(progressBar.progressProperty());

        Button button1 = new Button("Start");
        button1.setLayoutY(60);
        button1.setLayoutX(10);
        button1.setPrefWidth(100);

        // Timeline timeline = new Timeline(new KeyFrame(10,"timeline",);

        Button button2 = new Button("Restart");
        button2.setLayoutY(60);
        button2.setLayoutX(110);
        button2.setPrefWidth(100);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0 ; i <= 100; i++) {
                    double progressValue = i * 0.01;

                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            progressBar.setProgress(progressValue);
                            label.setText("załadowano " + progressValue * 100 + "%");
                        }
                    });
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        button1.setDisable(true);
                        button2.setDisable(false);
                        text2.setVisible(true);
                    }
                });
            }
        };

        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               new Thread(runnable).start();
            }
        });


        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                progressBar.setProgress(0);
                text2.setVisible(false);
                button1.setDisable(false);
                button2.setDisable(true);
            }
        });

        Group group = new Group();
        group.getChildren().add(text);
        group.getChildren().add(text2);
        group.getChildren().add(progressBar);
        group.getChildren().add(button1);
        group.getChildren().add(button2);
        group.getChildren().add(label);


        Scene scene = new Scene(group, 400, 400);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Zadanie Kontrolki");
        primaryStage.show();

    }

}
