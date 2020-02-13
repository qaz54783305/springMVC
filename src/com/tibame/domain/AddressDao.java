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
		//�z�LDataSource�n�@�ӳs������
				if(dataSource==null)
				{
					throw new SQLException("DataSource����|���`�J");
				}
				Connection connection=dataSource.getConnection();
				System.out.println("�s�����󲣥�..."+connection);
				//�ǳƩR�O���� ����d�߱ԭz
				return null;
	}

	@Override
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource=dataSource;
		
	}
	public AddressDao()
	{
		System.out.println("�غcAddressDAO Instance...");
	}
	
	//��ť�غc�l����޵o����l�ƨƥ�{��
	@PostConstruct
	public void init()
	{
		System.out.println("�غcAddressDAO Instance���󤧫�޵o��l�ƨƥ�{��...");
	}
	
	//��ť�@�Ӫ���Q����e�޵o���ƥ�{��
	@PreDestroy
	public void destroy()
	{
		System.out.println("AddressDAO Instance�������񤧫e �޵o�ƥ�{��...");
	}

}
