package org.mapper.processor;

import org.mapper.annotation.GenerationLauncher;
import org.mapper.annotation.MappedBy;
import org.mapper.annotation.MappedByField;
import org.mapper.processor.source.builder.SourceBuilder;
import org.mapper.processor.source.data.MappingInformation;
import org.mapper.processor.source.data.TargetField;
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
import java.util.ArrayList;
import java.util.List;
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
            Class<?> targetClazz = null;
            //elem.asType().
            try{
                clazz = Class.forName(elem.getAnnotation(GenerationLauncher.class).classToBeMapped()[0]);
                anno = clazz.getAnnotation(MappedBy.class);
                anno.targetedClass();

                //getMapping
                MappingInformation mappingInformation = new MappingInformation();
                mappingInformation.setClassName(clazz.getSimpleName()+"To"+anno.targetedClass().getSimpleName());
                mappingInformation.setPackageName(elem.getAnnotation(GenerationLauncher.class).packageName());
                mappingInformation.setReturnedType(clazz.getSimpleName());
                mappingInformation.setParamType(anno.targetedClass().getSimpleName());
                mappingInformation.setModuleName("testApp");

                List<String> imports = new ArrayList<String>();
                imports.add(clazz.getPackage().getName()+"."+clazz.getSimpleName());
                imports.add(anno.targetedClass().getPackage().getName()+"."+anno.targetedClass().getSimpleName());

                //getImport for clazz
                for(Field f : clazz.getDeclaredFields()){
                    if(f.getClass().getPackage().getName().startsWith("java.lang") == false){
                        imports.add(f.getClass().getPackage().getName());
                    }
                }
                //get import for targetClazz
                for(Field f :  anno.targetedClass().getDeclaredFields()){
                    if(f.getClass().getPackage().getName().startsWith("java.lang") == false){
                        imports.add(f.getClass().getPackage().getName());
                    }
                }
                mappingInformation.setImports(imports);
                List<TargetField> targetFields = new ArrayList<TargetField>();
                for (Field f : clazz.getDeclaredFields()){
                    MappedByField annoField = (MappedByField) f.getAnnotation(MappedByField.class);
                    if (annoField == null) continue;
                    if(f.getDeclaringClass().getAnnotation(MappedBy.class) != null){
                        //new SourceBuilder().generateSourceCode(f.getClass());
                        TargetField fields = new TargetField();
                        boolean isComplex = !f.getClass().getPackage().getName().startsWith("java");
                        fields.setComplexType(isComplex);
                        fields.setFieldName(f.getName());
                        if(annoField.fieldName() != null && annoField.fieldName().length() > 0){
                            fields.setTargetFieldName(annoField.fieldName());
                        }
                        else{
                            fields.setTargetFieldName(f.getName());
                        }

                        targetFields.add(fields);
                    }
                }
                mappingInformation.setMapping(targetFields);
                new SourceBuilder(mappingInformation).generateSourceCode();
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
