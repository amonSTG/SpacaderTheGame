package com.games.spacaderthegame;


import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneController {

    private Stage stage;
    private Scene scene;
    private Parent root;


    public void switchToSceneMainMenu(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }



    public void switchToSceneChooseFighter(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("ChooseFighter.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public void setSpaceShipSpeedy(ActionEvent event) throws Exception {
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            TheGame newGame = new TheGame();
            newGame.start(stage);
    }


    public void setSpaceShipTank(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("MainGame.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
