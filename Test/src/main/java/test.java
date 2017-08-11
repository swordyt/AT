import java.util.Iterator;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.maiziyun.common.enums.BankCardType;
import com.maiziyun.common.enums.BankInstId;
import com.maiziyun.common.enums.CertType;
import com.maiziyun.common.enums.MyServiceCode;
import com.maiziyun.payment.fxs.facade.UserSignService;
import com.maiziyun.payment.fxs.facade.model.SendVerfiyCodeRequest;
import com.maiziyun.payment.fxs.facade.model.SendVerfiyCodeResponse;
import com.solar.framework.core.enums.SourceCode;

public class test {
	public static void main(String[] args) {
		Logger log = Logger.getLogger(test.class);
		PropertyConfigurator.configure("src/main/java/log4j.properties");
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "dubbo-demo-provider.xml" });
		context.start();
		UserSignService service = (UserSignService) context.getBean("UserSignService");
		SendVerfiyCodeRequest request = new SendVerfiyCodeRequest();
		request.setCardName("Âó×Ó²âÊÔ2");
		request.setCardType(BankCardType.Debit);
		request.setUserId("00220161114232900000000000000041");
		request.setCardIdxNo("6212261001018876440");
		request.setCertNo("320200198008177639");
		request.setCertType(CertType.I);
		request.setInstId(BankInstId.ICBC);
		request.setMobile("13587657788");
		request.setPhase("ES_IDENTIFY_SMS");
		request.setService(MyServiceCode.Default);
		request.setSource(SourceCode.OpenApi);
		SendVerfiyCodeResponse  response = service.sendVerifyCode(request);
		Map<String, String> map = response.getExtFields();
		for (String key : map.keySet()) {
			log.info("==" + map.get(key + "=="));
		}
	}
}
