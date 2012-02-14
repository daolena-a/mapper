package org.mapper.processor;

import org.mapper.annotation.MappedBy;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import java.io.File;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.Set;

@SupportedAnnotationTypes(
        "org.mapper.annotation.MappedBy")
@SupportedSourceVersion(SourceVersion.RELEASE_7)
public class MappedByProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        System.out.println("procesor test");
            MappedBy anno;
            for(Element elem : roundEnv.getElementsAnnotatedWith(MappedBy.class)){
                System.out.println( elem.asType().toString());
                try {

                    Class clazz = Class.forName(elem.asType().toString());
                    System.out.println("name"+clazz.getCanonicalName());
                    anno =(MappedBy) clazz.getAnnotation(MappedBy.class);
                    if(anno == null) break;
                    File mappingFile = new File(clazz.getSimpleName()+"To"+anno.targetedClass().getSimpleName()+".java");
                    if(mappingFile.exists()){
                        mappingFile.delete();
                    }
                    mappingFile.createNewFile();
                    PrintWriter writer = new PrintWriter(mappingFile);
                    writer.println("package org.mapper.gen");
                    writer.println();
                    writer.println("import "+clazz.getCanonicalName()+";");
                    writer.println("import "+anno.targetedClass()+";");
                    writer.println("public class "+clazz.getSimpleName()+"To"+anno.targetedClass().getSimpleName()+"{");
                    for (Field f : clazz.getFields()){

                    }
                    writer.println("}");
                    writer.flush();
                    //package
                    //import
                    //className
                    //interface?
                    System.out.println("tse"+mappingFile.isFile());

                    System.out.println(clazz.getCanonicalName());
                } catch (Exception e) {
                    e.printStackTrace();  
                }


        }
        return true;
    }
}
