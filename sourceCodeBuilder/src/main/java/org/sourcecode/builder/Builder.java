package org.sourcecode.builder;

import org.sourcecode.builder.data.*;

import java.util.ArrayList;
import java.util.List;


public class Builder { //implements IBuilder {
    SourceFile sourceFile;

    public Builder(){
        sourceFile = new SourceFile();
    }
    public ClassBuilder classDeclaration(AccessLevel l , String name){
        ClassData data = new ClassData(l,name);
        sourceFile.getClasses().add(data);
        ClassBuilder builder = new ClassBuilder(data,this);
        return builder;
    }


    public Builder importsDeclaration (List<String> imports){
        sourceFile.getImports().addAll(imports);
        return this;
    }
    public Builder importDeclaration (String importValue){
        sourceFile.getImports().add(importValue);
        return this;
    }
    public Builder packageDeclaration (String packageName){
        sourceFile.setPackageName(packageName);
        return this;
    }
    
    public List<String> generateSource(){
        return sourceFile.toSource();
    }


}

