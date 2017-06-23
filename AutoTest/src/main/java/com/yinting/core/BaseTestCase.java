package com.yinting.core;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.Test;

@ContextConfiguration("classpath:config/framework/jdbc/datasource/ApplicationContext.xml")
@Transactional
// @Transactional(propagation = Propagation.REQUIRED)
public class BaseTestCase extends AbstractTransactionalTestNGSpringContextTests{
	@Test
	public void tet1() {
		System.out.println(System.getProperty("user.dir"));
	}
}