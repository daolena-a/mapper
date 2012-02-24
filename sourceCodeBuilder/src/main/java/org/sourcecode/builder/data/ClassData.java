package org.sourcecode.builder.data;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: adrien.daolena
 * Date: 24/02/12
 * Time: 15:20
 * To change this template use File | Settings | File Templates.
 */
public class ClassData {
    AccessLevel lvl;
    String name;
    List<FieldData> fields;
    List<MethodData> methods;

    public ClassData(AccessLevel lvl, String name) {
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
}
