package com.medium.caching;


/**
 *
 * Class for demonstration of WeekHashMap usage vs HashMap,
 * both usages can be found on test module MapCachingTest.class
 *
 *
 */
public class Demo {

    private String dummyField;

    public Demo(String dummyField){
        this.dummyField = dummyField;
    }

    public String getDummyField() {
        return dummyField;
    }

    public void setDummyField(String dummyField) {
        this.dummyField = dummyField;
    }

}
