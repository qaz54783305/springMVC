package com.tibame.domain;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
//實作IDao介面(功能架構採用介面多型化)
public class CustomersDAO implements IDao<Customer>{
	private DataSource dataSource;

	@Override
	public Customer select(String sql, Object... args) throws SQLException {
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
	@Autowired //DI
	public void setDataSource(DataSource dataSource) {
		this.dataSource=dataSource;
		
	}

}
