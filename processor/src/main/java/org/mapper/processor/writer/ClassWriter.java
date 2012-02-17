package org.mapper.processor.writer;

import org.mapper.processor.source.Source;

import java.io.*;
import java.util.List;


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
            sourceFile.getParentFile().mkdirs();
            sourceFile.createNewFile();

           // dir.mkdirs();
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
