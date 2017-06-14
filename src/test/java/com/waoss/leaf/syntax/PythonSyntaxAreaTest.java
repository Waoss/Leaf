/*
 *  Copyright (c) Waoss
 *
 *  Mail me at rahul29112002@gmail.com for any queries :)
 *
 *  This is free software licensed under the GNU General Public License.This license allows one to modify it on their will and also embed it or distribute it along with their own software.
 *  It is distributed in the hope that it shall be useful to whomsoever receives it,but does not provide ANY warranty or liability,not even the gurantee that the software will work in your certain usage.
 *  You receive a copy of the GNU General Public License version 3.0 when you download this software.See LICENSE.MD for more details.
 */

package com.waoss.leaf.syntax;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Screen;
import javafx.stage.Stage;


public class PythonSyntaxAreaTest extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        PythonSyntaxArea pythonSyntaxArea = new PythonSyntaxArea();
        pythonSyntaxArea.setPrefSize(Screen.getPrimary().getBounds().getWidth(), Screen.getPrimary().getBounds().getHeight());
        Scene scene = new Scene(new AnchorPane(pythonSyntaxArea));
        scene.getStylesheets().add(pythonSyntaxArea.getStylesheet());
        primaryStage.setScene(scene);
        primaryStage.setTitle("PythonSyntaxAreaTest");
        primaryStage.setMaximized(true);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}