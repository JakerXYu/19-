package com.lagou.utils;

import java.util.List;



import com.lagou.domain.Funs;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JsonUtil {
	public static String funToTree(List<Funs> funsList){
		JSONArray funJsonArray = new JSONArray();
		for (Funs fun : funsList) {
			System.out.println(fun.getFunName());
			JSONObject funJsonObject = new JSONObject();
			
			//id表示树节点的编号，可以通过方式获得
			funJsonObject.put("id",fun.getFunId());
			//text表示树节点的文本，可通过方式获得
			funJsonObject.put("text",fun.getFunName());
			//state表示树节点的状态，表示是打开还是关闭
			funJsonObject.put("state","open");
			//checked表示树节点的选中状态，TRUE表示选中，FALSE表示未选中
			funJsonObject.put("checked",false);
			funJsonArray.add(funJsonObject);
		}
		
		JSONArray treeArray = new JSONArray();
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("id",-1);//-1不用添加到数据库的id
		jsonObject.put("text","所有功能");
		jsonObject.put("state","open");
		//children表示树节点的子节点
		jsonObject.put("children",funJsonArray);
		treeArray.add(jsonObject);
		System.out.println( treeArray.toString());
		return treeArray.toString();
	}
}
