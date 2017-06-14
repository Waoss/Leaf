package com.waoss.leaf.syntax;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * Created by RAHUL on 12-06-2017.
 */
public class JavaSyntaxAreaTest extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        JavaSyntaxArea javaSyntaxArea = new JavaSyntaxArea();
        javaSyntaxArea.setPrefSize(Screen.getPrimary().getBounds().getWidth(), Screen.getPrimary().getBounds().getHeight());
        Scene scene = new Scene(new AnchorPane(javaSyntaxArea));
        scene.getStylesheets().add(javaSyntaxArea.getStylesheet());
        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaSyntaxAreaTest");
        primaryStage.setMaximized(true);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

}