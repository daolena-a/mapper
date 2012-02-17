package org.mapper.processor.source.data;

import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: adrien.daolena
 * Date: 14/02/12
 * Time: 18:33
 * To change this template use File | Settings | File Templates.
 */
public class MappingInformation {
    List<TargetField> mapping; //list of mapping between field
    List<String> imports; //  imports for the java file
    String className; // Name of the java File generated
    String packageName; // name of the package
    String returnedType; // Type convert(ParamType paramType)
    String paramType;
    String moduleName;

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getReturnedType() {
        return returnedType;
    }

    public void setReturnedType(String returnedType) {
        this.returnedType = returnedType;
    }

    public String getParamType() {
        return paramType;
    }

    public void setParamType(String paramType) {
        this.paramType = paramType;
    }

    public List<TargetField> getMapping() {
        return mapping;
    }

    public void setMapping(List<TargetField> mapping) {
        this.mapping = mapping;
    }

    public List<String> getImports() {
        return imports;
    }

    public void setImports(List<String> imports) {
        this.imports = imports;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }
}
