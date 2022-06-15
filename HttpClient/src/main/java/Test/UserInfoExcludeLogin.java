package Test;
import org.testng.annotations.Test;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class UserInfoExcludeLogin {
	@Test
	public static void post1() {
			String  url = "http://www.silkalley.cn/ctower-mobile-app/center/app/user/UserInfoExcludeLogin.do";
			HttpPost post = new HttpPost(url);
			try {
				ArrayList<BasicNameValuePair> list = new ArrayList<BasicNameValuePair>();
				list.add( new BasicNameValuePair("type","usercode"));
				list.add(new BasicNameValuePair("parameter","0001"));
				list.add(new BasicNameValuePair("t","1641482007"));
				post.setEntity(new UrlEncodedFormEntity(list, "UTF-8"));
		            //添加请求头参数
		        post.addHeader("X-Ecaspsplus-Signature","9b1b2df5f3584b52b012b6122b665f17");
		        CloseableHttpClient client = HttpClients.createDefault();
		            //启动执行请求，并获得返回值
		            CloseableHttpResponse response = client.execute(post);
		            //得到返回的entity对象
		            HttpEntity entity = response.getEntity();
		            //获取返回状态码
		            int status = response.getStatusLine().getStatusCode();
		            if (status == 200) {
		            	System.out.println("单个会员查询++++++++++++++++++++++++！！！！");
		            	//把实体对象转换为string
		            	 String result = EntityUtils.toString(entity, "UTF-8");
		                 //返回内容
		                 System.out.println(result);
		            }else {
		            	System.out.println("单个会员查询------------------------！！！！！");
		            }
		            client.close();
		            response.close();
		           
		        } catch (Exception e1) {
		            e1.printStackTrace();

		        }

		     
		    
}
}
