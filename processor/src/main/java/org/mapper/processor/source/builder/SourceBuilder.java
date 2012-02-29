package org.mapper.processor.source.builder;

import org.mapper.annotation.MappedBy;
import org.mapper.annotation.MappedByField;
import org.mapper.processor.source.Source;
import org.mapper.processor.source.builder.api.ISourceBuilder;
import org.mapper.processor.source.data.MappingInformation;
import org.mapper.processor.source.data.TargetField;
import org.mapper.processor.source.tree.ClassTree;
import org.mapper.processor.util.StringUtil;
import org.mapper.processor.writer.ClassWriter;
import org.sourcecode.builder.Builder;
import org.sourcecode.builder.InstructionBuilder;
import org.sourcecode.builder.MethodBuilder;
import org.sourcecode.builder.data.AccessLevel;
import org.sourcecode.builder.data.Params;

import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SourceBuilder<T> {
    ClassTree tree;
    Source source;
    MappingInformation mappingInformation;
    public SourceBuilder(MappingInformation mappingInformation){
        tree = new ClassTree();
        source = new Source();
        tree.addSource(source);
        this.mappingInformation = mappingInformation;
    }
    public void generateSourceCode(){
        //MappedBy anno =(MappedBy) clazz.getAnnotation(MappedBy.class);
        //if(anno == null) return;
//        Source source = new Source();
//        source.addLine("package org.mapper.test.gen;");
//        source.addLine("");
//        source.addLine("import "+clazz.getCanonicalName()+";");
//        source.addLine("import org.mapper.test.gen.*;");
//        source.addLine("import "+anno.targetedClass().getCanonicalName()+";");
//        source.addLine("public class "+clazz.getSimpleName()+"To"+anno.targetedClass().getSimpleName()+"{");
//        source.addLine("public static "+clazz.getSimpleName()+" convert("+anno.targetedClass().getSimpleName()+" value){");
//        source.addLine(clazz.getSimpleName()+" result = new "+clazz.getSimpleName()+"();");
//        MappedByField annoField;
//        for (Field f : clazz.getDeclaredFields()){
//            annoField = (MappedByField) f.getAnnotation(MappedByField.class);
//            System.out.println(f.getClass().getAnnotation(MappedBy.class));
//            if(f.getDeclaringClass().getAnnotation(MappedBy.class) != null){
//                System.out.println("COMPLEX");
//             //   new SourceBuilder().generateSourceCode(f.getDeclaringClass());
//                if(annoField.fieldName() != null && annoField.fieldName().length() > 0)
//                    source.addLine("result.set"+camelCase(f.getName())+"("+f.getDeclaringClass().getSimpleName()+"To"+f.getClass().getAnnotation(MappedBy.class).targetedClass().getSimpleName() +".convert(value.get"+camelCase(annoField.fieldName())+"()));");
//                else source.addLine("result.set"+camelCase(f.getName())+"("+f.getDeclaringClass().getSimpleName()+"To"+f.getClass().getAnnotation(MappedBy.class).targetedClass().getSimpleName() +".convert(value.get"+camelCase(f.getName())+"()));");
//                continue;
//            }
//            if (annoField == null) continue;
//
//            if(annoField.fieldName() != null && annoField.fieldName().length() > 0)
//                source.addLine("result.set"+camelCase(f.getName())+"(value.get"+camelCase(annoField.fieldName())+"());");
//            else{
//                source.addLine("result.set"+camelCase(f.getName())+"(value.get"+camelCase(f.getName())+"());");
//            }
//
//        }
//        source.addLine("return result;}");
//
//        source.addLine("");
//        //reverse
//        source.addLine("public static "+anno.targetedClass().getSimpleName()+" convertReverse("+clazz.getSimpleName()+" value){");
//        source.addLine(anno.targetedClass().getSimpleName()+" result = new "+anno.targetedClass().getSimpleName()+"();");
//        for (Field f : clazz.getDeclaredFields()){
//            annoField = (MappedByField) f.getAnnotation(MappedByField.class);
//            if(f.getDeclaringClass().getAnnotation(MappedBy.class) != null){
//                //new SourceBuilder().generateSourceCode(f.getClass());
//                if(annoField.fieldName() != null && annoField.fieldName().length() > 0)
//                    source.addLine("result.set"+camelCase(f.getName())+"("+f.getDeclaringClass().getSimpleName()+"To"+f.getClass()
//                            .getAnnotation(MappedBy.class).targetedClass().getSimpleName() +".convert(value.get"+
//                            camelCase(annoField.fieldName())+"()));");
//                else source.addLine("result.set"+camelCase(f.getName())+"("+f.getDeclaringClass().getSimpleName()+"To"+f.getClass().getAnnotation(MappedBy.class).targetedClass().getSimpleName() +".convert(value.get"+camelCase(f.getName())+"()));");
//                continue;
//            }
//            if (annoField == null) continue;
//
//            if(annoField.fieldName() != null && annoField.fieldName().length() > 0)
//                source.addLine("result.set"+camelCase(annoField.fieldName())+"(value.get"+camelCase(f.getName())+"());");
//            else{
//                source.addLine("result.set"+camelCase(f.getName())+"(value.get"+camelCase(f.getName())+"());");
//            }
//
//        }
//        source.addLine("return result;}");
//        source.addLine("}");
//
//
//        ClassWriter classWriter = new ClassWriter("./testApp/src/main/java/org/mapper/test/gen/"+clazz.getSimpleName()+"To"+anno.targetedClass().getSimpleName()+".java");
//        classWriter.writeClass(source);
//        //package
//        //import
//        //className
//        //interface?

        generatePackage();
        generateImport();
        emptyLine();
        generateClass();

        MethodBuilder m = new Builder().packageDeclaration(mappingInformation.getPackageName()).importsDeclaration(mappingInformation.getImports())
                .classDeclaration(AccessLevel.PUBLIC, mappingInformation.getReturnedType()+"To"+mappingInformation.getParamType())
                .methodDeclaration(AccessLevel.PUBLIC, mappingInformation.getReturnedType(), "convert",new Params(mappingInformation.getParamType(), "value"))
                    .instruction()
                        .type(mappingInformation.getReturnedType()).equals().object("res").end();

        for(TargetField field : mappingInformation.getMapping()){
            m.instruction().object("res").call("set"+field.getFieldName()).open().object("value").call("get"+field.getTargetFieldName());
        }
        m.close().close();

        new ClassWriter("./"+mappingInformation.getModuleName()+"/src/main/java/"+convertToFilePathPackageName(mappingInformation.getPackageName())+"/"+mappingInformation.getClassName()+".java").writeClass(source);
       // source.addLine("public class "+clazz.getSimpleName()+"To"+anno.targetedClass().getSimpleName()+"{");
        //source.addLine("public static "+clazz.getSimpleName()+" convert("+anno.targetedClass().getSimpleName()+" value){");
        //source.addLine(clazz.getSimpleName()+" result = new "+clazz.getSimpleName()+"();");
    }



    private void generateImport( ){
        //TODO check import validity
        for(String s : mappingInformation.getImports()){
            source.addLine("import "+s+".*;");

        }
    }
    private void generatePackage (){
        source.addLine("package "+mappingInformation.getPackageName()+";");
    }
    private void emptyLine(){
        source.addLine("");
    }
    private void startCodeBloc(){
        source.addLine("{");
    }
    private void endCodeBloc(){
        source.addLine("}");
    }
    private void generateClass(){
        source.addLine("public class "+mappingInformation.getReturnedType()+"To"+mappingInformation.getParamType());
        startCodeBloc();
        generateMethod();
        endCodeBloc();

    }
    private void generateMethod(){
        source.addLine("public static "+mappingInformation.getReturnedType()+" convert("+mappingInformation.getParamType()+" value)");
        startCodeBloc();
        generateInstantiation();
        for(TargetField field : mappingInformation.getMapping()){
            generateSetter(field);
        }
        endCodeBloc();
    }
    private void generateInstantiation(){
        String instantiation=""+mappingInformation.getReturnedType()+" res = new "+mappingInformation.getReturnedType()+"();";
        source.addLine(instantiation);
    }
    private void generateSetter(TargetField field){
       // String setter = new InstructionBuilder().object("res").call("set"+StringUtil.upperCaseFirstLetter(field.getFieldName()))
         //       .open().object("value").call("get" + StringUtil.upperCaseFirstLetter(field.getTargetFieldName())).open().close().close().end();
       // String setter = "res.set"+ StringUtil.upperCaseFirstLetter(field.getFieldName())+"(value.get"+StringUtil.upperCaseFirstLetter(field.getTargetFieldName())+"());";

       // source.addLine(setter);
    }
    private String convertToFilePathPackageName(String packageName){
        return packageName.replace(".","/");
    }
}
