package org.mapper.processor.source.builder;

import org.mapper.annotation.MappedBy;
import org.mapper.annotation.MappedByField;
import org.mapper.processor.source.Source;
import org.mapper.processor.source.tree.ClassTree;
import org.mapper.processor.writer.ClassWriter;

import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: adrien.daolena
 * Date: 14/02/12
 * Time: 14:03
 * To change this template use File | Settings | File Templates.
 */
public class SourceBuilder<T> {
    ClassTree tree;
    public SourceBuilder(){
        tree = new ClassTree();
    }
    public void generateSourceCode(Class<T> clazz){
        MappedBy anno =(MappedBy) clazz.getAnnotation(MappedBy.class);
        if(anno == null) return;
        Source source = new Source();
        source.addLine("package org.mapper.test.gen;");
        source.addLine("");
        source.addLine("import "+clazz.getCanonicalName()+";");
        source.addLine("import org.mapper.test.gen.*;");
        source.addLine("import "+anno.targetedClass().getCanonicalName()+";");
        source.addLine("public class "+clazz.getSimpleName()+"To"+anno.targetedClass().getSimpleName()+"{");
        source.addLine("public static "+clazz.getSimpleName()+" convert("+anno.targetedClass().getSimpleName()+" value){");
        source.addLine(clazz.getSimpleName()+" result = new "+clazz.getSimpleName()+"();");
        MappedByField annoField;
        for (Field f : clazz.getDeclaredFields()){
            annoField = (MappedByField) f.getAnnotation(MappedByField.class);
            if(f.getClass().getAnnotation(MappedBy.class) != null){
                new SourceBuilder().generateSourceCode(f.getClass());
                if(annoField.fieldName() != null && annoField.fieldName().length() > 0)
                    source.addLine("result.set"+camelCase(f.getName())+"("+f.getClass().getSimpleName()+"To"+f.getClass().getAnnotation(MappedBy.class).targetedClass().getSimpleName() +".convert(value.get"+camelCase(annoField.fieldName())+"()));");
                else source.addLine("result.set"+camelCase(f.getName())+"("+f.getClass().getSimpleName()+"To"+f.getClass().getAnnotation(MappedBy.class).targetedClass().getSimpleName() +".convert(value.get"+camelCase(f.getName())+"()));");
                continue;
            }
            if (annoField == null) continue;

            if(annoField.fieldName() != null && annoField.fieldName().length() > 0)
                source.addLine("result.set"+camelCase(f.getName())+"(value.get"+camelCase(annoField.fieldName())+"());");
            else{
                source.addLine("result.set"+camelCase(f.getName())+"(value.get"+camelCase(f.getName())+"());");
            }

        }
        source.addLine("return result;}");

        source.addLine("");
        //reverse
        source.addLine("public static "+anno.targetedClass().getSimpleName()+" convertReverse("+clazz.getSimpleName()+" value){");
        source.addLine(anno.targetedClass().getSimpleName()+" result = new "+anno.targetedClass().getSimpleName()+"();");
        for (Field f : clazz.getDeclaredFields()){
            annoField = (MappedByField) f.getAnnotation(MappedByField.class);
            if(f.getClass().getAnnotation(MappedBy.class) != null){
                new SourceBuilder().generateSourceCode(f.getClass());
                if(annoField.fieldName() != null && annoField.fieldName().length() > 0)
                    source.addLine("result.set"+camelCase(f.getName())+"("+f.getClass().getSimpleName()+"To"+f.getClass()
                            .getAnnotation(MappedBy.class).targetedClass().getSimpleName() +".convert(value.get"+
                            camelCase(annoField.fieldName())+"()));");
                else source.addLine("result.set"+camelCase(f.getName())+"("+f.getClass().getSimpleName()+"To"+f.getClass().getAnnotation(MappedBy.class).targetedClass().getSimpleName() +".convert(value.get"+camelCase(f.getName())+"()));");
                continue;
            }
            if (annoField == null) continue;

            if(annoField.fieldName() != null && annoField.fieldName().length() > 0)
                source.addLine("result.set"+camelCase(annoField.fieldName())+"(value.get"+camelCase(f.getName())+"());");
            else{
                source.addLine("result.set"+camelCase(f.getName())+"(value.get"+camelCase(f.getName())+"());");
            }

        }
        source.addLine("return result;}");
        source.addLine("}");
        
        
        ClassWriter classWriter = new ClassWriter("./testApp/src/main/java/org/mapper/test/gen/"+clazz.getSimpleName()+"To"+anno.targetedClass().getSimpleName()+".java");
        classWriter.writeClass(source);
        //package
        //import
        //className
        //interface?
    }


    private String camelCase(String value){
        return  value.substring(0,1).toUpperCase() + value.substring(1);

    }
}
