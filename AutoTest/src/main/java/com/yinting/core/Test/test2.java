package com.yinting.core.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class test2 implements IAnnotationTransformer {
	public test2(){
		System.out.println("test2");
	}

	public void transform(ITestAnnotation annotation, Class testClass,
			Constructor testConstructor, Method testMethod) {
		System.out.println("ITestAnnotation");
		
	}


}