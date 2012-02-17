package org.mapper.processor.util;


public class StringUtil {
    public static String upperCaseFirstLetter(String value){
        return  value.substring(0,1).toUpperCase() + value.substring(1);
    }
}
