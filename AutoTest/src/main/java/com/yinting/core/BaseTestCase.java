package com.yinting.core;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.transaction.annotation.Transactional;

import com.yinting.core.Http.HttpRequest;

@ContextConfiguration("classpath:qacontext/applicationContext.xml")
@Transactional
// @Transactional(propagation = Propagation.REQUIRED)
public class BaseTestCase extends AbstractTransactionalTestNGSpringContextTests {
	@Autowired
	protected HttpRequest driver;
}
