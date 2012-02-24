package org.sourcecode.builder.data;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: adrien.daolena
 * Date: 22/02/12
 * Time: 15:35
 * To change this template use File | Settings | File Templates.
 */
public class MethodData {
    AccessLevel lvl;
    String returnType;
    List<Params> params;
    String name;
    List<String> instructions;

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

    public List<String> getInstructions() {
        return instructions;
    }

    public void setInstructions(List<String> instructions) {
        this.instructions = instructions;
    }
}
