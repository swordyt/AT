package com.yinting.test;

import org.springframework.stereotype.Service;
@Service
public class AspectTest{
	public void test(String who) {
		System.out.println(who);
		System.out.println(AspectTest.class);
	}
}
