package org.mapper.processor.source.tree;

import org.mapper.processor.source.Source;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: adrien.daolena
 * Date: 14/02/12
 * Time: 14:11
 * To change this template use File | Settings | File Templates.
 */
public class ClassTree {
    List<Source> tree;
    public ClassTree(){
        tree =  new ArrayList<Source>();
    }
    public void addSource(Source s){
        tree.add(s);
    }
}
