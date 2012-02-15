package org.mapper.processor.writer;

import org.mapper.processor.source.Source;

import java.io.*;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: adrien.daolena
 * Date: 14/02/12
 * Time: 13:50
 * To change this template use File | Settings | File Templates.
 */
public class ClassWriter {
    private File sourceFile;
    private PrintWriter writer;
    public ClassWriter(String path){
        sourceFile = new File(path);
        initIOObject();

    }
    private void initIOObject(){
        try {
            if(sourceFile.exists()){
                sourceFile.delete();
            }
            sourceFile.createNewFile();
            writer = new PrintWriter(sourceFile);
        } catch (IOException io) {
            throw new IllegalArgumentException(io);
        }
    }
    public final void writeClass(Source source){
        for (String line : source.getSourceCode()){
            writer.println(line);
        }
        writer.flush();


    }
}