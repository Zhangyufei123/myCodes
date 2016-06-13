package myCodesTest;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.ValueFilter;

public class JsonTest {
	public static void main(String[] args) {
		Map m=new HashMap();
		m.put("a","1");
		m.put("b","");
		m.put("c",null);
		m.put("d",0);
		 
		JSON j=(JSON)JSON.toJSON(m);
		System.out.println(j);
		//1.Êä³ö½á¹û£º{"a":"1","b":"","d":0}
		
		String js=JSON.toJSONString(m,SerializerFeature.WriteMapNullValue);
		ValueFilter filter = new ValueFilter() {
		    @Override
		    public Object process(Object obj, String s, Object v) {
		    if(v==null)
		        return "";
		    return v;
		    }
		};
		JSON.toJSONString(m, filter);

		System.out.println(js);
		
	}
}
