package com.waoss.leaf.syntax;

import java.io.*;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

/**
 * Created by RAHUL on 12-06-2017.
 */
public class SyntaxAreaWriter {

    protected BufferedWriter bufferedWriter;
    protected Writer writer;

    public SyntaxAreaWriter(Writer writer) {
        this.writer = writer;
        this.bufferedWriter = new BufferedWriter(writer);
    }

    public SyntaxAreaWriter(BufferedWriter bufferedWriter) {
        this.bufferedWriter = bufferedWriter;
    }

    public SyntaxAreaWriter(File file) throws IOException {
        this.writer = new OutputStreamWriter(new FileOutputStream(file));
    }

    public void write(SyntaxArea syntaxArea) {
    }
}
