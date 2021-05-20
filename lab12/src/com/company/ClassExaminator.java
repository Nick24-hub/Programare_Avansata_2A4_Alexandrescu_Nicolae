package com.company;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.util.Arrays;

public class ClassExaminator {
    public void examinate (String className) throws ClassNotFoundException, IntrospectionException {
        Class clazz=Class.forName(className);
        BeanInfo beanInfo= Introspector.getBeanInfo(clazz);
        System.out.println("Bean descriptor:"+beanInfo.getBeanDescriptor().getBeanClass());
        System.out.println("Property descriptor:"+ Arrays.toString(beanInfo.getPropertyDescriptors()));
    }
}
