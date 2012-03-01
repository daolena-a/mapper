package org.sourcecode.builder.data;

import org.sourcecode.builder.LineGenerator;

import java.util.ArrayList;
import java.util.List;


public class SourceFile {
    String packageName;
    List<String> imports;
    List<ClassData> classes;
    public SourceFile(){
        imports = new ArrayList<String>();
        classes = new ArrayList<ClassData>();
    }


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
    public List<String> toSource(){
        List<String> source = new ArrayList<String>();

        source.add(new LineGenerator().addKeyWord("package").space().value(getPackageName()).semicolon().toString());
        for(String s : getImports()){
            source.add( new LineGenerator().addKeyWord("import").addData(s).semicolon().toString());
        }
        for(ClassData clazz : getClasses()){
            source.addAll(clazz.toSource());
        }
        return source;
    }

}
