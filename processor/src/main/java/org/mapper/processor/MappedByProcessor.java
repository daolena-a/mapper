package org.mapper.processor;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: adrien.daolena
 * Date: 08/02/12
 * Time: 09:33
 * To change this template use File | Settings | File Templates.
 */
@SupportedAnnotationTypes(
        "org.mapper.annotation.MappedBy")
@SupportedSourceVersion(SourceVersion.RELEASE_7)
public class MappedByProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        System.out.println("procesor test");

        return true;
    }
}
