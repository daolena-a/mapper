package org.mapper.generation.launcher;

import org.mapper.annotation.GenerationLauncher;

/**
 * Created by IntelliJ IDEA.
 * User: adrien.daolena
 * Date: 15/02/12
 * Time: 16:24
 * To change this template use File | Settings | File Templates.
 */
@GenerationLauncher(
        classToBeMapped = {"org.mapper.entity.Test" ,
        "org.mapper.entity.TestComplex"}, packageName = "org.converter", projectName = "testApp"

)
public class Launcher {

}

