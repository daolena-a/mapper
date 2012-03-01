package org.sourcecode.builder.data;

import org.sourcecode.builder.LineGenerator;

import java.util.ArrayList;
import java.util.List;


public class Params {
    String type;
    String val;
    public Params(String type, String val){
        this.type = type;
        this.val = val;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }
    public String toSource(){

        return new LineGenerator().addData(type).space().addData(val).toString();

    }
}
