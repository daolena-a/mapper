package org.mapper.processor.source;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class Source {
    List<String> sourceCode;
    public Source(){
        sourceCode = new ArrayList<String>();
    }
    public Source(List<String> source){
        sourceCode = new ArrayList<String>();
    }
    public void addLine(String line){
        sourceCode.add(line);
    }
    public List<String> getSourceCode(){
        return sourceCode;
        //return Collections.unmodifiableList(sourceCode);
    }
}
