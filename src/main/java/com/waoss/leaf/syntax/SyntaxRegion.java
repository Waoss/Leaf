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

import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.layout.Region;

import java.io.File;

public class SyntaxRegion extends Region {

    protected SimpleObjectProperty<SyntaxArea> syntaxArea = new SimpleObjectProperty<>(this, "syntaxArea");
    protected SimpleObjectProperty<File> file = new SimpleObjectProperty<>(this, "file");

    public SyntaxRegion(SimpleObjectProperty<SyntaxArea> syntaxArea, SimpleObjectProperty<File> file) {
        this.syntaxArea = syntaxArea;
        this.file = file;
    }

    public SyntaxRegion(SimpleObjectProperty<File> file) {
        this.file = file;
    }

    public SyntaxRegion(SyntaxArea syntaxArea) {

        this.setSyntaxArea(syntaxArea);
        this.getChildren().add(syntaxArea);
    }

    public SyntaxArea getSyntaxArea() {
        return syntaxArea.get();
    }

    public void setSyntaxArea(SyntaxArea syntaxArea) {
        this.syntaxArea.set(syntaxArea);
    }

    public SimpleObjectProperty<SyntaxArea> syntaxAreaProperty() {
        return syntaxArea;
    }

    public File getFile() {
        return file.get();
    }

    public void setFile(File file) {
        this.file.set(file);
    }

    public SimpleObjectProperty<File> fileProperty() {
        return file;
    }
}
