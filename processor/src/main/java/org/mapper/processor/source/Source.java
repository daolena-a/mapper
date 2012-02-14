package org.mapper.processor.source;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: adrien.daolena
 * Date: 14/02/12
 * Time: 14:07
 * To change this template use File | Settings | File Templates.
 */
public class Source {
    List<String> sourceCode;
    public Source(){
        sourceCode = new ArrayList<String>();
    }
    public void addLine(String line){
        sourceCode.add(line);
    }
    public List<String> getSourceCode(){
        return Collections.unmodifiableList(sourceCode);
    }
}
