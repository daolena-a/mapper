package org.sourcecode.builder.data;

/**
 * Created by IntelliJ IDEA.
 * User: adrien.daolena
 * Date: 29/02/12
 * Time: 11:19
 * To change this template use File | Settings | File Templates.
 */
public enum KeyWord {
    PACKAGE("package"),IMPORT("import"),
    CLASS("class");
    private final String value;
    public String getValue(){return value;}
    KeyWord(String val){
        value = val;
    }
}
