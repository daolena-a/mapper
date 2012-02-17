package org.mapper.entity;

import org.mapper.annotation.MappedBy;
import org.mapper.annotation.MappedByField;


@MappedBy(targetedClass = TestMappedComplex.class)
public class TestComplex {
    @MappedByField
    private String test;
    @MappedByField
    private String test2;

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public String getTest2() {
        return test2;
    }

    public void setTest2(String test2) {
        this.test2 = test2;
    }
}
