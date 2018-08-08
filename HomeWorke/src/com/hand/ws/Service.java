package com.hand.ws;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

/**
 * 
 * @ClassName: WebService
 * 
 * @Description:
 * 
 * @author ZhongLingYun
 * 
 * @date 2018年8月8日 上午11:07:14
 * 
 */
@WebService
public class Service {
	
	private static Integer x=0;
	public Integer queryWeather(String cityName) {
        System.out.println(x);  
        Integer result=x;
        x++;
        return result;
    }
	
	
	public static void main(String[] args) {
	         // 使用Endpoint(终端)类发布webservice
		        Endpoint.publish("http://localhost:8080/service", new Service());
		         System.out.println("Publish Success");
		     }

}
