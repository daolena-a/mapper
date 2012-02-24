package org.sourcecode.builder;

import org.sourcecode.builder.data.*;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: adrien.daolena
 * Date: 24/02/12
 * Time: 15:50
 * To change this template use File | Settings | File Templates.
 */
public class ClassBuilder {
    ClassData clazzData;
    Builder builder;

    public ClassBuilder(ClassData clazzData, Builder builder) {
        this.clazzData = clazzData;
        this.builder = builder;
    }

    public ClassData getData() {
        return clazzData;
    }

    public void setData(ClassData data) {
        this.clazzData = data;
    }

    public Builder getBuilder() {
        return builder;
    }

    public void setBuilder(Builder builder) {
        this.builder = builder;
    }
    public MethodBuilder methodDeclaration(AccessLevel l, String returnedType, String name, Params... param ) {
        MethodData data =  new MethodData();
        data.setParams(param);
        data.setLvl(l);
        data.setName(name);
        data.setReturnType(returnedType);

        clazzData.getMethods().add(data);
        MethodBuilder m = new MethodBuilder(data,this);
        return m;
    }
    public ClassBuilder fieldDeclaration(AccessLevel lvl, String type, String name, boolean generateGetter, boolean generateSetter) {
        FieldData field = new FieldData();
        field.setLvl(lvl);
        field.setName(name);
        field.setType(type);
        field.setGenerateGetter(generateGetter);
        field.setGenerateSetter(generateSetter);
        clazzData.getFields().add(field);
        return this;
    }

    public Builder close(){
        return builder;
    }
}
