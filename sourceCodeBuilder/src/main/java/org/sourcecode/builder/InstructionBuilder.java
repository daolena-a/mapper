package org.sourcecode.builder;

import org.sourcecode.builder.data.InstructionData;
import org.sourcecode.builder.data.Params;

/**
 * Created by IntelliJ IDEA.
 * User: adrien.daolena
 * Date: 23/02/12
 * Time: 17:03
 * To change this template use File | Settings | File Templates.
 */
public class InstructionBuilder {
    StringBuilder instruction;
    MethodBuilder builder;

    public InstructionBuilder(MethodBuilder builder) {
        instruction = new StringBuilder();
        this.builder = builder;
    }

    public MethodBuilder getBuilder() {
        return builder;
    }

    public void setBuilder(MethodBuilder builder) {
        this.builder = builder;
    }

    public InstructionBuilder call(String methodName){
        instruction.append(".").append(methodName);
        return this;
    }
    public InstructionBuilder type(String type){
        instruction.append(type);
        return this;
    }
    public InstructionBuilder returnKeyWord(){
        instruction.append(" return ");
        return this;
    }
    public InstructionBuilder equals (){
        instruction.append(" = ");
        return this;
    }
    public InstructionBuilder left(){
        instruction.append("(");
        return this;
    }
    public InstructionBuilder right(){
        instruction.append(")");
        return this;
    }
    public MethodBuilder end(){
        instruction.append(";");
        builder.getMethod().getInstructions().add(new InstructionData(instruction.toString()));

        return builder;
    }
    public InstructionBuilder newKeyWord(){
        instruction.append(" ").append("new").append(" ");
        return this;
    }
    public InstructionBuilder object(String objectName){
        instruction.append(" ").append(objectName);
        return this;
    }
    public InstructionBuilder param(Params... params){
        for(Params p : params){
            instruction.append(p.getType()).append(" ").append(p.getVal());
        }
        return this;
    }
}
