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
	//�ۭq�@�Ӥ�k ���Ͷ��X���
	@PostConstruct //EJB callback
	public void init()
	{
		data.add("allen");
		data.add("barry");
		data.add("cathy");
		data.add("deby");
		System.out.println(data);
	}
	
	//�M�����X
	@PreDestroy
	public void destroy()
	{
		data.clear();
		System.out.println("���X���e:"+data);
	}

}
