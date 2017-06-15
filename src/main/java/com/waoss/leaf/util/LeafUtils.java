/*
 *  Copyright (c) Waoss
 *
 *  Mail me at rahul29112002@gmail.com for any queries :)
 *
 *  This is free software licensed under the GNU General Public License.This license allows one to modify it on their will and also embed it or distribute it along with their own software.
 *  It is distributed in the hope that it shall be useful to whomsoever receives it,but does not provide ANY warranty or liability,not even the gurantee that the software will work in your certain usage.
 *  You receive a copy of the GNU General Public License version 3.0 when you download this software.See LICENSE.MD for more details.
 */

package com.waoss.leaf.util;

import com.waoss.leaf.syntax.AbstractSyntaxArea;
import com.waoss.leaf.syntax.PlaintextSyntaxArea;

import java.io.File;

public class LeafUtils {
    public static AbstractSyntaxArea getSyntaxArea(File file) {
        String string = file.toString();
        AbstractSyntaxArea abstractSyntaxArea;
        try {
            abstractSyntaxArea = AbstractSyntaxArea.getSyntaxAreaByLanguage(Language.valueOf(string.substring(string.lastIndexOf("."), string.length() - 1)));
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException e) {
            return new PlaintextSyntaxArea();
        }
        return abstractSyntaxArea;
    }
}
