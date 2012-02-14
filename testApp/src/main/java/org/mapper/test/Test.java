package org.mapper.test;


import org.mapper.annotation.MappedBy;
import org.mapper.annotation.MappedByField;
//import org.mapper.test.gen.TestToTestMapped;

@MappedBy(targetedClass = TestMapped.class)
public class Test {

    @MappedByField
    private String field1;
    @MappedByField(fieldName = "fieldDifferent")
    private String field2;

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }
   /* public static void main(String[] args){
        TestMapped test = new TestMapped();
        test.setField1("field1");
        test.setFieldDifferent("field2");
      Test t =  new TestToTestMapped().convert(test);
       System.out.println(t.getField1() + t.getField2());
    }*/
}
