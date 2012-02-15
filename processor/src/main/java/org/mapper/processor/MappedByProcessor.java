package org.mapper.processor;

import org.mapper.annotation.GenerationLauncher;
import org.mapper.annotation.MappedBy;
import org.mapper.annotation.MappedByField;
import org.mapper.processor.source.builder.SourceBuilder;
import org.mapper.processor.writer.ClassWriter;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.management.RuntimeErrorException;
import java.io.File;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.util.Set;

@SupportedAnnotationTypes(
        "org.mapper.annotation.GenerationLauncher")
@SupportedSourceVersion(SourceVersion.RELEASE_7)
public class MappedByProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        MappedBy anno;
        ClassWriter classWriter;
        System.out.println("processor");

        for(Element elem : roundEnv.getElementsAnnotatedWith(GenerationLauncher.class)){
            Class<?> clazz = null;

            //elem.asType().
            try{
                clazz = Class.forName(elem.getAnnotation(GenerationLauncher.class).classToBeMapped()[0]);
                System.out.println(clazz.getCanonicalName()+clazz.getDeclaredFields().length);

            }catch(Exception e){e.printStackTrace();}
//            try {
//                System.out.println(elem.asType().toString());
//                clazz = Class.forName(elem.asType().toString());
//                System.out.println("got class");
//                SourceBuilder builder = new SourceBuilder();
//                builder.generateSourceCode(clazz);
//            } catch (ClassNotFoundException e) {
//                e.printStackTrace();
//            }

        }
        return true;
    }


}
