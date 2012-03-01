package org.sourcecode.builder;


import org.sourcecode.builder.data.SourceFile;
import org.sourcecode.builder.data.InstructionData;
import org.sourcecode.builder.data.MethodData;

import java.util.List;


public class SourceGenerator {
    List<String> sources;
    private static String SPACE = " ";
    private static String LEFT = "(";
    public void generateSource(SourceFile data){
        
    }
    private SourceGenerator startBloc(){
        sources.add("{");
        return this;
    }
    private SourceGenerator endBloc(){
        sources.add("}");
        return this;
    
    }
    private SourceGenerator addAll(List<String> bodyLines){
        sources.addAll(bodyLines);
        return this;
    }
    private SourceGenerator generateMethod(MethodData data){
        generateMethodSignature(data)
                .startBloc()
                .generateInstructions(data.getInstructions())
                .endBloc();
                return this;
    }
    private SourceGenerator generateInstructions(List<InstructionData> instructions){
        for(InstructionData i : instructions){
            sources.add(i.getSourceCode());
        }
        return this;
    }
    private SourceGenerator generateMethodSignature(MethodData method){
       LineGenerator line = new LineGenerator();
        line.addKeyWord(method.getLvl().getValue())
                .addKeyWord(method.getReturnType())
                .addKeyWord(method.getName()).left().param(method.getParams()).right();
        sources.add(line.toString());
        return this;
                
    }

    @Override
    public String toString() {
        return "SourceGenerator{" +
                "sources=" + sources +
                '}';
    }
}
