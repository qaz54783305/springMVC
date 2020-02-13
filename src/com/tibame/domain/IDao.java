package com.tibame.domain;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

//規劃具有Generic 泛型
public interface IDao<T> {
	//查詢的方法規範 單筆查詢-回應一個物件Entity(JavaBean)
	//Select * from customer where customer_id=? and xxxx=?
	public T select(String sql,Object...args) throws SQLException;
	//強制注入DataSource(Dependency Injection_注入)
	@Autowired
	public void setDataSource(DataSource dataSource);

}
