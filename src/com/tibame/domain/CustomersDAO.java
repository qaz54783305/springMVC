package com.tibame.domain;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
//��@IDao����(�\��[�c�ĥΤ����h����)
public class CustomersDAO implements IDao<Customer>{
	private DataSource dataSource;

	@Override
	public Customer select(String sql, Object... args) throws SQLException {
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
	@Autowired //DI
	public void setDataSource(DataSource dataSource) {
		this.dataSource=dataSource;
		
	}

}
