package testapi;

import org.testng.annotations.Test;

import com.yinting.core.Request;
import com.yinting.core.Http.HttpRequest;

public class test {
	@Test
public void test(){
	Request request=new HttpRequest();
	request.GET("http://www.baidu.com").invoke();
}
}
