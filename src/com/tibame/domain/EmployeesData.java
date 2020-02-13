package com.tibame.domain;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("empdata")
@Scope("prototype")
public class EmployeesData {
	private List<String> data=new ArrayList<String>();
	
	//method
	public List<String> getData()
	{
		return data;
	}
	//自訂一個方法 產生集合資料
	@PostConstruct //EJB callback
	public void init()
	{
		data.add("allen");
		data.add("barry");
		data.add("cathy");
		data.add("deby");
		System.out.println(data);
	}
	
	//清除集合
	@PreDestroy
	public void destroy()
	{
		data.clear();
		System.out.println("集合內容:"+data);
	}

}
