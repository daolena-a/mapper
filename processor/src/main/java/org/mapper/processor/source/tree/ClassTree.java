package org.mapper.processor.source.tree;

import org.mapper.processor.source.Source;

import java.util.ArrayList;
import java.util.List;


public class ClassTree {
    List<Source> tree;
    public ClassTree(){
        tree =  new ArrayList<Source>();
    }
    public void addSource(Source s){
        tree.add(s);
    }
}
