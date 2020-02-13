package com.tibame.domain;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component("MyCustomers") //�w�]�ͩR�g�� �H�����Ψt�αҰʲ���Instance
@Scope("prototype") //default singleton prototpye stateless �C�@�ӽեβ��ͤ@�ӭ��骫��
public class MyCustomers implements IDao<Customer> {
	private DataSource dataSource;
	
	public MyCustomers()
	{
		int idNo=(int)(Math.random()*10000)+1;
		System.out.println("MyCustomers���󬡹L��!!!"+idNo);
	}

	@Override
	public Customer select(String sql, Object... args) throws SQLException {
		//Console
		System.out.println("DataSource Instance:"+dataSource.getConnection().getCatalog());
		return null;
	}

	@Override
	@Autowired  //DI-Dependency Injection �ѼƦW�� ����DataSource bean id
	public void setDataSource(DataSource dataSource1) {
		if(dataSource1!=null){
			this.dataSource=dataSource1;
		}
		
	}

}
