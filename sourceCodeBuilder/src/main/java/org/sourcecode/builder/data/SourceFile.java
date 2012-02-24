package org.sourcecode.builder.data;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: adrien.daolena
 * Date: 22/02/12
 * Time: 15:34
 * To change this template use File | Settings | File Templates.
 */
public class SourceFile {
    String packageName;
    List<String> imports;
    List<ClassData> classes;



    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public List<String> getImports() {
        return imports;
    }

    public void setImports(List<String> imports) {
        this.imports = imports;
    }

    public List<ClassData> getClasses() {
        return classes;
    }

    public void setClasses(List<ClassData> classes) {
        this.classes = classes;
    }

}
