package org.mapper.processor.source.data;

/**
 * Created by IntelliJ IDEA.
 * User: adrien.daolena
 * Date: 15/02/12
 * Time: 09:04
 * To change this template use File | Settings | File Templates.
 */
public class TargetField {
    String fieldName;
    String targetFieldName;
    boolean isComplexType;

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getTargetFieldName() {
        return targetFieldName;
    }

    public void setTargetFieldName(String targetFieldName) {
        this.targetFieldName = targetFieldName;
    }

    public boolean isComplexType() {
        return isComplexType;
    }

    public void setComplexType(boolean complexType) {
        isComplexType = complexType;
    }
}
