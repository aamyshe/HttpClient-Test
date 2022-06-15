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

public class Post {
		
@Test
    public static void post(){        
        //创建post请求对象
        HttpPost post = new HttpPost("http://www.silkalley.cn/ctower-mobile-app/center/app/user/UserInfoListExcludeLogin.do");
        try {
        	//map集合
        	/*HashMap<String,String>  man = new HashMap();
        	man.put("t", "1641482007");
        	man.put("starttime", "2021-10-31");
        	man.put("endtime", "2021-10-31");
        	man.put("beginPage", "1");
        	man.put("pageSize", "20");
        	String param = JSON.toJSONString(man);
        	post.addHeader("X-Ecaspsplus-Signature", "9b1b2df5f3584b52b012b6122b665f17");*/
            //创建参数集合
            List<BasicNameValuePair> list = new ArrayList<BasicNameValuePair>();
            //添加参数
            list.add(new BasicNameValuePair("t", "1641482007"));
            list.add(new BasicNameValuePair("starttime","2021-10-31"));
            list.add(new BasicNameValuePair("endtime","2021-10-31"));
            list.add(new BasicNameValuePair("beginPage","1"));
            list.add(new BasicNameValuePair("pageSize","20"));
            //把参数放入请求对象，，post发送的参数list，指定格式
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
            	System.out.println("正式环境查询会员接口请求通过！！！！");
            	//把实体对象转换为string
            	 String result = EntityUtils.toString(entity, "UTF-8");
                 //返回内容
                 System.out.println(result);
            }else {
            	System.out.println("正式环境查询会员接口请求失败！！！！！");
            }
            client.close();
            response.close();
           
        } catch (Exception e1) {
            e1.printStackTrace();

        }

     
    }


}