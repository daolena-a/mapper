package org.mapper.processor.source.builder.api;

/**
 * Created by IntelliJ IDEA.
 * User: adrien.daolena
 * Date: 15/02/12
 * Time: 09:16
 * To change this template use File | Settings | File Templates.
 */
public interface ISourceBuilder {
    void generateSourceCode(Class<?> clazz);
}
