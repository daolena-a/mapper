package org.mapper.annotation;


public @interface GenerationLauncher {
    String[] classToBeMapped();
    String packageName() default "";
    String projectName() default "";
}
