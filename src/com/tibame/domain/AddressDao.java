package com.tibame.domain;

import java.sql.Connection;
import java.sql.SQLException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component("addressdao")
@Scope("prototype")
public class AddressDao implements IDao<Address> {
	private DataSource dataSource;

	@Override
	public Address select(String sql, Object... args) throws SQLException {
		//透過DataSource要一個連接物件
				if(dataSource==null)
				{
					throw new SQLException("DataSource物件尚未注入");
				}
				Connection connection=dataSource.getConnection();
				System.out.println("連接物件產生..."+connection);
				//準備命令物件 執行查詢敘述
				return null;
	}

	@Override
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource=dataSource;
		
	}
	public AddressDao()
	{
		System.out.println("建構AddressDAO Instance...");
	}
	
	//聆聽建構子之後引發的初始化事件程序
	@PostConstruct
	public void init()
	{
		System.out.println("建構AddressDAO Instance物件之後引發初始化事件程序...");
	}
	
	//聆聽一個物件被釋放前引發的事件程序
	@PreDestroy
	public void destroy()
	{
		System.out.println("AddressDAO Instance物件釋放之前 引發事件程序...");
	}

}
