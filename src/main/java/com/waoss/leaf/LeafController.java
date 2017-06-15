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

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import org.apache.commons.io.IOUtils;
import org.fxmisc.richtext.CodeArea;

import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.util.ResourceBundle;

public class LeafController implements Initializable {

    @FXML
    CodeArea codeArea;
    @FXML
    AnchorPane anchorPane;
    @FXML
    MenuItem fileOpen;
    @FXML
    MenuItem fileNew;
    @FXML
    MenuItem fileClose;

    FileChooser fileChooser;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fileChooser = new FileChooser();
    }

    @FXML
    public void fileCloseOnAction(ActionEvent actionEvent) {
        System.exit(0);
    }

    @FXML
    public void fileNewOnAction(ActionEvent actionEvent) {

    }

    @FXML
    public void fileOpenOnAction(ActionEvent actionEvent) throws Exception {
        File file = fileChooser.showOpenDialog(Leaf.getInstance().getStage());
        codeArea.replaceText(0, 0, IOUtils.toString(new FileReader(file)));
    }
}
