package com.games.spacaderthegame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Game extends Application {


    @Override
    public void start(Stage theStage) {
        try {
            Parent root = FXMLLoader.load((getClass().getResource("MainMenu.fxml")));
            Scene scene = new Scene(root);
            theStage.setScene(scene);
            theStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args)
    {
        launch(args);
    }

}