package org.mapper.entity;

public class TestMapped {
    private String field1;
    private String fieldDifferent;
    private TestMappedComplex complex;

    public TestMappedComplex getComplex() {
        return complex;
    }

    public void setComplex(TestMappedComplex complex) {
        this.complex = complex;
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public String getFieldDifferent() {
        return fieldDifferent;
    }

    public void setFieldDifferent(String fieldDifferent) {
        this.fieldDifferent = fieldDifferent;
    }
}
