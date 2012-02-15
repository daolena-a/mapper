package org.mapper.processor.util;

/**
 * Created by IntelliJ IDEA.
 * User: adrien.daolena
 * Date: 15/02/12
 * Time: 14:12
 * To change this template use File | Settings | File Templates.
 */
public class StringUtil {
    public static String upperCaseFirstLetter(String value){
        return  value.substring(0,1).toUpperCase() + value.substring(1);
    }
}
