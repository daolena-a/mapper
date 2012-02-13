package org.mapper.processor;

import org.mapper.annotation.MappedBy;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import java.util.Set;

@SupportedAnnotationTypes(
        "org.mapper.annotation.MappedBy")
@SupportedSourceVersion(SourceVersion.RELEASE_7)
public class MappedByProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        System.out.println("procesor test");
        for (TypeElement t : annotations){
            for(Element elem : roundEnv.getElementsAnnotatedWith(MappedBy.class)){
                System.out.println( elem.asType().toString());
                try {
                    Class clazz = Class.forName(elem.asType().toString());
                    System.out.println(clazz.getCanonicalName());
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }

            }
            
        }
        return true;
    }
}
