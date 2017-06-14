package com.waoss.leaf.syntax;

import com.google.gson.Gson;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyEvent;

import org.fxmisc.richtext.CodeArea;
import org.fxmisc.richtext.LineNumberFactory;
import org.fxmisc.richtext.model.StyleSpans;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Rahul Chhabra
 */
public abstract class SyntaxArea extends CodeArea implements Serializable {

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

    protected KeyCodeCombination shiftTab = new KeyCodeCombination(KeyCode.TAB, KeyCodeCombination.SHIFT_DOWN);
    protected List<Long> list = new LinkedList<>();

    public SyntaxArea() {
        this.setParagraphGraphicFactory(LineNumberFactory.get(this));
        this.richChanges().filter(change -> !change.getInserted().equals(change.getRemoved())).subscribe(change -> this.setStyleSpans(0, computeHighlighting(this.getText())));
        this.setKeyEvents();
    }

    public abstract StyleSpans<Collection<String>> computeHighlighting(String text);

    public abstract String getStylesheet();

    public void setFontSize(int size) {
        this.setStyle(String.format("-fx-font-size : %d", size));
    }

    protected void setKeyEvents() {
        this.addEventHandler(KeyEvent.KEY_PRESSED, key -> {
            int paragraph = this.getCurrentParagraph();
            String textAtParagraph = this.getText(paragraph);
            long j = 0;
            for (int i = 0; textAtParagraph.charAt(i) == '\t'; i++) {
                list.add(paragraph, j++);
            }
            if (key.getCode() == KeyCode.ENTER) {
                String tabs = "";
                for (int i = 0; i < list.get(this.getCurrentParagraph()); i++) {
                    tabs += '\t';
                }
                this.appendText(tabs);
            }
        });
    }
}
