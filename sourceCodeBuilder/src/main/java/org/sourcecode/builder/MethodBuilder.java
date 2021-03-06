package org.sourcecode.builder;

import org.sourcecode.builder.data.InstructionData;
import org.sourcecode.builder.data.MethodData;
import org.sourcecode.builder.data.Params;

import java.util.ArrayList;
import java.util.List;


public class MethodBuilder {
    MethodData method;
    ClassBuilder builder;

    public MethodData getMethod() {
        return method;
    }

    public void setMethod(MethodData method) {
        this.method = method;
    }

    public MethodBuilder(MethodData method,ClassBuilder builder){
        this.builder =builder ;

        this.method = method;
    }
//    public MethodBuilder instruction(String line){
//        method.getInstructions().add(line);
//        return this;
//    }
    public ClassBuilder close(){

        return builder;
    }
    public InstructionBuilder instruction(){

        return new InstructionBuilder(this);
    }

}
