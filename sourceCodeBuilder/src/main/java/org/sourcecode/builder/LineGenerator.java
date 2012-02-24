package org.sourcecode.builder;

import org.sourcecode.builder.data.Params;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: adrien.daolena
 * Date: 22/02/12
 * Time: 18:24
 * To change this template use File | Settings | File Templates.
 */
public class LineGenerator {
    StringBuilder line;

    public LineGenerator left(){
        line.append("(");
        return this;
    }
    public LineGenerator right(){
        line.append(")");
        return this;
    }
    public LineGenerator space(){
        line.append(" ");
        return this;
    }
    public LineGenerator value(String value){
        line.append(value);
        return this;
    }
    public LineGenerator addKeyWord(String word){
        line.append(" ").append(word);
        return this;
    }
    public LineGenerator param(List<Params> param){
        for(Params p : param){
            addKeyWord(p.getType()).addKeyWord(p.getVal());
        }
        return this;
    }
    public String end(){
        return line.append(";").toString();

    }

    @Override
    public String toString() {
        return  line.toString() ;
    }
}
