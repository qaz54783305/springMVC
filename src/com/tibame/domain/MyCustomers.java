package com.tibame.domain;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component("MyCustomers") //預設生命週期 隨著應用系統啟動產生Instance
@Scope("prototype") //default singleton prototpye stateless 每一個調用產生一個個體物件
public class MyCustomers implements IDao<Customer> {
	private DataSource dataSource;
	
	public MyCustomers()
	{
		int idNo=(int)(Math.random()*10000)+1;
		System.out.println("MyCustomers物件活過來!!!"+idNo);
	}

	@Override
	public Customer select(String sql, Object... args) throws SQLException {
		//Console
		System.out.println("DataSource Instance:"+dataSource.getConnection().getCatalog());
		return null;
	}

	@Override
	@Autowired  //DI-Dependency Injection 參數名稱 應對DataSource bean id
	public void setDataSource(DataSource dataSource1) {
		if(dataSource1!=null){
			this.dataSource=dataSource1;
		}
		
	}

}
