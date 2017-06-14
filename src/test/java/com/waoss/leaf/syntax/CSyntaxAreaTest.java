package com.waoss.leaf.syntax;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * Created by RAHUL on 12-06-2017.
 */
public class CSyntaxAreaTest extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        CSyntaxArea cSyntaxArea = new CSyntaxArea();
        cSyntaxArea.setPrefSize(Screen.getPrimary().getBounds().getWidth(), Screen.getPrimary().getBounds().getHeight());
        Scene scene = new Scene(new AnchorPane(cSyntaxArea));
        scene.getStylesheets().add(cSyntaxArea.getStylesheet());
        primaryStage.setScene(scene);
        primaryStage.setTitle("CSyntaxAreaTest");
        primaryStage.setMaximized(true);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}