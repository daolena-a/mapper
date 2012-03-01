package org.sourcecode.builder.data;


public enum KeyWord {
    PACKAGE("package"),IMPORT("import"),
    CLASS("class");
    private final String value;
    public String getValue(){return value;}
    KeyWord(String val){
        value = val;
    }
}
