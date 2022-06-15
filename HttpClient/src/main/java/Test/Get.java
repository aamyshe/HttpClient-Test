package Test;

import java.io.IOException;  
import org.apache.http.HttpEntity;                                                                                                                                      import org.apache.http.client.ClientProtocolException; 
import org.apache.http.client.methods.CloseableHttpResponse; 
import org.apache.http.client.methods.HttpGet;                                                                                                                          import org.apache.http.impl.client.CloseableHttpClient; 
import org.apache.http.impl.client.HttpClients;                       
import org.apache.http.util.EntityUtils; 
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Guice;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;


public class Get { 
 	String url; 
 	CloseableHttpClient client; 
 	CloseableHttpResponse response; 
 	HttpEntity responseBody; 
 	int responseCode; 
 
 	public void sendGet() throws Throwable { 
 	 	//String url = "https://reqres.in/api/users?pages=2";
 		//http://demo.max-chain.com:3752/document_http_service!getXiuShuiTrxLineList.action?json=%20%7B%27business_date%27:%272022-05-30%27,%27current_page%27:%271%27%7D"
 		
 	 	String url ="http://121.37.94.194:8080/document_http_service!getXiuShuiTrxLineList.action?json=%20%7B%27business_date%27:%272022-06-03%27,%27current_page%27:%271%27%7D";
 	 	
 	 	// 创建一个 httpClient 的实例 
 	 	client = HttpClients.createDefault(); 
 	 	// 创建一个 httpGet 请求实例 
 	 	HttpGet httpGet = new HttpGet(url); 
 	 	try { 
 	 	 	// 使用 httpClient 实例发送刚创建的 get 请求，并用httpResponse 将响应接收 
 	 	 	response = client.execute(httpGet); 
 	 	 	// 从响应中提取出状态码  
 	 	 	responseCode = response.getStatusLine().getStatusCode(); 
 	 	 	System.out.println(responseCode); 
 	 	 	// 从响应中提取出响应主体 
 	 	 	responseBody = response.getEntity(); 
 	 	 	System.out.println(responseBody);
 	 	 	// 转为字符串 
 	 	 	String responseBodyString = EntityUtils.toString(responseBody, "utf-8"); 
 	 	 	JSONObject json = JSONObject.parseObject(responseBodyString);
 	 	 	System.out.println(json);
 	/* 	 	String total = json.getString("total_page");
 	 	 	System.out.println(total);*/
 	 	 	
 	 	 	//System.out.println(responseBodyString);
 	 	 	
 	 	} catch (ClientProtocolException cpe) { 
 	 	 	cpe.printStackTrace(); 
 	 	} catch (IOException ioe) { 
 	 	 	ioe.printStackTrace(); 
 	 	}finally { 	 
 	 	 	client.close(); 
 	 	 	response.close(); 
 	 	}   
 	} 
 


	public static void main(String[] args) throws Throwable { 
	 	Get simpleGetTest = new Get(); 
 	 	simpleGetTest.sendGet(); 
 	} 
} 