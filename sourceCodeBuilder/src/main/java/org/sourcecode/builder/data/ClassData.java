package org.sourcecode.builder.data;

import org.sourcecode.builder.LineGenerator;

import java.util.ArrayList;
import java.util.List;


public class ClassData {
    AccessLevel lvl;
    String name;
    List<FieldData> fields;
    List<MethodData> methods;

    public ClassData(){
        fields = new ArrayList<FieldData>();
        methods = new ArrayList<MethodData>();
    }

    public ClassData(AccessLevel lvl, String name) {
        this();
        this.lvl = lvl;
        this.name = name;
    }

    public AccessLevel getLvl() {
        return lvl;
    }

    public void setLvl(AccessLevel lvl) {
        this.lvl = lvl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<FieldData> getFields() {
        return fields;
    }

    public void setFields(List<FieldData> fields) {
        this.fields = fields;
    }

    public List<MethodData> getMethods() {
        return methods;
    }

    public void setMethods(List<MethodData> methods) {
        this.methods = methods;
    }
    public List<String> toSource(){
        List<String> sources = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        sources.add(new LineGenerator().addKeyWord(getLvl().getValue()).addKeyWord("class").addData(getName()).startBloc().toString());
        for(FieldData m : getFields()){
            sources.add(m.toSource());
        }
        for(MethodData m : getMethods()){
            sources.addAll(m.toSource());
        }
        sources.add(new LineGenerator().endBloc().toString());
        return sources;
    }
}
