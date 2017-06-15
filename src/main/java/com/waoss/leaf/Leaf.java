
/*
 *  Copyright (c) Waoss
 *
 *  Mail me at rahul29112002@gmail.com for any queries :)
 *
 *  This is free software licensed under the GNU General Public License.This license allows one to modify it on their will and also embed it or distribute it along with their own software.
 *  It is distributed in the hope that it shall be useful to whomsoever receives it,but does not provide ANY warranty or liability,not even the gurantee that the software will work in your certain usage.
 *  You receive a copy of the GNU General Public License version 3.0 when you download this software.See LICENSE.MD for more details.
 */

package com.waoss.leaf;

import javafx.application.Application;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Leaf extends Application {

    protected static Leaf instance;
    protected SimpleObjectProperty<Stage> stage = new SimpleObjectProperty<>(this, "stage");

    public static Leaf getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        launch(args);
    }

    public Stage getStage() {
        return stage.get();
    }

    public void setStage(Stage stage) {
        this.stage.set(stage);
    }

    public SimpleObjectProperty<Stage> stageProperty() {
        return stage;
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        instance = this;
        stage.set(primaryStage);
        stage.get().setTitle("Leaf");
        stage.get().setScene(new Scene(FXMLLoader.load(getClass().getResource("/com/waoss/leaf/Leaf.fxml"))));
        stage.get().getScene().getStylesheets().add(getClass().getResource("/com/waoss/leaf/syntax/default.css").toExternalForm());
        stage.get().getIcons().add(new Image(getClass().getResourceAsStream("/com/waoss/leaf/Leaf.jpg")));
        stage.get().setMaximized(true);
        stage.get().show();
    }
}
