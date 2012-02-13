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
                    File mappingFile = new File(clazz.getSimpleName()+"To"+anno.targetedClass()+".java");
                    mappingFile.createNewFile();
                    System.out.println("tse"+mappingFile.isFile());
                    for (Field f : clazz.getFields()){
                        
                    }
                    System.out.println(clazz.getCanonicalName());
                } catch (Exception e) {
                    e.printStackTrace();  
                }


        }
        return true;
    }
}
