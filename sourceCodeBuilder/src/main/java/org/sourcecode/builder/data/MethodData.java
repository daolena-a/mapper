package org.sourcecode.builder.data;

import org.sourcecode.builder.LineGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class MethodData {
    AccessLevel lvl;
    String returnType;
    List<Params> params;
    String name;
    List<InstructionData> instructions;

    public MethodData(){
        params = new ArrayList<Params>();
        instructions = new ArrayList<InstructionData>();
    }

    public AccessLevel getLvl() {
        return lvl;
    }

    public void setLvl(AccessLevel lvl) {
        this.lvl = lvl;
    }

    public String getReturnType() {
        return returnType;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

    public List<Params> getParams() {
        return params;
    }

    public void setParams(Params... params) {
        this.params = Arrays.asList(params);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<InstructionData> getInstructions() {
        return instructions;
    }

    public void setInstructions(List<InstructionData> instructions) {
        this.instructions = instructions;
    }
    public List<String> toSource(){
        List<String> source = new ArrayList<String>();
        LineGenerator l = new LineGenerator().addKeyWord(getLvl().getValue())
                .addData(getReturnType())
                .addData(getName()).left();
        for(Params p : getParams()){
            l.addData(p.toSource());
        }
        l.right().startBloc();
        source.add(l.toString());
        for(InstructionData instruction : getInstructions()){
            source.add(new LineGenerator().addData(instruction.getSourceCode()).toString());
        }
        source.add(new LineGenerator().endBloc().toString());
        return source;
    }
}
