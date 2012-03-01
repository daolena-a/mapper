package org.sourcecode.builder.interfaces;

import org.sourcecode.builder.data.AccessLevel;
import org.sourcecode.builder.data.Params;

import java.util.List;


public interface IBuilder {
    IBuilder classCode();
    IBuilder methodCode();
    IBuilder fieldDeclaration();
//    IBuilder startBlocCode();
//    IBuilder endBlocCode();
//    IBuilder methodDeclaration(AccessLevel lvl,String returnedType, String methodName, Params... params);
//    IBuilder classDeclaration(AccessLevel lvl, String className);
//    IBuilder instructionLine(String line);
    IBuilder getter(String fieldName);
    IBuilder setter (String fieldName);
}
