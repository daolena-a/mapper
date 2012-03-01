package org.sourcecode.builder.data;

import org.sourcecode.builder.LineGenerator;


public class FieldData {
    AccessLevel lvl ;
    String type;
    String name;
    boolean generateGetter;
    boolean generateSetter;

    public boolean isGenerateGetter() {
        return generateGetter;
    }

    public void setGenerateGetter(boolean generateGetter) {
        this.generateGetter = generateGetter;
    }

    public boolean isGenerateSetter() {
        return generateSetter;
    }

    public void setGenerateSetter(boolean generateSetter) {
        this.generateSetter = generateSetter;
    }

    public AccessLevel getLvl() {
        return lvl;
    }

    public void setLvl(AccessLevel lvl) {
        this.lvl = lvl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String toSource(){
        return new LineGenerator().addData(getType()).addData(getName()).toString();
    }
}
