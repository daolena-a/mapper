package org.sourcecode.builder;

import org.sourcecode.builder.data.Params;

import java.util.List;


public class LineGenerator {
    StringBuilder line;
    public LineGenerator(){
        line = new StringBuilder();
    }
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
    public LineGenerator addData(String word){
        line.append(" ").append(word);
        return this;
    }
    public LineGenerator param(List<Params> param){
        for(Params p : param){
            addKeyWord(p.getType()).addKeyWord(p.getVal());
        }
        return this;
    }
    public LineGenerator semicolon(){
         line.append(";");
        return this;

    }
    public LineGenerator startBloc(){
        line.append("{");
        return this;
    }
    public LineGenerator endBloc(){
        line.append("}");
        return this;
    }

    @Override
    public String toString() {
        return  line.toString() ;
    }
}
