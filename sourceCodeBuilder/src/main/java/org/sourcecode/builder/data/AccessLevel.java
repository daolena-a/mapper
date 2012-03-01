package org.sourcecode.builder.data;


public enum AccessLevel {
    PRIVATE("private") , PUBLIC("public") , PROTECTED("protected") , DEFAULT(" ");
    private final String value;
    public String getValue(){return value;}
    AccessLevel(String val){
        value = val;
    }

}
