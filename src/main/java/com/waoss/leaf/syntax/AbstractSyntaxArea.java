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

import com.waoss.leaf.util.Language;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import org.fxmisc.richtext.CodeArea;
import org.fxmisc.richtext.model.StyleSpans;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;


/**
 * @author Rahul Chhabra
 */
public abstract class AbstractSyntaxArea extends CodeArea implements Serializable {

    protected static TreeMap<Language, Class<? extends SyntaxArea>> map;
    protected KeyCodeCombination shiftTab = new KeyCodeCombination(KeyCode.TAB, KeyCodeCombination.SHIFT_DOWN);
    protected List<Long> list = new LinkedList<>();

    public AbstractSyntaxArea() {
        map = new TreeMap<>();
        map.put(Language.JAVA, JavaSyntaxArea.class);
        map.put(Language.C, CSyntaxArea.class);
        map.put(Language.CPP, CppSyntaxArea.class);
        map.put(Language.PYTHON, PythonSyntaxArea.class);
    }

    public static SyntaxArea getSyntaxAreaByLanguage(Language language) throws IllegalAccessException, InstantiationException {
        return map.get(language).newInstance();
    }

    public static void setSyntaxAreaForLanguage(Language language, Class<? extends SyntaxArea> syntaxAreaClass) {
        map.put(language, syntaxAreaClass);
    }

    public abstract StyleSpans<Collection<String>> computeHighlighting(String text);

    public abstract String getStylesheet();

    public void setFontSize(int size) {
        this.setStyle(String.format("-fx-font-size : %d", size));
    }
}
