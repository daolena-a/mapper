package org.sourcecode.builder.data;

/**
 * Created by IntelliJ IDEA.
 * User: adrien.daolena
 * Date: 22/02/12
 * Time: 13:56
 * To change this template use File | Settings | File Templates.
 */
public enum AccessLevel {
    PRIVATE("private") , PUBLIC("public") , PROTECTED("protected") , DEFAULT(" ");
    private final String value;
    public String getValue(){return value;}
    AccessLevel(String val){
        value = val;
    }

}
